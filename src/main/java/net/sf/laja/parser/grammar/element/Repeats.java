package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IRepeats;

public class Repeats implements IRepeats {
	private int min;
	private int max;
	
	@Override
	public void setMin(String min) {
		this.min = this.max = java.lang.Integer.parseInt(min);
	}

	@Override
	public void setMax(String max) {
		if (max.equals("*")) {
			this.max = java.lang.Integer.MAX_VALUE;
		} else {
			this.max = java.lang.Integer.parseInt(max);
		}
	}

	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}

	public boolean isMaxDefined() {
		return max > min;
	}
}
