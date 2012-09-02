package net.sf.laja.launch;

public class UnknownOptionCommand implements ViewInfoCommand {
	private String argument;
	
	public UnknownOptionCommand(String argument) {
		this.argument = argument;
	}

	@Override
	public void execute() {
		System.out.println("Unknown option: " + argument);
	}
}
