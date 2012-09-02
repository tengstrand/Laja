package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class Range implements Element {
	private int hashCode;
	private int id;
	private boolean not;
	private String name;
	private char chr1;
	private char chr2;
	private String string;
	private Output output;

	// char, char
	public Range(int id, String name, String str1, String str2) {
		this(id, name, str1, str2, new NoOutput());
	}
	
	public Range(int id, String name, String str1, char chr2) {
		this(id, name, str1, chr2, new NoOutput());
	}
	
	public Range(int id, String name, char chr1, String str2) {
		this(id, name, chr1, str2, new NoOutput());
	}

	public Range(int id, String name, char chr1, char chr2) {
		this(id, name, chr1, chr2, new NoOutput());
	}
	
	// char, char, flags
	public Range(int id, String name, String str1, String str2, int flags) {
		this(id, name, str1.charAt(0), str2.charAt(0), flags, new NoOutput());
	}
	
	public Range(int id, String name, String str1, char chr2, int flags) {
		this(id, name, str1.charAt(0), chr2, flags, new NoOutput());
	}
	
	public Range(int id, String name, char chr1, String str2, int flags) {
		this(id, name, chr1, str2.charAt(0), flags, new NoOutput());
	}

	public Range(int id, String name, char chr1, char chr2, int flags) {
		this(id, name, chr1, chr2, flags, new NoOutput());
	}

	// char, char, output
	public Range(int id, String name, String str1, String str2, Output output) {
		this(id, name, str1.charAt(0), str2.charAt(0), 0, output);
	}
	
	public Range(int id, String name, String str1, char chr2, Output output) {
		this(id, name, str1.charAt(0), chr2, 0, output);
	}
	
	public Range(int id, String name, char chr1, String str2, Output output) {
		this(id, name, chr1, str2.charAt(0), 0, output);
	}

	public Range(int id, String name, char chr1, char chr2, Output output) {
		this(id, name, chr1, chr2, 0, output);
	}
	
	// char, char, flags, output
	public Range(int id, String name, char chr1, char chr2, int flags, Output output) {
		this.hashCode = new Integer(id).hashCode();
		this.id = id;
		this.name = name;
		this.not = (flags & NOT) > 0;
		this.chr1 = chr1;
		this.chr2 = chr2;
		this.output = output;
		
		StringBuffer sb = new StringBuffer();
		sb.append("'").append(chr1).append("'..'").append(chr2).append("'");
		string = sb.toString();
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
		if (source.reachedEnd()) {
			return false;
		}

		int bookmark = source.getBookmark();

		char chr = source.getCharacter();

		// The "methods" CS (case sensitive) and CI (case insesitive) is not applied for Range.
		boolean eq = chr >= chr1 && chr <= chr2;
		
		eq = (eq != not);

		if (eq && (receive || output.receive())) {
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
		return ((Range)obj).getId() == id;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Range:[id=").append(id)
			.append("chr=").append(chr1).append("..").append(chr2)
			.append("]");
		return sb.toString();
	}
}
