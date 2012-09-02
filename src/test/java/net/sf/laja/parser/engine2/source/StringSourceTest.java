package net.sf.laja.parser.engine2.source;

import static org.junit.Assert.*;

import net.sf.laja.parser.engine2.source.SourceLine;
import net.sf.laja.parser.engine2.source.StringSource;

import org.junit.Test;

public class StringSourceTest {
	
	@Test
	public void errorInLineOne() {
		StringSource stringSource = new StringSource("12345\n6789");
		
		final int index = 0;
		SourceLine sourceLine = stringSource.getSourceLine(index);
		SourceLine expectedLine = new SourceLine(1, 1, index, "12345", "^");
		
		assertEquals(expectedLine, sourceLine);
	}

	@Test
	public void errorInLineTwo() {
		StringSource stringSource = new StringSource("1\r\n2345\r\n67");
		
		final int index = 4;
		SourceLine sourceLine = stringSource.getSourceLine(index);
		SourceLine expectedLine = new SourceLine(2, 2, index, "2345", " ^");
		
		assertEquals(expectedLine, sourceLine);
	}
}
