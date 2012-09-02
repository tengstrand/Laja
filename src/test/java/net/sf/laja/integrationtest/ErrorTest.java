package net.sf.laja.integrationtest;

import org.junit.Test;

public class ErrorTest extends AbstractIntegrationTestBase {
	
	@Test
	public void error() {
		testAndExpectToFindErrorMessageAtLeastOnce("error", "error", "Stop the execution");
	}
}
