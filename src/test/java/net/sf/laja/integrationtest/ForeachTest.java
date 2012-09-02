package net.sf.laja.integrationtest;

import org.junit.Test;

public class ForeachTest extends AbstractIntegrationTestBase {

	@Test
	public void foreachList() {
		test("foreach", "foreach-list");
	}

	@Test
	public void foreachMap() {
		test("foreach", "foreach-map");
	}
	
	@Test
	public void foreachReferenceList() {
		test("foreach", "foreach-reference-list");
	}

	@Test
	public void foreachReferenceArray() {
		test("foreach", "foreach-reference-array");
	}
	
	@Test
	public void foreachWhere() {
		test("foreach", "foreach-where");
	}

	@Test
	public void foreachNull() {
		test("foreach", "foreach-null");
	}
}
