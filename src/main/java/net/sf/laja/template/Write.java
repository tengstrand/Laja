package net.sf.laja.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import net.sf.laja.FileTextWriter;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.TemplateParser.IWrite;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.StringExp;

public class Write implements IWrite, FileTextWriter, Generator {
	private int indexInSource;
	private StringExp filename;
	private Block block;

	private Source source;
	private PrintWriter out;
	private TemplateTextWriter templateTextWriter;
	
	public Write(Source source, TemplateTextWriter templateTextWriter) {
		this.source = source;
		this.templateTextWriter = templateTextWriter;
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setFilename(IStringExp istringExp) {
		this.filename = (StringExp)istringExp;
	}

	public void setBlock(IBlock iblock) {
		this.block = (Block)iblock;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public void open() {
		try {
			String writeToFile = filename.evaluate();
			System.out.print("  Writing to file \"" + getPath(writeToFile) + "\"");
			out = new PrintWriter(new BufferedWriter(new FileWriter(writeToFile)));
		} catch (IOException e) {
			System.out.println();
			throw new InterpretationException(source, indexInSource, e);
		}
	}

	private String getPath(String filename) throws IOException {
		return new File(filename).getCanonicalPath().replace('\\', '/');
	}

	public void close(boolean ok) {
		out.close();
		
		if (ok) {
			System.out.println(" - OK");
		} else {
			System.out.println(" - Error");
		}
	}

	public void write(Object object) {
		out.print(object == null ? "NULL" : object.toString());
	}
	
	public Object generate() {
		// Open a file and write its content to that file and all other currently opened files.
		open();
		templateTextWriter.addFileWriter(this);
		boolean ok = true;
		try {
			block.generate();
		} catch (RuntimeException e) {
			ok = false;
			throw e;
		} finally {
			close(ok);
			templateTextWriter.removeFileWriter(this);
		}
		return null;
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#write ");
		filename.print(printer);
		printer.println();
		printer.tabForward();
		block.print(printer);
		printer.tabBackward();
		printer.printlnWithTabs("#end");
	}
	
	@Override
	public int hashCode() {
		return filename.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Write)) {
			return false;
		}
		return filename.equals(((Write)obj).filename);
	}

	@Override
	public String toString() {
		return "Write{filename=" + filename + ", block=" + block + "}";
	}
}
