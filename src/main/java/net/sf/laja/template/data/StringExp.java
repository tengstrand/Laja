package net.sf.laja.template.data;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.TemplateParser.IStringref;
import net.sf.laja.context.Context;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Stringref;

public class StringExp implements IStringExp, Evaluator {
	private List<Evaluator> expression = new ArrayList<Evaluator>();
	
	private class TextAdapter implements Evaluator {
		private String text;
		
		private TextAdapter(String text) {
			// Replace \" with "
			this.text = text.replace("\\\"", "\"");
		}
		public Object evaluate() {
			return text;
		}
		public boolean isLazy() {
			return false;
		}
		public String toString() {
			return text;
		}
		public void setAttribute(String attributeName, Context context) {
			throw new IllegalStateException("This method should not be called!");
		}
		public String getDataType() {
			return "String";
		}
		public void print(SyntaxPrinter printer) {
			printer.print(text);
		}
	}
	
	public void addText(String text) {
		expression.add(new TextAdapter(text));
	}
	
	public void addStringref(IStringref istringref) {
		Stringref stringref = (Stringref)istringref;
		if (stringref.getDirectory() != null) {
			expression.add(new TextAdapter(stringref.getDirectory()));
		} else {
			expression.add(stringref.getReference());
		}
	}

	public String evaluate() {
		String result = "";
		for (Evaluator evaluator : expression) {
			result += evaluator.evaluate();
		}
		return result;
	}

	public boolean isLazy() {
		return true;
	}
	
	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluate());
	}
	
	public String getDataType() {
		return "String";
	}

	public void print(SyntaxPrinter printer) {
		printer.print("\"");
		for (Evaluator evaluator : expression) {
			evaluator.print(printer);
		}
		printer.print("\"");
	}
	
	@Override
	public String toString() {
		return "StringExp{" + expression + "}";
	}
}
