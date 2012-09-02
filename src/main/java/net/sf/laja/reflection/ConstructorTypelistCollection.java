package net.sf.laja.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConstructorTypelistCollection implements Iterable<Typelist> {
	private List<Typelist> typelists = new ArrayList<Typelist>();

	public ConstructorTypelistCollection(Class clazz) {
		Constructor[] constructors = clazz.getConstructors();
		
		for (Constructor constructor : constructors) {
			if (!Modifier.isPrivate(constructor.getModifiers()) &&
				!Modifier.isProtected(constructor.getModifiers())) {
				typelists.add(new ConstructorTypelist(constructor));
			}
		}
	}
	
	@Override
	public Iterator<Typelist> iterator() {
		return typelists.iterator();
	}
}
