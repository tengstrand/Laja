package net.sf.laja;

public interface SyntaxPrinter {
	public void print(String text);
	public void println();
	public void println(String text);
	public void printWithTabs(String text);
	public void printlnWithTabs(String text);
	public void tabForward();
	public void tabBackward();
}
