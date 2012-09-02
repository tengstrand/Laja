package net.sf.laja.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.sf.laja.exception.LajaException;
import net.sf.laja.template.Args;
import net.sf.laja.template.data.Data;

public class MethodInvoker {
	private static String getStringFirstLetterUpperCase(String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}
	
	public static Object callMethodOrAccessFieldIfMatchingMethodNotFound(Class clazz, Object instance, String methodName, List<String> validMethodPrefixes, List<Object> argumentList) {
		Object[] arguments = new Object[argumentList.size()];
		for (int i=0; i<argumentList.size(); i++) {
			arguments[i] = argumentList.get(i);
		}
		return callMethodOrAccessFieldIfMatchingMethodNotFound(clazz, instance, methodName, validMethodPrefixes, arguments);
	}

	public static Object callMethodOrAccessFieldIfMatchingMethodNotFound(Class clazz, Object instance, String methodName, List<String> validMethodPrefixes, Args args) {
		int argumentsSize = args == null ? 0 : args.getArguments().size();
		Object[] arguments = new Object[argumentsSize];

		for (int i=0; i<argumentsSize; i++) {
			Data argument = args.getArguments().get(i); 
			arguments[i] = argument.evaluate();
		}
		return callMethodOrAccessFieldIfMatchingMethodNotFound(clazz, instance, methodName, validMethodPrefixes, arguments);
	}
	
	public static Object callMethodOrAccessFieldIfMatchingMethodNotFound(Class clazz, Object instance, String methodName, List<String> validMethodPrefixes, Object[] arguments) {
		Class[] parameterTypes = new Class[arguments.length];

		for (int i=0; i<arguments.length; i++) {
			parameterTypes[i] = arguments[i] == null ? null : arguments[i].getClass();
		}
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(clazz, methodName, validMethodPrefixes, parameterTypes);
		
		if (methodTypelist == null) {
			if (arguments.length == 0) {
				// Search for fields
				for (Field field : clazz.getFields()) {
					if (methodName.equals(field.getName())) {
						try {
                            field.setAccessible(true);
							return field.get(instance);
						} catch (IllegalArgumentException e) {
							throw new LajaException("Could not access field '" + methodName + "': " + e.getMessage());
						} catch (IllegalAccessException e) {
							throw new LajaException("Could not access field '" + methodName + "': " + e.getMessage());
						}
					}
				}
				if (clazz.isArray() && methodName.equals("length")) {
					return Array.getLength(instance);
				}
			}
			
			String message = "Could not find method " + methodName + "(";
			String separator = "";
			if (arguments.length > 0) {
				for (int i=0; i<arguments.length; i++) {
					message += separator + parameterTypes[i];
					separator = ", ";
				}
			}
			message += ") in class " + clazz.getCanonicalName() + ".";
			
			throw new LajaException(message);
		}
		
		try {
			if (methodTypelist.isVararg()) {
				Object[] varargArguments = new Object[methodTypelist.getVarargStartIndex() + 1];
				for (int i=0; i<methodTypelist.getVarargStartIndex(); i++) {
					varargArguments[i] = arguments[i];
				}
				
				int varargLength = arguments.length - methodTypelist.getVarargStartIndex();
				Object varargs = Array.newInstance(methodTypelist.getVarargType(), varargLength);
				System.arraycopy(arguments, methodTypelist.getVarargStartIndex(), varargs, 0, varargLength);

				varargArguments[methodTypelist.getVarargStartIndex()] = varargs;
				
				return methodTypelist.getMethod().invoke(instance, varargArguments);
			} else {
				return methodTypelist.getMethod().invoke(instance, arguments);
			}
		} catch (IllegalArgumentException e) {
			return new LajaException(e);
		} catch (IllegalAccessException e) {
			return new LajaException(e);
		} catch (InvocationTargetException e) {
			return new LajaException(e);
		}
	}

	/**
	 * Searches for the best matching method for a given class, method name and parameter list.
	 * 
	 * @param clazz the class we are trying find a matching method for.
	 *   
	 * @return the best matched method. Returns null if no match was found.
	 */
	
	static MethodTypelist getBestMatchedMethod(Class clazz, String methodName, List<String> validMethodPrefixes, Class[] parameterTypes) {
		MethodTypelistCollection methodTypelistCollection = new MethodTypelistCollection(clazz, methodName);
		MethodTypelist methodTypelist = (MethodTypelist)TypelistEvaluator.getBestTypelist(parameterTypes, methodTypelistCollection);
		if (methodTypelist == null) {
			for (String validMethodPrefix : validMethodPrefixes) {
				if (!methodName.startsWith(validMethodPrefix)) {
					methodTypelistCollection = new MethodTypelistCollection(clazz, validMethodPrefix + getStringFirstLetterUpperCase(methodName));
					methodTypelist = (MethodTypelist)TypelistEvaluator.getBestTypelist(parameterTypes, methodTypelistCollection);
					if (methodTypelist != null) {
						return methodTypelist;
					}
				}
			}
		}
		return methodTypelist;
	}
}
