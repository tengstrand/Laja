package net.sf.laja.parser.template;

public class ChrData {
	private String integer;
	
	public ChrData(String integer) {
		this.integer = integer;
	}

	public String getInteger() {
		return integer;
	}
	
	@Override
	public String toString() {
		return "ChrData{" + integer + "}";
	}
}
