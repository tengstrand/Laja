package net.sf.laja.template;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IArgs;
import net.sf.laja.TemplateParser.INewStatement;
import net.sf.laja.context.Context;
import net.sf.laja.exception.LajaException;
import net.sf.laja.reflection.ConstructorTypelist;
import net.sf.laja.reflection.ConstructorTypelistCollection;
import net.sf.laja.reflection.TypelistEvaluator;
import net.sf.laja.template.data.Data;

public class NewStatement implements INewStatement, Evaluator {
	private String className;
	private Args args;
	private List<Data> arguments;
	
	private Classes classes;

	public NewStatement(Classes classes) {
		this.classes = classes;
	}
	
	public void addClassOrPackageName(String classOrPackageName) {
		if (className == null) {
			className = classOrPackageName;
		} else {
			className += "." + classOrPackageName;
		}
	}
	
	public void setArguments(IArgs iargs) {
		args = (Args)iargs;
		arguments = ((Args)iargs).getArguments();
	}

	public Object evaluate() {
		try {
			return newInstance();
		} catch (Exception e) {
			throw new LajaException(e);
		}
	}

	public String getDataType() {
		return "new statement";
	}

	public boolean isLazy() {
		return false;
	}	

	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluate());
	}

	private Object newInstance() throws ClassNotFoundException, SecurityException, NoSuchMethodException, 
		IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		
		Class clazz = calculateClass();
		
		Object[] args = new Object[arguments.size()];
		Class[] types = new Class[arguments.size()];
		
		for (int i=0; i<arguments.size(); i++) {
			args[i] = arguments.get(i).evaluate();
			types[i] = args[i].getClass();
		}

		ConstructorTypelistCollection constructorTypelistCollection = new ConstructorTypelistCollection(clazz);
		ConstructorTypelist constructorTypelist = (ConstructorTypelist)TypelistEvaluator.getBestTypelist(types, constructorTypelistCollection);

		if (constructorTypelist == null) {
			throw new LajaException("Could not find a constructor for class " + clazz.getCanonicalName() + " with the parameter list: " + Arrays.asList(types));
		}
		
		return constructorTypelist.getConstructor().newInstance(args);
	}

	private Class calculateClass() throws ClassNotFoundException {
		Class clazz = getClassByClassName(className);
		
		if (clazz == null && !className.contains(".")) {
			clazz = getClassByClassName("java.lang." + className);
		}
		if (clazz == null) {
			clazz = getClassFromImportedClasses();
		}
		if (clazz == null) {
			throw new ClassNotFoundException(className);
		}
		return clazz;
	}
	
	private Class getClassByClassName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	private Class getClassFromImportedClasses() {
		return classes.getClass(className);
	}

	public void print(SyntaxPrinter printer) {
		printer.print("new ");
		printer.print(className);
		args.print(printer);
	}
	
	@Override
	public String toString() {
		return "NewStatement{className=" + className + ", arguments=" + arguments + "}";
	}
}
