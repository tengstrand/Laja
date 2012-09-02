package net.sf.laja.reflection;

import java.lang.reflect.Constructor;

public class ConstructorTypelist extends AbstractTypelist {
	private Constructor constructor;
	
	public ConstructorTypelist(Constructor constructor) {
		this.constructor = constructor;
	}

	public Constructor getConstructor() {
		return constructor;
	}
	
	@Override
	public Class[] getTypes() {
		return constructor.getParameterTypes();
	}
}
