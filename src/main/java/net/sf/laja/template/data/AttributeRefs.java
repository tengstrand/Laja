package net.sf.laja.template.data;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.context.Context;

public class AttributeRefs {
	private List<AttributeRef> attributes;

	public AttributeRefs() {
		attributes = new ArrayList<AttributeRef>();
	}

	public AttributeRefs(List<AttributeRef> attributes) {
		this.attributes = attributes;
	}
	
	public void add(AttributeRef attributeRef) {
		attributes.add(attributeRef);
	}

	public int size() {
		return attributes.size();
	}
	
	public boolean hasAttributes() {
		return attributes.size() > 0;
	}
	
	public AttributeRef getLastAttribute() {
		return attributes.get(attributes.size()-1);
	}
	
	public AttributeRefs createAttributesSkipLast() {
		return new AttributeRefs(attributes.subList(0, attributes.size()-1));
	}

	public Object evaluateNextAttributes(Context context, Object attribute) {
		for (AttributeRef attributeRef : attributes) {
			Context attributeContext = context.createContext(attribute, attributeRef);
			attribute = attributeContext.evaluate(attributeRef);
			if (attributeRef.hasListIndex()) {
				attribute = attributeRef.evaluateArrayOrList(attribute);
			}
		}
		return attribute;
	}
	
	public String toString() {
		return "AttribututeRefs{attributes=" + attributes + "}";
	}
}
