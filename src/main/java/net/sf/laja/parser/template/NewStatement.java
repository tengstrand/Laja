package net.sf.laja.parser.template;

import net.sf.laja.parser.grammar.element.Repeats;

public class NewStatement {
	private int id = 0;
	private String className;
	private String variableName;
	private String elementName;
	private boolean not;
	private Boolean caseSensitive;
	private String output;
	private Repeats repeats;

	private String variableRef;
	private RangeData rangeData;
	private ChrData chrData;

	public NewStatement(String className, String variableName) {
		this.className = className;
		this.variableName = variableName;
		output = "";
	}
	
	public NewStatement(String className, String variableName, String variableRef) {
		this(className, variableName);
		this.variableRef = variableRef;
	}

	public NewStatement(String className, String variableName, RangeData rangeData) {
		this(className, variableName);
		this.rangeData = rangeData;
	}

	public NewStatement(String className, String variableName, ChrData chrData) {
		this(className, variableName);
		this.chrData = chrData;
	}

	public int getId() {
		if (id == 0) {
			id = GrammarData.getId();
		}
		return id;
	}
	
	public boolean isVariableRefDefined() {
		return variableRef != null;
	}
	
	public boolean isRangeDefined() {
		return rangeData != null;
	}
	
	public boolean isChrDefined() {
		return chrData != null;
	}
	
	public String getClassName() {
		return className;
	}

	public String getVariableName() {
		return variableName;
	}

	public String getVariableRef() {
		return variableRef;
	}

	public RangeData getRange() {
		return rangeData;
	}
	
	public ChrData getChr() {
		return chrData;
	}
	
	public void setOutput(String output) {
		this.output = output == null ? "" : output;
	}

	public void setData(boolean not, Boolean caseSensitive, String output) {
		setData(not, caseSensitive, output, null);
	}
	
	public void setData(boolean not, Boolean caseSensitive, String output, Repeats repeats) {
		this.not = not;
		this.caseSensitive = caseSensitive;
		this.output = output == null ? "" : output;
		this.repeats = repeats;
	}

	public boolean getIsRepeatsDefined() {
		return repeats != null;
	}
	
	public Repeats getRepeats() {
		return repeats;
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
	
	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	public boolean isOutputDefined() {
		return output.length() > 0;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("NewStatement{")
			.append("className=").append(className)
			.append(", variableName=").append(variableName)
			.append(", elementName=").append(elementName)
			.append(", not=").append(not)
			.append(", caseSensitive=").append(caseSensitive)
			.append(", output=\"").append(output).append("\"")
			.append(", variableRef=").append(variableRef)
			.append(", rangeData=").append(rangeData)
			.append(", chrData=").append(chrData)
			.append("}");
		return sb.toString();
	}
}
