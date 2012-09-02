package net.sf.laja.integrationtest;

import org.junit.Test;

public class FunctionTest extends AbstractIntegrationTestBase {

	@Test
	public void function() {
		test("function", "function");
	}

	@Test
	public void functionMethodReference() {
		test("function", "function-method-reference");
	}
	
	@Test
	public void functionPassArgumentsBetweenFunctions() {
		test("function", "function-pass-arguments-between-functions");
	}

	@Test
	public void functionReferenceDefaultNamespace() {
		test("function", "function-reference-default-namespace");
	}
	
	@Test
	public void functionReturnComparition() {
		test("function", "function-return-comparition");
	}
	
}
