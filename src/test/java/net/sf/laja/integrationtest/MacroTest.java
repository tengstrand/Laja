package net.sf.laja.integrationtest;

import org.junit.Test;

public class MacroTest extends AbstractIntegrationTestBase {

	@Test
	public void macro() {
		test("macro", "macro");
	}

	@Test
	public void macroDynamic() {
		test("macro", "macro-dynamic");
	}

	@Test
	public void macroRecursive() {
		test("macro", "macro-recursive");
	}

	@Test
	public void macroLoopList() {
		test("macro", "macro-loop-list");
	}

	@Test
	public void macroLocalReference() {
		test("macro", "macro-local-reference");
	}

	@Test
	public void macroNestedReference() {
		test("macro", "macro-nested-reference");
	}

	@Test
	public void macroSetReturnedValue() {
		test("macro", "macro-set-returned-value");
	}

	@Test
	public void macroMultiArguments() {
		test("macro", "macro-multi-arguments");
	}

	@Test
	public void macroMissingArguments() {
		testAndExpectToFindErrorMessageOnce("macro", "macro-missing-arguments", "Missing argument in parameter list for macro 'callme'");
	}

	@Test
	public void macroTooManyArguments() {
		testAndExpectToFindErrorMessageOnce("macro", "macro-too-many-arguments", "Too many arguments in parameter list for macro 'callme'");
	}

	@Test
	public void macroNotFound() {
		testAndExpectToFindErrorMessageOnce("macro", "macro-not-found", "Could not find macro 'mymacro'");
	}

	@Test
	public void macroPassArgumentsBetweenMacros() {
		test("macro", "macro-pass-arguments-between-macros");
	}

	@Test
	public void macroArgumentsAsMap() {
		test("macro", "macro-arguments-as-map");
	}

	@Test
	public void macroAccessImplicit() {
		test("macro", "macro-access-implicit");
	}

	@Test
	public void macroWrite() {
		test("macro", "macro-write");
	}

	@Test
	public void macroMethodReference() {
		testAndExpectToFindErrorMessageOnce("macro", "macro-method-reference", "Accessing attributes or methods on macros not supported. Use #set or #function");
	}

	@Test
	public void macroAccessWithSameName() {
		test("macro", "macro-access-with-same-name");
	}
}
