package net.sf.laja.integrationtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ReferenceTest extends AbstractIntegrationTestBase {

	public static class MyAttributes {
		public int x = 123;
		public String y = "abc";
		public int[] z = new int[1];
	}
	
	public static class Data {
		public boolean isValid() {
			return true;
		}
		
		public String getStringValue() {
			return "a string value";
		}
		
		@SuppressWarnings("unchecked")
		public List getList() {
			List list = new ArrayList();
			list.add("one");
			list.add("two");
			return list;
		}
		
		public int[] getArray(int index) {
			int[][] array = new int[2][];
			array[0] = new int[] { 1,2,3 } ;
			array[1] = new int[] { 4,5,6 } ;
			return array[index];
		}
		
		public String method(int x, String attribute, Map map) {
			return map.get(attribute).toString() + ":" + x;
		}
		
		public String toString() {
			return "This is the result of toString() in Data";
		}
	}
	
	@Test
	public void referenceVariable() {
		test("reference", "reference-variable");
	}

	@Test
	public void referenceMap() {
		test("reference", "reference-map");
	}
	
	@Test
	public void referenceObject() {
		test("reference", "reference-object");
	}

	@Test
	public void referenceList() {
		test("reference", "reference-list");
	}

	@Test
	public void referenceArray() {
		test("reference", "reference-array");
	}

	@Test
	public void referencePrimitiveMethod() {
		test("reference", "reference-primitive-method");
	}
	
	@Test
	public void referenceObjectMethod() {
		test("reference", "reference-object-method");
	}

	@Test
	public void referenceObjectField() {
		test("reference", "reference-object-field");
	}
	
	@Test
	public void referenceDefaultNamespace() {
		test("reference", "reference-default-namespace");
	}
}
