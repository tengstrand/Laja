package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBooleanData;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IFloatData;
import net.sf.laja.TemplateParser.IIntegerData;
import net.sf.laja.TemplateParser.IListData;
import net.sf.laja.TemplateParser.IMapDataRef;
import net.sf.laja.TemplateParser.INewStatement;
import net.sf.laja.TemplateParser.INullData;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.context.Context;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.condition.Comparition;

public class Data implements IData, Evaluator, SyntaxPrintable {
	private String originalString;
	private Evaluator evaluator;

	public void setContent(String data) {
		originalString = data;
	}

	public void setNewStatement(INewStatement inewStatement) {
		evaluator = (Evaluator) inewStatement;
	}

	public void setStringExp(IStringExp istringExp) {
		evaluator = (Evaluator) istringExp;
	}

	public void setListData(IListData ilistData) {
		evaluator = (Evaluator) ilistData;
	}

	public void setMapData(MapData mapData) {
		evaluator = mapData;
	}

	public void setMapDataRef(IMapDataRef imapDataRef) {
		evaluator = (Evaluator) imapDataRef;
	}

	public void setReference(IReference ireference) {
		evaluator = (Evaluator) ireference;
	}

	public void setNullData(INullData inullData) {
		evaluator = (Evaluator) inullData;
	}

	public void setBooleanData(IBooleanData ibooleanData) {
		evaluator = (Evaluator) ibooleanData;
	}

	public void setIntegerData(IIntegerData iintegerData) {
		evaluator = (Evaluator) iintegerData;
	}

	public void setFloatData(IFloatData ifloatData) {
		evaluator = (Evaluator) ifloatData;
	}

	public void setComparision(Comparition comparition) {
		evaluator = comparition;
	}

	public String getDataType() {
		return evaluator.getDataType();
	}

	public Object evaluate() {
		return evaluator.evaluate();
	}

	public void setAttribute(String attributeName, Context parentContext) {
		evaluator.setAttribute(attributeName, parentContext);
	}

	public boolean isLazy() {
		return evaluator.isLazy();
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public void print(SyntaxPrinter printer) {
		printer.print(originalString);
	}
	
	@Override
	public String toString() {
		return "Data:[evaluator=" + evaluator + "]";
	}
}