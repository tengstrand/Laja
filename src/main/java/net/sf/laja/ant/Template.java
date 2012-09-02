package net.sf.laja.ant;

public class Template {
	private String filename = "generate.laja";
	
	public void setFile(String filename) {
		this.filename = filename;
	}
	
	public String asArguments() {
		return filename;
	}
}
