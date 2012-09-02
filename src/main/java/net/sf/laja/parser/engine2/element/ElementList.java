package net.sf.laja.parser.engine2.element;

import java.util.Iterator;

import net.sf.laja.parser.engine2.ElementOutputList;
import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.ElementOutputList.ElementOutput;
import net.sf.laja.parser.engine2.source.Source;

public class ElementList implements Element {
	private int id;
	private boolean not;
	private Boolean caseSensitive;
	private String name;
	private Output thisOutput;
	private ElementOutputList list;

	public ElementList(int id, String name) {
		this(id, name, new NoOutput());
	}

	public ElementList(int id, String name, int flags) {
		this(id, name, flags, new NoOutput());
	}

	public ElementList(int id, String name, Output output) {
		this(id, name, 0, output);
	}

	public ElementList(int id, String name, int flags, Output output) {
		this.id = id;
		this.name = name;
		this.not = (flags & NOT) > 0;
		this.caseSensitive = (flags & CASE) == 0 ? null : new Boolean((flags & CS) > 0);
		this.thisOutput = output;
		this.list = new ElementOutputList(this, new NoOutput());
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIdName() {
		return name;
	}
	
	public String getString() {
		return null;
	}

	public boolean isTerminal() {
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public Output getOutput() {
		return thisOutput;
	}

	public void add(int id, Element element) {
		list.add(id, element);
	}

	public void add(int id, Element element, int flags) {
		list.add(id, element, flags);
	}

	public void add(int id, Element element, Output output) {
		list.add(id, element, 0, output);
	}

	public void add(int id, Element element, int flags, Output output) {
		list.add(id, element, flags, output);
	}

	public boolean hasElements() {
		return list.iterator().hasNext();
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		level++;
		Recorder recorder = source.getRecorder();
		int bestMatchIdx = source.getBestIndex();
		int startBookmark = source.getBookmark();
		int startIndex = recorder.getIndex();
		
		for (Iterator i = list.iterator(); i.hasNext();) {
			ElementOutput elementOutput = (ElementOutput)i.next();
			Element element = elementOutput.getElement();
			Output output = elementOutput.getOutput();
			boolean elementNot = elementOutput.isNot();

			if (this.caseSensitive != null) {
				caseSensitive = this.caseSensitive.booleanValue();
			}
			if (elementOutput.isCaseSensitive() != null) {
				caseSensitive = elementOutput.isCaseSensitive().booleanValue();
			}

			int bookmark = source.getBookmark();

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
					int mindex = recorder.reserveMatchIndex(level, element, source.getBookmark(), parentNot, elementNot);
					match = element.parse(level, source, not|parentNot|elementNot, caseSensitive, false);
					match = match != elementNot;
					recorder.set(level, source, element, bookmark, source.getBookmark(), source.getBestIndex(), mindex, match, parentNot, elementNot);
				}
			}
			
			if (match == not) {
				if (!receive) {
					recorder.setIndex(startIndex);
				}
				return false;
			}
			
			if (not) {
				break;
			}

			if (elementNot) {
				source.setBookmark(bookmark);
				source.skipCharacter();
				if (source.getBookmark() > bestMatchIdx) {
					source.setBestIndex(source.getBookmark());
				}
			}

			if (receive) {
				if (elementNot) {
					output.init(source);
					output.set(source, bookmark);
				} else {
					source.setBookmark(bookmark);
					output.init(source);
					element.parse(level, source, not|parentNot|elementNot, caseSensitive, receive);
					output.set(source, bookmark);
				}
			}
		}

		if (not) {
			source.setBookmark(startBookmark);
			source.getCharacterAsString();
		}
		if (thisOutput != null && (receive || thisOutput.receive())) {
			thisOutput.init(source);
			thisOutput.set(source, startBookmark);
		}
		
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ElementList:[id=").append(id)
			.append(", not=").append(not)
			.append(", caseSensitive=").append(caseSensitive)
			.append(", name=").append(name)
			.append(", thisOutput=").append(thisOutput)
			.append(", list=").append(list)
			.append("]");
		return sb.toString();
	}
}
