import com.mockobjects.dynamic.C;

class ClassService {
	private Map types = new HashMap();
	
	public ClassService() {
		types.put("Double", Double.class);
		types.put("Float", Float.class);
		types.put("Long", Long.class);
		types.put("Integer", Integer.class);
		types.put("Short", Short.class);
		types.put("Character", Character.class);
		types.put("Byte", Byte.class);
		types.put("Boolean", Boolean.class);
		
		types.put("double", double.class);
		types.put("float", float.class);
		types.put("long", long.class);
		types.put("int", int.class);
		types.put("short", short.class);
		types.put("char", char.class);
		types.put("byte", byte.class);
		types.put("boolean", boolean.class);
	}
	
	/**
	 * True if: a instanceof b
	 */
	boolean isInstanceof(def a, def b) {
		if (!(a instanceof Class)) {
			a = a.class
		}
		if (!(b instanceof Class)) {
			b = b.class
		}
		
		return b.isAssignableFrom(a)
	}
	
	public Class loadClass(String className) {
		return Class.forName(className)
	}

	public Class type(String type) {
		return types.get(type);
	}
}
