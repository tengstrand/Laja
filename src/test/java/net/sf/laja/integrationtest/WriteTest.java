package net.sf.laja.integrationtest;

import org.junit.Test;

public class WriteTest extends AbstractIntegrationTestBase {

	@Test
	public void writeSingle() {
		test("write", "write-single");
	}

	@Test
	public void writeNestedComment() {
		test("write", "write-nested-comments");
	}
	
	@Test
	public void writeMulti() {
		testMultiOutput("write", "write-multi", "write-multi-inner", "write-multi-outer");
	}

	@Test
	public void writeExpression() {
		test("write", "write-expression");
	}
}
