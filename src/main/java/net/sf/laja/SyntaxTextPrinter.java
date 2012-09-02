package net.sf.laja;

public class SyntaxTextPrinter implements SyntaxPrinter {
	private final String TAB = "  ";

	private int tabs = 0;
	
	@Override
	public void print(String text) {
		System.out.print(text);
	}

	@Override
	public void println() {
		System.out.println();
	}

	@Override
	public void println(String text) {
		System.out.println(text);
	}
	
	@Override
	public void printWithTabs(String text) {
		printTabs();
		System.out.print(text);
	}

	@Override
	public void printlnWithTabs(String text) {
		printTabs();
		System.out.println(text);
	}
	
	private void printTabs() {
		for (int i=0; i<tabs; i++) {
			System.out.print(TAB);
		}
	}

	@Override
	public void tabForward() {
		tabs++;
	}
	
	@Override
	public void tabBackward() {
		if (tabs == 0) {
			throw new IllegalStateException("Not possible to tab backwards, current tab possition is 0");
		}
		tabs--;
	}
}
