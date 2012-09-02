package net.sf.laja.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an iteratable list with all methods for a class and all its super class(es)
 * that matches a given method name.
 * 
 * @author Joakim Tengstrand
 */
public class MethodTypelistCollection implements Iterable<Typelist> {
	private List<Typelist> typelists = new ArrayList<Typelist>();
	
	public MethodTypelistCollection(Class clazz, String methodName) {
		populateTypelistWithClassMethods(clazz, methodName);
	}

	private void populateTypelistWithClassMethods(Class clazz, String methodName) {
		Method methods[] = clazz.getDeclaredMethods();

		for (Method method : methods) {
			if (method.getName().equals(methodName) &&
					!Modifier.isPrivate(method.getModifiers()) && 
					!Modifier.isProtected(method.getModifiers())) {
				typelists.add(new MethodTypelist(method));
			}
		}
		clazz = clazz.getSuperclass();
		
		if (clazz != null) {
			populateTypelistWithClassMethods(clazz, methodName);
		}
	}
	
	public Iterator<Typelist> iterator() {
		return typelists.iterator();
	}
}
