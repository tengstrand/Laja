package net.sf.laja.parser.engine2.inspector;

import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.engine2.DefaultSyntaxError.DefaultSyntaxErrorFactoryFactory;
import net.sf.laja.parser.engine2.DefaultSyntaxError.Rowinfo;
import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

/**
 * This is the default SyntaxErrorHandler
 * 
 * @author Joakim Tengstrand
 */
public abstract class AbstractSyntaxErrorHandler implements SyntaxErrorHandler {
	protected int bookmark;
	
	protected AbstractSyntaxErrorHandler() {
	}
	
	public abstract void writeSyntaxError(boolean success, Source source, Element element);
	
	protected void addErrorInRowMessage(Source source, Writer writer) {
		this.bookmark = source.getBestIndex();
		DefaultSyntaxErrorFactoryFactory factoryFactory = new DefaultSyntaxErrorFactoryFactory(bookmark);
		DefaultSyntaxErrorParser parser = new DefaultSyntaxErrorParser(factoryFactory);
		source.reset();
		parser.parse(source);
		Rowinfo rowinfo = factoryFactory.getMatchedRow();


		writer.write("Syntax error in ").write(source.getType());
		if (source.getName() != null) {
			writer.write(" \"").write(source.getName()).write("\"");
		}

		if (rowinfo == null) {
			return;
		}
		
		int row = rowinfo.getRow() == 0 ? 1 : rowinfo.getRow();
		
		writer.write(", row ").write(row)
			.write(", column ").write(rowinfo.getColumn())
			.write(" (character index: ").write(bookmark).write(")")
			.writeln(":").writeln(rowinfo.getLine());

		String line = rowinfo.getLine();
		int idx = rowinfo.getColumn() - 1;
		for (int i = 0; i < idx; i++) {
			if (line.substring(i, i + 1).equals("\t")) {
				writer.write("\t");
			} else {
				writer.write(" ");
			}
		}
		writer.write("^");
	}
}
