package net.sf.laja.template;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.IFunction;
import net.sf.laja.TemplateParser.IMacro;
import net.sf.laja.context.Context;
import net.sf.laja.context.LocalContext;
import net.sf.laja.context.MapContext;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.Data;

public class Macro implements IMacro, IFunction, Generator {
	private boolean isFunction;
	private int indexInSource;
	private String name;
	private List<String> parameters = new ArrayList<String>();
	private Block block;
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	private Context context;
	private Source source;
	private LocalContext localContext;
	
	public Macro(boolean isFunction, Source source, Namespaces namespaces, TemplateTextWriter templateTextWriter, Context context) {
		this.isFunction = isFunction;
		this.context = context;
		this.source = source;
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setName(String name) {
		this.name = name;
		localContext = new LocalContext(name, namespaces, templateTextWriter, context);
	}

	public void addParameter(String parameter) {
		parameters.add(parameter);
	}

	public void setBlock(IBlock iblock) {
		block = (Block)iblock;
	}

	public boolean isFunction() {
		return isFunction;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public Block getBlock() {
		return block;
	}

	public Context getLocalContext() {
		return localContext;
	}
	
	public Object generate() {
		context.addMacro(this);
		return null;
	}

	public void populateArguments(List<Object> arguments) {
		MapContext populatedArguments = new MapContext(name, namespaces, templateTextWriter);
		
		Iterator<Object> argumentsIterator = arguments.iterator();
		
		for (String parameter : parameters) {
			if (!argumentsIterator.hasNext()) {
				throw new InterpretationException(source, indexInSource, "Missing argument in parameter list for macro '" + name + "'");
			}
			populatedArguments.set(parameter, argumentsIterator.next());
		}
		if (argumentsIterator.hasNext()) {
			throw new InterpretationException(source, indexInSource, "Too many arguments in parameter list for macro '" + name + "'");
		}
		localContext.setLocalVariables(populatedArguments);
	}
	
	public void populateDataArguments(List<Data> arguments) {
		MapContext populatedArguments = new MapContext(name, namespaces, templateTextWriter);
		
		Iterator<Data> argumentsIterator = arguments.iterator();

		for (String parameter : parameters) {
			if (!argumentsIterator.hasNext()) {
				throw new InterpretationException(source, indexInSource, "Missing argument in parameter list for macro '" + name + "'");
			}
			Data argument = argumentsIterator.next();
			if (argument.isLazy()) {
				populatedArguments.set(parameter, argument);
			} else {
				populatedArguments.set(parameter, argument.evaluate());
			}
		}
		if (argumentsIterator.hasNext()) {
			throw new InterpretationException(source, indexInSource, "Too many arguments in parameter list for macro '" + name + "'");
		}
		localContext.setLocalVariables(populatedArguments);
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#macro ");
		printer.print(name);
		printer.print("(");
		
		String comma = "";
		for (String parameter : parameters) {
			printer.print(comma);
			printer.print(parameter);
			comma = ", ";
		}
		printer.println(")");
		
		if (block != null) {
			printer.tabForward();
			block.print(printer);
			printer.tabBackward();
		}
		printer.printlnWithTabs("#end");
	}
	
	@Override
	public String toString() {
		return "Macro{name=" + name + ", parameters=" + parameters + "}";
	}
}
