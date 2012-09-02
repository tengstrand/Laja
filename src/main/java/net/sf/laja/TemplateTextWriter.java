package net.sf.laja;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TemplateTextWriter {
	private List<FileTextWriter> fileTextWriters = new ArrayList<FileTextWriter>();
	private Stack<TextWriter> textWriterStack = new Stack<TextWriter>();

 	public void addFileWriter(FileTextWriter fileTextWriter) {
		fileTextWriters.add(fileTextWriter);
	}

 	public void pushTextWriter() {
 		textWriterStack.push(new TextWriterBuffer());
 	}

 	public String popTextWriter() {
 		TextWriter textWriter = textWriterStack.pop();
 		return textWriter.getText();
 	}
 	
	public void removeFileWriter(FileTextWriter fileTextWriter) {
		fileTextWriters.remove(fileTextWriter);
	}
	
	public void write(Object object) {
		if (textWriterStack.isEmpty()) {
			for (FileTextWriter fileTextWriter : fileTextWriters) {
				fileTextWriter.write(object);
			}
		} else {
			textWriterStack.peek().write(object);
		}
	}
}
