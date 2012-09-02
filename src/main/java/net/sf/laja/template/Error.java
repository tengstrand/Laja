package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IError;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.StringExp;

public class Error implements IError, Generator {
	private StringExp message;
	
	private int indexInSource;
	private Source source;

	public Error(Source source) {
		this.source = source;
	}
 	
	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}

	public void setMessage(IStringExp imessage) {
		message = (StringExp)imessage;
	}

	public Object generate() {
		throw new InterpretationException(source, indexInSource, message.evaluate());
	}

	public void print(SyntaxPrinter printer) {
		printer.printlnWithTabs(message.evaluate());
	}
}
