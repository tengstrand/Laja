package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.laja.parser.grammar.element.Constructor;

public class RefList implements Iterable {
	private ArrayList<Ref> list = new ArrayList<Ref>();

	public RefList() {
	}

	public Iterator<Ref> iterator() {
		return list.iterator();
	}
	
	public List<Ref> getList() {
		return list;
	}

	public Ref getRef(String refname) {
		if (refname != null) {
			for (Ref ref : list) {
				if (ref.getRefname().equals(refname)) {
					return ref;
				}
			}
		}
		return null;
	}

	public String getArgClass(String argName) {
		for (Ref ref : list) {
			if (ref.getRefname().equals(argName)) {
				return ref.getClassName();
			}
		}
		return null;
	}

	public void add(String className, Constructor constructor, String variableName) {
		list.add(new Ref(className, constructor, variableName));
	}
}
