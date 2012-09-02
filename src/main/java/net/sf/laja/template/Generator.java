package net.sf.laja.template;

import net.sf.laja.SyntaxPrintable;

public interface Generator extends SyntaxPrintable {
	public Object generate();
}
