package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser.IDefaultSyntaxError;
import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser.IDefaultSyntaxErrorFactory;

public class DefaultSyntaxErrorFactory implements IDefaultSyntaxErrorFactory {
	private DefaultSyntaxError defaultSyntaxError;

	public DefaultSyntaxErrorFactory(DefaultSyntaxError defaultSyntaxError) {
		this.defaultSyntaxError = defaultSyntaxError;
	}

	public IDefaultSyntaxError createDefaultSyntaxError() {
		return defaultSyntaxError;
	}
}
