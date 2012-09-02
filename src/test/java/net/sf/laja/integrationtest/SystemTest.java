package net.sf.laja.integrationtest;

import org.junit.Test;

public class SystemTest extends AbstractIntegrationTestBase {

	@Test
	public void readDatabase() {
		test("system", "system-database");
	}
	
	@Test
	public void isInstanceof() {
		test("system", "system-instanceof");
	}

	@Test
	public void loadClass() {
		test("system", "system-load-class");
	}

	@Test
	public void viewClass() {
		test("system", "system-view-class");
	}

	@Test
	public void viewClassInstance() {
		test("system", "system-view-class-instance");
	}

	@Test
	public void classType() {
		test("system", "system-class-type");
	}
	
	@Test
	public void fileExists() {
		test("system", "system-file-exists");
	}

	@Test
	public void directoryExists() {
		test("system", "system-directory-exists");
	}
	
	@Test
	public void env() {
		test("system", "system-env");
	}

	@Test
	public void dir() {
		test("system", "system-dir");
	}

	@Test
	public void home() {
		test("system", "system-home");
	}

	@Test
	public void strings() {
		test("system", "system-strings");
	}

	@Test
	public void math() {
		test("system", "system-math");
	}

	@Test
	public void time() {
		test("system", "system-time");
	}

	@Test
	public void parser() {
		test("system", "system-parser");
	}

	@Test
	public void createDirectory() {
		test("system", "system-create-directory");
	}

	@Test
	public void createDirectoryPath() {
		test("system", "system-create-directory-path");
	}
	
	@Test
	public void println() {
		testAndExpectToFindErrorMessageOnce("system", "system-println", "This is my message");
	}

    @Test
    public void counter() {
        test("system", "system-common-counter");
    }
}
