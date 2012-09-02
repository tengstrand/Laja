package net.sf.laja;

import groovy.lang.GroovyClassLoader;
import net.sf.laja.TemplateParser.IArgs;
import net.sf.laja.TemplateParser.IAttributeMethodRef;
import net.sf.laja.TemplateParser.IAttributeRef;
import net.sf.laja.TemplateParser.IAttributeVariableRef;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.IBooleanData;
import net.sf.laja.TemplateParser.ICall;
import net.sf.laja.TemplateParser.ICallReference;
import net.sf.laja.TemplateParser.ICommand;
import net.sf.laja.TemplateParser.IComparition;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IConditionAnd;
import net.sf.laja.TemplateParser.IConditionBase;
import net.sf.laja.TemplateParser.IConditionElement;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IElse;
import net.sf.laja.TemplateParser.IElseif;
import net.sf.laja.TemplateParser.IError;
import net.sf.laja.TemplateParser.IFloatData;
import net.sf.laja.TemplateParser.IForeach;
import net.sf.laja.TemplateParser.IFunction;
import net.sf.laja.TemplateParser.IIfcmd;
import net.sf.laja.TemplateParser.IImportcmd;
import net.sf.laja.TemplateParser.IIndexItem;
import net.sf.laja.TemplateParser.IIntegerData;
import net.sf.laja.TemplateParser.IListData;
import net.sf.laja.TemplateParser.IListIndex;
import net.sf.laja.TemplateParser.ILocal;
import net.sf.laja.TemplateParser.IMacro;
import net.sf.laja.TemplateParser.IMapData;
import net.sf.laja.TemplateParser.IMapDataRef;
import net.sf.laja.TemplateParser.IMapMember;
import net.sf.laja.TemplateParser.IMethodRef;
import net.sf.laja.TemplateParser.INamespace;
import net.sf.laja.TemplateParser.INamespaceRef;
import net.sf.laja.TemplateParser.INewStatement;
import net.sf.laja.TemplateParser.INullData;
import net.sf.laja.TemplateParser.IOperator;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.TemplateParser.IReturncmd;
import net.sf.laja.TemplateParser.ISet;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.TemplateParser.IStringref;
import net.sf.laja.TemplateParser.ITemplate;
import net.sf.laja.TemplateParser.ITemplateFactory;
import net.sf.laja.TemplateParser.IText;
import net.sf.laja.TemplateParser.IVariableRef;
import net.sf.laja.TemplateParser.IWhilecmd;
import net.sf.laja.TemplateParser.IWrite;
import net.sf.laja.context.Context;
import net.sf.laja.exception.LajaException;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.Args;
import net.sf.laja.template.Block;
import net.sf.laja.template.Call;
import net.sf.laja.template.Classes;
import net.sf.laja.template.Command;
import net.sf.laja.template.Condition;
import net.sf.laja.template.ConditionAnd;
import net.sf.laja.template.ConditionBase;
import net.sf.laja.template.ConditionElement;
import net.sf.laja.template.Else;
import net.sf.laja.template.Elseif;
import net.sf.laja.template.Foreach;
import net.sf.laja.template.Ifcmd;
import net.sf.laja.template.Importcmd;
import net.sf.laja.template.ImportedFiles;
import net.sf.laja.template.IndexItem;
import net.sf.laja.template.ListIndex;
import net.sf.laja.template.Macro;
import net.sf.laja.template.MapMember;
import net.sf.laja.template.Namespace;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.NewStatement;
import net.sf.laja.template.Operator;
import net.sf.laja.template.Returncmd;
import net.sf.laja.template.Set;
import net.sf.laja.template.Stringref;
import net.sf.laja.template.Template;
import net.sf.laja.template.Text;
import net.sf.laja.template.Whilecmd;
import net.sf.laja.template.Write;
import net.sf.laja.template.condition.Comparition;
import net.sf.laja.template.data.AttributeRef;
import net.sf.laja.template.data.BooleanData;
import net.sf.laja.template.data.CallReference;
import net.sf.laja.template.data.Data;
import net.sf.laja.template.data.FloatData;
import net.sf.laja.template.data.IntegerData;
import net.sf.laja.template.data.ListData;
import net.sf.laja.template.data.MapData;
import net.sf.laja.template.data.MapDataRef;
import net.sf.laja.template.data.MethodRef;
import net.sf.laja.template.data.NamespaceRef;
import net.sf.laja.template.data.NullData;
import net.sf.laja.template.data.Reference;
import net.sf.laja.template.data.StringExp;
import net.sf.laja.template.data.VariableRef;

public class TemplateFactory implements ITemplateFactory {
	private Source source;
	private Template baseTemplate;
	private TemplateTextWriter templateTextWriter;
	private Namespaces namespaces;
	private Classes classes;
	private GroovyClassLoader groovyClassLoader;

	public TemplateFactory(Source source, TemplateTextWriter templateTextWriter, Namespaces namespaces, Classes classes, GroovyClassLoader groovyClassLoader) {
		this.source = source;
		this.templateTextWriter = templateTextWriter;
		this.namespaces = namespaces;
		this.classes = classes;
		this.groovyClassLoader = groovyClassLoader;
	}

	public Template getBaseTemplate() {
		return baseTemplate;
	}

	/**
	 * imacro is set to not null (living on the stack) if we are in the macro
	 * body, if so -> return the context from the macro (local context). The
	 * same logic for functions. Otherwise return the context of the namespace
	 * via template.
	 * 
	 * @param itemplate
	 * @param imacrobody
	 * @return
	 */
	private Context getContext(ITemplate itemplate, IMacro imacro, IFunction ifunction) {
		Template template = (Template) itemplate;
		if (imacro != null) {
			return ((Macro) imacro).getLocalContext();
		}
		if (ifunction != null) {
			return ((Macro) ifunction).getLocalContext();
		}
		return template.getContext();
	}

	@Override
	public ITemplate createTemplate() {
		if (baseTemplate != null) {
			return new Template(new ImportedFiles(), namespaces, templateTextWriter, source, classes, groovyClassLoader);
		}
		baseTemplate = new Template(new ImportedFiles(), namespaces, templateTextWriter, source, classes, groovyClassLoader);

		return baseTemplate;
	}

	@Override
	public IStringExp createStringExp() {
		return new StringExp();
	}

	@Override
	public ICommand createCommand() {
		return new Command();
	}

	@Override
	public IWrite createWrite() {
		return new Write(source, templateTextWriter);
	}

	@Override
	public ISet createSet(ITemplate itemplate, IMacro imacro) {
		Template template = (Template) itemplate;
		return new Set(source, namespaces, templateTextWriter, (Macro) imacro, template.getContext());
	}

	@Override
	public ILocal createLocal(ITemplate itemplate, IMacro imacro, IFunction ifunction) {
		if (imacro == null && ifunction == null) {
			throw new LajaException("#local variables can not exist outside a #macro or #function body.");
		}
		Macro macro = (Macro) imacro;

		if (macro == null) {
			macro = (Macro) ifunction;
		}
		return new Set(source, namespaces, templateTextWriter, macro, macro.getLocalContext());
	}


	@Override
	public IText createText() {
		return new Text(templateTextWriter);
	}

	@Override
	public INamespaceRef createNamespaceRef() {
		return new NamespaceRef(namespaces);
	}

	@Override
	public IMethodRef createMethodRef() {
		return new MethodRef();
	}

	@Override
	public IAttributeVariableRef createAttributeVariableRef() {
		return new AttributeRef(namespaces);
	}

	@Override
	public IVariableRef createVariableRef() {
		return new VariableRef();
	}

	@Override
	public IAttributeRef createAttributeRef() {
		return new AttributeRef(namespaces);
	}

	@Override
	public IAttributeMethodRef createAttributeMethodRef() {
		return new AttributeRef(namespaces);
	}

	@Override
	public IReference createReference(ITemplate itemplate, IMacro imacro, IFunction ifunction) {
		Context context = getContext(itemplate, imacro, ifunction);
		return new Reference(source, context, templateTextWriter, namespaces);
	}

	@Override
	public ICallReference createCallReference(ITemplate itemplate, IMacro imacro, IFunction ifunction) {
		Context context = getContext(itemplate, imacro, ifunction);
		return new CallReference(source, context, templateTextWriter, namespaces);
	}

	// @Override
	// public ICallReference createCallReference(ITemplate itemplate, IMacro
	// imacro, IFunction ifunction) {
	// Context context = getContext(itemplate, imacro, ifunction);
	// return new Reference(source, context, templateTextWriter, namespaces);
	// }

	@Override
	public INullData createNullData() {
		return new NullData();
	}

	@Override
	public IStringref createStringref() {
		return new Stringref(source);
	}

	@Override
	public IData createData() {
		return new Data();
	}

	@Override
	public IBooleanData createBooleanData() {
		return new BooleanData();
	}

	@Override
	public IFloatData createFloatData() {
		return new FloatData();
	}

	@Override
	public IIntegerData createIntegerData() {
		return new IntegerData();
	}

	@Override
	public IListData createListData() {
		return new ListData(namespaces, templateTextWriter);
	}

	@Override
	public IMapDataRef createMapDataRef() {
		return new MapDataRef(namespaces, templateTextWriter);
	}

	@Override
	public IMapData createMapData() {
		return new MapData(namespaces, templateTextWriter);
	}

	@Override
	public IMapMember createMapMember() {
		return new MapMember();
	}

	// @Override
	// public IAttribute createAttribute() {
	// return new Attribute();
	// }
	//	
	// @Override
	// public IMethodAttribute createMethodAttribute() {
	// return new Attribute();
	// }

	@Override
	public IListIndex createListIndex() {
		return new ListIndex();
	}

	@Override
	public IIndexItem createIndexItem() {
		return new IndexItem();
	}

	@Override
	public IArgs createArgs() {
		return new Args();
	}

	@Override
	public IComparition createComparition() {
		return new Comparition();
	}

	@Override
	public IConditionAnd createConditionAnd() {
		return new ConditionAnd();
	}

	@Override
	public IConditionBase createConditionBase() {
		return new ConditionBase();
	}

	@Override
	public IConditionElement createConditionElement() {
		return new ConditionElement();
	}

	@Override
	public ICondition createCondition() {
		return new Condition();
	}

	@Override
	public IIfcmd createIfcmd() {
		return new Ifcmd();
	}


	@Override
	public IWhilecmd createWhilecmd() {
		return new Whilecmd();
	}
	
	@Override
	public IElseif createElseif() {
		return new Elseif();
	}

	@Override
	public IElse createElse() {
		return new Else();
	}

	@Override
	public IForeach createForeach(ITemplate itemplate) {
		Template template = (Template) itemplate;
		return new Foreach(source, template.getContext());
	}

	@Override
	public IImportcmd createImportcmd(ITemplate itemplate) {
		Template template = (Template) itemplate;
		StringExp filename = new StringExp();
		filename.addText(source.getName());
		return new Importcmd(new ImportedFiles(filename), templateTextWriter, source, namespaces, classes, template.getContext(), groovyClassLoader);
	}

	@Override
	public IMacro createMacro(ITemplate itemplate) {
		Template template = (Template) itemplate;
		return new Macro(false, source, namespaces, templateTextWriter, template.getContext());
	}

	// @Override
	// public IMacroref createMacroref(ITemplate itemplate) {
	// Template template = (Template)itemplate;
	// return new Macroref(source, template.getContext(), namespaces,
	// templateTextWriter);
	// }

	@Override
	public IOperator createOperator() {
		return new Operator();
	}

	@Override
	public ICall createCall(ITemplate itemplate) {
		Template template = (Template) itemplate;
		return new Call(source, template.getContext(), namespaces, templateTextWriter);
	}

	@Override
	public INamespace createNamespace() {
		return new Namespace(namespaces);
	}

	@Override
	public IBlock createBlock() {
		return new Block(templateTextWriter);
	}

	@Override
	public INewStatement createNewStatement() {
		return new NewStatement(classes);
	}

	@Override
	public IFunction createFunction(ITemplate itemplate) {
		Template template = (Template) itemplate;
		return new Macro(true, source, namespaces, templateTextWriter, template.getContext());
	}

	@Override
	public IReturncmd createReturncmd(IFunction ifunction) {
		return new Returncmd((Macro) ifunction);
	}

	@Override
	public IError createError() {
		return new net.sf.laja.template.Error(source);
	}
}
