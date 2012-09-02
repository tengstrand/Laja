package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IWhilecmd;

public class Whilecmd implements IWhilecmd, Generator {
	private Condition condition;
	private Block block;

	public void setCondition(ICondition icondition) {
		condition = (Condition)icondition;
	}

	public void setBlock(IBlock iblock) {
		block = (Block)iblock;
	}

	public Object generate() {
		while (condition.evaluateBoolean()) {
			block.generate();
		}
		return null;
	}

	public void print(SyntaxPrinter printer) {
		// TODO Implement!
	}
}
