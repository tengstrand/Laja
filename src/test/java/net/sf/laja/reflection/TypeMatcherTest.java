package net.sf.laja.reflection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TypeMatcherTest {
	
	@Test
	public void compareNumberWithInteger() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Number.class, Integer.class);
		
		assertEquals(new TypeMatcher(1, 0, Number.class), result);
	}

	@Test
	public void compareIntegerWithNull() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(Number.class, null);

		assertEquals(new TypeMatcher(0, 0, Number.class), result);
	}
	
	@Test
	public void compareIntWithNull() {
		TypeMatcher result = TypeMatcher.evaluateAssignableType(int.class, null);
		
		assertNull(result);
	}
}
