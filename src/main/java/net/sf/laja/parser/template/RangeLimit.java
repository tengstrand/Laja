package net.sf.laja.parser.template;

import net.sf.laja.parser.grammar.element.Range1;

public class RangeLimit {
	private String string;
	private Integer integer;
	
	public RangeLimit(Range1 range1) {
		string = range1.getString();
		integer = range1.getInteger();
	}
	
	public boolean isStringDefined() {
		return string != null;
	}
	
	public String getString() {
		return string;
	}
	
	public Integer getInteger() {
		return integer;
	}
	
	@Override
	public String toString() {
		if (string != null) {
			return "RangeLimit{\"" + string + "\"}";
		}
		return "RangeLimit{" + integer + "}";
	}
}
