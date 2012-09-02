package net.sf.laja.parser.engine2;

public class Index {
	private int startIdx;
	private int endIdx;

	public Index(int startIdx, int endIdx) {
		this.startIdx = startIdx;
		this.endIdx = endIdx;
	}

	public int getStartIndex() {
		return startIdx;
	}

	public int getEndIndex() {
		return endIdx;
	}

	public String toString() {
		return "(" + startIdx + "," + endIdx + ")";
	}
}
