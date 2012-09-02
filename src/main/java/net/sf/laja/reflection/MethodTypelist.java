package net.sf.laja.reflection;

import java.lang.reflect.Method;

public class MethodTypelist extends AbstractTypelist {
	private Method method;
	
	public MethodTypelist(Method method) {
        method.setAccessible(true);
		this.method = method;
	}

	public Class[] getTypes() {
		return method.getParameterTypes();
	}
	
	public Method getMethod() {
		return method;
	}
}
