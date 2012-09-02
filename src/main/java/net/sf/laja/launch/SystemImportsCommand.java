package net.sf.laja.launch;

import java.io.File;

import net.sf.laja.template.Template;

public class SystemImportsCommand extends SetCommand {
	public static final String SYSTEM_IMPORTS_VARIABLE_NAME = "sysimp";
	
	public SystemImportsCommand(String variable, String value, Settings settings) {
		super(variable, value.replace('/', File.separatorChar), settings);
	}

	@Override
	public void execute(Template template) {
		getSettings().setSystemImportsFilename(getValue());
	}
}
