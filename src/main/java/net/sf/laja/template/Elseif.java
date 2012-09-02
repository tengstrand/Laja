package net.sf.laja.template;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IElseif;

public class Elseif implements IElseif, SyntaxPrintable {
	private Condition condition;
	private Block block;

	public void setCondition(ICondition icondition) {
		this.condition = (Condition)icondition;
	}

	public void setBlock(IBlock iblock) {
		this.block = (Block)iblock;
	}
	
	public boolean isTrue() {
		return condition.evaluateBoolean();
	}
	
	public Block getBlock() {
		return block;
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#else if (");
		condition.print(printer);
		printer.println(")");
		
		if (block != null) {
			printer.tabForward();
			block.print(printer);
			printer.tabBackward();
		}
	}
}
