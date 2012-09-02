package net.sf.laja.parser.template;

public class AddStatement {
	private int id = 0;
	private String elementId;
	private String method = "add";
	private NewStatement newStatement;
	private RefStatement refStatement;

	public AddStatement() {
	}

	public AddStatement(String elementId, NewStatement newStatement) {
		this.elementId = elementId;
		this.newStatement = newStatement;
	}

	public AddStatement(String elementId, RefStatement refStatement) {
		this.elementId = elementId;
		this.refStatement = refStatement;
	}

	public void setMehtod(String method) {
		this.method = method;
	}
	
	public int getId() {
		if (id == 0) {
			id = GrammarData.getId();
		}
		return id;
	}
	
	public boolean isNewStatementDefined() {
		return newStatement != null;
	}

	public boolean isRefStatementDefined() {
		return refStatement != null;
	}
	
	public String getElementId() {
		return elementId;
	}
	
	public NewStatement getNewStatement() {
		return newStatement;
	}
	
	public RefStatement getRefStatement() {
		return refStatement;
	}

	public String getMethod() {
		return method;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("AddStatement{")
		    .append("method=").append(method)
			.append(", newStatement=").append(newStatement)
			.append(", refStatement=").append(refStatement)
			.append("}");
		return sb.toString();
	}
}
