package net.sf.laja.template.data;

import net.sf.laja.TemplateParser.IArgs;
import net.sf.laja.TemplateParser.IMethodRef;
import net.sf.laja.template.Args;

public class MethodRef implements IMethodRef {
	private String methodName;
	private Args args;
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public void setArgs(IArgs iargs) {
		args = (Args)iargs;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public Args getArguments() {
		return args;
	}
	
	@Override
	public String toString() {
		return "MethodRef{methodName=" + methodName + ", args=" + args + "}";
	}
}
