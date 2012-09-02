package net.sf.laja.integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.laja.launch.LajaLauncher;

public class AbstractIntegrationTestBase {
	private static final String OUTPUT_DIR = "target/test-output";
	private static final String TEST_DIR = "src/test/laja";

	public void test(String directory, String name, String... arguments) {
		generateTemplate(directory, name, arguments);
		verifyFile(directory, name);
	}

	public void testAndExpectToFindErrorMessageOnce(String directory, String name, String expectedErrorMessage, String... arguments) {
		String outputMessages = generateTemplate(directory, name, expectedErrorMessage, arguments);
		verifyThatSystemMessageExistsOnce(expectedErrorMessage, outputMessages);
	}

	public void testAndExpectToFindErrorMessageAtLeastOnce(String directory, String name, String expectedErrorMessage, String... arguments) {
		String outputMessages = generateTemplate(directory, name, expectedErrorMessage, arguments);
		assertTrue("Expected to find message at least once: " + expectedErrorMessage, outputMessages.contains(expectedErrorMessage));
	}

	private String generateTemplate(String directory, String name, String expectedErrorMessage, String... arguments) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream originalSystemOut = System.out;
		System.setOut(printStream);

		generateTemplate(directory, name, arguments);
		System.setOut(originalSystemOut);
		return byteArrayOutputStream.toString();
	}

	public void testMultiOutput(String directory, String name, String... expectedNames) {
		generateTemplate(directory, name);

		for (String expectedName : expectedNames) {
			verifyFile(directory, expectedName);
		}
	}

	private void generateTemplate(String directory, String name, String... arguments) {
		String templateFilename = TEST_DIR + File.separator + directory + File.separator + name + ".laja";

		recreateOutputDirs();

		List<String> launchArguments = new ArrayList<String>();
		launchArguments.add(templateFilename);

		for (String argument : arguments) {
			launchArguments.add(argument);
		}
		new LajaLauncher().execute(launchArguments);
	}

	private void verifyThatSystemMessageExistsOnce(String expectedMessage, String outputMessage) {
		int index = outputMessage.indexOf(expectedMessage);

		if (index >= 0) {
			if (true) {
				int index2 = outputMessage.indexOf(expectedMessage, index + 1);
				if (index2 >= 0) {
					index = -1;
				}
			}
		}
		assertTrue("Expected to find system output (once): " + expectedMessage + ", found: " + outputMessage, index >= 0);
	}

	private void verifyFile(String directory, String name) {
		String outputFilename = OUTPUT_DIR + File.separator + name + ".out";
		String expectedFilename = TEST_DIR + File.separator + directory + File.separator + name + ".expected";

		try {
			String result1 = openFile(expectedFilename);
			String result2 = openFile(outputFilename);
			assertEquals(result1, result2);
		} catch (IOException e) {
			assertTrue(e.getMessage(), false);
		}
	}

	private void recreateOutputDirs() {
		File outputDir = new File(OUTPUT_DIR);
		if (outputDir.exists()) {
			boolean deleted = deleteDirectory(OUTPUT_DIR);
			if (!deleted) {
				deleted = deleteDirectory(OUTPUT_DIR);
			}
			assertTrue("Could not delete directory \"" + OUTPUT_DIR + "\"", deleted);
		}
		boolean created = outputDir.mkdir();
		assertTrue(created);
	}

	private String openFile(String filename) throws IOException {
		File file = new File(filename);
		int size = (int) file.length();
		char[] characters = new char[size];

		FileInputStream inputStream = new FileInputStream(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		reader.read(characters);
		reader.close();
		inputStream.close();
		return new String(characters);
	}

	private boolean deleteDirectory(String directory) {
		return deleteDirectory(new File(directory));
	}

	public boolean deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDirectory(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}
}
