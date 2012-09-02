package net.sf.laja.launch;

public class DefaultTemplateNotFoundCommand implements ViewInfoCommand {

	@Override
	public void execute() {
		System.out.println("Could not find default template file '" + Settings.DEFULT_TEMPLATE_FILE + "'. Type 'laja -help' for instructions");
	}
}
