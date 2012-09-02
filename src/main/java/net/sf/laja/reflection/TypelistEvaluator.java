package net.sf.laja.reflection;

public class TypelistEvaluator {
	
	private static class Match {
		Typelist typelist = null;
		TypeMatcher typeMatcher = new TypeMatcher(Double.MAX_VALUE, null);
	}
	
	public static Typelist getBestTypelist(Class[] callingTypes, Iterable<Typelist> typelistCollection) {
		Match bestMatch = new Match();
		
		for (Typelist typelist : typelistCollection) {
			if (callingTypes.length == typelist.getTypes().length) {
				setBestMatchNormalArgumentList(callingTypes, typelist, bestMatch);
			}
			if (callingTypes.length >= typelist.getTypes().length && isLastElementArray(typelist)) {
				setBestMatchVarargs(callingTypes, typelist, bestMatch);
			}
		}
		return bestMatch.typelist;
	}

	private static Class getLastElement(Typelist typelist) {
		return typelist.getTypes()[typelist.getTypes().length-1];
	}

	private static boolean isLastElementArray(Typelist typelist) {
		return typelist.getTypes().length > 0 && getLastElement(typelist).isArray();
	}
	
	private static void setBestMatchNormalArgumentList(Class[] callingTypes, Typelist typelist, Match bestMatch) {
		TypeMatcher methodResult = new TypeMatcher();
		
		Class[] types = typelist.getTypes();
		
		for (int i=0; i<callingTypes.length; i++) {
			TypeMatcher result = TypeMatcher.evaluateAssignableType(types[i], callingTypes[i]);
			
			if (result == null) {
				return;
			}
			
			methodResult = methodResult.add(result);
			
			if (methodResult.compareTo(bestMatch.typeMatcher) > 0) {
				return;
			}
		}
		if (methodResult.compareTo(bestMatch.typeMatcher) < 0) {
			bestMatch.typeMatcher = methodResult;
			bestMatch.typelist = typelist;
		}
	}

	private static void setBestMatchVarargs(Class[] callingTypes, Typelist typelist, Match bestMatch) {
		TypeMatcher methodResult = new TypeMatcher();
		
		Class[] types = typelist.getTypes();
		
		for (int i=0; i<typelist.getTypes().length; i++) {
			TypeMatcher result = TypeMatcher.evaluateAssignableType(types[i], callingTypes[i]);
			
			if (result == null) {
				if (isLastElement(typelist, i)) {
					Class varargType = getLastElement(typelist).getComponentType();

					result = new TypeMatcher();
					
					for (int j=i; j<callingTypes.length; j++) {
						if (!varargType.isAssignableFrom(callingTypes[j])) {
							return;
						}
						result = result.addVarargPenalty();
					}
					typelist.setVarargStartIndex(i);
				}
			}
			methodResult = methodResult.add(result);
			
			if (methodResult.compareTo(bestMatch.typeMatcher) > 0) {
				return;
			}
		}
		if (methodResult.compareTo(bestMatch.typeMatcher) < 0) {
			bestMatch.typeMatcher = methodResult;
			bestMatch.typelist = typelist;
		}
	}

	private static boolean isLastElement(Typelist typelist, int i) {
		return i == typelist.getTypes().length-1;
	}

	
	// int, String, String
	// int, String, String...
	// int, String, Object...
	
	
}
