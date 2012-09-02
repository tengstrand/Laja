package net.sf.laja.integrationtest;

import org.junit.Test;

public class LocalTest extends AbstractIntegrationTestBase {
	
	@Test
	public void setlocalMacro() {
		test("local", "local-macro");
	}
	
	@Test
	public void setLocalFunction() {
		test("local", "local-function");
	}
	
	@Test
	public void setLocalComparition() {
		test("local", "local-comparition");
	}
}
