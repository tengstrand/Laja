package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IElse;
import net.sf.laja.TemplateParser.IElseif;
import net.sf.laja.TemplateParser.IIfcmd;

public class Ifcmd implements IIfcmd, Generator {
	private Condition ifcondition;
	private List<Elseif> elseifs = new ArrayList<Elseif>();
	private Else elsecmd;
	private Block block;

	public void setCondition(ICondition icondition) {
		this.ifcondition = (Condition)icondition;
	}

	public void addElseif(IElseif ielseif) {
		elseifs.add((Elseif)ielseif);
	}

	public void setElse(IElse ielse) {
		elsecmd = (Else)ielse;
	}
	
	public void setBlock(IBlock itrueBlock) {
		this.block = (Block)itrueBlock;
	}
	
	public Object generate() {
		Block block = performIfStatementAndReturnBlockIfTrue();
		if (block != null) {
			block.generate();
		}
		return null;
	}
	
	private Block performIfStatementAndReturnBlockIfTrue() {
		if (ifcondition.evaluateBoolean()) {
			return block;
		}
		for (Elseif elseif : elseifs) {
			if (elseif.isTrue()) {
				return elseif.getBlock();
			}
		}
		return elsecmd == null ? null : elsecmd.getBlock();
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#if (");
		ifcondition.print(printer);
		printer.println(")");
		
		if (block != null) {
			printer.tabForward();
			block.print(printer);
			printer.tabBackward();
		}

		for (Elseif elseif : elseifs) {
			elseif.print(printer);
		}
		
		if (elsecmd != null) {
			elsecmd.print(printer);
		}
		printer.printlnWithTabs("#end");
	}
	
	@Override
	public String toString() {
		return "Ifcmd{ifcondition=" + ifcondition + ", block=" + block + "}";
	}
}
