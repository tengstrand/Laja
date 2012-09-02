package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Util;
import net.sf.laja.parser.engine2.source.Source;

public class Str implements Element {
	private int hashCode;
	private int id;
	private boolean not;
	private String str;
	private char[] strChars;
	private String string;
	private Boolean caseSensitive;
	private Output output;
	
	public Str(int id, String str) {
		this(id, str, new NoOutput());
	}

	public Str(int id, String str, int flags) {
		this(id, str, flags, new NoOutput());
	}

	public Str(int id, String str, Output output) {
		this(id, str, 0, output);
	}

	public Str(int id, String str, int flags, Output output) {
		this.hashCode = new Integer(id).hashCode();
		this.id = id;
		this.str = str;
		this.strChars = str.toCharArray();
		this.not = (flags & NOT) > 0;
		this.caseSensitive = (flags & CASE) == 0 ? null : new Boolean((flags & CS) > 0);
		this.output = output;
		
		this.string = Util.replaceWhiteSpaces("\"" + str + "\"");
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId() {
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
		return str;
	}
	
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		if (source.reachedEnd()) {
			return false;
		}
		if (this.caseSensitive != null) {
			caseSensitive = this.caseSensitive.booleanValue();
		}
		
		int bookmark = source.getBookmark();
		
		boolean eq = source.match(strChars, parentNot, not, caseSensitive);

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
		return ((Str)obj).getId() == id;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Str:[id=").append(id)
			.append(", str=\"").append(str)
			.append("\"]");
		return sb.toString();
	}
}
