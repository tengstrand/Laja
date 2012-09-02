package net.sf.laja.template;

import net.sf.laja.TemplateParser.ICall;
import net.sf.laja.TemplateParser.ICommand;
import net.sf.laja.TemplateParser.IError;
import net.sf.laja.TemplateParser.IForeach;
import net.sf.laja.TemplateParser.IFunction;
import net.sf.laja.TemplateParser.IIfcmd;
import net.sf.laja.TemplateParser.IImportcmd;
import net.sf.laja.TemplateParser.ILocal;
import net.sf.laja.TemplateParser.IMacro;
import net.sf.laja.TemplateParser.ISet;
import net.sf.laja.TemplateParser.IWhilecmd;
import net.sf.laja.TemplateParser.IWrite;

public class Command implements ICommand {
	private Generator generator;

	public void setWrite(IWrite iwrite) {
		generator = (Generator)iwrite;
	}

	public void setSet(ISet iset) {
		generator = (Generator)iset;
	}

	public void setLocal(ILocal ilocal) {
		generator = (Generator)ilocal;
	}
	
	public void setIfcmd(IIfcmd iifcmd) {
		generator = (Generator)iifcmd;
	}

	public void setWhilecmd(IWhilecmd iwhilecmd) {
		generator = (Generator)iwhilecmd;
	}
	
	public void setForeach(IForeach iforeach) {
		generator = (Generator)iforeach;
	}

	public void setImport(IImportcmd iimportcmd) {
		generator = (Generator)iimportcmd;
	}

	public void setMacro(IMacro imacro) {
		generator = (Generator)imacro;
	}

	public void setCall(ICall icall) {
		generator = (Generator)icall;
	}
	
	public void setFunction(IFunction ifunction) {
		generator = (Macro)ifunction;
	}

	public void setError(IError ierror) {
		generator = (Error)ierror;
	}
	
	public Generator getGenerator() {
		return generator;
	}

	public String toString() {
		return "Command{" + generator + "}";
	}
}
