package net.sf.laja.template;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.IElse;

public class Else implements IElse, SyntaxPrintable {
	private Block block;

	public void setBlock(IBlock iblock) {
		this.block = (Block)iblock;
	}
	
	public Block getBlock() {
		return block;
	}

	public void print(SyntaxPrinter printer) {
		printer.printlnWithTabs("#else");
		if (block != null) {
			printer.tabForward();
			block.print(printer);
			printer.tabBackward();
		}
	}
}
