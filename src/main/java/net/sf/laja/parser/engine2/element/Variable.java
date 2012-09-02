package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class Variable implements Element {
	private int hashCode;
	private int id;
	private boolean not;
	private String name;
	private String str;
	private Boolean caseSensitive;
	private Output output;
	private Value value;
	private String string;
	private Condition condition;

	public interface Condition {
		public boolean isTrue();
	}

	public interface Value {
		public String getValue();
	}

	public Variable(int id, String name, Value value) {
		this(id, name, value, new NoOutput());
	}

	public Variable(int id, String name, Value value, int flags) {
		this(id, name, value, flags, new NoOutput());
	}

	public Variable(int id, String name, Value value, Output output) {
		this(id, name, value, 0, output);
	}

	public Variable(int id, String name, Value value, int flags, Output output) {
		this.hashCode = new Integer(id).hashCode();
		this.id = id;
		this.name = name;
		this.value = value;
		this.not = (flags & NOT) > 0;
		this.caseSensitive = (flags & CASE) == 0 ? null : new Boolean((flags & CS) > 0);
		this.output = output;
		this.string = "$" + name + ": \"" + str + "\"";
	}

	public Variable(int id, String name, Condition condition) {
		this(id, name, condition, new NoOutput());
	}

	public Variable(int id, String name, Condition condition, int flags) {
		this(id, name, condition, flags, new NoOutput());
	}

	public Variable(int id, String name, Condition condition, Output output) {
		this(id, name, condition, 0, output);
	}

	public Variable(int id, String name, Condition condition, int flags, Output output) {
		this.id = id;
		this.name = name;
		this.condition = condition;
		this.not = (flags & NOT) > 0;
		this.caseSensitive = (flags & CASE) == 0 ? null : new Boolean((flags & CS) > 0);
		this.output = output;
		this.string = "$" + name + ": \"" + str + "\"";
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId(){
		return id;
	}

	public String getIdName() {
		return string;
	}
	
	public String getString() {
		return string;
	}
	
	public boolean isTerminal() {
		return true;
	}
	
	public String getName() {
		return name;
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		if (condition != null) {
			return condition.isTrue() != not;
		}

		if (source.reachedEnd()) {
			return false;
		}

		if (this.caseSensitive != null) {
			caseSensitive = this.caseSensitive.booleanValue();
		}
	
		int bookmark = source.getBookmark();		
		str = value.getValue();

		boolean eq = source.match(str.toCharArray(), parentNot, not, caseSensitive);
		
		if (eq) {
			if (receive || output.receive()) {
				output.init(source);
				output.set(source, bookmark);
			}
		}
		return eq;
	}

	public int hashCode() {
		return hashCode;
	}

	public boolean equals(Object obj) {
		return ((Variable)obj).getId() == id;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Variable:[id=").append(id)
			.append(", name=").append(name)
			.append(", value=\"").append(str)
			.append("\"]");
		return sb.toString();
	}
}
