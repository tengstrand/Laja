package net.sf.laja.integrationtest;

import org.junit.Test;

public class IfTest extends AbstractIntegrationTestBase {

	@Test
	public void testIf() {
		test("if", "if-equals");
	}

	@Test
	public void esleif() {
		test("if", "elseif");
	}
	
	@Test
	public void lessThan() {
		test("if", "if-less-than");
	}

	@Test
	public void lessOrEqual() {
		test("if", "if-less-or-equal");
	}
	
	@Test
	public void greaterOrEqual() {
		test("if", "if-greater-or-equal");
	}
	
	@Test
	public void greaterThan() {
		test("if", "if-greater-than");
	}
	
	@Test
	public void ifNull() {
		test("if", "if-null");
	}
	
	@Test
	public void ifBoolean() {
		test("if", "if-boolean");
	}
	
	@Test
	public void ifNotBoolean() {
		test("if", "if-not-boolean");
	}
	
	@Test
	public void ifExpression() {
		test("if", "if-expression");
	}

	@Test
	public void ifObjectMethod() {
		test("if", "if-object-method");
	}

	@Test
	public void ifFunction() {
		test("if", "if-function");
	}
}
