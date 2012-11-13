package net.sf.laja.launch;

import net.sf.laja.template.Template;

public class SetCommand implements PrepareGenerateCommand {
	private final String variable;
	private final String value;
	private final Settings settings;

	public SetCommand(String variable, String value, Settings settings) {
		this.variable = variable;
		this.settings = settings;
		
		this.value = value;
	}

	public void execute(Template template) {
		settings.setValue(variable, value);
	}
	
	public String getValue() {
		return value;
	}

	protected Settings getSettings() {
		return settings;
	}
	
	@Override
	public boolean equals(Object obj) {
		SetCommand other = (SetCommand)obj;
		
		return variable.equals(other.variable) && value.equals(other.value);
	}
}
