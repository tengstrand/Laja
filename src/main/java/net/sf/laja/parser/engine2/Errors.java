package net.sf.laja.parser.engine2;

public class Errors {
	
	public Errors(int errorIdx) {
		this.errorIdx = errorIdx;
	}
	
	private int errorIdx;
	
	public int getErrorIdx() {
		return errorIdx;
	}
}
