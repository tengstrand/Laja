package net.sf.laja.parser.engine2;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

public class RecorderImpl implements Recorder {
	private int cnt = 0;
	private boolean debug = false; //false

	private long startTime = -1;
	private long prevTime = System.currentTimeMillis();

	private int mindex;
	private int bindex;
	private List<Integer> matches;
	private List<Integer> bookmarks;

	private int maxId;
	private int maxSourceIndex;
	
	private int sourceSize;
	private RecorderLogging logging;

	private PrintWriter out;
	
	private static final int SHIFTS = 5;
	private static final int MASK = 31;

	public RecorderImpl(int sourceSize) {
		this.sourceSize = sourceSize;
		matches = new ArrayList<Integer>(sourceSize/4);
		bookmarks = new ArrayList<Integer>();
		
//		try {
//			out = new PrintWriter("C:/Java/laja/laja.log");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public int getMaxId() {
		return maxId;
	}
	
	public int getMaxSourceIndex() {
		return maxSourceIndex;
	}
	
	public void setLogging(Writer writer, int bestSourceIndex) {
		logging = new RecorderLoggingImpl(this, writer, sourceSize, bestSourceIndex);
	}
	
	public void printLogging(Source source) {
		logging.printTrace(source);
	}

	public void set(int level, Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, boolean match, boolean parentNot, boolean not) {
		if (debug) {
			int index = match ? afterSourceIndex : beforeSourceIndex;
			debug(level, source, index, parentNot, not, element, "Set " + element.getClass().getSimpleName() + "(" + beforeSourceIndex + "," + index + ") " + match);
		}
		
		if (logging != null) {
			logging.setId(source, element, beforeSourceIndex, afterSourceIndex, bestSourceIndex, mindex, match, not);
		} else {
			setMax(element.getId(), afterSourceIndex);
		}

		if (match) {
			setMatchedBit(mindex);
		} else {
			clearMatchedBit(mindex);
		}
		if (not || !match) {
			this.mindex = mindex+1;
		}
	}

	private void setMatchedBit(int mindex) {
		int index = mindex >> SHIFTS;
		matches.set(index, matches.get(index) | (1 << (mindex & MASK)));
	}

	private void clearMatchedBit(int mindex) {
		int index = mindex >> SHIFTS;
		matches.set(index, matches.get(index) & ~(1 << (mindex & MASK)));
	}
	
	private void setBookmark(int index) {
		if (bindex >= bookmarks.size()) {
			bookmarks.add(index);
		} else {
			bookmarks.set(bindex, index);
		}
	}
	
	public void set(int level, Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, int bindex, boolean match, boolean parentNot, boolean not) {
		if (debug) {
			int index = match ? afterSourceIndex : beforeSourceIndex;
			debug(level, source, index, parentNot, not, element, element.getClass().getSimpleName() + "(" + beforeSourceIndex + "," + index + ") match=" + match);
		}
		
		if (logging != null) {
			logging.setId(source, element, beforeSourceIndex, afterSourceIndex, bestSourceIndex, mindex, match, not);
		} else {
			setMax(element.getId(), afterSourceIndex);
		}

		if (match) {
			setMatchedBit(mindex);
		} else {
			clearMatchedBit(mindex);
		}
		setBookmark(beforeSourceIndex);
		
		if (not || !match) {
			this.mindex = mindex+1;
			this.bindex = bindex+1;
		}
	}
	
	public int reserveMatchIndex(int level, Element element, int beforeSourceIndex, boolean parentNot, boolean not) {
		if (debug) {
			debug(level, parentNot, not, element, element.getClass().getSimpleName() + " ?");
		}
		if (logging != null) {
			logging.reserveId(element, mindex, beforeSourceIndex, not);
		}
		if (matches.size() <= (mindex >> SHIFTS)) {
			matches.add(0);
		}
		return mindex++;
	}
	
	public int reserveBookmarkIndex() {
		return bindex++;
	}
	
	public void rewind() {
		mindex = 0;
		bindex = 0;
	}
	
	public boolean playMatch(Element element, int beforeSourceIndex) {
		boolean match = (matches.get(mindex >> SHIFTS) & (1 << (mindex & MASK))) != 0;
		if (debug) {
			debug(element, "Play " + mindex + " " + element.getClass().getSimpleName() + "(" + beforeSourceIndex + ",?" + ") " + match);
		}
		mindex++;
		return match;
	}

	public int playBookmark() {
		return bookmarks.get(bindex++);
	}
	
	public int getIndex() {
		return mindex;
	}
	
	// TODO: Use new class "RecorderIndex" to hold both mindex and bindex
	// use it in the argument list, and return it from getIndex();
	public void setIndex(int index) {
		this.mindex = index;
	}
	
	private void setMax(int id, int sourceIndex) {
		if (id > maxId) {
			maxId = id;
		}
		if (sourceIndex > maxSourceIndex) {
			maxSourceIndex = sourceIndex;
		}
	}

	public String translateInvisibleCharacters(Source source, int startIndex) {
		int bookmark = source.getBookmark();
		String string = source.get(startIndex, 20);
		source.setBookmark(bookmark);
		return translateInvisibleCharacters(string);
	}
	
	public String translateInvisibleCharacters(String string) {
		if (string == null) {
			return string;
		}
		string = string.replace("\\", "\\\\");
		string = string.replace("\t", "\\t");
		string = string.replace("\n", "\\n");
		string = string.replace("\r", "\\r");
		return string;
	}
	
	private void debug(int level, boolean parentNot, boolean not, Element element, String message) {
		cnt++;
		String msg = "level=" + level + " cnt=" + cnt + " " + translateInvisibleCharacters(element.getName()) + " (" + element.getId() + ") " + " parentNot=" + parentNot + " not=" + not + " " + message;
		debug(element, msg);
	}
	
	private void debug(int level, Source source, int startIndex, boolean parentNot, boolean not, Element element, String message) {
		cnt++;
		String msg = "level=" + level + " cnt=" + cnt + " " + translateInvisibleCharacters(element.getName()) + " (" + element.getId() + ") " + " parentNot=" + parentNot + " not=" + not + " " +  message + " : " + translateInvisibleCharacters(source, startIndex);
		debug(element, msg);
	}
	
	private void debug(Element element, String message) {
		long newTime = System.currentTimeMillis();
		int time = (int)(newTime - prevTime);

		if (startTime < 0) {
			startTime = newTime;
		}
		
//		out.println(message + " time=" +  time/1000.0 + " total=" + (newTime-startTime)/1000.0);
		out.println(message);
		prevTime = newTime;
		System.out.println(message);
		
//		if (element.getId() == 271) {
//			int dummy = 1;
//		}
		
		if (cnt == 7526) {
			// Set the instance variable 'debug' to true
			// and add your breakpoint here if you want to
			// debug yor generated parser.
			int dummy = 1;
		}
	}
}
