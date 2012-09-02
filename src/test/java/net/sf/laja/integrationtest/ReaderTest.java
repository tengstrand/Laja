package net.sf.laja.integrationtest;

import org.junit.Test;

public class ReaderTest extends AbstractIntegrationTestBase {

	@Test
	public void readPropertiesIntoVariable() {
		test("reader", "reader-properties-into-variable");
	}

	@Test
	public void readPropertiesIntoNamespace() {
		test("reader", "reader-properties-into-namespace");
	}

	@Test
	public void readUnsupportedSource() {
		testAndExpectToFindErrorMessageOnce("reader", "reader-unsupported-source", "The command #read does not support this source: x");
	}
}
