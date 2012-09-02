package net.sf.laja.integrationtest;

import org.junit.Test;

public class ParameterTest extends AbstractIntegrationTestBase {

	@Test
	public void setInteger() {
		test("parameter", "parameter-set-integer", "value=123");
	}
	
	@Test
	public void setString() {
		test("parameter", "parameter-set-string", "message1='This is a string'", "message2=\"Hello\"");
	}

	@Test
	public void setStringInSpecifiedNamespace() {
		test("parameter", "parameter-set-string-in-specified-namespace", "$x.message='This is a string'");
	}
}
