package net.sf.laja.context;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.template.Namespaces;

public abstract class AbstractContext extends Context {

	public AbstractContext(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		super(namespaces, templateTextWriter);
	}
}
