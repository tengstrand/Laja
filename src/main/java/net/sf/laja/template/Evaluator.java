package net.sf.laja.template;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.context.Context;

public interface Evaluator extends SyntaxPrintable {
	public String getDataType();
	public Object evaluate();
	public boolean isLazy();
	public void setAttribute(String attributeName, Context parentContext);
}
