package net.sf.laja.launch;

import net.sf.laja.template.Template;

/**
 * If sending in e.g.: -i
 * ...then the variable _i is set to true.
 *
 */
public class SingleParameterCommand implements PrepareGenerateCommand {
	private final String variable;
    private final Settings settings;

    public SingleParameterCommand(String variable, Settings settings) {
		this.variable = "_" + variable.substring(1);
        this.settings = settings;
	}

    public void execute(Template template) {
        settings.setValue(variable, "true");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleParameterCommand that = (SingleParameterCommand) o;

        if (variable != null ? !variable.equals(that.variable) : that.variable != null) return false;

        return true;
    }
}
