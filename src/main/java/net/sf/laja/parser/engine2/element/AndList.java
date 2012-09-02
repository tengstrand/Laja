package net.sf.laja.parser.engine2.element;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class AndList implements Element {
	private int id;
	private String name;
	private Output thisOutput;
	private ElementList mainAnd;
	private List<ElementList> pipeToElements = new ArrayList<ElementList>();

	public AndList(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public AndList(int id, String name, Output output) {
		this.id = id;
		this.name = name;
		this.thisOutput = output;
	}
	
	@Override
	public boolean isOptional() {
		return false;
	}

	@Override
	public int getId(){
		return id;
	}

	@Override
	public String getIdName() {
		return name;
	}
	
	@Override
	public String getString() {
		return null;
	}
	
	@Override
	public boolean isTerminal() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void mainAnd(int id, Element element) {
		mainAnd = new ElementList(id, name);
		mainAnd.add(id, element);
	}

	public void mainAnd(int id, Element element, int flags) {
		mainAnd = new ElementList(id, name);
		mainAnd.add(id, element, flags);
	}
	
	public void mainAnd(int id, Element element, Output output) {
		mainAnd = new ElementList(id, name);
		mainAnd.add(id, element, output);
	}
	
	public void mainAnd(int id, Element element, int flags, Output output) {
		mainAnd = new ElementList(id, name);
		mainAnd.add(id, element, flags, output);
	}

	public void and(int id, Element element) {
		ElementList pipeTo = new ElementList(id, name);
		pipeTo.add(id, element);
		pipeToElements.add(pipeTo);
	}

	public void and(int id, Element element, int flags) {
		ElementList pipeTo = new ElementList(id, name);
		pipeTo.add(id, element, flags);
		pipeToElements.add(pipeTo);
	}
	
	public void and(int id, Element element, Output output) {
		ElementList pipeTo = new ElementList(id, name);
		pipeTo.add(id, element, output);
		pipeToElements.add(pipeTo);
	}
	
	public void and(int id, Element element, int flags, Output output) {
		ElementList pipeTo = new ElementList(id, name);
		pipeTo.add(id, element, flags, output);
		pipeToElements.add(pipeTo);
	}
	
	@Override
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		int bookmark = source.getBookmark();
		int recorderIndex = source.getRecorder().getIndex();

		int bestIndex = source.getBestIndex();
		boolean match = mainAnd.parse(level, source, parentNot, caseSensitive, receive);

		if (!match) {
			source.getRecorder().setIndex(recorderIndex);
			return false;
		}

		int endBookmark = source.getBookmark();
		
		for (ElementList pipeTo : pipeToElements) {
			Source pipeToSource = source.newSource(bookmark, endBookmark);
			match = pipeTo.parse(level, pipeToSource, parentNot, caseSensitive, receive);
			if (!match) {
				source.setBestIndex(bestIndex);
				return false;
			}
			if (!pipeToSource.reachedEnd()) {
				int bestToIndex = pipeToSource.getBestIndex();
				if (bestToIndex >= 0 && bestToIndex > bestIndex) {
					source.setBestIndex(bestToIndex);
				}
				return false;
			}
		}

		if (thisOutput != null && (receive || thisOutput.receive())) {
			thisOutput.init(source);
			thisOutput.set(source, bookmark);
		}
		
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pipe:[id=").append(id)
			.append(", name=").append(name)
			.append(", pipeFrom=" + mainAnd)
			.append(", pipeToElements=" + pipeToElements)
			.append("]");
		return sb.toString();
	}
}
