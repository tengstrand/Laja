package net.sf.laja.launch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InargsParserTest {
	private Settings settings;
	
	@Before
	public void init() {
		settings = new Settings();
	}
	
	@Test
	public void noArguments() throws InargumentException {
		InargsParser inargsParser = new InargsParser(settings, new String[] {});
		
		assertTrue(inargsParser.getViewInfoCommand() != null);
		assertEquals(DefaultTemplateNotFoundCommand.class, inargsParser.getViewInfoCommand().getClass());
	}
	
	@Test
	public void oneGenerateWithMissingLastQuotationMark() throws InargumentException {
		final String filename = "\"myfile.laja";
		InargsParser inargsParser = new InargsParser(settings, filename);

		assertTrue(inargsParser.getViewInfoCommand() != null);
		assertEquals(ViewExceptionCommand.class, inargsParser.getViewInfoCommand().getClass());
	}

	@Test
	public void oneGenerateWithMissingFirstQuotationMark() throws InargumentException {
		final String filename = "myfile.laja\"";
		InargsParser inargsParser = new InargsParser(settings, filename);
		
		assertTrue(inargsParser.getViewInfoCommand() != null);
		assertEquals(ViewExceptionCommand.class, inargsParser.getViewInfoCommand().getClass());
	}
	
	@Test
	public void oneGenerateWithQuotationMarks() throws InargumentException {
		final String quotationMark = "\"";
		final String filename = "myfile.laja";
		InargsParser inargsParser = new InargsParser(settings, quotationMark + filename + quotationMark);
		
		assertEquals(0, inargsParser.getPrepareGenerateCommands().size());
		assertEquals(1, inargsParser.getGenerateCommands().size());
		assertEquals(new GenerateCommand(settings, filename), inargsParser.getGenerateCommands().get(0));
	}

	@Test
	public void oneGenerate() throws InargumentException {
		final String filename = "myfile.laja";
		InargsParser inargsParser = new InargsParser(settings, filename);

		assertEquals(0, inargsParser.getPrepareGenerateCommands().size());
		assertEquals(1, inargsParser.getGenerateCommands().size());
		assertEquals(new GenerateCommand(settings, filename), inargsParser.getGenerateCommands().get(0));
	}

	@Test
	public void twoGenerate() throws InargumentException {
		final String filename1 = "myfile1.laja";
		final String filename2 = "myfile2.laja";
		InargsParser inargsParser = new InargsParser(settings, filename1, filename2);

		assertEquals(0, inargsParser.getPrepareGenerateCommands().size());
		assertEquals(2, inargsParser.getGenerateCommands().size());
		assertEquals(new GenerateCommand(settings, filename1), inargsParser.getGenerateCommands().get(0));
		assertEquals(new GenerateCommand(settings, filename2), inargsParser.getGenerateCommands().get(1));
	}

	@Test
	public void setValueInDefaultNamespace() throws InargumentException {
		final String variable = "property";
		final String value = "1";
		final String filename = "myfile.laja";
		new InargsParser(settings, variable + "=" + value, filename);
	}

	@Test
	public void help() throws InargumentException {
		InargsParser inargsParser = new InargsParser(settings, "-help");
		
		assertTrue(inargsParser.getViewInfoCommand() != null);
		assertEquals(HelpCommand.class, inargsParser.getViewInfoCommand().getClass());
	}
	
	@Test
	public void version() throws InargumentException {
		InargsParser inargsParser = new InargsParser(settings, "-version");
		
		assertTrue(inargsParser.getViewInfoCommand() != null);
		assertEquals(VersionCommand.class, inargsParser.getViewInfoCommand().getClass());
	}

	@Test
	public void singleParameter() throws InargumentException {
		InargsParser inargsParser = new InargsParser(settings, "-i", "myfile.laja");

        assertEquals(1, inargsParser.getGenerateCommands().size());
        assertEquals(1, inargsParser.getPrepareGenerateCommands().size());
        assertEquals(new SingleParameterCommand("-i", settings), inargsParser.getPrepareGenerateCommands().get(0));
	}
}
