package net.sf.laja.integrationtest;

import org.junit.Test;

public class NamespaceTest extends AbstractIntegrationTestBase {
	
	@Test
	public void accessAnotherNamespace() {
		test("namespace", "namespace-access-another-namespace");
	}

	@Test
	public void accessDefaultNamespaceFromAnotherNamespace() {
		test("namespace", "namespace-access-default-namespace-from-another-namespace");
	}

	@Test
	public void setVariableInAnotherNamespace() {
		test("namespace", "namespace-set-variable-in-another-namespace");
	}
}
