package net.sf.laja.ant;

import org.apache.tools.ant.BuildException;

public class Value {
	private String name;
	private Integer intValue;
	private Long longValue;
	private Double doubleValue;
	private String stringValue;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String asArguments() {
		throwExceptionIfMissingMandatoryValues();

		String args = name + "=";
		
		if (intValue != null) {
			args += intValue;
		} else if (longValue != null) {
			args += longValue;
		} else if (doubleValue != null) {
			args += doubleValue;
		} else {
			args += "\"" + stringValue + "\"";
		}
				
		return args;
	}

	private void throwExceptionIfMissingMandatoryValues() {
		if (name == null) {
			throw new BuildException("Missing property: name");
		}
		if (intValue == null && longValue == null && stringValue == null && doubleValue == null) {
			throw new BuildException("Missing property: intValue, longValue, doubleValue or stringValue");
		}
	}
}
