package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IIndexItem;
import net.sf.laja.TemplateParser.IListIndex;

public class ListIndex implements IListIndex, SyntaxPrintable {
	private List<IndexItem> indices = new ArrayList<IndexItem>();

	public List<IndexItem> getIndices() {
		return indices;
	}

	public void addIndexItem(IIndexItem iindexItem) {
		indices.add((IndexItem)iindexItem);
	}

	public void print(SyntaxPrinter printer) {
		for (IndexItem indexItem : indices) {
			printer.print("[");
			indexItem.print(printer);
			printer.print("]");
		}
	}
	
	public int evaluateListIndex(int index) {
		return indices.get(index).evaluateInteger();
	}
	
	@Override
	public String toString() {
		return indices.toString();
	}
}
