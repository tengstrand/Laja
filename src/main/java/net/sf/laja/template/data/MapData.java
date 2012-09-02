package net.sf.laja.template.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IMapData;
import net.sf.laja.TemplateParser.IMapMember;
import net.sf.laja.context.Context;
import net.sf.laja.context.MapContext;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.MapMember;
import net.sf.laja.template.Namespaces;

public class MapData implements IMapData, Evaluator, SyntaxPrintable {
	private List<MapMember> members = new ArrayList<MapMember>();
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;

	public MapData(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
	}

	public void addMember(IMapMember imapMember) {
		members.add((MapMember)imapMember);
	}

	public Object evaluate() {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		for (MapMember member : members) {
			map.put(member.getName(), member.evaluate());
		}
		return map;
	}

	public boolean isLazy() {
		return true;
	}
	
	public void setAttribute(String attributeName, Context parentContext) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		parentContext.set(attributeName, map);
		Context mapSetter = new MapContext(attributeName, namespaces, templateTextWriter, map);
		for (MapMember member : members) {
			member.set(mapSetter);
		}
	}
	
	public String getDataType() {
		return "Map";
	}

	public void print(SyntaxPrinter printer) {
		String sep = "";
		
		for (MapMember member : members) {
			printer.print(sep);
			member.print(printer);
			sep = ", ";
		}
	}
	
	public String toString() {
		return members.toString();
	}
}
