//package net.sf.laja;
//
//import java.util.Arrays;
//
//import net.sf.laja.context.Context;
//import net.sf.laja.parser.engine1.source.Source;
//import net.sf.laja.template.Namespaces;
//import net.sf.laja.template.data.Macroref;
//
///**
// * Used to call macros from Groovy.
// */
//public class MacroCaller {
//	private String namespace;
//	private Macroref macroref;
//	
//	public MacroCaller(String namespace, Source source, Context context, Namespaces namespaces, TemplateTextWriter templateTextWriter) {
//		this.namespace = namespace;
//		macroref = new Macroref(source, context, namespaces, templateTextWriter);
//	}
//	
//	public Object evaluateMacro(String macroName, Object... arguments) {
//		macroref.setNamespace(namespace);
//		macroref.setName(macroName);
//		macroref.setArguments(Arrays.asList(arguments));
//		return macroref.evaluate();
//	}
//}
