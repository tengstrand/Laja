package net.sf.laja.reflection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class MethodInvokerTest {

	public static class TestData {
		public static String getStaticMethod() {
			return "static";
		}
		
		public String getValue() {
			return "value";
		}
		
		public String getValue(int intparam) {
			return "intparam: " + intparam;
		}
		
		public String getValue(String stringparam) {
			return "stringparam: " + stringparam;
		}
		
		public void vararg(String... args) {
		}
	}

	@Test
	public void loadClass() {
		try {
			Class clazz = Class.forName("net.sf.laja.integrationtest.CallTest$MyClass");
		} catch (ClassNotFoundException e) {
			assertTrue("Could not load class MyClass", false);
		}
	}
	
	@Test
	public void invokeStaticMethod() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class clazz = TestData.class;
		
		String callingMethodName = "getStaticMethod";
		Class[] parameterTypes = new Class[0];
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(clazz, callingMethodName, Arrays.asList("get"), parameterTypes);
		
		String result = (String)methodTypelist.getMethod().invoke(null, new Object[0]);
		
		assertEquals("static", result);
	}
	
	@Test
	public void invokeMethodWithNoArguments() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class clazz = TestData.class;
		String callingMethodName = "getValue";
		Class[] parameterTypes = new Class[0];
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(clazz, callingMethodName, Arrays.asList("get"), parameterTypes);
		
		TestData testData = new TestData();
		String result = (String)methodTypelist.getMethod().invoke(testData, new Object[0]);
		
		assertEquals("value", result);
	}
	
	@Test
	public void invokeMethodWithIntArgument() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class clazz = TestData.class;
		String callingMethodName = "getValue";
		Class[] parameterTypes = new Class[] { Integer.class };
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(clazz, callingMethodName, Arrays.asList("get"), parameterTypes);

		Object[] args = new Object[parameterTypes.length];
		args[0] = 123;

		Object instance = new TestData();
		Object result = methodTypelist.getMethod().invoke(instance, args);
		
		assertEquals(result, "intparam: 123");
	}

	@Test
	public void invokeMethodWithNullArgument() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class clazz = TestData.class;
		String callingMethodName = "getValue";
		Class[] parameterTypes = new Class[] { null };
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(clazz, callingMethodName, Arrays.asList("get"), parameterTypes);

		Object[] args = new Object[parameterTypes.length];
		args[0] = null;

		Object instance = new TestData();
		Object result = methodTypelist.getMethod().invoke(instance, args);
		
		assertEquals(result, "stringparam: null");
	}

	@Test
	public void invokeMethodWithVararg() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String callingMethodName = "vararg";
		Class[] parameterTypes = new Class[] { String[].class };
		
		MethodTypelist methodTypelist = MethodInvoker.getBestMatchedMethod(TestData.class, callingMethodName, new ArrayList<String>(), parameterTypes);

		String[] args = new String[1];
		args[0] = "abc";

		Object instance = new TestData();
		methodTypelist.getMethod().invoke(instance, new Object[] {args});
	}
}
