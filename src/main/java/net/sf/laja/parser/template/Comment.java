package net.sf.laja.parser.template;

public class Comment {
	private boolean tab;
	private String comment;
	
	public Comment(boolean tab, String comment) {
		this.tab = tab;
		this.comment = comment;
	}

	public boolean isTab() {
		return tab;
	}
	
	public String getComment() {
		return comment;
	}	
	
	@Override
	public String toString() {
		return "Comment{tab=" + tab + ", comment=" + comment + "}";
	}
}
