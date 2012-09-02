package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.source.Source;

public interface Output {
	public boolean receive();

	public void init(Source source);

	public void set(Source source, int bookmark);
}
