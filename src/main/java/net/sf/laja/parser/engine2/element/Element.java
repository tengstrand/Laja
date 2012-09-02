package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.inspector.Inspectable;
import net.sf.laja.parser.engine2.source.Source;

public interface Element extends Inspectable {
	public static final int NOT = 1;
	public static final int CS = 2;
	public static final int CI = 4;
	public static final int CASE = 6;

	public int getId();
	public String getName();
	public String getString();
	public boolean isOptional();
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive);
}
