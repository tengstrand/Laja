package net.sf.laja.parser.template;

import java.util.ArrayList;
import java.util.List;

public class StatementList {
	private List<Statement> list = new ArrayList<Statement>();

	public void add(Statement statement) {
		list.add(statement);
	}
	
	public List<Statement> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "StatementList{list=" + list + "}";
	}
}
