package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.source.Source;

public class FollowedBy implements Element {
	private int id;
	private String name;
	private Output thisOutput;
	private ElementList element;
	private ElementList followedByElement;

	public FollowedBy(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public FollowedBy(int id, String name, Output output) {
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
	
	public void setElement(int id, Element element) {
		this.element = new ElementList(id, name);
		this.element.add(id, element);
	}

	public void setElement(int id, Element element, int flags) {
		this.element = new ElementList(id, name);
		this.element.add(id, element, flags);
	}
	
	public void setElement(int id, Element element, Output output) {
		this.element = new ElementList(id, name);
		this.element.add(id, element, output);
	}
	
	public void setElement(int id, Element element, int flags, Output output) {
		this.element = new ElementList(id, name);
		this.element.add(id, element, flags, output);
	}

	public void followedby(int id, Element element) {
		this.followedByElement = new ElementList(id, name);
		followedByElement.add(id, element);
	}

	public void followedby(int id, Element element, int flags) {
		this.followedByElement = new ElementList(id, name);
		followedByElement.add(id, element, flags);
	}
	
	public void followedby(int id, Element element, Output output) {
		this.followedByElement = new ElementList(id, name);
		followedByElement.add(id, element, output);
	}
	
	public void followedby(int id, Element element, int flags, Output output) {
		this.followedByElement = new ElementList(id, name);
		followedByElement.add(id, element, flags, output);
	}
	
	@Override
	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		int bookmark = source.getBookmark();
		int recorderIndex = source.getRecorder().getIndex();

		boolean match = element.parse(level, source, parentNot, caseSensitive, receive);

		if (!match) {
			source.getRecorder().setIndex(recorderIndex);
			return false;
		}

		int endBookmark = source.getBookmark();
		
		match = followedByElement.parse(level, source, parentNot, caseSensitive, receive);

		if (!match) {
			source.getRecorder().setIndex(recorderIndex);
			return false;
		}

		source.setBookmark(endBookmark);
		
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
			.append(", element=" + element)
			.append(", followedByElement=" + followedByElement)
			.append("]");
		return sb.toString();
	}
}
