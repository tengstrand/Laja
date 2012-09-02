package net.sf.laja.parser.engine2;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

public class RecorderLoggingImpl implements RecorderLogging {
	private int status = 0;
	private int endIndex = -1;
	private int bestSourceIndex;
	private MaxSource maxSource;
	private Writer writer;
	private List ids;

	class Data {
		public static final int VIEW_CHARACTERS = 20;
		public static final int UNDEFINED = -1;
		
		private boolean match;
		private boolean not;
		private int id;
		private int beforeSourceIndex;
		private int afterSourceIndex;
		Data(Element element, int beforeSourceIndex, int afterSourceIndex, boolean match, boolean not) {
			this.id = element.getId();
			this.beforeSourceIndex = beforeSourceIndex;
			this.afterSourceIndex = afterSourceIndex;
			this.match = match;
			this.not = not;
		}
		public String getLogRow(Source source) {
			int length = getMaxLength(maxSource.getMaxSourceIndex());
			String afterIndex;
			if (afterSourceIndex == UNDEFINED) {
				afterIndex = String.format("%" + length + "s", "?");
			} else {
				afterIndex = format(afterSourceIndex,maxSource.getMaxSourceIndex());
			}
			
			String readableSource = getReadableSource(source, beforeSourceIndex); 
			
			return (match ? "T" : " ") + (not ? "!" : " ") + 
				" (" + format(beforeSourceIndex,maxSource.getMaxSourceIndex()) + " " + afterIndex + ") " +
				"id=" + format(id, maxSource.getMaxId()) + " " + readableSource;
		}
		
		private boolean isReserved() {
			return afterSourceIndex == UNDEFINED;
		}
		
		private String getReadableSource(Source source, int index) {
			int bookmark = source.getBookmark();
			String str = source.get(index, VIEW_CHARACTERS);
			source.setBookmark(bookmark);
			str = str.replace("\\", "\\\\");
			str = str.replace("\t", "\\t");
			str = str.replace("\n", "\\n");
			str = str.replace("\r", "\\r");
			return str;
		}
	}

	public RecorderLoggingImpl(MaxSource maxSourceIndex, Writer writer, int sourceSize, int bestSourceIndex) {
		this.maxSource = maxSourceIndex;
		this.writer = writer;
		this.bestSourceIndex = bestSourceIndex;
		ids = new ArrayList(sourceSize);
	}
	
	public void reserveId(Element element, int mindex, int beforeSourceIndex, boolean not) {
		if (writer != null) {
			boolean match = false;
			int afterSourceIndex = Data.UNDEFINED;
			if (ids.size() <= mindex) {
				ids.add(new Data(element, beforeSourceIndex, afterSourceIndex, match, not));
			} else {
				ids.set(mindex, new Data(element, beforeSourceIndex, afterSourceIndex, match, not));
			}
		}
	}
	
	public void setId(Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, boolean match, boolean not) {
		if (ids.size() <= mindex) {
			ids.add(new Data(element, beforeSourceIndex, afterSourceIndex, match, not));
		} else {
			boolean isReserved = ((Data)ids.get(mindex)).isReserved();
			if (status == 1 && !isReserved) {
				printTrace(source);
			}
			ids.set(mindex, new Data(element, beforeSourceIndex, afterSourceIndex, match, not));
		}

		if (this.bestSourceIndex == bestSourceIndex && status == 0) {
			status = 1;
			endIndex = mindex;
		}
	}
	
	public void printTrace(Source source) {
		if (status == 1) {
			status = 2;
			
			for (int i=0; i<=endIndex; i++) {
				Data data = (Data)ids.get(i);
				writer.writeln(data.getLogRow(source));
			}
		}
	}
	
	private int getMaxLength(int max) {
		int length = 1;
		int boundary = 10;
		
		while (true) {
			if (max < boundary) {
				return length;
			}
			length++;
			boundary *= 10;
		}
	}
	
	private String format(int val, int max) {
		int length = getMaxLength(max);
		return String.format("%" + length + "d", val);
	}
	
	
}
