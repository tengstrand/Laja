package net.sf.laja.parser.engine2.inspector;

import net.sf.laja.parser.engine2.FileWriter;
import net.sf.laja.parser.engine2.MultiWriter;
import net.sf.laja.parser.engine2.PrintWriter;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

/**
 * This is the default SyntaxErrorHandler used by generated parsers.
 * 
 * @author Joakim Tengstrand
 */
public class DefaultSyntaxErrorHandler extends AbstractSyntaxErrorHandler {
	private Writer writer;
	private Writer fileWriter;
	
	public DefaultSyntaxErrorHandler() {
		this((String)null);
	}

	public DefaultSyntaxErrorHandler(String logfile) {
		if (logfile == null) {
			writer = new PrintWriter();
		} else {
			fileWriter = new FileWriter(logfile);
			writer = new MultiWriter(new PrintWriter(), fileWriter);
		}
	}

	//TODO: Replace header "Next expected" and "Referenced from" with callback solution (inner class).
	public void writeSyntaxError(boolean success, Source source, Element element) {
		try {
			if (!success) {
				addErrorInRowMessage(source, writer);
				
				// TODO: Add functionality for "Next expected".
			}
		} finally {
			writer.close();
		}
	}
}
