package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser.IDefaultSyntaxError;
import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser.IDefaultSyntaxErrorFactory;
import net.sf.laja.parser.engine2.DefaultSyntaxErrorParser.IDefaultSyntaxErrorFactoryFactory;

public class DefaultSyntaxError implements IDefaultSyntaxError {
	private int row;
	private int index;
	private String line;

	private Rowinfo matchedRow;
	
	public static class DefaultSyntaxErrorFactoryFactory implements IDefaultSyntaxErrorFactoryFactory {
		private DefaultSyntaxError defaultSyntaxError;
		private DefaultSyntaxErrorFactory defaultSyntaxErrorFactory;
		
		public DefaultSyntaxErrorFactoryFactory(int index) {
			defaultSyntaxError = new DefaultSyntaxError(index);
		}

		public IDefaultSyntaxErrorFactory getFactory(int phase) {
			if (defaultSyntaxErrorFactory == null) {
				defaultSyntaxErrorFactory = new DefaultSyntaxErrorFactory(defaultSyntaxError);
			}
			return defaultSyntaxErrorFactory;
		}
		
		public Rowinfo getMatchedRow() {
			return defaultSyntaxError.getMatchedRow();
		}
	}
	
	public static class Rowinfo {
		private int row;
		private int column;
		private String line;

		public Rowinfo(int row, int column, String line) {
			this.row = row;
			this.column = column;
			this.line = line;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		public String getLine() {
			return line;
		}

		public String toString() {
			return "row=" + row + ", column=" + column + ", line=" + line;
		}
	}

	public DefaultSyntaxError(int index) {
		this.index = index;
	}

	public void setLine(String line, Index idx) {
		if (index >= idx.getStartIndex() && index <= idx.getEndIndex()) {
			this.line = line;
			matchedRow = new Rowinfo(row, index - idx.getStartIndex() + 1, line);
		}
	}

	public void setRow(String line, Index idx) {
		row++;
		if (index >= idx.getStartIndex() && index <= idx.getEndIndex()) {
			this.line = line;
			matchedRow = new Rowinfo(row, index - idx.getStartIndex() + 1, line);
		}
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return line == null ? 0 : line.length();
	}

	public Rowinfo getMatchedRow() {
		return matchedRow;
	}
}
