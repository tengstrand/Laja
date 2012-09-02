package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.source.Source;

public class Optional implements Element {
	private int id;
	private String name;
	private ElementList elementList;

	public Optional(int id, String name) {
		this.id = id;
		elementList = new ElementList(id, name);
	}

	public Optional(int id, String name, Output output) {
		this.id = id;
		elementList = new ElementList(id, name, output);
	}

	@Override
	public boolean isOptional() {
		return true;
	}
	
	public int getId(){
		return id;
	}

	public String getIdName() {
		return "[" + getName() + "]";
	}
	
	public String getString() {
		return null;
	}

	public boolean isTerminal() {
		return false;
	}
	
	public String getName() {
		return elementList.getName();
	}
	
	public void add(int id, Element element) {
		elementList.add(id, element);
	}

	public void add(int id, Element element, int flags) {
		elementList.add(id, element, flags);
	}

	public void add(int id, Element element, Output output) {
		elementList.add(id, element, output);
	}

	public void add(int id, Element element, int flags, Output output) {
		elementList.add(id, element, flags, output);
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		Recorder recorder = source.getRecorder();
		int bookmark = source.getBookmark();

		boolean match;

		if (receive) {
			match = recorder.playMatch(elementList, source.getBookmark());
		} else {
			int index = recorder.reserveMatchIndex(level, elementList, source.getBookmark(), parentNot, false);
			match = elementList.parse(level, source, parentNot, caseSensitive, false);
			recorder.set(level, source, elementList, bookmark, source.getBookmark(), source.getBestIndex(), index, match, parentNot, false);
		}
		
		if (!match) {
			source.setBookmark(bookmark);
		}

		if (receive) {
			if (match) {
				source.setBookmark(bookmark);
				elementList.parse(level, source, parentNot, caseSensitive, receive);
			} else if (elementList.getOutput() != null) {
				// Optional is always true!
				elementList.getOutput().init(source);
				elementList.getOutput().set(source, bookmark);
			}
		}

		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id=").append(id)
			.append(", name=").append(name)
			.append(", elementList=").append(elementList)
			.append("]");
		return sb.toString();
	}
}
