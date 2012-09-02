package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IText;

public class Text implements IText, Generator {
	private String text;
	private TemplateTextWriter templateTextWriter;

	public Text(TemplateTextWriter templateTextWriter) {
		this.templateTextWriter = templateTextWriter;
	}

	public void setContent(String text) {
		this.text = text;
	}
	
	public Object generate() {
		templateTextWriter.write(text);
		return null;
	}

	public void print(SyntaxPrinter printer) {
		printer.print(text.toString());
	}
	
	public String toString() {
		return "Text{text=\"" + text + "\"}";
	}
}
