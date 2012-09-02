package net.sf.laja.template.data;

import net.sf.laja.TemplateParser.IVariableRef;

public class VariableRef implements IVariableRef {
	private String variableName;
	
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableName() {
		return variableName;
	}
	
	@Override
	public String toString() {
		return "VariableRef{variableName=" + variableName + "}";
	}
}
