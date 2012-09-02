package net.sf.laja.parser.grammar;

import net.sf.laja.parser.GrammarParser;

public class Omarg implements GrammarParser.IOmarg {
	private boolean isStr = false;
	private boolean isIndex = false;
	private String arg;

	public void setStr() {
		isStr = true;
	}

	public void setIndex() {
		isIndex = true;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}

	public boolean isStr() {
		return isStr;
	}

	public boolean isIndex() {
		return isIndex;
	}

	public String getArg() {
		return arg;
	}

	public String toString() {
		if (isStr()) {
			return "String " + arg;
		}
		return "Index " + arg;
	}
}
