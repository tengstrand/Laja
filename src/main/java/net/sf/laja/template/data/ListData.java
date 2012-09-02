package net.sf.laja.template.data;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IListData;
import net.sf.laja.context.Context;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Namespaces;

public class ListData implements IListData, Evaluator, SyntaxPrintable {
	private boolean isArray;
	private List<Data> members = new ArrayList<Data>(); 
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	
	public ListData(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
	}

	public void setArray() {
		isArray = true;
	}
	
	public void addData(IData idata) {
		members.add((Data)idata);
	}
	
	public Object evaluate() {
		if (isArray) {
			return evaluateArray();
		}
		return evaluateList();
	}

	private Object[] evaluateArray() {
		Object[] array = new Object[members.size()];
		
		for (int i=0; i<members.size(); i++) {
			array[i] = members.get(i).evaluate();
		}
		return array;
	}
	
	private List<Object> evaluateList() {
		List<Object> resultList = new ArrayList<Object>();
		
		for (Data data : members) {
			resultList.add(data.evaluate());
		}
		return resultList;
	}
	
	public boolean isLazy() {
		return true;
	}
	
	public void setAttribute(String attributeName, Context parentContext) {
		if (isArray) {
			setArrayAttribute(attributeName, parentContext);
		} else {
			setListAttribute(attributeName, parentContext);
		}
	}

	private void setArrayAttribute(String attributeName, Context parentContext) {
		Object[] array = new Object[members.size()];
		parentContext.set(attributeName, array);

		int index = 0;
		for (Data data : members) {
			array[index++] = data.evaluate();
		}
	}
	
	private void setListAttribute(String attributeName, Context parentContext) {
		List<Object> list = new ArrayList<Object>();
		parentContext.set(attributeName, list);
		
		for (Data data : members) {
			list.add(data.evaluate());
		}
	}

	public String getDataType() {
		return "List";
	}

	public void print(SyntaxPrinter printer) {
		String sep = "";
		
		printer.print("[");
		
		for (Data data : members) {
			printer.print(sep);
			data.print(printer);
			sep = ", ";
		}
		
		printer.print("]");
		
		if (isArray) {
			printer.print(" as array");
		}
	}

	@Override
	public String toString() {
		return members.toString();
	}
}
