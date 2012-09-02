package net.sf.laja.integrationtest;

import org.junit.Test;

public class ImportTest extends AbstractIntegrationTestBase {

	@Test
	public void testImport() {
		test("import", "import-template");
	}

	@Test
	public void testImportAsText() {
		test("import", "import-template-as-text");
	}
	
	@Test
	public void importNested() {
		test("import", "import-nested");
	}
	
	@Test
	public void importGroovyClass() {
		test("import", "import-groovy-class");
	}
}
