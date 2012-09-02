package net.sf.laja.parser.template;

import java.util.ArrayList;
import java.util.List;

public class Comments {
	private int phase;
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public Comments() {
	}
	
	public void add(boolean tab, String comment) {
		commentList.add(new Comment(tab, comment));
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	public boolean hasElements() {
		return commentList.size() > 0;
	}
	
	@Override
	public String toString() {
		String str = "Comment{";
		String concat = "";
		for (Comment comment : commentList) {
			str += concat + comment.toString();
			concat = ", ";
		}
		return str + "}";
	}
}
