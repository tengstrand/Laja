package net.sf.laja.reflection;

import java.util.HashMap;
import java.util.Map;

public class TypeMatcher implements Comparable<TypeMatcher> {
	private static double VARARG_PENALTY = 100000000;
	private static double INHERITANCE_FACTOR = 10000;

	private double missmatchScore;
	private Class matchedType;

	private static Map<Class, Class> typeConvererTable = new HashMap<Class, Class>();

	static {
		typeConvererTable.put(Double.class, double.class);
		typeConvererTable.put(Float.class, float.class);
		typeConvererTable.put(Long.class, long.class);
		typeConvererTable.put(Integer.class, int.class);
		typeConvererTable.put(Short.class, short.class);
		typeConvererTable.put(Character.class, char.class);
		typeConvererTable.put(Byte.class, byte.class);
		typeConvererTable.put(Boolean.class, boolean.class);
		typeConvererTable.put(double.class, Double.class);
		typeConvererTable.put(float.class, Float.class);
		typeConvererTable.put(long.class, Long.class);
		typeConvererTable.put(int.class, Integer.class);
		typeConvererTable.put(short.class, Short.class);
		typeConvererTable.put(char.class, Character.class);
		typeConvererTable.put(byte.class, Byte.class);
		typeConvererTable.put(boolean.class, Boolean.class);
	}

	public TypeMatcher() {
		this(0, 0, null);
	}

	public TypeMatcher(double missmatchScore, Class matchedType) {
		this.missmatchScore = missmatchScore;
		this.matchedType = matchedType;
	}

	public TypeMatcher(int inheritanceMissmatchScore,
			int primitiveMissmatchScore, Class matchedType) {
		this.missmatchScore = inheritanceMissmatchScore * INHERITANCE_FACTOR
				+ primitiveMissmatchScore;
		this.matchedType = matchedType;
	}

	/**
	 * Calculates an assignable type (java.lang.Class) for a given type.
	 * Calculates how well a parameter is matching a specific type, e.g:
	 * 
	 * Parameter type      Argument type     IMS PMS Description (IMS=inheritance missmatch score, PMS=primitive missmatch score - less is better)
	 * =================   ================= === === ===========
	 * java.lang.Integer - java.lang.Integer   0   0  100% match. 
	 * java.lang.integer - int                 0   1
	 * java.lang.Integer - java.lang.Number    1   0 
	 * java.lang.Intger  - java.lang.Object    2   0
	 * java.lang.Integer - java.lang.Double           Returns null, it was not possible to find an assignable class.
	 * java.lang.Number  - null                0   0 
	 * java.lang.int     - null                       Returns null, can not assign null to a native type.
	 * 
	 * @param parameterType test against this type.
	 * @param argumentType the type we want to test
	 * @return matching type matcher
	 */
	public static TypeMatcher evaluateAssignableType(Class parameterType, Class argumentType) {
		if (argumentType == null) {
			if (parameterType.isPrimitive()) {
				return null;
			}
			return new TypeMatcher(0, 0, parameterType);
		}
		
		if (!parameterType.isAssignableFrom(argumentType)) {
			Class primitive = typeConvererTable.get(argumentType);
			if (primitive != null && parameterType.isAssignableFrom(primitive)) {
				return new TypeMatcher(0, 1, primitive);
			}
			return null;
		}
		int inheritanceMissmatchScore = 0;

		while (!argumentType.isAssignableFrom(parameterType)) {
			inheritanceMissmatchScore++;
			argumentType = argumentType.getSuperclass();

			if (argumentType == null) {
				return null;
			}
		}
		return new TypeMatcher(inheritanceMissmatchScore, 0, argumentType);
	}

	public Class getMatchedType() {
		return matchedType;
	}

	public TypeMatcher add(TypeMatcher that) {
		return new TypeMatcher(missmatchScore + that.missmatchScore, null);
	}

	public TypeMatcher addVarargPenalty() {
		return new TypeMatcher(missmatchScore + VARARG_PENALTY, null);
	}

	@Override
	public int compareTo(TypeMatcher that) {
		return new Double(missmatchScore).compareTo(that.missmatchScore);
	}

	@Override
	public boolean equals(Object obj) {
		TypeMatcher that = (TypeMatcher) obj;
		return missmatchScore == that.missmatchScore
				&& matchedType == that.matchedType;
	}
}
