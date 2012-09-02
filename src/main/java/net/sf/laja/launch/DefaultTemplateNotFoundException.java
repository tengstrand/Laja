package net.sf.laja.launch;

public class DefaultTemplateNotFoundException extends InargumentException {
	
	public DefaultTemplateNotFoundException() {
		super("Could not find default template file '" + Settings.DEFULT_TEMPLATE_FILE + "'. Type 'laja -help' for instructions");
	}
	
}
