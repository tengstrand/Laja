package net.sf.laja.parser.engine2;

import java.util.AbstractList;
import java.util.ArrayList;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.inspector.Inspectable;

public class ElementOutputList extends AbstractList {
	private ArrayList list = new ArrayList();
	private Output output;
	private Element parent;

	public ElementOutputList(Element element, Output output) {
		this.parent = element;
		this.output = output;
	}

	public Output getOutput() {
		return output;
	}

	public void add(int id, Element element) {
		list.add(new ElementOutput(id, element, parent, 0, this.output));
	}

	public void add(int id, Element element, int flags) {
		list.add(new ElementOutput(id, element, parent, flags, this.output));
	}

	public void add(int id, Element element, Output o) {
		list.add(new ElementOutput(id, element, parent, 0, o));
	}

	public void add(int id, Element element, int flags, Output o) {
		list.add(new ElementOutput(id, element, parent, flags, o));
	}

	public static class ElementOutput implements Inspectable {
		private int id;
		private int parentId;
		private boolean not;
		private Element element;
		private Element parent;
		private Boolean caseSensitive;
		private Output output;

		private ElementOutput(int id, Element element, Element parent, int flags, Output output) {
			this.id = id;
			this.not = (flags & Element.NOT) > 0;
			this.element = element;
			this.parent = parent;
			this.caseSensitive = (flags & Element.CASE) == 0 ? null : new Boolean((flags & Element.CS) > 0);
			this.output = output;
		}

		public int getId() {
			return id;
		}
		
		public String getIdName() {
			return parent.getName() + "." + id;
		}
		
		public boolean isNot() {
			return not;
		}

		public Element getElement() {
			return element;
		}

		public Element getParentElement() {
			return parent;
		}
		
		public Boolean isCaseSensitive() {
			return caseSensitive;
		}

		public Output getOutput() {
			return output;
		}

		// Not implemented for not-terminals.
		public String getString() {
			return null;
		}
		
		public boolean isTerminal() {
			return false;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("ElementOutput:[id=").append(id)
				.append(", not=").append(not)
				.append(", element=").append(element)
//				.append(", parent=").append(parent)
				.append(", caseSensitive").append(caseSensitive)
				.append(", output").append(output)
				.append("]");
			return sb.toString();
		}
	}

	//@Override
	public Object get(int index) {
		return list.get(index);
	}

	//@Override
	public int size() {
		return list.size();
	}
}
