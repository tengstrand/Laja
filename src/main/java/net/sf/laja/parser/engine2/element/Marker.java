package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class Marker implements Element {
	private int id;
	private String name;
	private Output output;

	public Marker(int id, String name) {
		this(id, name, new NoOutput());
	}

	public Marker(int id, String name, Output output) {
		this.id = id;
		this.output = output;
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId(){
		return id;
	}

	public String getIdName() {
		return getString();
	}
	
	public String getString() {
		return "MARKER";
	}
	
	public boolean isTerminal() {
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		if (receive || output.receive()) {
			output.init(source);
			output.set(source, source.getBookmark());
		}
		
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id=").append(id)
			.append(", name=").append(name)
			.append(", output=").append(output)
			.append("]");
		return sb.toString();
	}
}
