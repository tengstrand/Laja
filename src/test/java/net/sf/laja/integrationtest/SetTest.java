package net.sf.laja.integrationtest;

import java.util.Map;

import org.junit.Test;

public class SetTest extends AbstractIntegrationTestBase {

	public static class Myclass {
		private String value = "empty";
		
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}

		public String getValue(String string) {
			return string;
		}
		
		@Override
		public String toString() {
			return "Myclass:[value=" + value + "]";
		}
	}
	
	public static class CreateMe {
		private String message;
		private Map map;
		
		public CreateMe(String message, Map map) {
			this.message = message;
			this.map = map;
		}
		
		@Override
		public String toString() {
			return "Message=" + message + ", map=" + map;
		}
	}
	
	@Test
	public void setBoolean() {
		test("set", "set-boolean");
	}
	
	@Test
	public void setString() {
		test("set", "set-string");
	}
	
	@Test
	public void setInteger() {
		test("set", "set-integer");
	}

	@Test
	public void setFloat() {
		test("set", "set-float");
	}
	
	@Test
	public void setExpression() {
		test("set", "set-expression");
	}
	
	@Test
	public void setList() {
		test("set", "set-list");
	}

	@Test
	public void setMap() {
		test("set", "set-map");
	}

	@Test
	public void setReference() {
		test("set", "set-reference");
	}

	@Test
	public void setNewInstance() {
		test("set", "set-new-instance");
	}

	@Test
	public void setObjectMethod() {
		test("set", "set-object-method");
	}
	
	@Test
	public void setReferenceAttribute() {
		test("set", "set-reference-attribute");
	}

	@Test
	public void setComparition() {
		test("set", "set-comparition");
	}

	@Test
	public void setFunction() {
		test("set", "set-function");
	}

	@Test
	public void setMacro() {
		test("set", "set-macro");
	}
}
