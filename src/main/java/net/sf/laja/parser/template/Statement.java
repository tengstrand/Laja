package net.sf.laja.parser.template;

public class Statement {
	boolean isBaseDeclaration;
	private String className;
	private String variableName;

	private int phase;
	private Comments comments;
	private NewStatement newStatement;
	private AddStatement addStatement;

	public Statement(int phase, Comments comments) {
		this.phase = phase;
		this.comments = comments;
	}

	public Statement(int phase, boolean baseDecl, String className, String variableName, NewStatement newStatement) {
		this.phase = phase;
		this.isBaseDeclaration = baseDecl;
		this.className = className;
		this.variableName = variableName;
		this.newStatement = newStatement;
	}
	
	public Statement(int phase, boolean baseDecl, String variableName, AddStatement addStatement) {
		this.phase = phase;
		this.isBaseDeclaration = baseDecl;
		this.variableName = variableName;
		this.addStatement = addStatement;
	}

	public int getPhase() {
		return phase;
	}
	
	public Comments getComments() {
		return comments;
	}
	
	public NewStatement getNewStatement() {
		return newStatement;
	}
	
	public AddStatement getAddStatement() {
		return addStatement;
	}

	public boolean isStatDeclaration() {
		return !isBaseDeclaration && newStatement != null;
	}
	
	public boolean isBaseDeclaration() {
		return isBaseDeclaration;
	}

	public String getClassName() {
		return className;
	}
	
	public String getVariableName() {
		return variableName;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Statement{")
			.append("isBaseDeclaration=").append(isBaseDeclaration)
			.append(", classname=").append(className)
			.append(", variableName=").append(variableName)
			.append(", comments=").append(comments)
			.append(", newStatement=").append(newStatement)
			.append(", addStatement=").append(addStatement)
			.append("}");
		return sb.toString();
	}
}
