package net.sf.laja.parser.template;

public class RefStatement {
	private String refName;
	private boolean not;
	private Boolean caseSensitive;
	private String output;

	public RefStatement(String refName) {
		this.refName = refName;
		output = "";
	}
	
	public void setData(boolean not, Boolean caseSensitive, String output) {
		this.not = not;
		this.caseSensitive = caseSensitive;
		this.output = output == null ? "" : output;
	}

	/**
	 * @return the variableName
	 */
	public String getRefName() {
		return refName;
	}
	
	public boolean isNot() {
		return not;
	}
	
	public boolean isCaseSensitive() {
		return caseSensitive != null && caseSensitive;
	}
	
	public boolean isCaseInsensitive() {
		return caseSensitive != null && !caseSensitive;
	}

	public boolean isOutputDefined() {
		return output.length() > 0;
	}
	
	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(1000);
		sb.append("RefStatement{")
			.append("refName=").append(refName)
			.append(", not=").append(not)
			.append(", caseSensitive=").append(caseSensitive)
			.append(", output=\"").append(output).append("\"")
			.append("}");
		return sb.toString();
	}
}
