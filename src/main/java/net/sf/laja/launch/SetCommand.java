package net.sf.laja.launch;

import net.sf.laja.template.Template;

public class SetCommand implements PrepareGenerateCommand {
	private String variable;
	private String value;
	private Settings settings;

	public SetCommand(String variable, String value, Settings settings) {
		this.variable = variable;
		this.settings = settings;
		
		this.value = value;
	}

	@Override
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
