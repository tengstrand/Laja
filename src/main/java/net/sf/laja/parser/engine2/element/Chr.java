package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Util;
import net.sf.laja.parser.engine2.source.Source;

public class Chr implements Element {
	private int hashCode;
	private int id;
	private boolean not;
	private char character;
	private String str;
	private String string;
	private Output output;

	public Chr(int id, String str) {
		this(id, str, new NoOutput());
	}

	public Chr(int id, String str, int flags) {
		this(id, str, flags, new NoOutput());
	}

	public Chr(int id, char character) {
		this(id, character, 0, new NoOutput());
	}

	public Chr(int id, char character, int flags) {
		this(id, character, flags, new NoOutput());
	}

	public Chr(int id, String str, Output output) {
		this(id, str, 0, output);
	}

	public Chr(int id, String str, int flags, Output output) {
		this.id = id;
		this.character = str.charAt(0);
		this.not = (flags & NOT) > 0;
		this.str = str;
		this.output = output;
		this.string = Util.replaceWhiteSpaces("'" + str + "'");
	}

	public Chr(int id, char character, Output output) {
		this(id, character, 0, output);
	}

	public Chr(int id, char character, int flags, Output output) {
		this.hashCode = new Integer(id).hashCode();
		this.id = id;
		this.character = character;
		this.not = (flags & NOT) > 0;
		this.str = new String(new char[] { character });
		this.output = output;
		this.string = Util.replaceWhiteSpaces("'" + str + "'");
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
		return "'" + str + "'";
	}
	
	public char getCharacter() {
		return character;
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		if (source.reachedEnd()) {
			return false;
		}

		int bookmark = source.getBookmark();
		
		String s = source.getCharacterAsString();
		boolean eq;
		
		if (caseSensitive) {
			eq = s.equals(str);
		} else {
			eq = s.equalsIgnoreCase(str);
		}
		eq = (eq != not);

		if ((eq && receive) || output.receive()) {
			output.init(source);
			output.set(source, bookmark);
		}

		if (eq && !parentNot) {
			source.setBestIndex();
		}

		return eq;
	}

	public int hashCode() {
		return hashCode;
	}

	public boolean equals(Object obj) {
		return ((Chr)obj).getId() == id;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Chr:[[id=").append(id)
			.append(", not=").append(not)
			.append(", character=").append(character)
			.append(", str=\"").append(str)
			.append("\", output=").append(output)
			.append("]");
		return sb.toString();
	}
}
