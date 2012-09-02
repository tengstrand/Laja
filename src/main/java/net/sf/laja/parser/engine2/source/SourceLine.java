package net.sf.laja.parser.engine2.source;

/**
 * 
 * 
 * @author Joakim Tengstrand
 */
public class SourceLine {
	private final int row;
	private final int column;
	private final int index;
	private final String line;
	private final String cursor;
	
	public SourceLine(int row, int column, int index, String line, String cursor) {
		this.row = row;
		this.column = column;
		this.index = index;
		this.line = line;
		this.cursor = cursor;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getIndex() {
		return index;
	}
	
	public String getLine() {
		return line;
	}
	
	public String getCursor() {
		return cursor;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SourceLine)) {
			return false;
		}
		SourceLine sourceLine = (SourceLine)obj;
		
		return row == sourceLine.row &&
			column == sourceLine.column &&
			index == sourceLine.index &&
			((line == null && sourceLine.line == null) || line.equals(sourceLine.line)) &&
			((cursor == null && sourceLine.cursor == null) || cursor.equals(sourceLine.cursor));
	}
	
	@Override
	public String toString() {
		return "row=" + row +
			", column=" + column +
			", index=" + index + 
			", line=" + line +
			", cursor=" + cursor;
	}
}
