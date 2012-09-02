package net.sf.laja.reflection;

import org.junit.Test;
import static junit.framework.Assert.*;

public class TypeComparisionResultTest {
	
	@Test
	public void calculateAssignableTypeIntegerInteger() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Integer.class, Integer.class);
		TypeMatcher expectedResult = new TypeMatcher(0, 0, Integer.class);
		
		assertEquals(expectedResult, result);
	}

	@Test
	public void calculateAssignableTypeIntegerInt() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Integer.class, int.class);
		TypeMatcher expectedResult = new TypeMatcher(0, 1, Integer.class);
		
		assertEquals(expectedResult, result);
	}

	@Test
	public void calculateAssignableTypeIntInteger() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(int.class, Integer.class);
		TypeMatcher expectedResult = new TypeMatcher(0, 1, int.class);
		
		assertEquals(expectedResult, result);
	}

	@Test
	public void calculateAssignableTypeNumberInteger() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Number.class, Integer.class);
		TypeMatcher expectedResult = new TypeMatcher(1, 0, Number.class);
		
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void calculateAssignableTypeObjectInteger() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Double.class, Integer.class);
		
		assertNull(result);
	}
	
	@Test
	public void add() {
		TypeMatcher result1 = new TypeMatcher(1, 2, null);
		TypeMatcher result2 = new TypeMatcher(10, 20, null);
		TypeMatcher expectedResult = new TypeMatcher(11, 22, null);
		
		assertEquals(expectedResult, result1.add(result2));
	}
}
