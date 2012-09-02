package net.sf.laja.parser.template;

public class RangeData {
	private RangeLimit rangeLimit1;
	private RangeLimit rangeLimit2;

	public RangeData(RangeLimit rangeLimit1, RangeLimit rangeLimit2) {
		this.rangeLimit1 = rangeLimit1;
		this.rangeLimit2 = rangeLimit2;
	}
	
	public RangeLimit getLimit1() {
		return rangeLimit1;
	}
	
	public RangeLimit getLimit2() {
		return rangeLimit2;
	}
	
	@Override
	public String toString() {
		return "RangeData{" + rangeLimit1 + "-" + rangeLimit2 + "}";
	}
}
