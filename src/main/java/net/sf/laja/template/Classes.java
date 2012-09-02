package net.sf.laja.template;

import java.util.HashMap;
import java.util.Map;

public class Classes {
	private Map<String,Class> classes = new HashMap<String,Class>();
	
	public void addClass(Class clazz) {
		classes.put(clazz.getName(), clazz);
	}
	
	public Class getClass(String className) {
		return classes.get(className);
	}
}
