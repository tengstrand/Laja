package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IArgs;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IMapData;
import net.sf.laja.template.data.Data;
import net.sf.laja.template.data.MapData;

public class Args implements IArgs, SyntaxPrintable {
	private List<Data> arguments = new ArrayList<Data>();

	public void addData(IData idata, String stringData) {
		arguments.add((Data)idata);
	}

	public void setMapData(IMapData imapData) {
		Data mapData = new Data();
		mapData.setMapData((MapData)imapData);
		arguments.add(mapData);
	}
	
	public List<Data> getArguments() {
		return arguments;
	}

	public void print(SyntaxPrinter printer) {
		printer.print("(");
		
		String sep = "";
		
		for (Data argument : arguments) {
			printer.print(sep);
			argument.print(printer);
			sep = ", ";
		}

		printer.print(")");
	}
	
	public String toString() {
		return "Args{arguments=" + arguments + "}";
	}
}
