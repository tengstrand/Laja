package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IMapData;
import net.sf.laja.TemplateParser.IMapDataRef;
import net.sf.laja.context.Context;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Namespaces;

public class MapDataRef implements IMapDataRef, Evaluator, SyntaxPrintable {
	private MapData mapData;
	
	public MapDataRef(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		mapData = new MapData(namespaces, templateTextWriter);
	}
	
	public void setMapData(IMapData imapData) {
		mapData = (MapData)imapData;
	}

	public Object evaluate() {
		return mapData.evaluate();
	}

	public String getDataType() {
		return mapData.getDataType();
	}

	public boolean isLazy() {
		return mapData.isLazy();
	}

	public void print(SyntaxPrinter printer) {
		printer.print("{");
		mapData.print(printer);
		printer.print("}");
	}
	
	public void setAttribute(String attributeName, Context parentContext) {
		mapData.setAttribute(attributeName, parentContext);
	}
}
