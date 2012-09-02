package net.sf.laja.context;

import java.util.Arrays;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.exception.LajaException;
import net.sf.laja.reflection.MethodInvoker;
import net.sf.laja.template.Args;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.data.AttributeRef;

public class ObjectContext extends Context {
	private Object object;

	public ObjectContext(Namespaces namespaces, TemplateTextWriter templateTextWriter, Object object) {
		super(namespaces, templateTextWriter);
		this.object = object;
	}

	@Override
	public String getName() {
		return object.getClass().getCanonicalName();
	}

	@Override
	public Macro getMacro(String macroName) {
		throw new LajaException("Macros not supported for ObjectContext.");
	}

	@Override
	public void addMacro(Macro macro) {
		throw new LajaException("Macros not supported for ObjectContext.");
	}

	@Override
	public Object evaluateMacro(AttributeRef attributeRef) {
		throw new LajaException("Macros not supported for ObjectContext.");
	}
	
	@Override
	public boolean contains(String attributeName) {
		// TODO: Implement!
		throw new LajaException("2. To be implemented!!!");
	}

	@Override
	public void set(String methodName, Object value) {
		try {
			MethodInvoker.callMethodOrAccessFieldIfMatchingMethodNotFound(
					object.getClass(), object, methodName,
					Arrays.asList("set"), new Object[] { value });
		} catch (LajaException e) {
			if (object instanceof Class) {
				// If the instance "object" is a Class, then try to call the
				// static method.
				MethodInvoker.callMethodOrAccessFieldIfMatchingMethodNotFound(
						(Class) object, null, methodName, Arrays.asList("set"),
						new Object[] { value });
			}
		}
	}

	@Override
	public boolean isLazy(AttributeRef attributeRef) {
		return false;
	}

	@Override
	public Object evaluate(AttributeRef attributeRef) {
		if (object == null) {
			throw new LajaException("Can not call method with null reference");
		}
		String methodOrAttributeName;
		Args methodArguments;

		if (attributeRef.isMethodRef()) {
			methodOrAttributeName = attributeRef.getMethodName();
			methodArguments = attributeRef.getMethodArguments();
		} else {
			methodOrAttributeName = attributeRef.getVariableName();
			methodArguments = new Args();
		}

		Object result = null;

		try {
			result = MethodInvoker.callMethodOrAccessFieldIfMatchingMethodNotFound(object.getClass(), object, methodOrAttributeName, Arrays.asList("get", "is"), methodArguments);
		} catch (LajaException e) {
			if (object instanceof Class) {
				// If the instance "object" is a Class, then try to call the static method.
				try {
					result = MethodInvoker.callMethodOrAccessFieldIfMatchingMethodNotFound((Class) object, null, methodOrAttributeName, Arrays.asList("get", "is"), methodArguments);
				} catch (LajaException e2) {
					// If a method could not be found, return null!
				}
			}
		}
		return result;
	}

	// if (attributes.size() == 0) {
	// return object.toString();
	// }
	// Attribute attribute = attributes.get(0);
	// Args args = attribute.getArgs();
	// String methodName = attribute.getName();
	//
	// Object result = null;
	// try {
	// result = MethodInvoker.callMethod(object.getClass(), object, methodName,
	// Arrays.asList("get", "is"), args);
	// } catch (LajaException e) {
	// if (object instanceof Class) {
	// // If the instance "object" is a Class, then try to call the static
	// method.
	// try {
	// result = MethodInvoker.callMethod((Class)object, null, methodName,
	// Arrays.asList("get", "is"), args);
	// } catch (LajaException e2) {
	// // If a method could not be found, return null!
	// }
	// }
	// }
	//		
	// return evaluateNextAttribute(result, methodName, attributes);

	@Override
	public String toString() {
		return object.toString();
	}
}
