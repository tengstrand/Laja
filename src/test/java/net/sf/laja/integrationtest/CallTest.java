package net.sf.laja.integrationtest;

import java.util.Map;

import org.junit.Test;

public class CallTest extends AbstractIntegrationTestBase {
	
	public static class MyClass {
		public static int staticMethod(int value) {
			return value + 100;
		}
		
		public static void staticMethod(Map<Object,String> map, String attribute) {
			map.put(attribute, "Populated in MyClass.staticMethod(Map,String)");
		}
		
		public void getValue(Map<Object,String> map, String attribute) {
			map.put(attribute, "The value");
		}

		public void setLength(Map<Object,String> map, String... array) {
			map.put("length", String.valueOf(array.length));
		}
		
		public void setLength(Map<Object,String> map, int a, String b, String... array) {
			map.put("length", String.valueOf(array.length));
		}
	}
	
	@Test
	public void callStaticMethod() {
		test("call", "call-static-method");
	}

	@Test
	public void callMapMethod() {
		test("call", "call-map-method");
	}
	
	@Test
	public void callObjectMethod() {
		test("call", "call-object-method");
	}
	
	@Test
	public void callObjectMethodVarargs() {
		test("call", "call-object-method-varargs");
	}
	
	@Test
	public void callListMethod() {
		test("call", "call-list-method");
	}

	@Test
	public void callMacroArgumentsAsMap() {
		test("call", "call-macro-arguments-as-map");
	}

	@Test
	public void callFunctionIntoVariable() {
		test("call", "call-function-into-variable");
	}

	@Test
	public void callFunctionIntoNamepace() {
		test("call", "call-function-into-namespace");
	}
	
	@Test
	public void callMacroIntoVariable() {
		test("call", "call-macro-into-variable");
	}
}
