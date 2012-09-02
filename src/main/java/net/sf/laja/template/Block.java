package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.ICommand;
import net.sf.laja.TemplateParser.IReturncmd;
import net.sf.laja.TemplateParser.IStringref;
import net.sf.laja.TemplateParser.IText;
import net.sf.laja.context.Context;
import net.sf.laja.template.data.Reference;

public class Block implements IBlock, Generator {
	private boolean hasReturnBeenExecuted;
	private Object returnedValue;
	
	private Context context;
	private TemplateTextWriter templateTextWriter;
	private List<Generator> contents = new ArrayList<Generator>();

	public Block(TemplateTextWriter templateTextWriter) {
		this.templateTextWriter = templateTextWriter;
	}
	
	public void addText(String plainText) {
		Text text = new Text(templateTextWriter);
		text.setContent(plainText);
		contents.add(text);
	}
	
	public void addCommand(ICommand icommand) {
		Command command = (Command)icommand;
		contents.add(command.getGenerator());
	}

	public void addStringref(IStringref istringref) {
		Stringref stringref = (Stringref)istringref;
		contents.add(stringref.getReference());
	}

	public void addText(IText itext) {
		contents.add((Text)itext);
	}

	public void addReturncmd(IReturncmd ireturncmd) {
		contents.add((Returncmd)ireturncmd);
	}

	public void insertFirst(Importcmd importcmd) {
		contents.add(0, importcmd);
	}
	
	public Context getContext() {
		return context;
	}
	
	public Object generate() {
		hasReturnBeenExecuted = false;
		
		for (Generator content : contents) {
			content.generate();
			if (hasReturnBeenExecuted) {
				return returnedValue;
			}
		}
		return null;
	}

	public void setReturnedValue(Object returnedValue) {		
		this.returnedValue = returnedValue;
		this.hasReturnBeenExecuted = true;
	}
	
	public boolean hasReturnBeenExecuted() {
		return hasReturnBeenExecuted;
	}

	public void print(SyntaxPrinter printer) {
		for (Generator content : contents) {
			if (content instanceof Reference) {
				printer.print("{");
				content.print(printer);
				printer.print("}");
			} else {
				content.print(printer);
			}
		}
	}
	
	public String toString() {
		return "Block{contents=" + contents + "}";
	}
}
