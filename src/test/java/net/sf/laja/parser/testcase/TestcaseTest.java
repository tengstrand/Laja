package net.sf.laja.parser.testcase;

import net.sf.laja.parser.testcase.TestcaseParser.ITestcaseFactory;
import net.sf.laja.parser.testcase.TestcaseParser.ITestcaseFactoryFactory;
import net.sf.laja.parser.testcase.Testcases.TestcaseFactory;

import org.junit.Test;

public class TestcaseTest {

	/**
	 * Runs all the tests defined in class Testcases.
	 */
	@Test
	public void testParser() {
		String file = "src/test/java/net/sf/laja/parser/testcase/testcase.txt";

		TestcaseParser parser = new TestcaseParser(new ITestcaseFactoryFactory() {
			public ITestcaseFactory getFactory(int phase) {
				return new TestcaseFactory(phase);
			}
		});

		parser.parseFile(file);
	}
}
