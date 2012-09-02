package net.sf.laja.template;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IMapMember;
import net.sf.laja.context.Context;
import net.sf.laja.template.data.Data;

public class MapMember implements IMapMember, Evaluator, SyntaxPrintable {
	private String name;
	private Data data;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setData(IData idata) {
		this.data = (Data)idata;
	}

	public boolean isLazy() {
		return data.isLazy();
	}
	
	public String getName() {
		return name;
	}
	
	public Object evaluate() {
		return data.evaluate();
	}
	
	public void set(Context context) {
		data.setAttribute(name, context);
	}

	public void setAttribute(String attributeName, Context context) {
		throw new IllegalStateException("This method should not be called.");
	}

	public String getDataType() {
		return "Map";
	}

	public void print(SyntaxPrinter printer) {
		printer.print(name + ": ");
		data.print(printer);
	}
	
	@Override
	public String toString() {
		return name + "=" + data;
	}
}
