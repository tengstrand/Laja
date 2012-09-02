package net.sf.laja.parser.engine2.element;

import java.util.Iterator;

import net.sf.laja.parser.engine2.ElementOutputList;
import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.source.Source;

public class OrList implements Element {
	private int id;
	private boolean not;
	private Boolean caseSensitive;
	private String name;
	private ElementOutputList list;

	public OrList(int id, String name) {
		this(id, name, new NoOutput());
	}

	public OrList(int id, String name, int flags) {
		this(id, name, flags, new NoOutput());
	}

	public OrList(int id, String name, Output output) {
		this(id, name, 0, output);
	}

	public OrList(int id, String name, int flags, Output output) {
		this.id = id;
		this.name = name;
		this.not = (flags & NOT) > 0;
		this.caseSensitive = (flags & CASE) == 0 ? null : new Boolean((flags & CS) > 0);
		list = new ElementOutputList(this, output);
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	@Override
	public int getId(){
		return id;
	}

	@Override
	public String getIdName() {
		return name;
	}
	
	@Override
	public String getString() {
		return null;
	}
	
	@Override
	public boolean isTerminal() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void add(int id, Element element) {
		list.add(id, element);
	}

	public void add(int id, Element element, int flags) {
		list.add(id, element, flags);
	}
	
	public void add(int id, Element element, Output output) {
		list.add(id, element, output);
	}
	
	public void add(int id, Element element, int flags, Output output) {
		list.add(id, element, flags, output);
	}
	
	@Override
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		level++;
		Recorder recorder = source.getRecorder();
		int bookmark = source.getBookmark();
		int recIndex = recorder.getIndex();

		for (Iterator i = list.iterator(); i.hasNext();) {
			source.setBookmark(bookmark);

			ElementOutputList.ElementOutput elementOutput = (ElementOutputList.ElementOutput)i.next();
			Element element = elementOutput.getElement();
			Output output = elementOutput.getOutput();
			
			boolean elementNot = elementOutput.isNot();

			if (this.caseSensitive != null) {
				caseSensitive = this.caseSensitive.booleanValue();
			}
			if (elementOutput.isCaseSensitive() != null) {
				caseSensitive = elementOutput.isCaseSensitive().booleanValue();
			}

			boolean match = false;
			if (output.receive()) {
				if (receive) {
					match = recorder.playMatch(element, source.getBookmark());
					source.setBookmark(recorder.playBookmark());
				} else {
					output.init(source);
					int mindex = recorder.reserveMatchIndex(level, element, source.getBookmark(), parentNot, elementNot);
					int bindex = recorder.reserveBookmarkIndex();
					match = element.parse(level, source, not|parentNot|elementNot, caseSensitive, false);
					match = match != elementNot;
					recorder.set(level, source, element, bookmark, source.getBookmark(), source.getBestIndex(), mindex, bindex, match, parentNot, elementNot);
					output.set(source, bookmark);
				}
			} else {
				if (receive) {
					match = recorder.playMatch(element, source.getBookmark());
				} else {
					int index = recorder.reserveMatchIndex(level, element, source.getBookmark(), parentNot, elementNot);
					match = element.parse(level, source, not|parentNot|elementNot, caseSensitive, false);
					match = (match != elementNot);
					recorder.set(level, source, element, bookmark, source.getBookmark(), source.getBestIndex(), index, match, parentNot, elementNot);
				}
			}

			if (match) {
				if (receive && !elementNot && !not) {
					source.setBookmark(bookmark);
					output.init(source);
					element.parse(level, source, not|parentNot|elementNot, caseSensitive, receive);
					output.set(source, bookmark);
				}
                output = list.getOutput();
                if (output != null && receive) {
                    output.init(source);
                    output.set(source, bookmark);
                }
                
                return !not;
			}
		}
		if (not) {
			source.setBookmark(bookmark);
			source.skipCharacter();

			Output output = list.getOutput();
			if (output != null && receive) {
				output.init(source);
				output.set(source, bookmark);
			}
		} else {
			recorder.setIndex(recIndex);
		}

		return not;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("OrList:[id=").append(id)
			.append(", not=").append(not)
			.append(", caseSensitive").append(caseSensitive)
			.append(", list=").append(list)
			.append("]");
		return sb.toString();
	}
}
