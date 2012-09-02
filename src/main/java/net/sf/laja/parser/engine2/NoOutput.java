package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.source.Source;

public class NoOutput implements Output {

	public NoOutput() {
	}

	public void init(Source source) {
	}

	public void set(Source source, int bookmark) {
	}

	public boolean receive() {
		return false;
	}
}
