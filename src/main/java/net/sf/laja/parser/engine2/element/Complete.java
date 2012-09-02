package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class Complete implements Element {
	private int id;
	private boolean not;
	private String name;
	private Output output;

	public Complete(int id, String name) {
		this(id, name, new NoOutput());
	}

	public Complete(int id, String name, int flags) {
		this(id, name, flags, new NoOutput());
	}

	public Complete(int id, String name, Output output) {
		this(id, name, 0, output);
	}

	public Complete(int id, String name, int flags, Output output) {
		this.id = id;
		this.name = name;
		this.not = (flags & NOT) > 0;
		this.output = output;
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIdName() {
		return getString();
	}
	
	public String getString() {
		return "*";
	}
	
	public boolean isTerminal() {
		return true;
	}
	
	public String getName() {
		return name;
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		int bookmark = source.getBookmark();
		source.setBookmark(source.getEndIndex());

		if (not) {
			return false;
		}
		
		if (receive | output.receive()) {
			output.init(source);
			output.set(source, bookmark);
		}

		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id=").append(id)
			.append(", not=").append(not)
			.append(", name=").append(name)
			.append(", output=").append(output)
			.append("]");
		return sb.toString();
	}
}
