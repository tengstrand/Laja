package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IComparition;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IReturncmd;
import net.sf.laja.template.condition.Comparition;
import net.sf.laja.template.data.Data;

public class Returncmd implements IReturncmd, Generator {
	private Data returnedData;
	private Macro macro;
	
	public Returncmd(Macro macro) {
		this.macro = macro;
	}

	public void setReturnedData(IData idata) {
		this.returnedData = (Data)idata;
	}

	public void setReturnedComparition(IComparition icomparition) {
		returnedData = new Data();
		returnedData.setComparision((Comparition)icomparition);
	}
	
	public Object generate() {
		macro.getBlock().setReturnedValue(returnedData.evaluate());
		return null;
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#return ");
		returnedData.print(printer);
		printer.println();
	}
}
