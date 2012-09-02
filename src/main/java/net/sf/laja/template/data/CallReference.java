package net.sf.laja.template.data;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.context.Context;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.Namespaces;

public class CallReference extends Reference {

	public CallReference(Source source, Context context, TemplateTextWriter templateTextWriter, Namespaces namespaces) {
		super(source, context, templateTextWriter, namespaces);
	}
	
	@Override
	public Object generate() {
		if (attributeRef != null && attributeRef.isMacro(getContext())) {
			generateMacro();
		} else if (attributeRef != null && attributeRef.isFunction(context)) {
			return evaluateFunction();
		} else {
			return evaluate();
		}
		return null;
	}
}
