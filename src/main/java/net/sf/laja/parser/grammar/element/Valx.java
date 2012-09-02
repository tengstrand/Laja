package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IRepeats;
import net.sf.laja.parser.GrammarParser.IValx;

public class Valx implements IValx {
	private boolean repeat = false;
	private String varName;
	private String repeatName;
	private Repeats repeats;

	@Override
	public void setVarname(String varname) {
		varName = varname;
	}

	@Override
	public void setRepeat() {
		repeat = true;
	}

	@Override
	public void setRepeats(IRepeats irepeats) {
		this.repeats = (Repeats)irepeats;
		repeat = true;
	}

	@Override
	public void setRepeatName(String repeatName) {
		this.repeatName = repeatName;
	}
	
	public boolean isRepeat() {
		return repeat;
	}
	
	public String getVarName() {
		return varName;
	}

	public String getRepeatName() {
		return repeatName;
	}
	
	public Repeats getRepeats() {
		return repeats;
	}
}
