package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.exception.ParserException;

public class Repeats {
	private int min;
	private int max;
	
	public Repeats(int repeats) {
		min = max = repeats;
	}

	public Repeats(int min, int max) {
		if (max < min) {
			throw new ParserException("Illegal range: " + min + ".." + max);
		}
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
}
