package net.sf.laja.launch;

public class ViewExceptionCommand implements ViewInfoCommand {
	private InargumentException inargumentException;
	
	public ViewExceptionCommand(InargumentException inargumentException) {
		this.inargumentException = inargumentException;
	}

	@Override
	public void execute() {
		System.out.println(inargumentException.getMessage());
	}
}
