package net.sf.laja;

import java.util.Stack;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.element.AndList;
import net.sf.laja.parser.engine2.element.Chr;
import net.sf.laja.parser.engine2.element.Complete;
import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.element.ElementList;
import net.sf.laja.parser.engine2.element.End;
import net.sf.laja.parser.engine2.element.FollowedBy;
import net.sf.laja.parser.engine2.element.Marker;
import net.sf.laja.parser.engine2.element.Optional;
import net.sf.laja.parser.engine2.element.OrList;
import net.sf.laja.parser.engine2.element.Range;
import net.sf.laja.parser.engine2.element.Repeat;
import net.sf.laja.parser.engine2.element.Str;
import net.sf.laja.parser.engine2.element.Variable;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.engine2.inspector.DefaultSyntaxErrorHandler;
import net.sf.laja.parser.engine2.inspector.SyntaxErrorHandler;
import net.sf.laja.parser.engine2.source.FileSource;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.parser.engine2.source.StringSource;
import net.sf.laja.parser.engine2.source.URLSource;

/**
 * Auto generated 2010-11-25 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-005-beta
 */
public final class TemplateParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private ITemplateFactory factory1;
    private ITemplateFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public TemplateParser(ITemplateFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(ITemplateFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public TemplateParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public TemplateParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public ITemplateFactory getFactory1() {
        return factory1;
    }

    public ITemplateFactory getFactory() {
        return factory2;
    }

    // parse string
    public ParsingResult parseString(String string) throws ParserException {
        return parse(new StringSource(string));
    }

    // parse file
    public ParsingResult parseFile(String filename) throws ParserException {
        return parse(new FileSource(filename));
    }

    // parse URL
    public ParsingResult parseURL(String url) throws ParserException {
        return parse(new URLSource(url));
    }

    // parse
    public ParsingResult parse(Source source) throws ParserException {
        net.sf.laja.parser.engine2.element.Element element = getGrammar1();

        boolean match = element.parse(0, source, false, true, false);
        int bestIndex = source.getBestIndex();

        if (match && source.reachedEnd()) {
            source.reset();
            element = getGrammar2();
            match = element.parse(0, source, false, true, true);
            if (!match) {
                throw new IllegalStateException("The parsing result was true in phase 1, but false in phase 2.");
            }
            return new ParsingResult(true, source, syntaxErrorHandler);
        } else if (sourceRecorderLogWriter != null) {
            source.reset();
            source.getRecorder().setLogging(sourceRecorderLogWriter, bestIndex);
            element.parse(0, source, false, true, false);
        }

        return new ParsingResult(false, source, element, syntaxErrorHandler);
    }

    private net.sf.laja.parser.engine2.element.Element getGrammar2() {
        // *** Output classes ***
        Data.BooleanDataBooleanData booleanDataBooleanData = data2.new BooleanDataBooleanData("booleanDataBooleanData");
        Data.IntegerDataIntegerData integerDataIntegerData = data2.new IntegerDataIntegerData("integerDataIntegerData");
        Data.FloatDataFloatData floatDataFloatData = data2.new FloatDataFloatData("floatDataFloatData");
        Data.DataData dataData = data2.new DataData("dataData");
        Data.TextText textText = data2.new TextText("textText");
        Data.StringExpStringExpStringref stringExpStringExpStringref = data2.new StringExpStringExpStringref("stringExpStringExpStringref");
        Data.StringExpStringExpText stringExpStringExpText = data2.new StringExpStringExpText("stringExpStringExpText");
        Data.NewStatementNewStatementClassOrPackageName newStatementNewStatementClassOrPackageName = data2.new NewStatementNewStatementClassOrPackageName("newStatementNewStatementClassOrPackageName");
        Data.NewStatementNewStatementArgs newStatementNewStatementArgs = data2.new NewStatementNewStatementArgs("newStatementNewStatementArgs");
        Data.DataDataNewStatement dataDataNewStatement = data2.new DataDataNewStatement("dataDataNewStatement");
        Data.DataDataStringExp dataDataStringExp = data2.new DataDataStringExp("dataDataStringExp");
        Data.DataDataListData dataDataListData = data2.new DataDataListData("dataDataListData");
        Data.DataDataMapDataRef dataDataMapDataRef = data2.new DataDataMapDataRef("dataDataMapDataRef");
        Data.DataDataNullData dataDataNullData = data2.new DataDataNullData("dataDataNullData");
        Data.DataDataBooleanData dataDataBooleanData = data2.new DataDataBooleanData("dataDataBooleanData");
        Data.DataDataReference dataDataReference = data2.new DataDataReference("dataDataReference");
        Data.DataDataFloatData dataDataFloatData = data2.new DataDataFloatData("dataDataFloatData");
        Data.DataDataIntegerData dataDataIntegerData = data2.new DataDataIntegerData("dataDataIntegerData");
        Data.ListDataListDataData listDataListDataData = data2.new ListDataListDataData("listDataListDataData");
        Data.ListDataListDataArray listDataListDataArray = data2.new ListDataListDataArray("listDataListDataArray");
        Data.MapMemberMapMemberName mapMemberMapMemberName = data2.new MapMemberMapMemberName("mapMemberMapMemberName");
        Data.MapMemberMapMemberData mapMemberMapMemberData = data2.new MapMemberMapMemberData("mapMemberMapMemberData");
        Data.MapDataRefMapDataRefMapData mapDataRefMapDataRefMapData = data2.new MapDataRefMapDataRefMapData("mapDataRefMapDataRefMapData");
        Data.MapDataMapDataMapMember mapDataMapDataMapMember = data2.new MapDataMapDataMapMember("mapDataMapDataMapMember");
        Data.IndexItemIndexItemUnsignedInt indexItemIndexItemUnsignedInt = data2.new IndexItemIndexItemUnsignedInt("indexItemIndexItemUnsignedInt");
        Data.IndexItemIndexItemReference indexItemIndexItemReference = data2.new IndexItemIndexItemReference("indexItemIndexItemReference");
        Data.ListIndexListIndexIndexItem listIndexListIndexIndexItem = data2.new ListIndexListIndexIndexItem("listIndexListIndexIndexItem");
        Data.ArgsArgsMapData argsArgsMapData = data2.new ArgsArgsMapData("argsArgsMapData");
        Data.ArgsArgsData argsArgsData = data2.new ArgsArgsData("argsArgsData");
        Data.NamespaceRefNamespaceRefNamespace namespaceRefNamespaceRefNamespace = data2.new NamespaceRefNamespaceRefNamespace("namespaceRefNamespaceRefNamespace");
        Data.VariableRefVariableRefVariableName variableRefVariableRefVariableName = data2.new VariableRefVariableRefVariableName("variableRefVariableRefVariableName");
        Data.MethodRefMethodRefMethodName methodRefMethodRefMethodName = data2.new MethodRefMethodRefMethodName("methodRefMethodRefMethodName");
        Data.MethodRefMethodRefArgs methodRefMethodRefArgs = data2.new MethodRefMethodRefArgs("methodRefMethodRefArgs");
        Data.AttributeRefAttributeRefMethodRef attributeRefAttributeRefMethodRef = data2.new AttributeRefAttributeRefMethodRef("attributeRefAttributeRefMethodRef");
        Data.AttributeRefAttributeRefVariableRef attributeRefAttributeRefVariableRef = data2.new AttributeRefAttributeRefVariableRef("attributeRefAttributeRefVariableRef");
        Data.AttributeRefAttributeRefListIndex attributeRefAttributeRefListIndex = data2.new AttributeRefAttributeRefListIndex("attributeRefAttributeRefListIndex");
        Data.AttributeVariableRefAttributeVariableRefVariableRef attributeVariableRefAttributeVariableRefVariableRef = data2.new AttributeVariableRefAttributeVariableRefVariableRef("attributeVariableRefAttributeVariableRefVariableRef");
        Data.AttributeVariableRefAttributeVariableRefListIndex attributeVariableRefAttributeVariableRefListIndex = data2.new AttributeVariableRefAttributeVariableRefListIndex("attributeVariableRefAttributeVariableRefListIndex");
        Data.AttributeMethodRefAttributeMethodRefMethodRef attributeMethodRefAttributeMethodRefMethodRef = data2.new AttributeMethodRefAttributeMethodRefMethodRef("attributeMethodRefAttributeMethodRefMethodRef");
        Data.AttributeMethodRefAttributeMethodRefListIndex attributeMethodRefAttributeMethodRefListIndex = data2.new AttributeMethodRefAttributeMethodRefListIndex("attributeMethodRefAttributeMethodRefListIndex");
        Data.ReferenceReferenceBegin referenceReferenceBegin = data2.new ReferenceReferenceBegin("referenceReferenceBegin");
        Data.ReferenceReferenceNamespaceRef referenceReferenceNamespaceRef = data2.new ReferenceReferenceNamespaceRef("referenceReferenceNamespaceRef");
        Data.ReferenceReferenceAttributeRef referenceReferenceAttributeRef = data2.new ReferenceReferenceAttributeRef("referenceReferenceAttributeRef");
        Data.ReferenceReferenceNextAttributeRef referenceReferenceNextAttributeRef = data2.new ReferenceReferenceNextAttributeRef("referenceReferenceNextAttributeRef");
        Data.ReferenceReferenceFloatData referenceReferenceFloatData = data2.new ReferenceReferenceFloatData("referenceReferenceFloatData");
        Data.ReferenceReferenceIntegerData referenceReferenceIntegerData = data2.new ReferenceReferenceIntegerData("referenceReferenceIntegerData");
        Data.ReferenceReferenceStringExp referenceReferenceStringExp = data2.new ReferenceReferenceStringExp("referenceReferenceStringExp");
        Data.CallReferenceCallReferenceBegin callReferenceCallReferenceBegin = data2.new CallReferenceCallReferenceBegin("callReferenceCallReferenceBegin");
        Data.CallReferenceCallReferenceNamespaceRef callReferenceCallReferenceNamespaceRef = data2.new CallReferenceCallReferenceNamespaceRef("callReferenceCallReferenceNamespaceRef");
        Data.CallReferenceCallReferenceAttributeMethodRef callReferenceCallReferenceAttributeMethodRef = data2.new CallReferenceCallReferenceAttributeMethodRef("callReferenceCallReferenceAttributeMethodRef");
        Data.CallReferenceCallReferenceAttributeVariableRef callReferenceCallReferenceAttributeVariableRef = data2.new CallReferenceCallReferenceAttributeVariableRef("callReferenceCallReferenceAttributeVariableRef");
        Data.CallReferenceCallReferenceNextAttributeRef callReferenceCallReferenceNextAttributeRef = data2.new CallReferenceCallReferenceNextAttributeRef("callReferenceCallReferenceNextAttributeRef");
        Data.StringrefStringrefBegin stringrefStringrefBegin = data2.new StringrefStringrefBegin("stringrefStringrefBegin");
        Data.StringrefStringrefParentDir stringrefStringrefParentDir = data2.new StringrefStringrefParentDir("stringrefStringrefParentDir");
        Data.StringrefStringrefCurrentDir stringrefStringrefCurrentDir = data2.new StringrefStringrefCurrentDir("stringrefStringrefCurrentDir");
        Data.StringrefStringrefReference stringrefStringrefReference = data2.new StringrefStringrefReference("stringrefStringrefReference");
        Data.WriteWriteBegin writeWriteBegin = data2.new WriteWriteBegin("writeWriteBegin");
        Data.WriteWriteFilename writeWriteFilename = data2.new WriteWriteFilename("writeWriteFilename");
        Data.WriteWriteBlock writeWriteBlock = data2.new WriteWriteBlock("writeWriteBlock");
        Data.SetSetBegin setSetBegin = data2.new SetSetBegin("setSetBegin");
        Data.SetSetTarget setSetTarget = data2.new SetSetTarget("setSetTarget");
        Data.SetSetComparition setSetComparition = data2.new SetSetComparition("setSetComparition");
        Data.SetSetData setSetData = data2.new SetSetData("setSetData");
        Data.LocalLocalTarget localLocalTarget = data2.new LocalLocalTarget("localLocalTarget");
        Data.LocalLocalComparition localLocalComparition = data2.new LocalLocalComparition("localLocalComparition");
        Data.LocalLocalData localLocalData = data2.new LocalLocalData("localLocalData");
        Data.OperatorOperatorEquals operatorOperatorEquals = data2.new OperatorOperatorEquals("operatorOperatorEquals");
        Data.OperatorOperatorNotEquals operatorOperatorNotEquals = data2.new OperatorOperatorNotEquals("operatorOperatorNotEquals");
        Data.OperatorOperatorLessOrEqual operatorOperatorLessOrEqual = data2.new OperatorOperatorLessOrEqual("operatorOperatorLessOrEqual");
        Data.OperatorOperatorLessThan operatorOperatorLessThan = data2.new OperatorOperatorLessThan("operatorOperatorLessThan");
        Data.OperatorOperatorGreaterOrEqual operatorOperatorGreaterOrEqual = data2.new OperatorOperatorGreaterOrEqual("operatorOperatorGreaterOrEqual");
        Data.OperatorOperatorGreaterThan operatorOperatorGreaterThan = data2.new OperatorOperatorGreaterThan("operatorOperatorGreaterThan");
        Data.ComparitionComparitionLeftOperand comparitionComparitionLeftOperand = data2.new ComparitionComparitionLeftOperand("comparitionComparitionLeftOperand");
        Data.ComparitionComparitionOperator comparitionComparitionOperator = data2.new ComparitionComparitionOperator("comparitionComparitionOperator");
        Data.ComparitionComparitionRightOperand comparitionComparitionRightOperand = data2.new ComparitionComparitionRightOperand("comparitionComparitionRightOperand");
        Data.ConditionElementConditionElementNot conditionElementConditionElementNot = data2.new ConditionElementConditionElementNot("conditionElementConditionElementNot");
        Data.ConditionElementConditionElementComparition conditionElementConditionElementComparition = data2.new ConditionElementConditionElementComparition("conditionElementConditionElementComparition");
        Data.ConditionElementConditionElementReference conditionElementConditionElementReference = data2.new ConditionElementConditionElementReference("conditionElementConditionElementReference");
        Data.ConditionElementConditionElementBooleanCondition conditionElementConditionElementBooleanCondition = data2.new ConditionElementConditionElementBooleanCondition("conditionElementConditionElementBooleanCondition");
        Data.ConditionBaseConditionBaseConditionElement conditionBaseConditionBaseConditionElement = data2.new ConditionBaseConditionBaseConditionElement("conditionBaseConditionBaseConditionElement");
        Data.ConditionBaseConditionBaseCondition conditionBaseConditionBaseCondition = data2.new ConditionBaseConditionBaseCondition("conditionBaseConditionBaseCondition");
        Data.ConditionAndConditionAndConditionBase conditionAndConditionAndConditionBase = data2.new ConditionAndConditionAndConditionBase("conditionAndConditionAndConditionBase");
        Data.ConditionConditionConditionAnd conditionConditionConditionAnd = data2.new ConditionConditionConditionAnd("conditionConditionConditionAnd");
        Data.IfcmdIfcmdCondition ifcmdIfcmdCondition = data2.new IfcmdIfcmdCondition("ifcmdIfcmdCondition");
        Data.IfcmdIfcmdBlock ifcmdIfcmdBlock = data2.new IfcmdIfcmdBlock("ifcmdIfcmdBlock");
        Data.IfcmdIfcmdElseif ifcmdIfcmdElseif = data2.new IfcmdIfcmdElseif("ifcmdIfcmdElseif");
        Data.IfcmdIfcmdElse ifcmdIfcmdElse = data2.new IfcmdIfcmdElse("ifcmdIfcmdElse");
        Data.ElseifElseifCondition elseifElseifCondition = data2.new ElseifElseifCondition("elseifElseifCondition");
        Data.ElseifElseifBlock elseifElseifBlock = data2.new ElseifElseifBlock("elseifElseifBlock");
        Data.ElseElseBlock elseElseBlock = data2.new ElseElseBlock("elseElseBlock");
        Data.WhilecmdWhilecmdCondition whilecmdWhilecmdCondition = data2.new WhilecmdWhilecmdCondition("whilecmdWhilecmdCondition");
        Data.WhilecmdWhilecmdBlock whilecmdWhilecmdBlock = data2.new WhilecmdWhilecmdBlock("whilecmdWhilecmdBlock");
        Data.CallCallBegin callCallBegin = data2.new CallCallBegin("callCallBegin");
        Data.CallCallCallReference callCallCallReference = data2.new CallCallCallReference("callCallCallReference");
        Data.CallCallTargetNamespace callCallTargetNamespace = data2.new CallCallTargetNamespace("callCallTargetNamespace");
        Data.CallCallTargetVariable callCallTargetVariable = data2.new CallCallTargetVariable("callCallTargetVariable");
        Data.ForeachForeachBegin foreachForeachBegin = data2.new ForeachForeachBegin("foreachForeachBegin");
        Data.ForeachForeachVariable foreachForeachVariable = data2.new ForeachForeachVariable("foreachForeachVariable");
        Data.ForeachForeachListData foreachForeachListData = data2.new ForeachForeachListData("foreachForeachListData");
        Data.ForeachForeachMapDataRef foreachForeachMapDataRef = data2.new ForeachForeachMapDataRef("foreachForeachMapDataRef");
        Data.ForeachForeachReference foreachForeachReference = data2.new ForeachForeachReference("foreachForeachReference");
        Data.ForeachForeachCondition foreachForeachCondition = data2.new ForeachForeachCondition("foreachForeachCondition");
        Data.ForeachForeachBlock foreachForeachBlock = data2.new ForeachForeachBlock("foreachForeachBlock");
        Data.ImportcmdImportcmdBegin importcmdImportcmdBegin = data2.new ImportcmdImportcmdBegin("importcmdImportcmdBegin");
        Data.ImportcmdImportcmdFilename importcmdImportcmdFilename = data2.new ImportcmdImportcmdFilename("importcmdImportcmdFilename");
        Data.ImportcmdImportcmdAsText importcmdImportcmdAsText = data2.new ImportcmdImportcmdAsText("importcmdImportcmdAsText");
        Data.MacroMacroBegin macroMacroBegin = data2.new MacroMacroBegin("macroMacroBegin");
        Data.MacroMacroName macroMacroName = data2.new MacroMacroName("macroMacroName");
        Data.MacroMacroParameter macroMacroParameter = data2.new MacroMacroParameter("macroMacroParameter");
        Data.MacroMacroBlock macroMacroBlock = data2.new MacroMacroBlock("macroMacroBlock");
        Data.ReturncmdReturncmdData returncmdReturncmdData = data2.new ReturncmdReturncmdData("returncmdReturncmdData");
        Data.ReturncmdReturncmdComparition returncmdReturncmdComparition = data2.new ReturncmdReturncmdComparition("returncmdReturncmdComparition");
        Data.FunctionFunctionName functionFunctionName = data2.new FunctionFunctionName("functionFunctionName");
        Data.FunctionFunctionParameter functionFunctionParameter = data2.new FunctionFunctionParameter("functionFunctionParameter");
        Data.FunctionFunctionBlock functionFunctionBlock = data2.new FunctionFunctionBlock("functionFunctionBlock");
        Data.NamespaceNamespaceName namespaceNamespaceName = data2.new NamespaceNamespaceName("namespaceNamespaceName");
        Data.ErrorErrorBegin errorErrorBegin = data2.new ErrorErrorBegin("errorErrorBegin");
        Data.ErrorErrorMessage errorErrorMessage = data2.new ErrorErrorMessage("errorErrorMessage");
        Data.CommandCommandLocal commandCommandLocal = data2.new CommandCommandLocal("commandCommandLocal");
        Data.CommandCommandSet commandCommandSet = data2.new CommandCommandSet("commandCommandSet");
        Data.CommandCommandWrite commandCommandWrite = data2.new CommandCommandWrite("commandCommandWrite");
        Data.CommandCommandIfcmd commandCommandIfcmd = data2.new CommandCommandIfcmd("commandCommandIfcmd");
        Data.CommandCommandWhilecmd commandCommandWhilecmd = data2.new CommandCommandWhilecmd("commandCommandWhilecmd");
        Data.CommandCommandForeach commandCommandForeach = data2.new CommandCommandForeach("commandCommandForeach");
        Data.CommandCommandImportcmd commandCommandImportcmd = data2.new CommandCommandImportcmd("commandCommandImportcmd");
        Data.CommandCommandError commandCommandError = data2.new CommandCommandError("commandCommandError");
        Data.CommandCommandMacro commandCommandMacro = data2.new CommandCommandMacro("commandCommandMacro");
        Data.CommandCommandFunction commandCommandFunction = data2.new CommandCommandFunction("commandCommandFunction");
        Data.CommandCommandCall commandCommandCall = data2.new CommandCommandCall("commandCommandCall");
        Data.BlockAstextText blockAstextText = data2.new BlockAstextText("blockAstextText");
        Data.BlockBlockReturncmd blockBlockReturncmd = data2.new BlockBlockReturncmd("blockBlockReturncmd");
        Data.BlockBlockCommand blockBlockCommand = data2.new BlockBlockCommand("blockBlockCommand");
        Data.BlockBlockStringref blockBlockStringref = data2.new BlockBlockStringref("blockBlockStringref");
        Data.BlockBlockText blockBlockText = data2.new BlockBlockText("blockBlockText");
        Data.TemplateTemplateNamespace templateTemplateNamespace = data2.new TemplateTemplateNamespace("templateTemplateNamespace");
        Data.TemplateTemplateDefaultNamespace templateTemplateDefaultNamespace = data2.new TemplateTemplateDefaultNamespace("templateTemplateDefaultNamespace");
        Data.TemplateTemplateBlock templateTemplateBlock = data2.new TemplateTemplateBlock("templateTemplateBlock");
        Data.ConditionElementConditionElementBooleanData conditionElementConditionElementBooleanData = data2.new ConditionElementConditionElementBooleanData("conditionElementConditionElementBooleanData");
        Data.TextTextStringref textTextStringref = data2.new TextTextStringref("textTextStringref");

        // *** Declarations ***
        OrList newline = new OrList(1, "newline");
        ElementList comment = new ElementList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Str ff = new Str(5, "\"");
        Repeat spaces = new Repeat(6, "spaces");
        Range digit = new Range(7, "digit", "0", "9");
        FollowedBy booleanData = new FollowedBy(8, "booleanData", booleanDataBooleanData);
        Repeat unsignedInt = new Repeat(9, "unsignedInt");
        ElementList integerData = new ElementList(10, "integerData", integerDataIntegerData);
        ElementList floatData = new ElementList(11, "floatData", floatDataFloatData);
        OrList letter = new OrList(12, "letter");
        ElementList varname = new ElementList(13, "varname");
        Optional skip = new Optional(14, "skip");
        FollowedBy nullData = new FollowedBy(15, "nullData");
        ElementList stringExp = new ElementList(16, "stringExp");
        ElementList classOrPackageName = new ElementList(17, "classOrPackageName");
        ElementList newStatement = new ElementList(18, "newStatement");
        OrList data = new OrList(19, "data", dataData);
        ElementList listData = new ElementList(20, "listData");
        ElementList mapMember = new ElementList(21, "mapMember");
        ElementList mapDataRef = new ElementList(22, "mapDataRef");
        ElementList mapData = new ElementList(23, "mapData");
        OrList indexItem = new OrList(24, "indexItem");
        Repeat listIndex = new Repeat(25, "listIndex");
        ElementList args = new ElementList(26, "args");
        ElementList namespaceRef = new ElementList(27, "namespaceRef");
        ElementList variableRef = new ElementList(28, "variableRef");
        ElementList methodRef = new ElementList(29, "methodRef");
        ElementList attributeRef = new ElementList(30, "attributeRef");
        ElementList attributeVariableRef = new ElementList(31, "attributeVariableRef");
        ElementList attributeMethodRef = new ElementList(32, "attributeMethodRef");
        ElementList reference = new ElementList(33, "reference");
        ElementList callReference = new ElementList(34, "callReference");
        ElementList stringref = new ElementList(35, "stringref");
        ElementList end = new ElementList(36, "end");
        ElementList write = new ElementList(37, "write");
        ElementList set = new ElementList(38, "set");
        ElementList local = new ElementList(39, "local");
        OrList operator = new OrList(40, "operator");
        ElementList comparition = new ElementList(41, "comparition");
        ElementList conditionElement = new ElementList(42, "conditionElement");
        OrList conditionBase = new OrList(43, "conditionBase");
        ElementList conditionAnd = new ElementList(44, "conditionAnd");
        ElementList condition = new ElementList(45, "condition");
        ElementList ifcmd = new ElementList(46, "ifcmd");
        ElementList elseif = new ElementList(47, "elseif");
        ElementList _else = new ElementList(48, "else");
        ElementList whilecmd = new ElementList(49, "whilecmd");
        ElementList call = new ElementList(50, "call");
        ElementList foreach = new ElementList(51, "foreach");
        ElementList importcmd = new ElementList(52, "importcmd");
        ElementList macro = new ElementList(53, "macro");
        ElementList returncmd = new ElementList(54, "returncmd");
        ElementList function = new ElementList(55, "function");
        ElementList namespace = new ElementList(56, "namespace");
        ElementList error = new ElementList(57, "error");
        ElementList command = new ElementList(58, "command");
        ElementList astext = new ElementList(59, "astext");
        Repeat text = new Repeat(60, "text", textText);
        Optional block = new Optional(61, "block");
        ElementList template = new ElementList(62, "template");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(64, new Str(63, "\r\n"));
        newline.add(66, new Str(65, "\n"));

        // comment = [spaces] ("#*" [(comment | !"*#")+] "*#") | ("##" [!newline+] newline|END) skip
        Optional comment_1 = new Optional(67, "comment_1");
        comment_1.add(68, spaces);
        comment.add(69, comment_1);
        OrList comment_2 = new OrList(70, "comment_2");
        ElementList comment_2_1 = new ElementList(71, "comment_2_1");
        comment_2_1.add(73, new Str(72, "#*"));
        Optional comment_2_1_1 = new Optional(74, "comment_2_1_1");
        Repeat comment_2_1_1_1 = new Repeat(75, "comment_2_1_1_1");
        OrList comment_2_1_1_1_1 = new OrList(76, "comment_2_1_1_1_1");
        comment_2_1_1_1_1.add(77, comment);
        comment_2_1_1_1_1.add(79, new Str(78, "*#", NOT));
        comment_2_1_1_1.add(80, comment_2_1_1_1_1);
        comment_2_1_1.add(81, comment_2_1_1_1);
        comment_2_1.add(82, comment_2_1_1);
        comment_2_1.add(84, new Str(83, "*#"));
        comment_2.add(85, comment_2_1);
        ElementList comment_2_2 = new ElementList(86, "comment_2_2");
        comment_2_2.add(88, new Str(87, "##"));
        Optional comment_2_2_1 = new Optional(89, "comment_2_2_1");
        Repeat comment_2_2_1_1 = new Repeat(90, "comment_2_2_1_1");
        comment_2_2_1_1.add(91, newline, NOT);
        comment_2_2_1.add(92, comment_2_2_1_1);
        comment_2_2.add(93, comment_2_2_1);
        OrList comment_2_2_2 = new OrList(94, "comment_2_2_2");
        comment_2_2_2.add(95, newline);
        comment_2_2_2.add(97, new End(96, "comment_2_2_2"));
        comment_2_2.add(98, comment_2_2_2);
        comment_2.add(99, comment_2_2);
        comment.add(100, comment_2);
        comment.add(101, skip);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(102, "ws_1");
        ws_1.add(103, newline);
        ws_1.add(105, new Str(104, " "));
        ws_1.add(107, new Str(106, "\t"));
        ws_1.add(108, comment);
        ws.add(109, ws_1);

        // s = [ws]
        s.add(110, ws);

        // ff = "\""

        // spaces = (" " | "\t")+
        OrList spaces_1 = new OrList(111, "spaces_1");
        spaces_1.add(113, new Str(112, " "));
        spaces_1.add(115, new Str(114, "\t"));
        spaces.add(116, spaces_1);

        // digit = "0".."9"

        // booleanData = "true":true | "false":false \ !(letter|digit)
        OrList booleanData_1 = new OrList(117, "booleanData_1");
        booleanData_1.add(119, new Str(118, "true"));
        booleanData_1.add(121, new Str(120, "false"));
        booleanData.setElement(122, booleanData_1);
        OrList booleanData_2 = new OrList(123, "booleanData_2", NOT);
        booleanData_2.add(124, letter);
        booleanData_2.add(125, digit);
        booleanData.followedby(126, booleanData_2);

        // unsignedInt = digit+
        unsignedInt.add(127, digit);

        // integerData = ["-"] unsignedInt
        Optional integerData_1 = new Optional(128, "integerData_1");
        integerData_1.add(130, new Str(129, "-"));
        integerData.add(131, integerData_1);
        integerData.add(132, unsignedInt);

        // floatData = ["-"] unsignedInt "." unsignedInt
        Optional floatData_1 = new Optional(133, "floatData_1");
        floatData_1.add(135, new Str(134, "-"));
        floatData.add(136, floatData_1);
        floatData.add(137, unsignedInt);
        floatData.add(139, new Str(138, "."));
        floatData.add(140, unsignedInt);

        // letter = "a".."z" | "A".."Z" | "_"
        letter.add(142, new Range(141, "letter", "a", "z"));
        letter.add(144, new Range(143, "letter", "A", "Z"));
        letter.add(146, new Str(145, "_"));

        // varname = letter [letter|digit]+
        varname.add(147, letter);
        Optional varname_1 = new Optional(148, "varname_1");
        Repeat varname_1_1 = new Repeat(149, "varname_1_1");
        OrList varname_1_1_1 = new OrList(150, "varname_1_1_1");
        varname_1_1_1.add(151, letter);
        varname_1_1_1.add(152, digit);
        varname_1_1.add(153, varname_1_1_1);
        varname_1.add(154, varname_1_1);
        varname.add(155, varname_1);

        // skip = [[spaces] newline]
        Optional skip_1 = new Optional(156, "skip_1");
        skip_1.add(157, spaces);
        skip.add(158, skip_1);
        skip.add(159, newline);

        // nullData = "null" \ !(letter|digit)
        nullData.setElement(161, new Str(160, "null"));
        OrList nullData_1 = new OrList(162, "nullData_1", NOT);
        nullData_1.add(163, letter);
        nullData_1.add(164, digit);
        nullData.followedby(165, nullData_1);

        // stringExp = ff [stringref | (("\\\"" | !(ff|stringref))+):text]+ ff
        stringExp.add(166, ff);
        Optional stringExp_1 = new Optional(167, "stringExp_1");
        Repeat stringExp_1_1 = new Repeat(168, "stringExp_1_1");
        OrList stringExp_1_1_1 = new OrList(169, "stringExp_1_1_1");
        stringExp_1_1_1.add(170, stringref, stringExpStringExpStringref);
        Repeat stringExp_1_1_1_1 = new Repeat(171, "stringExp_1_1_1_1", stringExpStringExpText);
        OrList stringExp_1_1_1_1_1 = new OrList(172, "stringExp_1_1_1_1_1");
        stringExp_1_1_1_1_1.add(174, new Str(173, "\\\""));
        OrList stringExp_1_1_1_1_1_1 = new OrList(175, "stringExp_1_1_1_1_1_1", NOT);
        stringExp_1_1_1_1_1_1.add(176, ff);
        stringExp_1_1_1_1_1_1.add(177, stringref, stringExpStringExpStringref);
        stringExp_1_1_1_1_1.add(178, stringExp_1_1_1_1_1_1);
        stringExp_1_1_1_1.add(179, stringExp_1_1_1_1_1);
        stringExp_1_1_1.add(180, stringExp_1_1_1_1);
        stringExp_1_1.add(181, stringExp_1_1_1);
        stringExp_1.add(182, stringExp_1_1);
        stringExp.add(183, stringExp_1);
        stringExp.add(184, ff);

        // classOrPackageName = letter|"$" [letter|digit|"$"]+
        OrList classOrPackageName_1 = new OrList(185, "classOrPackageName_1");
        classOrPackageName_1.add(186, letter);
        classOrPackageName_1.add(188, new Str(187, "$"));
        classOrPackageName.add(189, classOrPackageName_1);
        Optional classOrPackageName_2 = new Optional(190, "classOrPackageName_2");
        Repeat classOrPackageName_2_1 = new Repeat(191, "classOrPackageName_2_1");
        OrList classOrPackageName_2_1_1 = new OrList(192, "classOrPackageName_2_1_1");
        classOrPackageName_2_1_1.add(193, letter);
        classOrPackageName_2_1_1.add(194, digit);
        classOrPackageName_2_1_1.add(196, new Str(195, "$"));
        classOrPackageName_2_1.add(197, classOrPackageName_2_1_1);
        classOrPackageName_2.add(198, classOrPackageName_2_1);
        classOrPackageName.add(199, classOrPackageName_2);

        // newStatement = "new" ws classOrPackageName ["." classOrPackageName]+ s args
        newStatement.add(201, new Str(200, "new"));
        newStatement.add(202, ws);
        newStatement.add(203, classOrPackageName, newStatementNewStatementClassOrPackageName);
        Optional newStatement_1 = new Optional(204, "newStatement_1");
        Repeat newStatement_1_1 = new Repeat(205, "newStatement_1_1");
        newStatement_1_1.add(207, new Str(206, "."));
        newStatement_1_1.add(208, classOrPackageName, newStatementNewStatementClassOrPackageName);
        newStatement_1.add(209, newStatement_1_1);
        newStatement.add(210, newStatement_1);
        newStatement.add(211, s);
        newStatement.add(212, args, newStatementNewStatementArgs);

        // data = newStatement | stringExp | listData | mapDataRef | nullData | booleanData | reference | floatData | integerData
        data.add(213, newStatement, dataDataNewStatement);
        data.add(214, stringExp, dataDataStringExp);
        data.add(215, listData, dataDataListData);
        data.add(216, mapDataRef, dataDataMapDataRef);
        data.add(217, nullData, dataDataNullData);
        data.add(218, booleanData, dataDataBooleanData);
        data.add(219, reference, dataDataReference);
        data.add(220, floatData, dataDataFloatData);
        data.add(221, integerData, dataDataIntegerData);

        // listData = "[" s [data [s "," s data]+ s] "]" [s "as array":array]
        listData.add(223, new Str(222, "["));
        listData.add(224, s);
        Optional listData_1 = new Optional(225, "listData_1");
        listData_1.add(226, data, listDataListDataData);
        Optional listData_1_1 = new Optional(227, "listData_1_1");
        Repeat listData_1_1_1 = new Repeat(228, "listData_1_1_1");
        listData_1_1_1.add(229, s);
        listData_1_1_1.add(231, new Str(230, ","));
        listData_1_1_1.add(232, s);
        listData_1_1_1.add(233, data, listDataListDataData);
        listData_1_1.add(234, listData_1_1_1);
        listData_1.add(235, listData_1_1);
        listData_1.add(236, s);
        listData.add(237, listData_1);
        listData.add(239, new Str(238, "]"));
        Optional listData_2 = new Optional(240, "listData_2");
        listData_2.add(241, s);
        listData_2.add(243, new Str(242, "as array", listDataListDataArray));
        listData.add(244, listData_2);

        // mapMember = varname:name s ":" s data
        mapMember.add(245, varname, mapMemberMapMemberName);
        mapMember.add(246, s);
        mapMember.add(248, new Str(247, ":"));
        mapMember.add(249, s);
        mapMember.add(250, data, mapMemberMapMemberData);

        // mapDataRef = "{" [mapData] "}"
        mapDataRef.add(252, new Str(251, "{"));
        Optional mapDataRef_1 = new Optional(253, "mapDataRef_1");
        mapDataRef_1.add(254, mapData, mapDataRefMapDataRefMapData);
        mapDataRef.add(255, mapDataRef_1);
        mapDataRef.add(257, new Str(256, "}"));

        // mapData = (s mapMember)+ s
        Repeat mapData_1 = new Repeat(258, "mapData_1");
        mapData_1.add(259, s);
        mapData_1.add(260, mapMember, mapDataMapDataMapMember);
        mapData.add(261, mapData_1);
        mapData.add(262, s);

        // indexItem = unsignedInt | reference
        indexItem.add(263, unsignedInt, indexItemIndexItemUnsignedInt);
        indexItem.add(264, reference, indexItemIndexItemReference);

        // listIndex = ("[" indexItem "]")+
        listIndex.add(266, new Str(265, "["));
        listIndex.add(267, indexItem, listIndexListIndexIndexItem);
        listIndex.add(269, new Str(268, "]"));

        // args = "(" s mapData|([data [s "," s data]+]) s ")"
        args.add(271, new Str(270, "("));
        args.add(272, s);
        OrList args_1 = new OrList(273, "args_1");
        args_1.add(274, mapData, argsArgsMapData);
        Optional args_1_1 = new Optional(275, "args_1_1");
        args_1_1.add(276, data, argsArgsData);
        Optional args_1_1_1 = new Optional(277, "args_1_1_1");
        Repeat args_1_1_1_1 = new Repeat(278, "args_1_1_1_1");
        args_1_1_1_1.add(279, s);
        args_1_1_1_1.add(281, new Str(280, ","));
        args_1_1_1_1.add(282, s);
        args_1_1_1_1.add(283, data, argsArgsData);
        args_1_1_1.add(284, args_1_1_1_1);
        args_1_1.add(285, args_1_1_1);
        args_1.add(286, args_1_1);
        args.add(287, args_1);
        args.add(288, s);
        args.add(290, new Str(289, ")"));

        // namespaceRef = "$" [varname]:namespace
        namespaceRef.add(292, new Str(291, "$"));
        Optional namespaceRef_1 = new Optional(293, "namespaceRef_1", namespaceRefNamespaceRefNamespace);
        namespaceRef_1.add(294, varname);
        namespaceRef.add(295, namespaceRef_1);

        // variableRef = varname:variableName
        variableRef.add(296, varname, variableRefVariableRefVariableName);

        // methodRef = varname:methodName s args
        methodRef.add(297, varname, methodRefMethodRefMethodName);
        methodRef.add(298, s);
        methodRef.add(299, args, methodRefMethodRefArgs);

        // attributeRef = methodRef|variableRef [listIndex]
        OrList attributeRef_1 = new OrList(300, "attributeRef_1");
        attributeRef_1.add(301, methodRef, attributeRefAttributeRefMethodRef);
        attributeRef_1.add(302, variableRef, attributeRefAttributeRefVariableRef);
        attributeRef.add(303, attributeRef_1);
        Optional attributeRef_2 = new Optional(304, "attributeRef_2");
        attributeRef_2.add(305, listIndex, attributeRefAttributeRefListIndex);
        attributeRef.add(306, attributeRef_2);

        // attributeVariableRef = variableRef [listIndex]
        attributeVariableRef.add(307, variableRef, attributeVariableRefAttributeVariableRefVariableRef);
        Optional attributeVariableRef_1 = new Optional(308, "attributeVariableRef_1");
        attributeVariableRef_1.add(309, listIndex, attributeVariableRefAttributeVariableRefListIndex);
        attributeVariableRef.add(310, attributeVariableRef_1);

        // attributeMethodRef = methodRef [listIndex]
        attributeMethodRef.add(311, methodRef, attributeMethodRefAttributeMethodRefMethodRef);
        Optional attributeMethodRef_1 = new Optional(312, "attributeMethodRef_1");
        attributeMethodRef_1.add(313, listIndex, attributeMethodRefAttributeMethodRefListIndex);
        attributeMethodRef.add(314, attributeMethodRef_1);

        // reference =
        //   :begin (([namespaceRef "."] attributeRef)|namespaceRef ["." attributeRef:nextAttributeRef]+) |
        //   (floatData|integerData|stringExp ("." attributeRef:nextAttributeRef)+)
        reference.add(316, new Marker(315, "begin", referenceReferenceBegin));
        OrList reference_1 = new OrList(317, "reference_1");
        ElementList reference_1_1 = new ElementList(318, "reference_1_1");
        OrList reference_1_1_1 = new OrList(319, "reference_1_1_1");
        ElementList reference_1_1_1_1 = new ElementList(320, "reference_1_1_1_1");
        Optional reference_1_1_1_1_1 = new Optional(321, "reference_1_1_1_1_1");
        reference_1_1_1_1_1.add(322, namespaceRef, referenceReferenceNamespaceRef);
        reference_1_1_1_1_1.add(324, new Str(323, "."));
        reference_1_1_1_1.add(325, reference_1_1_1_1_1);
        reference_1_1_1_1.add(326, attributeRef, referenceReferenceAttributeRef);
        reference_1_1_1.add(327, reference_1_1_1_1);
        reference_1_1_1.add(328, namespaceRef, referenceReferenceNamespaceRef);
        reference_1_1.add(329, reference_1_1_1);
        Optional reference_1_1_2 = new Optional(330, "reference_1_1_2");
        Repeat reference_1_1_2_1 = new Repeat(331, "reference_1_1_2_1");
        reference_1_1_2_1.add(333, new Str(332, "."));
        reference_1_1_2_1.add(334, attributeRef, referenceReferenceNextAttributeRef);
        reference_1_1_2.add(335, reference_1_1_2_1);
        reference_1_1.add(336, reference_1_1_2);
        reference_1.add(337, reference_1_1);
        ElementList reference_1_2 = new ElementList(338, "reference_1_2");
        OrList reference_1_2_1 = new OrList(339, "reference_1_2_1");
        reference_1_2_1.add(340, floatData, referenceReferenceFloatData);
        reference_1_2_1.add(341, integerData, referenceReferenceIntegerData);
        reference_1_2_1.add(342, stringExp, referenceReferenceStringExp);
        reference_1_2.add(343, reference_1_2_1);
        Repeat reference_1_2_2 = new Repeat(344, "reference_1_2_2");
        reference_1_2_2.add(346, new Str(345, "."));
        reference_1_2_2.add(347, attributeRef, referenceReferenceNextAttributeRef);
        reference_1_2.add(348, reference_1_2_2);
        reference_1.add(349, reference_1_2);
        reference.add(350, reference_1);

        // callReference =
        //   :begin (([namespaceRef "."](attributeMethodRef)|(attributeVariableRef ("." attributeRef:nextAttributeRef)+))
        //   ["." attributeRef:nextAttributeRef]+)
        callReference.add(352, new Marker(351, "begin", callReferenceCallReferenceBegin));
        ElementList callReference_1 = new ElementList(353, "callReference_1");
        ElementList callReference_1_1 = new ElementList(354, "callReference_1_1");
        Optional callReference_1_1_1 = new Optional(355, "callReference_1_1_1");
        callReference_1_1_1.add(356, namespaceRef, callReferenceCallReferenceNamespaceRef);
        callReference_1_1_1.add(358, new Str(357, "."));
        callReference_1_1.add(359, callReference_1_1_1);
        OrList callReference_1_1_2 = new OrList(360, "callReference_1_1_2");
        callReference_1_1_2.add(361, attributeMethodRef, callReferenceCallReferenceAttributeMethodRef);
        ElementList callReference_1_1_2_1 = new ElementList(362, "callReference_1_1_2_1");
        callReference_1_1_2_1.add(363, attributeVariableRef, callReferenceCallReferenceAttributeVariableRef);
        Repeat callReference_1_1_2_1_1 = new Repeat(364, "callReference_1_1_2_1_1");
        callReference_1_1_2_1_1.add(366, new Str(365, "."));
        callReference_1_1_2_1_1.add(367, attributeRef, callReferenceCallReferenceNextAttributeRef);
        callReference_1_1_2_1.add(368, callReference_1_1_2_1_1);
        callReference_1_1_2.add(369, callReference_1_1_2_1);
        callReference_1_1.add(370, callReference_1_1_2);
        callReference_1.add(371, callReference_1_1);
        Optional callReference_1_2 = new Optional(372, "callReference_1_2");
        Repeat callReference_1_2_1 = new Repeat(373, "callReference_1_2_1");
        callReference_1_2_1.add(375, new Str(374, "."));
        callReference_1_2_1.add(376, attributeRef, callReferenceCallReferenceNextAttributeRef);
        callReference_1_2.add(377, callReference_1_2_1);
        callReference_1.add(378, callReference_1_2);
        callReference.add(379, callReference_1);

        // stringref = :begin "{" "..":parentDir | ".":currentDir | reference "}"
        stringref.add(381, new Marker(380, "begin", stringrefStringrefBegin));
        stringref.add(383, new Str(382, "{"));
        OrList stringref_1 = new OrList(384, "stringref_1");
        stringref_1.add(386, new Str(385, "..", stringrefStringrefParentDir));
        stringref_1.add(388, new Str(387, ".", stringrefStringrefCurrentDir));
        stringref_1.add(389, reference, stringrefStringrefReference);
        stringref.add(390, stringref_1);
        stringref.add(392, new Str(391, "}"));

        // end = [spaces] "#end" skip
        Optional end_1 = new Optional(393, "end_1");
        end_1.add(394, spaces);
        end.add(395, end_1);
        end.add(397, new Str(396, "#end"));
        end.add(398, skip);

        // write = :begin "#write" ws stringExp:filename skip block end
        write.add(400, new Marker(399, "begin", writeWriteBegin));
        write.add(402, new Str(401, "#write"));
        write.add(403, ws);
        write.add(404, stringExp, writeWriteFilename);
        write.add(405, skip);
        write.add(406, block, writeWriteBlock);
        write.add(407, end);

        // set = :begin "#set" s "(" s reference:target s "=" s comparition|data s ")" skip
        set.add(409, new Marker(408, "begin", setSetBegin));
        set.add(411, new Str(410, "#set"));
        set.add(412, s);
        set.add(414, new Str(413, "("));
        set.add(415, s);
        set.add(416, reference, setSetTarget);
        set.add(417, s);
        set.add(419, new Str(418, "="));
        set.add(420, s);
        OrList set_1 = new OrList(421, "set_1");
        set_1.add(422, comparition, setSetComparition);
        set_1.add(423, data, setSetData);
        set.add(424, set_1);
        set.add(425, s);
        set.add(427, new Str(426, ")"));
        set.add(428, skip);

        // local = "#local" s "(" s reference:target s "=" s comparition|data s ")" skip
        local.add(430, new Str(429, "#local"));
        local.add(431, s);
        local.add(433, new Str(432, "("));
        local.add(434, s);
        local.add(435, reference, localLocalTarget);
        local.add(436, s);
        local.add(438, new Str(437, "="));
        local.add(439, s);
        OrList local_1 = new OrList(440, "local_1");
        local_1.add(441, comparition, localLocalComparition);
        local_1.add(442, data, localLocalData);
        local.add(443, local_1);
        local.add(444, s);
        local.add(446, new Str(445, ")"));
        local.add(447, skip);

        // operator = "==":equals | "!=":notEquals | "<=":lessOrEqual | "<":lessThan | ">=":greaterOrEqual | ">":greaterThan
        operator.add(449, new Str(448, "==", operatorOperatorEquals));
        operator.add(451, new Str(450, "!=", operatorOperatorNotEquals));
        operator.add(453, new Str(452, "<=", operatorOperatorLessOrEqual));
        operator.add(455, new Str(454, "<", operatorOperatorLessThan));
        operator.add(457, new Str(456, ">=", operatorOperatorGreaterOrEqual));
        operator.add(459, new Str(458, ">", operatorOperatorGreaterThan));

        // comparition = data:leftOperand s operator s data:rightOperand
        comparition.add(460, data, comparitionComparitionLeftOperand);
        comparition.add(461, s);
        comparition.add(462, operator, comparitionComparitionOperator);
        comparition.add(463, s);
        comparition.add(464, data, comparitionComparitionRightOperand);

        // conditionElement = ["!":not] s (comparition | (reference & (!booleanData *)) | booleanData:booleanCondition)
        Optional conditionElement_1 = new Optional(465, "conditionElement_1");
        conditionElement_1.add(467, new Str(466, "!", conditionElementConditionElementNot));
        conditionElement.add(468, conditionElement_1);
        conditionElement.add(469, s);
        OrList conditionElement_2 = new OrList(470, "conditionElement_2");
        conditionElement_2.add(471, comparition, conditionElementConditionElementComparition);
        ElementList conditionElement_2_1 = new ElementList(472, "conditionElement_2_1");
        AndList conditionElement_2_1_1 = new AndList(473, "conditionElement_2_1_1");
        conditionElement_2_1_1.mainAnd(474, reference, conditionElementConditionElementReference);
        ElementList conditionElement_2_1_1_1 = new ElementList(475, "conditionElement_2_1_1_1");
        conditionElement_2_1_1_1.add(476, booleanData, NOT, conditionElementConditionElementBooleanData);
        conditionElement_2_1_1_1.add(478, new Complete(477, "conditionElement_2_1_1_1"));
        conditionElement_2_1_1.and(479, conditionElement_2_1_1_1);
        conditionElement_2_1.add(480, conditionElement_2_1_1);
        conditionElement_2.add(481, conditionElement_2_1);
        conditionElement_2.add(482, booleanData, conditionElementConditionElementBooleanCondition);
        conditionElement.add(483, conditionElement_2);

        // conditionBase = conditionElement | (s "(" s condition s ")")
        conditionBase.add(484, conditionElement, conditionBaseConditionBaseConditionElement);
        ElementList conditionBase_1 = new ElementList(485, "conditionBase_1");
        conditionBase_1.add(486, s);
        conditionBase_1.add(488, new Str(487, "("));
        conditionBase_1.add(489, s);
        conditionBase_1.add(490, condition, conditionBaseConditionBaseCondition);
        conditionBase_1.add(491, s);
        conditionBase_1.add(493, new Str(492, ")"));
        conditionBase.add(494, conditionBase_1);

        // conditionAnd = conditionBase [s "&&" s conditionBase]+
        conditionAnd.add(495, conditionBase, conditionAndConditionAndConditionBase);
        Optional conditionAnd_1 = new Optional(496, "conditionAnd_1");
        Repeat conditionAnd_1_1 = new Repeat(497, "conditionAnd_1_1");
        conditionAnd_1_1.add(498, s);
        conditionAnd_1_1.add(500, new Str(499, "&&"));
        conditionAnd_1_1.add(501, s);
        conditionAnd_1_1.add(502, conditionBase, conditionAndConditionAndConditionBase);
        conditionAnd_1.add(503, conditionAnd_1_1);
        conditionAnd.add(504, conditionAnd_1);

        // condition = conditionAnd [s "||" s conditionAnd]+
        condition.add(505, conditionAnd, conditionConditionConditionAnd);
        Optional condition_1 = new Optional(506, "condition_1");
        Repeat condition_1_1 = new Repeat(507, "condition_1_1");
        condition_1_1.add(508, s);
        condition_1_1.add(510, new Str(509, "||"));
        condition_1_1.add(511, s);
        condition_1_1.add(512, conditionAnd, conditionConditionConditionAnd);
        condition_1.add(513, condition_1_1);
        condition.add(514, condition_1);

        // ifcmd = "#if" s "(" s condition s ")" skip [block] [elseif]+ [else] end
        ifcmd.add(516, new Str(515, "#if"));
        ifcmd.add(517, s);
        ifcmd.add(519, new Str(518, "("));
        ifcmd.add(520, s);
        ifcmd.add(521, condition, ifcmdIfcmdCondition);
        ifcmd.add(522, s);
        ifcmd.add(524, new Str(523, ")"));
        ifcmd.add(525, skip);
        Optional ifcmd_1 = new Optional(526, "ifcmd_1");
        ifcmd_1.add(527, block, ifcmdIfcmdBlock);
        ifcmd.add(528, ifcmd_1);
        Optional ifcmd_2 = new Optional(529, "ifcmd_2");
        Repeat ifcmd_2_1 = new Repeat(530, "ifcmd_2_1");
        ifcmd_2_1.add(531, elseif, ifcmdIfcmdElseif);
        ifcmd_2.add(532, ifcmd_2_1);
        ifcmd.add(533, ifcmd_2);
        Optional ifcmd_3 = new Optional(534, "ifcmd_3");
        ifcmd_3.add(535, _else, ifcmdIfcmdElse);
        ifcmd.add(536, ifcmd_3);
        ifcmd.add(537, end);

        // elseif = [spaces] "#else if" s "(" s condition s ")" skip [block]
        Optional elseif_1 = new Optional(538, "elseif_1");
        elseif_1.add(539, spaces);
        elseif.add(540, elseif_1);
        elseif.add(542, new Str(541, "#else if"));
        elseif.add(543, s);
        elseif.add(545, new Str(544, "("));
        elseif.add(546, s);
        elseif.add(547, condition, elseifElseifCondition);
        elseif.add(548, s);
        elseif.add(550, new Str(549, ")"));
        elseif.add(551, skip);
        Optional elseif_2 = new Optional(552, "elseif_2");
        elseif_2.add(553, block, elseifElseifBlock);
        elseif.add(554, elseif_2);

        // else = [spaces] "#else" skip [block]
        Optional else_1 = new Optional(555, "else_1");
        else_1.add(556, spaces);
        _else.add(557, else_1);
        _else.add(559, new Str(558, "#else"));
        _else.add(560, skip);
        Optional else_2 = new Optional(561, "else_2");
        else_2.add(562, block, elseElseBlock);
        _else.add(563, else_2);

        // whilecmd = "#while" s "(" s condition s ")" skip [block] end
        whilecmd.add(565, new Str(564, "#while"));
        whilecmd.add(566, s);
        whilecmd.add(568, new Str(567, "("));
        whilecmd.add(569, s);
        whilecmd.add(570, condition, whilecmdWhilecmdCondition);
        whilecmd.add(571, s);
        whilecmd.add(573, new Str(572, ")"));
        whilecmd.add(574, skip);
        Optional whilecmd_1 = new Optional(575, "whilecmd_1");
        whilecmd_1.add(576, block, whilecmdWhilecmdBlock);
        whilecmd.add(577, whilecmd_1);
        whilecmd.add(578, end);

        // call = :begin "#" callReference [ws "into" ws ("$" [varname]:targetNamespace)|varname:targetVariable] skip
        call.add(580, new Marker(579, "begin", callCallBegin));
        call.add(582, new Str(581, "#"));
        call.add(583, callReference, callCallCallReference);
        Optional call_1 = new Optional(584, "call_1");
        call_1.add(585, ws);
        call_1.add(587, new Str(586, "into"));
        call_1.add(588, ws);
        OrList call_1_1 = new OrList(589, "call_1_1");
        ElementList call_1_1_1 = new ElementList(590, "call_1_1_1");
        call_1_1_1.add(592, new Str(591, "$"));
        Optional call_1_1_1_1 = new Optional(593, "call_1_1_1_1", callCallTargetNamespace);
        call_1_1_1_1.add(594, varname);
        call_1_1_1.add(595, call_1_1_1_1);
        call_1_1.add(596, call_1_1_1);
        call_1_1.add(597, varname, callCallTargetVariable);
        call_1.add(598, call_1_1);
        call.add(599, call_1);
        call.add(600, skip);

        // foreach =
        //   :begin "#foreach" s "(" varname:variable ws "in" ws listData|mapDataRef|reference s
        //   ["where" s condition s] ")" skip block end
        foreach.add(602, new Marker(601, "begin", foreachForeachBegin));
        foreach.add(604, new Str(603, "#foreach"));
        foreach.add(605, s);
        foreach.add(607, new Str(606, "("));
        foreach.add(608, varname, foreachForeachVariable);
        foreach.add(609, ws);
        foreach.add(611, new Str(610, "in"));
        foreach.add(612, ws);
        OrList foreach_1 = new OrList(613, "foreach_1");
        foreach_1.add(614, listData, foreachForeachListData);
        foreach_1.add(615, mapDataRef, foreachForeachMapDataRef);
        foreach_1.add(616, reference, foreachForeachReference);
        foreach.add(617, foreach_1);
        foreach.add(618, s);
        Optional foreach_2 = new Optional(619, "foreach_2");
        foreach_2.add(621, new Str(620, "where"));
        foreach_2.add(622, s);
        foreach_2.add(623, condition, foreachForeachCondition);
        foreach_2.add(624, s);
        foreach.add(625, foreach_2);
        foreach.add(627, new Str(626, ")"));
        foreach.add(628, skip);
        foreach.add(629, block, foreachForeachBlock);
        foreach.add(630, end);

        // importcmd = :begin "#import" ws stringExp:filename [ws "as text":asText] skip
        importcmd.add(632, new Marker(631, "begin", importcmdImportcmdBegin));
        importcmd.add(634, new Str(633, "#import"));
        importcmd.add(635, ws);
        importcmd.add(636, stringExp, importcmdImportcmdFilename);
        Optional importcmd_1 = new Optional(637, "importcmd_1");
        importcmd_1.add(638, ws);
        importcmd_1.add(640, new Str(639, "as text", importcmdImportcmdAsText));
        importcmd.add(641, importcmd_1);
        importcmd.add(642, skip);

        // macro = :begin "#macro" ws varname:name s "(" s [varname:parameter [s "," s varname:parameter]+] s ")" skip [block] end
        macro.add(644, new Marker(643, "begin", macroMacroBegin));
        macro.add(646, new Str(645, "#macro"));
        macro.add(647, ws);
        macro.add(648, varname, macroMacroName);
        macro.add(649, s);
        macro.add(651, new Str(650, "("));
        macro.add(652, s);
        Optional macro_1 = new Optional(653, "macro_1");
        macro_1.add(654, varname, macroMacroParameter);
        Optional macro_1_1 = new Optional(655, "macro_1_1");
        Repeat macro_1_1_1 = new Repeat(656, "macro_1_1_1");
        macro_1_1_1.add(657, s);
        macro_1_1_1.add(659, new Str(658, ","));
        macro_1_1_1.add(660, s);
        macro_1_1_1.add(661, varname, macroMacroParameter);
        macro_1_1.add(662, macro_1_1_1);
        macro_1.add(663, macro_1_1);
        macro.add(664, macro_1);
        macro.add(665, s);
        macro.add(667, new Str(666, ")"));
        macro.add(668, skip);
        Optional macro_2 = new Optional(669, "macro_2");
        macro_2.add(670, block, macroMacroBlock);
        macro.add(671, macro_2);
        macro.add(672, end);

        // returncmd = [spaces] "#return" s ("(" s data s ")") | comparition|data skip
        Optional returncmd_1 = new Optional(673, "returncmd_1");
        returncmd_1.add(674, spaces);
        returncmd.add(675, returncmd_1);
        returncmd.add(677, new Str(676, "#return"));
        returncmd.add(678, s);
        OrList returncmd_2 = new OrList(679, "returncmd_2");
        ElementList returncmd_2_1 = new ElementList(680, "returncmd_2_1");
        returncmd_2_1.add(682, new Str(681, "("));
        returncmd_2_1.add(683, s);
        returncmd_2_1.add(684, data, returncmdReturncmdData);
        returncmd_2_1.add(685, s);
        returncmd_2_1.add(687, new Str(686, ")"));
        returncmd_2.add(688, returncmd_2_1);
        returncmd_2.add(689, comparition, returncmdReturncmdComparition);
        returncmd_2.add(690, data, returncmdReturncmdData);
        returncmd.add(691, returncmd_2);
        returncmd.add(692, skip);

        // function = :begin "#function" ws varname:name s "(" s [varname:parameter [s "," s varname:parameter]+] s ")" skip [block] end
        function.add(694, new Marker(693, "begin"));
        function.add(696, new Str(695, "#function"));
        function.add(697, ws);
        function.add(698, varname, functionFunctionName);
        function.add(699, s);
        function.add(701, new Str(700, "("));
        function.add(702, s);
        Optional function_1 = new Optional(703, "function_1");
        function_1.add(704, varname, functionFunctionParameter);
        Optional function_1_1 = new Optional(705, "function_1_1");
        Repeat function_1_1_1 = new Repeat(706, "function_1_1_1");
        function_1_1_1.add(707, s);
        function_1_1_1.add(709, new Str(708, ","));
        function_1_1_1.add(710, s);
        function_1_1_1.add(711, varname, functionFunctionParameter);
        function_1_1.add(712, function_1_1_1);
        function_1.add(713, function_1_1);
        function.add(714, function_1);
        function.add(715, s);
        function.add(717, new Str(716, ")"));
        function.add(718, skip);
        Optional function_2 = new Optional(719, "function_2");
        function_2.add(720, block, functionFunctionBlock);
        function.add(721, function_2);
        function.add(722, end);

        // namespace = "#namespace" ws varname:name skip
        namespace.add(724, new Str(723, "#namespace"));
        namespace.add(725, ws);
        namespace.add(726, varname, namespaceNamespaceName);
        namespace.add(727, skip);

        // error = :begin "#error" s "(" s stringExp:message s ")" skip
        error.add(729, new Marker(728, "begin", errorErrorBegin));
        error.add(731, new Str(730, "#error"));
        error.add(732, s);
        error.add(734, new Str(733, "("));
        error.add(735, s);
        error.add(736, stringExp, errorErrorMessage);
        error.add(737, s);
        error.add(739, new Str(738, ")"));
        error.add(740, skip);

        // command = [spaces] local|set|write|ifcmd|whilecmd|foreach|importcmd|error|macro|function|call
        Optional command_1 = new Optional(741, "command_1");
        command_1.add(742, spaces);
        command.add(743, command_1);
        OrList command_2 = new OrList(744, "command_2");
        command_2.add(745, local, commandCommandLocal);
        command_2.add(746, set, commandCommandSet);
        command_2.add(747, write, commandCommandWrite);
        command_2.add(748, ifcmd, commandCommandIfcmd);
        command_2.add(749, whilecmd, commandCommandWhilecmd);
        command_2.add(750, foreach, commandCommandForeach);
        command_2.add(751, importcmd, commandCommandImportcmd);
        command_2.add(752, error, commandCommandError);
        command_2.add(753, macro, commandCommandMacro);
        command_2.add(754, function, commandCommandFunction);
        command_2.add(755, call, commandCommandCall);
        command.add(756, command_2);

        // astext = "#>" [!"<#"+]:text "<#"
        astext.add(758, new Str(757, "#>"));
        Optional astext_1 = new Optional(759, "astext_1", blockAstextText);
        Repeat astext_1_1 = new Repeat(760, "astext_1_1");
        astext_1_1.add(762, new Str(761, "<#", NOT));
        astext_1.add(763, astext_1_1);
        astext.add(764, astext_1);
        astext.add(766, new Str(765, "<#"));

        // text = !(([spaces] "##"|"#*"|"#>"|("#" (letter | "$"))) | stringref)+
        OrList text_1 = new OrList(767, "text_1");
        ElementList text_1_1 = new ElementList(768, "text_1_1");
        Optional text_1_1_1 = new Optional(769, "text_1_1_1");
        text_1_1_1.add(770, spaces);
        text_1_1.add(771, text_1_1_1);
        OrList text_1_1_2 = new OrList(772, "text_1_1_2");
        text_1_1_2.add(774, new Str(773, "##"));
        text_1_1_2.add(776, new Str(775, "#*"));
        text_1_1_2.add(778, new Str(777, "#>"));
        ElementList text_1_1_2_1 = new ElementList(779, "text_1_1_2_1");
        text_1_1_2_1.add(781, new Str(780, "#"));
        OrList text_1_1_2_1_1 = new OrList(782, "text_1_1_2_1_1");
        text_1_1_2_1_1.add(783, letter);
        text_1_1_2_1_1.add(785, new Str(784, "$"));
        text_1_1_2_1.add(786, text_1_1_2_1_1);
        text_1_1_2.add(787, text_1_1_2_1);
        text_1_1.add(788, text_1_1_2);
        text_1.add(789, text_1_1);
        text_1.add(790, stringref, textTextStringref);
        text.add(791, text_1, NOT);

        // block = [astext|returncmd|command|stringref|comment|text]+
        Repeat block_1 = new Repeat(792, "block_1");
        OrList block_1_1 = new OrList(793, "block_1_1");
        block_1_1.add(794, astext);
        block_1_1.add(795, returncmd, blockBlockReturncmd);
        block_1_1.add(796, command, blockBlockCommand);
        block_1_1.add(797, stringref, blockBlockStringref);
        block_1_1.add(798, comment);
        block_1_1.add(799, text, blockBlockText);
        block_1.add(800, block_1_1);
        block.add(801, block_1);

        // template = [namespace|(:defaultNamespace)] block|END
        Optional template_1 = new Optional(802, "template_1");
        OrList template_1_1 = new OrList(803, "template_1_1");
        template_1_1.add(804, namespace, templateTemplateNamespace);
        template_1_1.add(806, new Marker(805, "defaultNamespace", templateTemplateDefaultNamespace));
        template_1.add(807, template_1_1);
        template.add(808, template_1);
        OrList template_2 = new OrList(809, "template_2");
        template_2.add(810, block, templateTemplateBlock);
        template_2.add(812, new End(811, "template_2"));
        template.add(813, template_2);

        return new TopElement(data2, template);
    }

    private net.sf.laja.parser.engine2.element.Element getGrammar1() {
        // *** Output classes ***

        // *** Declarations ***
        OrList newline = new OrList(1, "newline");
        ElementList comment = new ElementList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Str ff = new Str(5, "\"");
        Repeat spaces = new Repeat(6, "spaces");
        Range digit = new Range(7, "digit", "0", "9");
        FollowedBy booleanData = new FollowedBy(8, "booleanData");
        Repeat unsignedInt = new Repeat(9, "unsignedInt");
        ElementList integerData = new ElementList(10, "integerData");
        ElementList floatData = new ElementList(11, "floatData");
        OrList letter = new OrList(12, "letter");
        ElementList varname = new ElementList(13, "varname");
        Optional skip = new Optional(14, "skip");
        FollowedBy nullData = new FollowedBy(15, "nullData");
        ElementList stringExp = new ElementList(16, "stringExp");
        ElementList classOrPackageName = new ElementList(17, "classOrPackageName");
        ElementList newStatement = new ElementList(18, "newStatement");
        OrList data = new OrList(19, "data");
        ElementList listData = new ElementList(20, "listData");
        ElementList mapMember = new ElementList(21, "mapMember");
        ElementList mapDataRef = new ElementList(22, "mapDataRef");
        ElementList mapData = new ElementList(23, "mapData");
        OrList indexItem = new OrList(24, "indexItem");
        Repeat listIndex = new Repeat(25, "listIndex");
        ElementList args = new ElementList(26, "args");
        ElementList namespaceRef = new ElementList(27, "namespaceRef");
        ElementList variableRef = new ElementList(28, "variableRef");
        ElementList methodRef = new ElementList(29, "methodRef");
        ElementList attributeRef = new ElementList(30, "attributeRef");
        ElementList attributeVariableRef = new ElementList(31, "attributeVariableRef");
        ElementList attributeMethodRef = new ElementList(32, "attributeMethodRef");
        ElementList reference = new ElementList(33, "reference");
        ElementList callReference = new ElementList(34, "callReference");
        ElementList stringref = new ElementList(35, "stringref");
        ElementList end = new ElementList(36, "end");
        ElementList write = new ElementList(37, "write");
        ElementList set = new ElementList(38, "set");
        ElementList local = new ElementList(39, "local");
        OrList operator = new OrList(40, "operator");
        ElementList comparition = new ElementList(41, "comparition");
        ElementList conditionElement = new ElementList(42, "conditionElement");
        OrList conditionBase = new OrList(43, "conditionBase");
        ElementList conditionAnd = new ElementList(44, "conditionAnd");
        ElementList condition = new ElementList(45, "condition");
        ElementList ifcmd = new ElementList(46, "ifcmd");
        ElementList elseif = new ElementList(47, "elseif");
        ElementList _else = new ElementList(48, "else");
        ElementList whilecmd = new ElementList(49, "whilecmd");
        ElementList call = new ElementList(50, "call");
        ElementList foreach = new ElementList(51, "foreach");
        ElementList importcmd = new ElementList(52, "importcmd");
        ElementList macro = new ElementList(53, "macro");
        ElementList returncmd = new ElementList(54, "returncmd");
        ElementList function = new ElementList(55, "function");
        ElementList namespace = new ElementList(56, "namespace");
        ElementList error = new ElementList(57, "error");
        ElementList command = new ElementList(58, "command");
        ElementList astext = new ElementList(59, "astext");
        Repeat text = new Repeat(60, "text");
        Optional block = new Optional(61, "block");
        ElementList template = new ElementList(62, "template");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(64, new Str(63, "\r\n"));
        newline.add(66, new Str(65, "\n"));

        // comment = [spaces] ("#*" [(comment | !"*#")+] "*#") | ("##" [!newline+] newline|END) skip
        Optional comment_1 = new Optional(67, "comment_1");
        comment_1.add(68, spaces);
        comment.add(69, comment_1);
        OrList comment_2 = new OrList(70, "comment_2");
        ElementList comment_2_1 = new ElementList(71, "comment_2_1");
        comment_2_1.add(73, new Str(72, "#*"));
        Optional comment_2_1_1 = new Optional(74, "comment_2_1_1");
        Repeat comment_2_1_1_1 = new Repeat(75, "comment_2_1_1_1");
        OrList comment_2_1_1_1_1 = new OrList(76, "comment_2_1_1_1_1");
        comment_2_1_1_1_1.add(77, comment);
        comment_2_1_1_1_1.add(79, new Str(78, "*#", NOT));
        comment_2_1_1_1.add(80, comment_2_1_1_1_1);
        comment_2_1_1.add(81, comment_2_1_1_1);
        comment_2_1.add(82, comment_2_1_1);
        comment_2_1.add(84, new Str(83, "*#"));
        comment_2.add(85, comment_2_1);
        ElementList comment_2_2 = new ElementList(86, "comment_2_2");
        comment_2_2.add(88, new Str(87, "##"));
        Optional comment_2_2_1 = new Optional(89, "comment_2_2_1");
        Repeat comment_2_2_1_1 = new Repeat(90, "comment_2_2_1_1");
        comment_2_2_1_1.add(91, newline, NOT);
        comment_2_2_1.add(92, comment_2_2_1_1);
        comment_2_2.add(93, comment_2_2_1);
        OrList comment_2_2_2 = new OrList(94, "comment_2_2_2");
        comment_2_2_2.add(95, newline);
        comment_2_2_2.add(97, new End(96, "comment_2_2_2"));
        comment_2_2.add(98, comment_2_2_2);
        comment_2.add(99, comment_2_2);
        comment.add(100, comment_2);
        comment.add(101, skip);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(102, "ws_1");
        ws_1.add(103, newline);
        ws_1.add(105, new Str(104, " "));
        ws_1.add(107, new Str(106, "\t"));
        ws_1.add(108, comment);
        ws.add(109, ws_1);

        // s = [ws]
        s.add(110, ws);

        // ff = "\""

        // spaces = (" " | "\t")+
        OrList spaces_1 = new OrList(111, "spaces_1");
        spaces_1.add(113, new Str(112, " "));
        spaces_1.add(115, new Str(114, "\t"));
        spaces.add(116, spaces_1);

        // digit = "0".."9"

        // booleanData = "true":true | "false":false \ !(letter|digit)
        OrList booleanData_1 = new OrList(117, "booleanData_1");
        booleanData_1.add(119, new Str(118, "true"));
        booleanData_1.add(121, new Str(120, "false"));
        booleanData.setElement(122, booleanData_1);
        OrList booleanData_2 = new OrList(123, "booleanData_2", NOT);
        booleanData_2.add(124, letter);
        booleanData_2.add(125, digit);
        booleanData.followedby(126, booleanData_2);

        // unsignedInt = digit+
        unsignedInt.add(127, digit);

        // integerData = ["-"] unsignedInt
        Optional integerData_1 = new Optional(128, "integerData_1");
        integerData_1.add(130, new Str(129, "-"));
        integerData.add(131, integerData_1);
        integerData.add(132, unsignedInt);

        // floatData = ["-"] unsignedInt "." unsignedInt
        Optional floatData_1 = new Optional(133, "floatData_1");
        floatData_1.add(135, new Str(134, "-"));
        floatData.add(136, floatData_1);
        floatData.add(137, unsignedInt);
        floatData.add(139, new Str(138, "."));
        floatData.add(140, unsignedInt);

        // letter = "a".."z" | "A".."Z" | "_"
        letter.add(142, new Range(141, "letter", "a", "z"));
        letter.add(144, new Range(143, "letter", "A", "Z"));
        letter.add(146, new Str(145, "_"));

        // varname = letter [letter|digit]+
        varname.add(147, letter);
        Optional varname_1 = new Optional(148, "varname_1");
        Repeat varname_1_1 = new Repeat(149, "varname_1_1");
        OrList varname_1_1_1 = new OrList(150, "varname_1_1_1");
        varname_1_1_1.add(151, letter);
        varname_1_1_1.add(152, digit);
        varname_1_1.add(153, varname_1_1_1);
        varname_1.add(154, varname_1_1);
        varname.add(155, varname_1);

        // skip = [[spaces] newline]
        Optional skip_1 = new Optional(156, "skip_1");
        skip_1.add(157, spaces);
        skip.add(158, skip_1);
        skip.add(159, newline);

        // nullData = "null" \ !(letter|digit)
        nullData.setElement(161, new Str(160, "null"));
        OrList nullData_1 = new OrList(162, "nullData_1", NOT);
        nullData_1.add(163, letter);
        nullData_1.add(164, digit);
        nullData.followedby(165, nullData_1);

        // stringExp = ff [stringref | (("\\\"" | !(ff|stringref))+):text]+ ff
        stringExp.add(166, ff);
        Optional stringExp_1 = new Optional(167, "stringExp_1");
        Repeat stringExp_1_1 = new Repeat(168, "stringExp_1_1");
        OrList stringExp_1_1_1 = new OrList(169, "stringExp_1_1_1");
        stringExp_1_1_1.add(170, stringref);
        Repeat stringExp_1_1_1_1 = new Repeat(171, "stringExp_1_1_1_1");
        OrList stringExp_1_1_1_1_1 = new OrList(172, "stringExp_1_1_1_1_1");
        stringExp_1_1_1_1_1.add(174, new Str(173, "\\\""));
        OrList stringExp_1_1_1_1_1_1 = new OrList(175, "stringExp_1_1_1_1_1_1", NOT);
        stringExp_1_1_1_1_1_1.add(176, ff);
        stringExp_1_1_1_1_1_1.add(177, stringref);
        stringExp_1_1_1_1_1.add(178, stringExp_1_1_1_1_1_1);
        stringExp_1_1_1_1.add(179, stringExp_1_1_1_1_1);
        stringExp_1_1_1.add(180, stringExp_1_1_1_1);
        stringExp_1_1.add(181, stringExp_1_1_1);
        stringExp_1.add(182, stringExp_1_1);
        stringExp.add(183, stringExp_1);
        stringExp.add(184, ff);

        // classOrPackageName = letter|"$" [letter|digit|"$"]+
        OrList classOrPackageName_1 = new OrList(185, "classOrPackageName_1");
        classOrPackageName_1.add(186, letter);
        classOrPackageName_1.add(188, new Str(187, "$"));
        classOrPackageName.add(189, classOrPackageName_1);
        Optional classOrPackageName_2 = new Optional(190, "classOrPackageName_2");
        Repeat classOrPackageName_2_1 = new Repeat(191, "classOrPackageName_2_1");
        OrList classOrPackageName_2_1_1 = new OrList(192, "classOrPackageName_2_1_1");
        classOrPackageName_2_1_1.add(193, letter);
        classOrPackageName_2_1_1.add(194, digit);
        classOrPackageName_2_1_1.add(196, new Str(195, "$"));
        classOrPackageName_2_1.add(197, classOrPackageName_2_1_1);
        classOrPackageName_2.add(198, classOrPackageName_2_1);
        classOrPackageName.add(199, classOrPackageName_2);

        // newStatement = "new" ws classOrPackageName ["." classOrPackageName]+ s args
        newStatement.add(201, new Str(200, "new"));
        newStatement.add(202, ws);
        newStatement.add(203, classOrPackageName);
        Optional newStatement_1 = new Optional(204, "newStatement_1");
        Repeat newStatement_1_1 = new Repeat(205, "newStatement_1_1");
        newStatement_1_1.add(207, new Str(206, "."));
        newStatement_1_1.add(208, classOrPackageName);
        newStatement_1.add(209, newStatement_1_1);
        newStatement.add(210, newStatement_1);
        newStatement.add(211, s);
        newStatement.add(212, args);

        // data = newStatement | stringExp | listData | mapDataRef | nullData | booleanData | reference | floatData | integerData
        data.add(213, newStatement);
        data.add(214, stringExp);
        data.add(215, listData);
        data.add(216, mapDataRef);
        data.add(217, nullData);
        data.add(218, booleanData);
        data.add(219, reference);
        data.add(220, floatData);
        data.add(221, integerData);

        // listData = "[" s [data [s "," s data]+ s] "]" [s "as array":array]
        listData.add(223, new Str(222, "["));
        listData.add(224, s);
        Optional listData_1 = new Optional(225, "listData_1");
        listData_1.add(226, data);
        Optional listData_1_1 = new Optional(227, "listData_1_1");
        Repeat listData_1_1_1 = new Repeat(228, "listData_1_1_1");
        listData_1_1_1.add(229, s);
        listData_1_1_1.add(231, new Str(230, ","));
        listData_1_1_1.add(232, s);
        listData_1_1_1.add(233, data);
        listData_1_1.add(234, listData_1_1_1);
        listData_1.add(235, listData_1_1);
        listData_1.add(236, s);
        listData.add(237, listData_1);
        listData.add(239, new Str(238, "]"));
        Optional listData_2 = new Optional(240, "listData_2");
        listData_2.add(241, s);
        listData_2.add(243, new Str(242, "as array"));
        listData.add(244, listData_2);

        // mapMember = varname:name s ":" s data
        mapMember.add(245, varname);
        mapMember.add(246, s);
        mapMember.add(248, new Str(247, ":"));
        mapMember.add(249, s);
        mapMember.add(250, data);

        // mapDataRef = "{" [mapData] "}"
        mapDataRef.add(252, new Str(251, "{"));
        Optional mapDataRef_1 = new Optional(253, "mapDataRef_1");
        mapDataRef_1.add(254, mapData);
        mapDataRef.add(255, mapDataRef_1);
        mapDataRef.add(257, new Str(256, "}"));

        // mapData = (s mapMember)+ s
        Repeat mapData_1 = new Repeat(258, "mapData_1");
        mapData_1.add(259, s);
        mapData_1.add(260, mapMember);
        mapData.add(261, mapData_1);
        mapData.add(262, s);

        // indexItem = unsignedInt | reference
        indexItem.add(263, unsignedInt);
        indexItem.add(264, reference);

        // listIndex = ("[" indexItem "]")+
        listIndex.add(266, new Str(265, "["));
        listIndex.add(267, indexItem);
        listIndex.add(269, new Str(268, "]"));

        // args = "(" s mapData|([data [s "," s data]+]) s ")"
        args.add(271, new Str(270, "("));
        args.add(272, s);
        OrList args_1 = new OrList(273, "args_1");
        args_1.add(274, mapData);
        Optional args_1_1 = new Optional(275, "args_1_1");
        args_1_1.add(276, data);
        Optional args_1_1_1 = new Optional(277, "args_1_1_1");
        Repeat args_1_1_1_1 = new Repeat(278, "args_1_1_1_1");
        args_1_1_1_1.add(279, s);
        args_1_1_1_1.add(281, new Str(280, ","));
        args_1_1_1_1.add(282, s);
        args_1_1_1_1.add(283, data);
        args_1_1_1.add(284, args_1_1_1_1);
        args_1_1.add(285, args_1_1_1);
        args_1.add(286, args_1_1);
        args.add(287, args_1);
        args.add(288, s);
        args.add(290, new Str(289, ")"));

        // namespaceRef = "$" [varname]:namespace
        namespaceRef.add(292, new Str(291, "$"));
        Optional namespaceRef_1 = new Optional(293, "namespaceRef_1");
        namespaceRef_1.add(294, varname);
        namespaceRef.add(295, namespaceRef_1);

        // variableRef = varname:variableName
        variableRef.add(296, varname);

        // methodRef = varname:methodName s args
        methodRef.add(297, varname);
        methodRef.add(298, s);
        methodRef.add(299, args);

        // attributeRef = methodRef|variableRef [listIndex]
        OrList attributeRef_1 = new OrList(300, "attributeRef_1");
        attributeRef_1.add(301, methodRef);
        attributeRef_1.add(302, variableRef);
        attributeRef.add(303, attributeRef_1);
        Optional attributeRef_2 = new Optional(304, "attributeRef_2");
        attributeRef_2.add(305, listIndex);
        attributeRef.add(306, attributeRef_2);

        // attributeVariableRef = variableRef [listIndex]
        attributeVariableRef.add(307, variableRef);
        Optional attributeVariableRef_1 = new Optional(308, "attributeVariableRef_1");
        attributeVariableRef_1.add(309, listIndex);
        attributeVariableRef.add(310, attributeVariableRef_1);

        // attributeMethodRef = methodRef [listIndex]
        attributeMethodRef.add(311, methodRef);
        Optional attributeMethodRef_1 = new Optional(312, "attributeMethodRef_1");
        attributeMethodRef_1.add(313, listIndex);
        attributeMethodRef.add(314, attributeMethodRef_1);

        // reference =
        //   :begin (([namespaceRef "."] attributeRef)|namespaceRef ["." attributeRef:nextAttributeRef]+) |
        //   (floatData|integerData|stringExp ("." attributeRef:nextAttributeRef)+)
        reference.add(316, new Marker(315, "begin"));
        OrList reference_1 = new OrList(317, "reference_1");
        ElementList reference_1_1 = new ElementList(318, "reference_1_1");
        OrList reference_1_1_1 = new OrList(319, "reference_1_1_1");
        ElementList reference_1_1_1_1 = new ElementList(320, "reference_1_1_1_1");
        Optional reference_1_1_1_1_1 = new Optional(321, "reference_1_1_1_1_1");
        reference_1_1_1_1_1.add(322, namespaceRef);
        reference_1_1_1_1_1.add(324, new Str(323, "."));
        reference_1_1_1_1.add(325, reference_1_1_1_1_1);
        reference_1_1_1_1.add(326, attributeRef);
        reference_1_1_1.add(327, reference_1_1_1_1);
        reference_1_1_1.add(328, namespaceRef);
        reference_1_1.add(329, reference_1_1_1);
        Optional reference_1_1_2 = new Optional(330, "reference_1_1_2");
        Repeat reference_1_1_2_1 = new Repeat(331, "reference_1_1_2_1");
        reference_1_1_2_1.add(333, new Str(332, "."));
        reference_1_1_2_1.add(334, attributeRef);
        reference_1_1_2.add(335, reference_1_1_2_1);
        reference_1_1.add(336, reference_1_1_2);
        reference_1.add(337, reference_1_1);
        ElementList reference_1_2 = new ElementList(338, "reference_1_2");
        OrList reference_1_2_1 = new OrList(339, "reference_1_2_1");
        reference_1_2_1.add(340, floatData);
        reference_1_2_1.add(341, integerData);
        reference_1_2_1.add(342, stringExp);
        reference_1_2.add(343, reference_1_2_1);
        Repeat reference_1_2_2 = new Repeat(344, "reference_1_2_2");
        reference_1_2_2.add(346, new Str(345, "."));
        reference_1_2_2.add(347, attributeRef);
        reference_1_2.add(348, reference_1_2_2);
        reference_1.add(349, reference_1_2);
        reference.add(350, reference_1);

        // callReference =
        //   :begin (([namespaceRef "."](attributeMethodRef)|(attributeVariableRef ("." attributeRef:nextAttributeRef)+))
        //   ["." attributeRef:nextAttributeRef]+)
        callReference.add(352, new Marker(351, "begin"));
        ElementList callReference_1 = new ElementList(353, "callReference_1");
        ElementList callReference_1_1 = new ElementList(354, "callReference_1_1");
        Optional callReference_1_1_1 = new Optional(355, "callReference_1_1_1");
        callReference_1_1_1.add(356, namespaceRef);
        callReference_1_1_1.add(358, new Str(357, "."));
        callReference_1_1.add(359, callReference_1_1_1);
        OrList callReference_1_1_2 = new OrList(360, "callReference_1_1_2");
        callReference_1_1_2.add(361, attributeMethodRef);
        ElementList callReference_1_1_2_1 = new ElementList(362, "callReference_1_1_2_1");
        callReference_1_1_2_1.add(363, attributeVariableRef);
        Repeat callReference_1_1_2_1_1 = new Repeat(364, "callReference_1_1_2_1_1");
        callReference_1_1_2_1_1.add(366, new Str(365, "."));
        callReference_1_1_2_1_1.add(367, attributeRef);
        callReference_1_1_2_1.add(368, callReference_1_1_2_1_1);
        callReference_1_1_2.add(369, callReference_1_1_2_1);
        callReference_1_1.add(370, callReference_1_1_2);
        callReference_1.add(371, callReference_1_1);
        Optional callReference_1_2 = new Optional(372, "callReference_1_2");
        Repeat callReference_1_2_1 = new Repeat(373, "callReference_1_2_1");
        callReference_1_2_1.add(375, new Str(374, "."));
        callReference_1_2_1.add(376, attributeRef);
        callReference_1_2.add(377, callReference_1_2_1);
        callReference_1.add(378, callReference_1_2);
        callReference.add(379, callReference_1);

        // stringref = :begin "{" "..":parentDir | ".":currentDir | reference "}"
        stringref.add(381, new Marker(380, "begin"));
        stringref.add(383, new Str(382, "{"));
        OrList stringref_1 = new OrList(384, "stringref_1");
        stringref_1.add(386, new Str(385, ".."));
        stringref_1.add(388, new Str(387, "."));
        stringref_1.add(389, reference);
        stringref.add(390, stringref_1);
        stringref.add(392, new Str(391, "}"));

        // end = [spaces] "#end" skip
        Optional end_1 = new Optional(393, "end_1");
        end_1.add(394, spaces);
        end.add(395, end_1);
        end.add(397, new Str(396, "#end"));
        end.add(398, skip);

        // write = :begin "#write" ws stringExp:filename skip block end
        write.add(400, new Marker(399, "begin"));
        write.add(402, new Str(401, "#write"));
        write.add(403, ws);
        write.add(404, stringExp);
        write.add(405, skip);
        write.add(406, block);
        write.add(407, end);

        // set = :begin "#set" s "(" s reference:target s "=" s comparition|data s ")" skip
        set.add(409, new Marker(408, "begin"));
        set.add(411, new Str(410, "#set"));
        set.add(412, s);
        set.add(414, new Str(413, "("));
        set.add(415, s);
        set.add(416, reference);
        set.add(417, s);
        set.add(419, new Str(418, "="));
        set.add(420, s);
        OrList set_1 = new OrList(421, "set_1");
        set_1.add(422, comparition);
        set_1.add(423, data);
        set.add(424, set_1);
        set.add(425, s);
        set.add(427, new Str(426, ")"));
        set.add(428, skip);

        // local = "#local" s "(" s reference:target s "=" s comparition|data s ")" skip
        local.add(430, new Str(429, "#local"));
        local.add(431, s);
        local.add(433, new Str(432, "("));
        local.add(434, s);
        local.add(435, reference);
        local.add(436, s);
        local.add(438, new Str(437, "="));
        local.add(439, s);
        OrList local_1 = new OrList(440, "local_1");
        local_1.add(441, comparition);
        local_1.add(442, data);
        local.add(443, local_1);
        local.add(444, s);
        local.add(446, new Str(445, ")"));
        local.add(447, skip);

        // operator = "==":equals | "!=":notEquals | "<=":lessOrEqual | "<":lessThan | ">=":greaterOrEqual | ">":greaterThan
        operator.add(449, new Str(448, "=="));
        operator.add(451, new Str(450, "!="));
        operator.add(453, new Str(452, "<="));
        operator.add(455, new Str(454, "<"));
        operator.add(457, new Str(456, ">="));
        operator.add(459, new Str(458, ">"));

        // comparition = data:leftOperand s operator s data:rightOperand
        comparition.add(460, data);
        comparition.add(461, s);
        comparition.add(462, operator);
        comparition.add(463, s);
        comparition.add(464, data);

        // conditionElement = ["!":not] s (comparition | (reference & (!booleanData *)) | booleanData:booleanCondition)
        Optional conditionElement_1 = new Optional(465, "conditionElement_1");
        conditionElement_1.add(467, new Str(466, "!"));
        conditionElement.add(468, conditionElement_1);
        conditionElement.add(469, s);
        OrList conditionElement_2 = new OrList(470, "conditionElement_2");
        conditionElement_2.add(471, comparition);
        ElementList conditionElement_2_1 = new ElementList(472, "conditionElement_2_1");
        AndList conditionElement_2_1_1 = new AndList(473, "conditionElement_2_1_1");
        conditionElement_2_1_1.mainAnd(474, reference);
        ElementList conditionElement_2_1_1_1 = new ElementList(475, "conditionElement_2_1_1_1");
        conditionElement_2_1_1_1.add(476, booleanData, NOT);
        conditionElement_2_1_1_1.add(478, new Complete(477, "conditionElement_2_1_1_1"));
        conditionElement_2_1_1.and(479, conditionElement_2_1_1_1);
        conditionElement_2_1.add(480, conditionElement_2_1_1);
        conditionElement_2.add(481, conditionElement_2_1);
        conditionElement_2.add(482, booleanData);
        conditionElement.add(483, conditionElement_2);

        // conditionBase = conditionElement | (s "(" s condition s ")")
        conditionBase.add(484, conditionElement);
        ElementList conditionBase_1 = new ElementList(485, "conditionBase_1");
        conditionBase_1.add(486, s);
        conditionBase_1.add(488, new Str(487, "("));
        conditionBase_1.add(489, s);
        conditionBase_1.add(490, condition);
        conditionBase_1.add(491, s);
        conditionBase_1.add(493, new Str(492, ")"));
        conditionBase.add(494, conditionBase_1);

        // conditionAnd = conditionBase [s "&&" s conditionBase]+
        conditionAnd.add(495, conditionBase);
        Optional conditionAnd_1 = new Optional(496, "conditionAnd_1");
        Repeat conditionAnd_1_1 = new Repeat(497, "conditionAnd_1_1");
        conditionAnd_1_1.add(498, s);
        conditionAnd_1_1.add(500, new Str(499, "&&"));
        conditionAnd_1_1.add(501, s);
        conditionAnd_1_1.add(502, conditionBase);
        conditionAnd_1.add(503, conditionAnd_1_1);
        conditionAnd.add(504, conditionAnd_1);

        // condition = conditionAnd [s "||" s conditionAnd]+
        condition.add(505, conditionAnd);
        Optional condition_1 = new Optional(506, "condition_1");
        Repeat condition_1_1 = new Repeat(507, "condition_1_1");
        condition_1_1.add(508, s);
        condition_1_1.add(510, new Str(509, "||"));
        condition_1_1.add(511, s);
        condition_1_1.add(512, conditionAnd);
        condition_1.add(513, condition_1_1);
        condition.add(514, condition_1);

        // ifcmd = "#if" s "(" s condition s ")" skip [block] [elseif]+ [else] end
        ifcmd.add(516, new Str(515, "#if"));
        ifcmd.add(517, s);
        ifcmd.add(519, new Str(518, "("));
        ifcmd.add(520, s);
        ifcmd.add(521, condition);
        ifcmd.add(522, s);
        ifcmd.add(524, new Str(523, ")"));
        ifcmd.add(525, skip);
        Optional ifcmd_1 = new Optional(526, "ifcmd_1");
        ifcmd_1.add(527, block);
        ifcmd.add(528, ifcmd_1);
        Optional ifcmd_2 = new Optional(529, "ifcmd_2");
        Repeat ifcmd_2_1 = new Repeat(530, "ifcmd_2_1");
        ifcmd_2_1.add(531, elseif);
        ifcmd_2.add(532, ifcmd_2_1);
        ifcmd.add(533, ifcmd_2);
        Optional ifcmd_3 = new Optional(534, "ifcmd_3");
        ifcmd_3.add(535, _else);
        ifcmd.add(536, ifcmd_3);
        ifcmd.add(537, end);

        // elseif = [spaces] "#else if" s "(" s condition s ")" skip [block]
        Optional elseif_1 = new Optional(538, "elseif_1");
        elseif_1.add(539, spaces);
        elseif.add(540, elseif_1);
        elseif.add(542, new Str(541, "#else if"));
        elseif.add(543, s);
        elseif.add(545, new Str(544, "("));
        elseif.add(546, s);
        elseif.add(547, condition);
        elseif.add(548, s);
        elseif.add(550, new Str(549, ")"));
        elseif.add(551, skip);
        Optional elseif_2 = new Optional(552, "elseif_2");
        elseif_2.add(553, block);
        elseif.add(554, elseif_2);

        // else = [spaces] "#else" skip [block]
        Optional else_1 = new Optional(555, "else_1");
        else_1.add(556, spaces);
        _else.add(557, else_1);
        _else.add(559, new Str(558, "#else"));
        _else.add(560, skip);
        Optional else_2 = new Optional(561, "else_2");
        else_2.add(562, block);
        _else.add(563, else_2);

        // whilecmd = "#while" s "(" s condition s ")" skip [block] end
        whilecmd.add(565, new Str(564, "#while"));
        whilecmd.add(566, s);
        whilecmd.add(568, new Str(567, "("));
        whilecmd.add(569, s);
        whilecmd.add(570, condition);
        whilecmd.add(571, s);
        whilecmd.add(573, new Str(572, ")"));
        whilecmd.add(574, skip);
        Optional whilecmd_1 = new Optional(575, "whilecmd_1");
        whilecmd_1.add(576, block);
        whilecmd.add(577, whilecmd_1);
        whilecmd.add(578, end);

        // call = :begin "#" callReference [ws "into" ws ("$" [varname]:targetNamespace)|varname:targetVariable] skip
        call.add(580, new Marker(579, "begin"));
        call.add(582, new Str(581, "#"));
        call.add(583, callReference);
        Optional call_1 = new Optional(584, "call_1");
        call_1.add(585, ws);
        call_1.add(587, new Str(586, "into"));
        call_1.add(588, ws);
        OrList call_1_1 = new OrList(589, "call_1_1");
        ElementList call_1_1_1 = new ElementList(590, "call_1_1_1");
        call_1_1_1.add(592, new Str(591, "$"));
        Optional call_1_1_1_1 = new Optional(593, "call_1_1_1_1");
        call_1_1_1_1.add(594, varname);
        call_1_1_1.add(595, call_1_1_1_1);
        call_1_1.add(596, call_1_1_1);
        call_1_1.add(597, varname);
        call_1.add(598, call_1_1);
        call.add(599, call_1);
        call.add(600, skip);

        // foreach =
        //   :begin "#foreach" s "(" varname:variable ws "in" ws listData|mapDataRef|reference s
        //   ["where" s condition s] ")" skip block end
        foreach.add(602, new Marker(601, "begin"));
        foreach.add(604, new Str(603, "#foreach"));
        foreach.add(605, s);
        foreach.add(607, new Str(606, "("));
        foreach.add(608, varname);
        foreach.add(609, ws);
        foreach.add(611, new Str(610, "in"));
        foreach.add(612, ws);
        OrList foreach_1 = new OrList(613, "foreach_1");
        foreach_1.add(614, listData);
        foreach_1.add(615, mapDataRef);
        foreach_1.add(616, reference);
        foreach.add(617, foreach_1);
        foreach.add(618, s);
        Optional foreach_2 = new Optional(619, "foreach_2");
        foreach_2.add(621, new Str(620, "where"));
        foreach_2.add(622, s);
        foreach_2.add(623, condition);
        foreach_2.add(624, s);
        foreach.add(625, foreach_2);
        foreach.add(627, new Str(626, ")"));
        foreach.add(628, skip);
        foreach.add(629, block);
        foreach.add(630, end);

        // importcmd = :begin "#import" ws stringExp:filename [ws "as text":asText] skip
        importcmd.add(632, new Marker(631, "begin"));
        importcmd.add(634, new Str(633, "#import"));
        importcmd.add(635, ws);
        importcmd.add(636, stringExp);
        Optional importcmd_1 = new Optional(637, "importcmd_1");
        importcmd_1.add(638, ws);
        importcmd_1.add(640, new Str(639, "as text"));
        importcmd.add(641, importcmd_1);
        importcmd.add(642, skip);

        // macro = :begin "#macro" ws varname:name s "(" s [varname:parameter [s "," s varname:parameter]+] s ")" skip [block] end
        macro.add(644, new Marker(643, "begin"));
        macro.add(646, new Str(645, "#macro"));
        macro.add(647, ws);
        macro.add(648, varname);
        macro.add(649, s);
        macro.add(651, new Str(650, "("));
        macro.add(652, s);
        Optional macro_1 = new Optional(653, "macro_1");
        macro_1.add(654, varname);
        Optional macro_1_1 = new Optional(655, "macro_1_1");
        Repeat macro_1_1_1 = new Repeat(656, "macro_1_1_1");
        macro_1_1_1.add(657, s);
        macro_1_1_1.add(659, new Str(658, ","));
        macro_1_1_1.add(660, s);
        macro_1_1_1.add(661, varname);
        macro_1_1.add(662, macro_1_1_1);
        macro_1.add(663, macro_1_1);
        macro.add(664, macro_1);
        macro.add(665, s);
        macro.add(667, new Str(666, ")"));
        macro.add(668, skip);
        Optional macro_2 = new Optional(669, "macro_2");
        macro_2.add(670, block);
        macro.add(671, macro_2);
        macro.add(672, end);

        // returncmd = [spaces] "#return" s ("(" s data s ")") | comparition|data skip
        Optional returncmd_1 = new Optional(673, "returncmd_1");
        returncmd_1.add(674, spaces);
        returncmd.add(675, returncmd_1);
        returncmd.add(677, new Str(676, "#return"));
        returncmd.add(678, s);
        OrList returncmd_2 = new OrList(679, "returncmd_2");
        ElementList returncmd_2_1 = new ElementList(680, "returncmd_2_1");
        returncmd_2_1.add(682, new Str(681, "("));
        returncmd_2_1.add(683, s);
        returncmd_2_1.add(684, data);
        returncmd_2_1.add(685, s);
        returncmd_2_1.add(687, new Str(686, ")"));
        returncmd_2.add(688, returncmd_2_1);
        returncmd_2.add(689, comparition);
        returncmd_2.add(690, data);
        returncmd.add(691, returncmd_2);
        returncmd.add(692, skip);

        // function = :begin "#function" ws varname:name s "(" s [varname:parameter [s "," s varname:parameter]+] s ")" skip [block] end
        function.add(694, new Marker(693, "begin"));
        function.add(696, new Str(695, "#function"));
        function.add(697, ws);
        function.add(698, varname);
        function.add(699, s);
        function.add(701, new Str(700, "("));
        function.add(702, s);
        Optional function_1 = new Optional(703, "function_1");
        function_1.add(704, varname);
        Optional function_1_1 = new Optional(705, "function_1_1");
        Repeat function_1_1_1 = new Repeat(706, "function_1_1_1");
        function_1_1_1.add(707, s);
        function_1_1_1.add(709, new Str(708, ","));
        function_1_1_1.add(710, s);
        function_1_1_1.add(711, varname);
        function_1_1.add(712, function_1_1_1);
        function_1.add(713, function_1_1);
        function.add(714, function_1);
        function.add(715, s);
        function.add(717, new Str(716, ")"));
        function.add(718, skip);
        Optional function_2 = new Optional(719, "function_2");
        function_2.add(720, block);
        function.add(721, function_2);
        function.add(722, end);

        // namespace = "#namespace" ws varname:name skip
        namespace.add(724, new Str(723, "#namespace"));
        namespace.add(725, ws);
        namespace.add(726, varname);
        namespace.add(727, skip);

        // error = :begin "#error" s "(" s stringExp:message s ")" skip
        error.add(729, new Marker(728, "begin"));
        error.add(731, new Str(730, "#error"));
        error.add(732, s);
        error.add(734, new Str(733, "("));
        error.add(735, s);
        error.add(736, stringExp);
        error.add(737, s);
        error.add(739, new Str(738, ")"));
        error.add(740, skip);

        // command = [spaces] local|set|write|ifcmd|whilecmd|foreach|importcmd|error|macro|function|call
        Optional command_1 = new Optional(741, "command_1");
        command_1.add(742, spaces);
        command.add(743, command_1);
        OrList command_2 = new OrList(744, "command_2");
        command_2.add(745, local);
        command_2.add(746, set);
        command_2.add(747, write);
        command_2.add(748, ifcmd);
        command_2.add(749, whilecmd);
        command_2.add(750, foreach);
        command_2.add(751, importcmd);
        command_2.add(752, error);
        command_2.add(753, macro);
        command_2.add(754, function);
        command_2.add(755, call);
        command.add(756, command_2);

        // astext = "#>" [!"<#"+]:text "<#"
        astext.add(758, new Str(757, "#>"));
        Optional astext_1 = new Optional(759, "astext_1");
        Repeat astext_1_1 = new Repeat(760, "astext_1_1");
        astext_1_1.add(762, new Str(761, "<#", NOT));
        astext_1.add(763, astext_1_1);
        astext.add(764, astext_1);
        astext.add(766, new Str(765, "<#"));

        // text = !(([spaces] "##"|"#*"|"#>"|("#" (letter | "$"))) | stringref)+
        OrList text_1 = new OrList(767, "text_1");
        ElementList text_1_1 = new ElementList(768, "text_1_1");
        Optional text_1_1_1 = new Optional(769, "text_1_1_1");
        text_1_1_1.add(770, spaces);
        text_1_1.add(771, text_1_1_1);
        OrList text_1_1_2 = new OrList(772, "text_1_1_2");
        text_1_1_2.add(774, new Str(773, "##"));
        text_1_1_2.add(776, new Str(775, "#*"));
        text_1_1_2.add(778, new Str(777, "#>"));
        ElementList text_1_1_2_1 = new ElementList(779, "text_1_1_2_1");
        text_1_1_2_1.add(781, new Str(780, "#"));
        OrList text_1_1_2_1_1 = new OrList(782, "text_1_1_2_1_1");
        text_1_1_2_1_1.add(783, letter);
        text_1_1_2_1_1.add(785, new Str(784, "$"));
        text_1_1_2_1.add(786, text_1_1_2_1_1);
        text_1_1_2.add(787, text_1_1_2_1);
        text_1_1.add(788, text_1_1_2);
        text_1.add(789, text_1_1);
        text_1.add(790, stringref);
        text.add(791, text_1, NOT);

        // block = [astext|returncmd|command|stringref|comment|text]+
        Repeat block_1 = new Repeat(792, "block_1");
        OrList block_1_1 = new OrList(793, "block_1_1");
        block_1_1.add(794, astext);
        block_1_1.add(795, returncmd);
        block_1_1.add(796, command);
        block_1_1.add(797, stringref);
        block_1_1.add(798, comment);
        block_1_1.add(799, text);
        block_1.add(800, block_1_1);
        block.add(801, block_1);

        // template = [namespace|(:defaultNamespace)] block|END
        Optional template_1 = new Optional(802, "template_1");
        OrList template_1_1 = new OrList(803, "template_1_1");
        template_1_1.add(804, namespace);
        template_1_1.add(806, new Marker(805, "defaultNamespace"));
        template_1.add(807, template_1_1);
        template.add(808, template_1);
        OrList template_2 = new OrList(809, "template_2");
        template_2.add(810, block);
        template_2.add(812, new End(811, "template_2"));
        template.add(813, template_2);

        return new TopElement(data1, template);
    }

    // *** TopElement ***
    public static class TopElement implements net.sf.laja.parser.engine2.element.Element {
        private Data data;
        private net.sf.laja.parser.engine2.element.Element element;

        public TopElement(Data data, net.sf.laja.parser.engine2.element.Element element) {
            this.data = data;
            this.element = element;
        }
        public int getId() { return element.getId(); }
        public String getName() { return element.getName(); }
        public String getString() { return element.getString(); }
        public String getIdName() { return element.getIdName(); }
        public boolean isTerminal() { return element.isTerminal(); }
        public boolean isOptional() { return false; }
        public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
            data.pushTemplate();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popTemplate();
            return match;
        }
    }

    // *** ITemplateFactoryFactory
    public interface ITemplateFactoryFactory {
        public ITemplateFactory getFactory(int phase);
    }

    // *** ITemplateFactory ***
    public interface ITemplateFactory {
        TemplateParser.IStringExp createStringExp();
        TemplateParser.IListData createListData();
        TemplateParser.IMapMember createMapMember();
        TemplateParser.IMapDataRef createMapDataRef();
        TemplateParser.IMapData createMapData();
        TemplateParser.INewStatement createNewStatement();
        TemplateParser.IData createData();
        TemplateParser.IIndexItem createIndexItem();
        TemplateParser.IListIndex createListIndex();
        TemplateParser.IArgs createArgs();
        TemplateParser.INamespaceRef createNamespaceRef();
        TemplateParser.IVariableRef createVariableRef();
        TemplateParser.IMethodRef createMethodRef();
        TemplateParser.IAttributeRef createAttributeRef();
        TemplateParser.IAttributeMethodRef createAttributeMethodRef();
        TemplateParser.IAttributeVariableRef createAttributeVariableRef();
        TemplateParser.IReference createReference(ITemplate template, IMacro macro, IFunction function);
        TemplateParser.ICallReference createCallReference(ITemplate template, IMacro macro, IFunction function);
        TemplateParser.IStringref createStringref();
        TemplateParser.IFloatData createFloatData();
        TemplateParser.IIntegerData createIntegerData();
        TemplateParser.INullData createNullData();
        TemplateParser.IBooleanData createBooleanData();
        TemplateParser.IText createText();
        TemplateParser.IWrite createWrite();
        TemplateParser.ILocal createLocal(ITemplate template, IMacro macro, IFunction function);
        TemplateParser.ISet createSet(ITemplate template, IMacro macro);
        TemplateParser.IOperator createOperator();
        TemplateParser.IComparition createComparition();
        TemplateParser.IConditionElement createConditionElement();
        TemplateParser.IConditionBase createConditionBase();
        TemplateParser.IConditionAnd createConditionAnd();
        TemplateParser.ICondition createCondition();
        TemplateParser.IIfcmd createIfcmd();
        TemplateParser.IElseif createElseif();
        TemplateParser.IElse createElse();
        TemplateParser.IWhilecmd createWhilecmd();
        TemplateParser.ICall createCall(ITemplate template);
        TemplateParser.IForeach createForeach(ITemplate template);
        TemplateParser.IImportcmd createImportcmd(ITemplate template);
        TemplateParser.IMacro createMacro(ITemplate template);
        TemplateParser.ICommand createCommand();
        TemplateParser.INamespace createNamespace();
        TemplateParser.IError createError();
        TemplateParser.IReturncmd createReturncmd(IFunction function);
        TemplateParser.IFunction createFunction(ITemplate template);
        TemplateParser.IBlock createBlock();
        TemplateParser.ITemplate createTemplate();
    }

    // *** Interfaces ***
    // StringExp
    public interface IStringExp {
        public void addText(String text);
        public void addStringref(IStringref istringref);
    }

    // ListData
    public interface IListData {
        public void addData(IData idata);
        public void setArray();
    }

    // MapMember
    public interface IMapMember {
        public void setName(String name);
        public void setData(IData idata);
    }

    // MapDataRef
    public interface IMapDataRef {
        public void setMapData(IMapData imapData);
    }

    // MapData
    public interface IMapData {
        public void addMember(IMapMember imapMember);
    }

    // NewStatement
    public interface INewStatement {
        public void addClassOrPackageName(String classOrPackageName);
        public void setArguments(IArgs iargs);
    }

    // Data
    public interface IData {
        public void setContent(String data);
        public void setNewStatement(INewStatement inewStatement);
        public void setStringExp(IStringExp istringExp);
        public void setListData(IListData ilistData);
        public void setMapDataRef(IMapDataRef imapDataRef);
        public void setReference(IReference ireference);
        public void setNullData(INullData inullData);
        public void setBooleanData(IBooleanData ibooleanData);
        public void setIntegerData(IIntegerData iintegerData);
        public void setFloatData(IFloatData ifloatData);
    }

    // IndexItem
    public interface IIndexItem {
        public void setNumber(String unsignedInt);
        public void setReference(IReference ireference);
    }

    // ListIndex
    public interface IListIndex {
        public void addIndexItem(IIndexItem iindexItem);
    }

    // Args
    public interface IArgs {
        public void addData(IData idata, String stringData);
        public void setMapData(IMapData imapData);
    }

    // NamespaceRef
    public interface INamespaceRef {
        public void setNamespace(String namespace);
    }

    // VariableRef
    public interface IVariableRef {
        public void setVariableName(String variableName);
    }

    // MethodRef
    public interface IMethodRef {
        public void setMethodName(String methodName);
        public void setArgs(IArgs iargs);
    }

    // AttributeRef
    public interface IAttributeRef {
        public void setMethodRef(IMethodRef imethodRef);
        public void setVariableRef(IVariableRef ivariableRef);
        public void setListIndex(IListIndex ilistIndex);
    }

    // AttributeMethodRef
    public interface IAttributeMethodRef {
        public void setMethodRef(IMethodRef imethodRef);
        public void setListIndex(IListIndex ilistIndex);
    }

    // AttributeVariableRef
    public interface IAttributeVariableRef {
        public void setVariableRef(IVariableRef ivariableRef);
        public void setListIndex(IListIndex ilistIndex);
    }

    // Reference
    public interface IReference {
        public void setBegin(Index begin);
        public void setNamespaceRef(INamespaceRef inamespaceRef);
        public void setAttributeRef(IAttributeRef iattributeRef);
        public void setFloatData(IFloatData ifloatData, String name);
        public void setIntegerData(IIntegerData iintegerData, String name);
        public void setStringExp(IStringExp istringExp, String name);
        public void addNextAttributeRef(IAttributeRef inextAttributeRef);
    }

    // CallReference
    public interface ICallReference {
        public void setBegin(Index begin);
        public void setNamespaceRef(INamespaceRef inamespaceRef);
        public void setAttributeRef(IAttributeMethodRef iattributeMethodRef);
        public void setAttributeRef(IAttributeVariableRef iattributeVariableRef);
        public void addNextAttributeRef(IAttributeRef inextAttributeRef);
    }

    // Stringref
    public interface IStringref {
        public void setBegin(Index begin);
        public void setCurrentdir();
        public void setParentDir();
        public void setReference(IReference ireference);
    }

    // FloatData
    public interface IFloatData {
        public void setNumber(String floatData);
    }

    // IntegerData
    public interface IIntegerData {
        public void setNumber(String integerData);
    }

    // NullData
    public interface INullData {
    }

    // BooleanData
    public interface IBooleanData {
        public void setBoolean(String booleanData);
    }

    // Text
    public interface IText {
        public void setContent(String text);
    }

    // Write
    public interface IWrite {
        public void setBegin(Index begin);
        public void setFilename(IStringExp ifilename);
        public void setBlock(IBlock iblock);
    }

    // Local
    public interface ILocal {
        public void setTarget(IReference itarget);
        public void setData(IData idata);
        public void setComparition(IComparition icomparition);
    }

    // Set
    public interface ISet {
        public void setBegin(Index begin);
        public void setTarget(IReference itarget);
        public void setData(IData idata);
        public void setComparition(IComparition icomparition);
    }

    // Operator
    public interface IOperator {
        public void setEquals();
        public void setNotEquals();
        public void setLessThan();
        public void setLessOrEqual();
        public void setGreaterThan();
        public void setGreaterOrEqual();
    }

    // Comparition
    public interface IComparition {
        public void setLeftOperand(IData ileftOperand);
        public void setOperator(IOperator ioperator);
        public void setRightOperand(IData irightOperand);
    }

    // ConditionElement
    public interface IConditionElement {
        public void setNot();
        public void setComparition(IComparition icomparition);
        public void setBoolean(IBooleanData ibooleanCondition);
        public void setReference(IReference ireference);
    }

    // ConditionBase
    public interface IConditionBase {
        public void setConditionElement(IConditionElement iconditionElement);
        public void setCondition(ICondition icondition);
    }

    // ConditionAnd
    public interface IConditionAnd {
        public void addConditionBase(IConditionBase iconditionBase);
    }

    // Condition
    public interface ICondition {
        public void addConditionAnd(IConditionAnd iconditionAnd);
    }

    // Ifcmd
    public interface IIfcmd {
        public void setCondition(ICondition icondition);
        public void setBlock(IBlock iblock);
        public void addElseif(IElseif ielseif);
        public void setElse(IElse ielse);
    }

    // Elseif
    public interface IElseif {
        public void setCondition(ICondition icondition);
        public void setBlock(IBlock iblock);
    }

    // Else
    public interface IElse {
        public void setBlock(IBlock iblock);
    }

    // Whilecmd
    public interface IWhilecmd {
        public void setCondition(ICondition icondition);
        public void setBlock(IBlock iblock);
    }

    // Call
    public interface ICall {
        public void setBegin(Index begin);
        public void setReference(ICallReference icallReference);
        public void setTargetNamespace(String targetNamespace);
        public void setTargetVariable(String targetVariable);
    }

    // Foreach
    public interface IForeach {
        public void setBegin(Index begin);
        public void setVariable(String variable);
        public void setListData(IListData ilistData);
        public void setMapDataRef(IMapDataRef imapDataRef);
        public void setReference(IReference ireference);
        public void setCondition(ICondition icondition);
        public void setBlock(IBlock iblock);
    }

    // Importcmd
    public interface IImportcmd {
        public void setBegin(Index begin);
        public void setFilename(IStringExp ifilename);
        public void setAsText();
    }

    // Macro
    public interface IMacro {
        public void setBegin(Index begin);
        public void setName(String name);
        public void addParameter(String parameter);
        public void setBlock(IBlock iblock);
    }

    // Command
    public interface ICommand {
        public void setLocal(ILocal ilocal);
        public void setSet(ISet iset);
        public void setWrite(IWrite iwrite);
        public void setIfcmd(IIfcmd iifcmd);
        public void setWhilecmd(IWhilecmd iwhilecmd);
        public void setForeach(IForeach iforeach);
        public void setImport(IImportcmd iimportcmd);
        public void setMacro(IMacro imacro);
        public void setFunction(IFunction ifunction);
        public void setCall(ICall icall);
        public void setError(IError ierror);
    }

    // Namespace
    public interface INamespace {
        public void setName(String name);
    }

    // Error
    public interface IError {
        public void setBegin(Index begin);
        public void setMessage(IStringExp imessage);
    }

    // Returncmd
    public interface IReturncmd {
        public void setReturnedData(IData idata);
        public void setReturnedComparition(IComparition icomparition);
    }

    // Function
    public interface IFunction {
        public void setName(String name);
        public void addParameter(String parameter);
        public void setBlock(IBlock iblock);
    }

    // Block
    public interface IBlock {
        public void addText(String text);
        public void addCommand(ICommand icommand);
        public void addReturncmd(IReturncmd ireturncmd);
        public void addStringref(IStringref istringref);
        public void addText(IText itext);
    }

    // Template
    public interface ITemplate {
        public void setNamespace(INamespace inamespace);
        public void setDefaultNamespace();
        public void setBlock(IBlock iblock);
    }

    // *** Data ***
    public static final class Data {
        private TemplateParser.ITemplateFactory factory;
        private Stack<IStringExp> stringExpStack = new Stack<IStringExp>();
        private Stack<IListData> listDataStack = new Stack<IListData>();
        private Stack<IMapMember> mapMemberStack = new Stack<IMapMember>();
        private Stack<IMapDataRef> mapDataRefStack = new Stack<IMapDataRef>();
        private Stack<IMapData> mapDataStack = new Stack<IMapData>();
        private Stack<INewStatement> newStatementStack = new Stack<INewStatement>();
        private Stack<IData> dataStack = new Stack<IData>();
        private Stack<IIndexItem> indexItemStack = new Stack<IIndexItem>();
        private Stack<IListIndex> listIndexStack = new Stack<IListIndex>();
        private Stack<IArgs> argsStack = new Stack<IArgs>();
        private Stack<INamespaceRef> namespaceRefStack = new Stack<INamespaceRef>();
        private Stack<IVariableRef> variableRefStack = new Stack<IVariableRef>();
        private Stack<IMethodRef> methodRefStack = new Stack<IMethodRef>();
        private Stack<IAttributeRef> attributeRefStack = new Stack<IAttributeRef>();
        private Stack<IAttributeMethodRef> attributeMethodRefStack = new Stack<IAttributeMethodRef>();
        private Stack<IAttributeVariableRef> attributeVariableRefStack = new Stack<IAttributeVariableRef>();
        private Stack<IReference> referenceStack = new Stack<IReference>();
        private Stack<ICallReference> callReferenceStack = new Stack<ICallReference>();
        private Stack<IStringref> stringrefStack = new Stack<IStringref>();
        private Stack<IFloatData> floatDataStack = new Stack<IFloatData>();
        private Stack<IIntegerData> integerDataStack = new Stack<IIntegerData>();
        private Stack<INullData> nullDataStack = new Stack<INullData>();
        private Stack<IBooleanData> booleanDataStack = new Stack<IBooleanData>();
        private Stack<IText> textStack = new Stack<IText>();
        private Stack<IWrite> writeStack = new Stack<IWrite>();
        private Stack<ILocal> localStack = new Stack<ILocal>();
        private Stack<ISet> setStack = new Stack<ISet>();
        private Stack<IOperator> operatorStack = new Stack<IOperator>();
        private Stack<IComparition> comparitionStack = new Stack<IComparition>();
        private Stack<IConditionElement> conditionElementStack = new Stack<IConditionElement>();
        private Stack<IConditionBase> conditionBaseStack = new Stack<IConditionBase>();
        private Stack<IConditionAnd> conditionAndStack = new Stack<IConditionAnd>();
        private Stack<ICondition> conditionStack = new Stack<ICondition>();
        private Stack<IIfcmd> ifcmdStack = new Stack<IIfcmd>();
        private Stack<IElseif> elseifStack = new Stack<IElseif>();
        private Stack<IElse> elseStack = new Stack<IElse>();
        private Stack<IWhilecmd> whilecmdStack = new Stack<IWhilecmd>();
        private Stack<ICall> callStack = new Stack<ICall>();
        private Stack<IForeach> foreachStack = new Stack<IForeach>();
        private Stack<IImportcmd> importcmdStack = new Stack<IImportcmd>();
        private Stack<IMacro> macroStack = new Stack<IMacro>();
        private Stack<ICommand> commandStack = new Stack<ICommand>();
        private Stack<INamespace> namespaceStack = new Stack<INamespace>();
        private Stack<IError> errorStack = new Stack<IError>();
        private Stack<IReturncmd> returncmdStack = new Stack<IReturncmd>();
        private Stack<IFunction> functionStack = new Stack<IFunction>();
        private Stack<IBlock> blockStack = new Stack<IBlock>();
        private Stack<ITemplate> templateStack = new Stack<ITemplate>();

        public Data(TemplateParser.ITemplateFactory factory) {
            this.factory = factory;
        }

        // StringExp
        public void pushStringExp() { stringExpStack.push(factory.createStringExp()); }
        public TemplateParser.IStringExp popStringExp() { return (TemplateParser.IStringExp)stringExpStack.pop(); }
        public TemplateParser.IStringExp peekStringExp() {
            if (stringExpStack.empty()) { return null; }
            return stringExpStack.peek();
        }

        // ListData
        public void pushListData() { listDataStack.push(factory.createListData()); }
        public TemplateParser.IListData popListData() { return (TemplateParser.IListData)listDataStack.pop(); }
        public TemplateParser.IListData peekListData() {
            if (listDataStack.empty()) { return null; }
            return listDataStack.peek();
        }

        // MapMember
        public void pushMapMember() { mapMemberStack.push(factory.createMapMember()); }
        public TemplateParser.IMapMember popMapMember() { return (TemplateParser.IMapMember)mapMemberStack.pop(); }
        public TemplateParser.IMapMember peekMapMember() {
            if (mapMemberStack.empty()) { return null; }
            return mapMemberStack.peek();
        }

        // MapDataRef
        public void pushMapDataRef() { mapDataRefStack.push(factory.createMapDataRef()); }
        public TemplateParser.IMapDataRef popMapDataRef() { return (TemplateParser.IMapDataRef)mapDataRefStack.pop(); }
        public TemplateParser.IMapDataRef peekMapDataRef() {
            if (mapDataRefStack.empty()) { return null; }
            return mapDataRefStack.peek();
        }

        // MapData
        public void pushMapData() { mapDataStack.push(factory.createMapData()); }
        public TemplateParser.IMapData popMapData() { return (TemplateParser.IMapData)mapDataStack.pop(); }
        public TemplateParser.IMapData peekMapData() {
            if (mapDataStack.empty()) { return null; }
            return mapDataStack.peek();
        }

        // NewStatement
        public void pushNewStatement() { newStatementStack.push(factory.createNewStatement()); }
        public TemplateParser.INewStatement popNewStatement() { return (TemplateParser.INewStatement)newStatementStack.pop(); }
        public TemplateParser.INewStatement peekNewStatement() {
            if (newStatementStack.empty()) { return null; }
            return newStatementStack.peek();
        }

        // Data
        public void pushData() { dataStack.push(factory.createData()); }
        public TemplateParser.IData popData() { return (TemplateParser.IData)dataStack.pop(); }
        public TemplateParser.IData peekData() {
            if (dataStack.empty()) { return null; }
            return dataStack.peek();
        }

        // IndexItem
        public void pushIndexItem() { indexItemStack.push(factory.createIndexItem()); }
        public TemplateParser.IIndexItem popIndexItem() { return (TemplateParser.IIndexItem)indexItemStack.pop(); }
        public TemplateParser.IIndexItem peekIndexItem() {
            if (indexItemStack.empty()) { return null; }
            return indexItemStack.peek();
        }

        // ListIndex
        public void pushListIndex() { listIndexStack.push(factory.createListIndex()); }
        public TemplateParser.IListIndex popListIndex() { return (TemplateParser.IListIndex)listIndexStack.pop(); }
        public TemplateParser.IListIndex peekListIndex() {
            if (listIndexStack.empty()) { return null; }
            return listIndexStack.peek();
        }

        // Args
        public void pushArgs() { argsStack.push(factory.createArgs()); }
        public TemplateParser.IArgs popArgs() { return (TemplateParser.IArgs)argsStack.pop(); }
        public TemplateParser.IArgs peekArgs() {
            if (argsStack.empty()) { return null; }
            return argsStack.peek();
        }

        // NamespaceRef
        public void pushNamespaceRef() { namespaceRefStack.push(factory.createNamespaceRef()); }
        public TemplateParser.INamespaceRef popNamespaceRef() { return (TemplateParser.INamespaceRef)namespaceRefStack.pop(); }
        public TemplateParser.INamespaceRef peekNamespaceRef() {
            if (namespaceRefStack.empty()) { return null; }
            return namespaceRefStack.peek();
        }

        // VariableRef
        public void pushVariableRef() { variableRefStack.push(factory.createVariableRef()); }
        public TemplateParser.IVariableRef popVariableRef() { return (TemplateParser.IVariableRef)variableRefStack.pop(); }
        public TemplateParser.IVariableRef peekVariableRef() {
            if (variableRefStack.empty()) { return null; }
            return variableRefStack.peek();
        }

        // MethodRef
        public void pushMethodRef() { methodRefStack.push(factory.createMethodRef()); }
        public TemplateParser.IMethodRef popMethodRef() { return (TemplateParser.IMethodRef)methodRefStack.pop(); }
        public TemplateParser.IMethodRef peekMethodRef() {
            if (methodRefStack.empty()) { return null; }
            return methodRefStack.peek();
        }

        // AttributeRef
        public void pushAttributeRef() { attributeRefStack.push(factory.createAttributeRef()); }
        public TemplateParser.IAttributeRef popAttributeRef() { return (TemplateParser.IAttributeRef)attributeRefStack.pop(); }
        public TemplateParser.IAttributeRef peekAttributeRef() {
            if (attributeRefStack.empty()) { return null; }
            return attributeRefStack.peek();
        }

        // AttributeMethodRef
        public void pushAttributeMethodRef() { attributeMethodRefStack.push(factory.createAttributeMethodRef()); }
        public TemplateParser.IAttributeMethodRef popAttributeMethodRef() { return (TemplateParser.IAttributeMethodRef)attributeMethodRefStack.pop(); }
        public TemplateParser.IAttributeMethodRef peekAttributeMethodRef() {
            if (attributeMethodRefStack.empty()) { return null; }
            return attributeMethodRefStack.peek();
        }

        // AttributeVariableRef
        public void pushAttributeVariableRef() { attributeVariableRefStack.push(factory.createAttributeVariableRef()); }
        public TemplateParser.IAttributeVariableRef popAttributeVariableRef() { return (TemplateParser.IAttributeVariableRef)attributeVariableRefStack.pop(); }
        public TemplateParser.IAttributeVariableRef peekAttributeVariableRef() {
            if (attributeVariableRefStack.empty()) { return null; }
            return attributeVariableRefStack.peek();
        }

        // Reference
        public void pushReference() { referenceStack.push(factory.createReference(peekTemplate(), peekMacro(), peekFunction())); }
        public TemplateParser.IReference popReference() { return (TemplateParser.IReference)referenceStack.pop(); }
        public TemplateParser.IReference peekReference() {
            if (referenceStack.empty()) { return null; }
            return referenceStack.peek();
        }

        // CallReference
        public void pushCallReference() { callReferenceStack.push(factory.createCallReference(peekTemplate(), peekMacro(), peekFunction())); }
        public TemplateParser.ICallReference popCallReference() { return (TemplateParser.ICallReference)callReferenceStack.pop(); }
        public TemplateParser.ICallReference peekCallReference() {
            if (callReferenceStack.empty()) { return null; }
            return callReferenceStack.peek();
        }

        // Stringref
        public void pushStringref() { stringrefStack.push(factory.createStringref()); }
        public TemplateParser.IStringref popStringref() { return (TemplateParser.IStringref)stringrefStack.pop(); }
        public TemplateParser.IStringref peekStringref() {
            if (stringrefStack.empty()) { return null; }
            return stringrefStack.peek();
        }

        // FloatData
        public void pushFloatData() { floatDataStack.push(factory.createFloatData()); }
        public TemplateParser.IFloatData popFloatData() { return (TemplateParser.IFloatData)floatDataStack.pop(); }
        public TemplateParser.IFloatData peekFloatData() {
            if (floatDataStack.empty()) { return null; }
            return floatDataStack.peek();
        }

        // IntegerData
        public void pushIntegerData() { integerDataStack.push(factory.createIntegerData()); }
        public TemplateParser.IIntegerData popIntegerData() { return (TemplateParser.IIntegerData)integerDataStack.pop(); }
        public TemplateParser.IIntegerData peekIntegerData() {
            if (integerDataStack.empty()) { return null; }
            return integerDataStack.peek();
        }

        // NullData
        public void pushNullData() { nullDataStack.push(factory.createNullData()); }
        public TemplateParser.INullData popNullData() { return (TemplateParser.INullData)nullDataStack.pop(); }
        public TemplateParser.INullData peekNullData() {
            if (nullDataStack.empty()) { return null; }
            return nullDataStack.peek();
        }

        // BooleanData
        public void pushBooleanData() { booleanDataStack.push(factory.createBooleanData()); }
        public TemplateParser.IBooleanData popBooleanData() { return (TemplateParser.IBooleanData)booleanDataStack.pop(); }
        public TemplateParser.IBooleanData peekBooleanData() {
            if (booleanDataStack.empty()) { return null; }
            return booleanDataStack.peek();
        }

        // Text
        public void pushText() { textStack.push(factory.createText()); }
        public TemplateParser.IText popText() { return (TemplateParser.IText)textStack.pop(); }
        public TemplateParser.IText peekText() {
            if (textStack.empty()) { return null; }
            return textStack.peek();
        }

        // Write
        public void pushWrite() { writeStack.push(factory.createWrite()); }
        public TemplateParser.IWrite popWrite() { return (TemplateParser.IWrite)writeStack.pop(); }
        public TemplateParser.IWrite peekWrite() {
            if (writeStack.empty()) { return null; }
            return writeStack.peek();
        }

        // Local
        public void pushLocal() { localStack.push(factory.createLocal(peekTemplate(), peekMacro(), peekFunction())); }
        public TemplateParser.ILocal popLocal() { return (TemplateParser.ILocal)localStack.pop(); }
        public TemplateParser.ILocal peekLocal() {
            if (localStack.empty()) { return null; }
            return localStack.peek();
        }

        // Set
        public void pushSet() { setStack.push(factory.createSet(peekTemplate(), peekMacro())); }
        public TemplateParser.ISet popSet() { return (TemplateParser.ISet)setStack.pop(); }
        public TemplateParser.ISet peekSet() {
            if (setStack.empty()) { return null; }
            return setStack.peek();
        }

        // Operator
        public void pushOperator() { operatorStack.push(factory.createOperator()); }
        public TemplateParser.IOperator popOperator() { return (TemplateParser.IOperator)operatorStack.pop(); }
        public TemplateParser.IOperator peekOperator() {
            if (operatorStack.empty()) { return null; }
            return operatorStack.peek();
        }

        // Comparition
        public void pushComparition() { comparitionStack.push(factory.createComparition()); }
        public TemplateParser.IComparition popComparition() { return (TemplateParser.IComparition)comparitionStack.pop(); }
        public TemplateParser.IComparition peekComparition() {
            if (comparitionStack.empty()) { return null; }
            return comparitionStack.peek();
        }

        // ConditionElement
        public void pushConditionElement() { conditionElementStack.push(factory.createConditionElement()); }
        public TemplateParser.IConditionElement popConditionElement() { return (TemplateParser.IConditionElement)conditionElementStack.pop(); }
        public TemplateParser.IConditionElement peekConditionElement() {
            if (conditionElementStack.empty()) { return null; }
            return conditionElementStack.peek();
        }

        // ConditionBase
        public void pushConditionBase() { conditionBaseStack.push(factory.createConditionBase()); }
        public TemplateParser.IConditionBase popConditionBase() { return (TemplateParser.IConditionBase)conditionBaseStack.pop(); }
        public TemplateParser.IConditionBase peekConditionBase() {
            if (conditionBaseStack.empty()) { return null; }
            return conditionBaseStack.peek();
        }

        // ConditionAnd
        public void pushConditionAnd() { conditionAndStack.push(factory.createConditionAnd()); }
        public TemplateParser.IConditionAnd popConditionAnd() { return (TemplateParser.IConditionAnd)conditionAndStack.pop(); }
        public TemplateParser.IConditionAnd peekConditionAnd() {
            if (conditionAndStack.empty()) { return null; }
            return conditionAndStack.peek();
        }

        // Condition
        public void pushCondition() { conditionStack.push(factory.createCondition()); }
        public TemplateParser.ICondition popCondition() { return (TemplateParser.ICondition)conditionStack.pop(); }
        public TemplateParser.ICondition peekCondition() {
            if (conditionStack.empty()) { return null; }
            return conditionStack.peek();
        }

        // Ifcmd
        public void pushIfcmd() { ifcmdStack.push(factory.createIfcmd()); }
        public TemplateParser.IIfcmd popIfcmd() { return (TemplateParser.IIfcmd)ifcmdStack.pop(); }
        public TemplateParser.IIfcmd peekIfcmd() {
            if (ifcmdStack.empty()) { return null; }
            return ifcmdStack.peek();
        }

        // Elseif
        public void pushElseif() { elseifStack.push(factory.createElseif()); }
        public TemplateParser.IElseif popElseif() { return (TemplateParser.IElseif)elseifStack.pop(); }
        public TemplateParser.IElseif peekElseif() {
            if (elseifStack.empty()) { return null; }
            return elseifStack.peek();
        }

        // Else
        public void pushElse() { elseStack.push(factory.createElse()); }
        public TemplateParser.IElse popElse() { return (TemplateParser.IElse)elseStack.pop(); }
        public TemplateParser.IElse peekElse() {
            if (elseStack.empty()) { return null; }
            return elseStack.peek();
        }

        // Whilecmd
        public void pushWhilecmd() { whilecmdStack.push(factory.createWhilecmd()); }
        public TemplateParser.IWhilecmd popWhilecmd() { return (TemplateParser.IWhilecmd)whilecmdStack.pop(); }
        public TemplateParser.IWhilecmd peekWhilecmd() {
            if (whilecmdStack.empty()) { return null; }
            return whilecmdStack.peek();
        }

        // Call
        public void pushCall() { callStack.push(factory.createCall(peekTemplate())); }
        public TemplateParser.ICall popCall() { return (TemplateParser.ICall)callStack.pop(); }
        public TemplateParser.ICall peekCall() {
            if (callStack.empty()) { return null; }
            return callStack.peek();
        }

        // Foreach
        public void pushForeach() { foreachStack.push(factory.createForeach(peekTemplate())); }
        public TemplateParser.IForeach popForeach() { return (TemplateParser.IForeach)foreachStack.pop(); }
        public TemplateParser.IForeach peekForeach() {
            if (foreachStack.empty()) { return null; }
            return foreachStack.peek();
        }

        // Importcmd
        public void pushImportcmd() { importcmdStack.push(factory.createImportcmd(peekTemplate())); }
        public TemplateParser.IImportcmd popImportcmd() { return (TemplateParser.IImportcmd)importcmdStack.pop(); }
        public TemplateParser.IImportcmd peekImportcmd() {
            if (importcmdStack.empty()) { return null; }
            return importcmdStack.peek();
        }

        // Macro
        public void pushMacro() { macroStack.push(factory.createMacro(peekTemplate())); }
        public TemplateParser.IMacro popMacro() { return (TemplateParser.IMacro)macroStack.pop(); }
        public TemplateParser.IMacro peekMacro() {
            if (macroStack.empty()) { return null; }
            return macroStack.peek();
        }

        // Command
        public void pushCommand() { commandStack.push(factory.createCommand()); }
        public TemplateParser.ICommand popCommand() { return (TemplateParser.ICommand)commandStack.pop(); }
        public TemplateParser.ICommand peekCommand() {
            if (commandStack.empty()) { return null; }
            return commandStack.peek();
        }

        // Namespace
        public void pushNamespace() { namespaceStack.push(factory.createNamespace()); }
        public TemplateParser.INamespace popNamespace() { return (TemplateParser.INamespace)namespaceStack.pop(); }
        public TemplateParser.INamespace peekNamespace() {
            if (namespaceStack.empty()) { return null; }
            return namespaceStack.peek();
        }

        // Error
        public void pushError() { errorStack.push(factory.createError()); }
        public TemplateParser.IError popError() { return (TemplateParser.IError)errorStack.pop(); }
        public TemplateParser.IError peekError() {
            if (errorStack.empty()) { return null; }
            return errorStack.peek();
        }

        // Returncmd
        public void pushReturncmd() { returncmdStack.push(factory.createReturncmd(peekFunction())); }
        public TemplateParser.IReturncmd popReturncmd() { return (TemplateParser.IReturncmd)returncmdStack.pop(); }
        public TemplateParser.IReturncmd peekReturncmd() {
            if (returncmdStack.empty()) { return null; }
            return returncmdStack.peek();
        }

        // Function
        public void pushFunction() { functionStack.push(factory.createFunction(peekTemplate())); }
        public TemplateParser.IFunction popFunction() { return (TemplateParser.IFunction)functionStack.pop(); }
        public TemplateParser.IFunction peekFunction() {
            if (functionStack.empty()) { return null; }
            return functionStack.peek();
        }

        // Block
        public void pushBlock() { blockStack.push(factory.createBlock()); }
        public TemplateParser.IBlock popBlock() { return (TemplateParser.IBlock)blockStack.pop(); }
        public TemplateParser.IBlock peekBlock() {
            if (blockStack.empty()) { return null; }
            return blockStack.peek();
        }

        // Template
        public void pushTemplate() { templateStack.push(factory.createTemplate()); }
        public TemplateParser.ITemplate popTemplate() { return (TemplateParser.ITemplate)templateStack.pop(); }
        public TemplateParser.ITemplate peekTemplate() {
            if (templateStack.empty()) { return null; }
            return templateStack.peek();
        }

        // BooleanData booleanData.setBoolean(String *);
        public class BooleanDataBooleanData implements Output {
            private String name;
            public BooleanDataBooleanData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekBooleanData().setBoolean(source.get(bookmark));
            }
        }

        // IntegerData integerData.setNumber(String *);
        public class IntegerDataIntegerData implements Output {
            private String name;
            public IntegerDataIntegerData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekIntegerData().setNumber(source.get(bookmark));
            }
        }

        // FloatData floatData.setNumber(String *);
        public class FloatDataFloatData implements Output {
            private String name;
            public FloatDataFloatData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekFloatData().setNumber(source.get(bookmark));
            }
        }

        // Data data.setContent(String *);
        public class DataData implements Output {
            private String name;
            public DataData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekData().setContent(source.get(bookmark));
            }
        }

        // Text text.setContent(String *);
        public class TextText implements Output {
            private String name;
            public TextText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekText().setContent(source.get(bookmark));
            }
        }

        // stringExp.addStringref(Stringref stringref);
        public class StringExpStringExpStringref implements Output {
            private String name;
            public StringExpStringExpStringref(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringref(); }
            public void set(Source source, int bookmark) {
                peekStringExp().addStringref(popStringref());
            }
        }

        // StringExp stringExp.addText(String text);
        public class StringExpStringExpText implements Output {
            private String name;
            public StringExpStringExpText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushText(); }
            public void set(Source source, int bookmark) {
                popText();
                peekStringExp().addText(source.get(bookmark));
            }
        }

        // NewStatement newStatement.addClassOrPackageName(String classOrPackageName);
        public class NewStatementNewStatementClassOrPackageName implements Output {
            private String name;
            public NewStatementNewStatementClassOrPackageName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekNewStatement().addClassOrPackageName(source.get(bookmark));
            }
        }

        // newStatement.setArguments(Args args);
        public class NewStatementNewStatementArgs implements Output {
            private String name;
            public NewStatementNewStatementArgs(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushArgs(); }
            public void set(Source source, int bookmark) {
                peekNewStatement().setArguments(popArgs());
            }
        }

        // data.setNewStatement(NewStatement newStatement);
        public class DataDataNewStatement implements Output {
            private String name;
            public DataDataNewStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNewStatement(); }
            public void set(Source source, int bookmark) {
                peekData().setNewStatement(popNewStatement());
            }
        }

        // data.setStringExp(StringExp stringExp);
        public class DataDataStringExp implements Output {
            private String name;
            public DataDataStringExp(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringExp(); }
            public void set(Source source, int bookmark) {
                peekData().setStringExp(popStringExp());
            }
        }

        // data.setListData(ListData listData);
        public class DataDataListData implements Output {
            private String name;
            public DataDataListData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushListData(); }
            public void set(Source source, int bookmark) {
                peekData().setListData(popListData());
            }
        }

        // data.setMapDataRef(MapDataRef mapDataRef);
        public class DataDataMapDataRef implements Output {
            private String name;
            public DataDataMapDataRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapDataRef(); }
            public void set(Source source, int bookmark) {
                peekData().setMapDataRef(popMapDataRef());
            }
        }

        // data.setNullData(NullData nullData);
        public class DataDataNullData implements Output {
            private String name;
            public DataDataNullData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNullData(); }
            public void set(Source source, int bookmark) {
                peekData().setNullData(popNullData());
            }
        }

        // data.setBooleanData(BooleanData booleanData);
        public class DataDataBooleanData implements Output {
            private String name;
            public DataDataBooleanData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBooleanData(); }
            public void set(Source source, int bookmark) {
                peekData().setBooleanData(popBooleanData());
            }
        }

        // data.setReference(Reference reference);
        public class DataDataReference implements Output {
            private String name;
            public DataDataReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekData().setReference(popReference());
            }
        }

        // data.setFloatData(FloatData floatData);
        public class DataDataFloatData implements Output {
            private String name;
            public DataDataFloatData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushFloatData(); }
            public void set(Source source, int bookmark) {
                peekData().setFloatData(popFloatData());
            }
        }

        // data.setIntegerData(IntegerData integerData);
        public class DataDataIntegerData implements Output {
            private String name;
            public DataDataIntegerData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushIntegerData(); }
            public void set(Source source, int bookmark) {
                peekData().setIntegerData(popIntegerData());
            }
        }

        // ListData listData.addData(Data data);
        public class ListDataListDataData implements Output {
            private String name;
            public ListDataListDataData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekListData().addData(popData());
            }
        }

        // listData.setArray(void array);
        public class ListDataListDataArray implements Output {
            private String name;
            public ListDataListDataArray(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekListData().setArray();
            }
        }

        // MapMember mapMember.setName(String name);
        public class MapMemberMapMemberName implements Output {
            private String name;
            public MapMemberMapMemberName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMapMember().setName(source.get(bookmark));
            }
        }

        // mapMember.setData(Data data);
        public class MapMemberMapMemberData implements Output {
            private String name;
            public MapMemberMapMemberData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekMapMember().setData(popData());
            }
        }

        // MapDataRef mapDataRef.setMapData(MapData mapData);
        public class MapDataRefMapDataRefMapData implements Output {
            private String name;
            public MapDataRefMapDataRefMapData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapData(); }
            public void set(Source source, int bookmark) {
                peekMapDataRef().setMapData(popMapData());
            }
        }

        // MapData mapData.addMember(MapMember mapMember);
        public class MapDataMapDataMapMember implements Output {
            private String name;
            public MapDataMapDataMapMember(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapMember(); }
            public void set(Source source, int bookmark) {
                peekMapData().addMember(popMapMember());
            }
        }

        // IndexItem indexItem.setNumber(String unsignedInt);
        public class IndexItemIndexItemUnsignedInt implements Output {
            private String name;
            public IndexItemIndexItemUnsignedInt(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekIndexItem().setNumber(source.get(bookmark));
            }
        }

        // indexItem.setReference(Reference reference);
        public class IndexItemIndexItemReference implements Output {
            private String name;
            public IndexItemIndexItemReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekIndexItem().setReference(popReference());
            }
        }

        // ListIndex listIndex.addIndexItem(IndexItem indexItem);
        public class ListIndexListIndexIndexItem implements Output {
            private String name;
            public ListIndexListIndexIndexItem(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushIndexItem(); }
            public void set(Source source, int bookmark) {
                peekListIndex().addIndexItem(popIndexItem());
            }
        }

        // args.setMapData(MapData mapData);
        public class ArgsArgsMapData implements Output {
            private String name;
            public ArgsArgsMapData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapData(); }
            public void set(Source source, int bookmark) {
                peekArgs().setMapData(popMapData());
            }
        }

        // Args args.addData(Data data, String stringData);
        public class ArgsArgsData implements Output {
            private String name;
            public ArgsArgsData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekArgs().addData(popData(), source.get(bookmark));
            }
        }

        // NamespaceRef namespaceRef.setNamespace(String namespace);
        public class NamespaceRefNamespaceRefNamespace implements Output {
            private String name;
            public NamespaceRefNamespaceRefNamespace(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNamespace(); }
            public void set(Source source, int bookmark) {
                popNamespace();
                peekNamespaceRef().setNamespace(source.get(bookmark));
            }
        }

        // VariableRef variableRef.setVariableName(String variableName);
        public class VariableRefVariableRefVariableName implements Output {
            private String name;
            public VariableRefVariableRefVariableName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekVariableRef().setVariableName(source.get(bookmark));
            }
        }

        // MethodRef methodRef.setMethodName(String methodName);
        public class MethodRefMethodRefMethodName implements Output {
            private String name;
            public MethodRefMethodRefMethodName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMethodRef().setMethodName(source.get(bookmark));
            }
        }

        // methodRef.setArgs(Args args);
        public class MethodRefMethodRefArgs implements Output {
            private String name;
            public MethodRefMethodRefArgs(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushArgs(); }
            public void set(Source source, int bookmark) {
                peekMethodRef().setArgs(popArgs());
            }
        }

        // AttributeRef attributeRef.setMethodRef(MethodRef methodRef);
        public class AttributeRefAttributeRefMethodRef implements Output {
            private String name;
            public AttributeRefAttributeRefMethodRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMethodRef(); }
            public void set(Source source, int bookmark) {
                peekAttributeRef().setMethodRef(popMethodRef());
            }
        }

        // attributeRef.setVariableRef(VariableRef variableRef);
        public class AttributeRefAttributeRefVariableRef implements Output {
            private String name;
            public AttributeRefAttributeRefVariableRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVariableRef(); }
            public void set(Source source, int bookmark) {
                peekAttributeRef().setVariableRef(popVariableRef());
            }
        }

        // attributeRef.setListIndex(ListIndex listIndex);
        public class AttributeRefAttributeRefListIndex implements Output {
            private String name;
            public AttributeRefAttributeRefListIndex(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushListIndex(); }
            public void set(Source source, int bookmark) {
                peekAttributeRef().setListIndex(popListIndex());
            }
        }

        // AttributeVariableRef attributeVariableRef.setVariableRef(VariableRef variableRef);
        public class AttributeVariableRefAttributeVariableRefVariableRef implements Output {
            private String name;
            public AttributeVariableRefAttributeVariableRefVariableRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVariableRef(); }
            public void set(Source source, int bookmark) {
                peekAttributeVariableRef().setVariableRef(popVariableRef());
            }
        }

        // attributeVariableRef.setListIndex(ListIndex listIndex);
        public class AttributeVariableRefAttributeVariableRefListIndex implements Output {
            private String name;
            public AttributeVariableRefAttributeVariableRefListIndex(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushListIndex(); }
            public void set(Source source, int bookmark) {
                peekAttributeVariableRef().setListIndex(popListIndex());
            }
        }

        // AttributeMethodRef attributeMethodRef.setMethodRef(MethodRef methodRef);
        public class AttributeMethodRefAttributeMethodRefMethodRef implements Output {
            private String name;
            public AttributeMethodRefAttributeMethodRefMethodRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMethodRef(); }
            public void set(Source source, int bookmark) {
                peekAttributeMethodRef().setMethodRef(popMethodRef());
            }
        }

        // attributeMethodRef.setListIndex(ListIndex listIndex);
        public class AttributeMethodRefAttributeMethodRefListIndex implements Output {
            private String name;
            public AttributeMethodRefAttributeMethodRefListIndex(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushListIndex(); }
            public void set(Source source, int bookmark) {
                peekAttributeMethodRef().setListIndex(popListIndex());
            }
        }

        // Reference reference.setBegin(Index begin);
        public class ReferenceReferenceBegin implements Output {
            private String name;
            public ReferenceReferenceBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekReference().setBegin(source.getIndex(bookmark));
            }
        }

        // reference.setNamespaceRef(NamespaceRef namespaceRef);
        public class ReferenceReferenceNamespaceRef implements Output {
            private String name;
            public ReferenceReferenceNamespaceRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNamespaceRef(); }
            public void set(Source source, int bookmark) {
                peekReference().setNamespaceRef(popNamespaceRef());
            }
        }

        // reference.setAttributeRef(AttributeRef attributeRef);
        public class ReferenceReferenceAttributeRef implements Output {
            private String name;
            public ReferenceReferenceAttributeRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttributeRef(); }
            public void set(Source source, int bookmark) {
                peekReference().setAttributeRef(popAttributeRef());
            }
        }

        // reference.addNextAttributeRef(AttributeRef nextAttributeRef);
        public class ReferenceReferenceNextAttributeRef implements Output {
            private String name;
            public ReferenceReferenceNextAttributeRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttributeRef(); }
            public void set(Source source, int bookmark) {
                peekReference().addNextAttributeRef(popAttributeRef());
            }
        }

        // reference.setFloatData(FloatData floatData, String name);
        public class ReferenceReferenceFloatData implements Output {
            private String name;
            public ReferenceReferenceFloatData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushFloatData(); }
            public void set(Source source, int bookmark) {
                peekReference().setFloatData(popFloatData(), source.get(bookmark));
            }
        }

        // reference.setIntegerData(IntegerData integerData, String name);
        public class ReferenceReferenceIntegerData implements Output {
            private String name;
            public ReferenceReferenceIntegerData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushIntegerData(); }
            public void set(Source source, int bookmark) {
                peekReference().setIntegerData(popIntegerData(), source.get(bookmark));
            }
        }

        // reference.setStringExp(StringExp stringExp, String name);
        public class ReferenceReferenceStringExp implements Output {
            private String name;
            public ReferenceReferenceStringExp(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringExp(); }
            public void set(Source source, int bookmark) {
                peekReference().setStringExp(popStringExp(), source.get(bookmark));
            }
        }

        // CallReference callReference.setBegin(Index begin);
        public class CallReferenceCallReferenceBegin implements Output {
            private String name;
            public CallReferenceCallReferenceBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCallReference().setBegin(source.getIndex(bookmark));
            }
        }

        // callReference.setNamespaceRef(NamespaceRef namespaceRef);
        public class CallReferenceCallReferenceNamespaceRef implements Output {
            private String name;
            public CallReferenceCallReferenceNamespaceRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNamespaceRef(); }
            public void set(Source source, int bookmark) {
                peekCallReference().setNamespaceRef(popNamespaceRef());
            }
        }

        // callReference.setAttributeRef(AttributeMethodRef attributeMethodRef);
        public class CallReferenceCallReferenceAttributeMethodRef implements Output {
            private String name;
            public CallReferenceCallReferenceAttributeMethodRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttributeMethodRef(); }
            public void set(Source source, int bookmark) {
                peekCallReference().setAttributeRef(popAttributeMethodRef());
            }
        }

        // callReference.setAttributeRef(AttributeVariableRef attributeVariableRef);
        public class CallReferenceCallReferenceAttributeVariableRef implements Output {
            private String name;
            public CallReferenceCallReferenceAttributeVariableRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttributeVariableRef(); }
            public void set(Source source, int bookmark) {
                peekCallReference().setAttributeRef(popAttributeVariableRef());
            }
        }

        // callReference.addNextAttributeRef(AttributeRef nextAttributeRef);
        public class CallReferenceCallReferenceNextAttributeRef implements Output {
            private String name;
            public CallReferenceCallReferenceNextAttributeRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttributeRef(); }
            public void set(Source source, int bookmark) {
                peekCallReference().addNextAttributeRef(popAttributeRef());
            }
        }

        // Stringref stringref.setBegin(Index begin);
        public class StringrefStringrefBegin implements Output {
            private String name;
            public StringrefStringrefBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStringref().setBegin(source.getIndex(bookmark));
            }
        }

        // stringref.setParentDir(void parentDir);
        public class StringrefStringrefParentDir implements Output {
            private String name;
            public StringrefStringrefParentDir(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStringref().setParentDir();
            }
        }

        // stringref.setCurrentdir(void currentDir);
        public class StringrefStringrefCurrentDir implements Output {
            private String name;
            public StringrefStringrefCurrentDir(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStringref().setCurrentdir();
            }
        }

        // stringref.setReference(Reference reference);
        public class StringrefStringrefReference implements Output {
            private String name;
            public StringrefStringrefReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekStringref().setReference(popReference());
            }
        }

        // Write write.setBegin(Index begin);
        public class WriteWriteBegin implements Output {
            private String name;
            public WriteWriteBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekWrite().setBegin(source.getIndex(bookmark));
            }
        }

        // write.setFilename(StringExp filename);
        public class WriteWriteFilename implements Output {
            private String name;
            public WriteWriteFilename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringExp(); }
            public void set(Source source, int bookmark) {
                peekWrite().setFilename(popStringExp());
            }
        }

        // write.setBlock(Block block);
        public class WriteWriteBlock implements Output {
            private String name;
            public WriteWriteBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekWrite().setBlock(popBlock());
            }
        }

        // Set set.setBegin(Index begin);
        public class SetSetBegin implements Output {
            private String name;
            public SetSetBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekSet().setBegin(source.getIndex(bookmark));
            }
        }

        // set.setTarget(Reference target);
        public class SetSetTarget implements Output {
            private String name;
            public SetSetTarget(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekSet().setTarget(popReference());
            }
        }

        // set.setComparition(Comparition comparition);
        public class SetSetComparition implements Output {
            private String name;
            public SetSetComparition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushComparition(); }
            public void set(Source source, int bookmark) {
                peekSet().setComparition(popComparition());
            }
        }

        // set.setData(Data data);
        public class SetSetData implements Output {
            private String name;
            public SetSetData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekSet().setData(popData());
            }
        }

        // Local local.setTarget(Reference target);
        public class LocalLocalTarget implements Output {
            private String name;
            public LocalLocalTarget(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekLocal().setTarget(popReference());
            }
        }

        // local.setComparition(Comparition comparition);
        public class LocalLocalComparition implements Output {
            private String name;
            public LocalLocalComparition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushComparition(); }
            public void set(Source source, int bookmark) {
                peekLocal().setComparition(popComparition());
            }
        }

        // local.setData(Data data);
        public class LocalLocalData implements Output {
            private String name;
            public LocalLocalData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekLocal().setData(popData());
            }
        }

        // Operator operator.setEquals(void equals);
        public class OperatorOperatorEquals implements Output {
            private String name;
            public OperatorOperatorEquals(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setEquals();
            }
        }

        // operator.setNotEquals(void notEquals);
        public class OperatorOperatorNotEquals implements Output {
            private String name;
            public OperatorOperatorNotEquals(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setNotEquals();
            }
        }

        // operator.setLessOrEqual(void lessOrEqual);
        public class OperatorOperatorLessOrEqual implements Output {
            private String name;
            public OperatorOperatorLessOrEqual(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setLessOrEqual();
            }
        }

        // operator.setLessThan(void lessThan);
        public class OperatorOperatorLessThan implements Output {
            private String name;
            public OperatorOperatorLessThan(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setLessThan();
            }
        }

        // operator.setGreaterOrEqual(void greaterOrEqual);
        public class OperatorOperatorGreaterOrEqual implements Output {
            private String name;
            public OperatorOperatorGreaterOrEqual(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setGreaterOrEqual();
            }
        }

        // operator.setGreaterThan(void greaterThan);
        public class OperatorOperatorGreaterThan implements Output {
            private String name;
            public OperatorOperatorGreaterThan(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOperator().setGreaterThan();
            }
        }

        // Comparition comparition.setLeftOperand(Data leftOperand);
        public class ComparitionComparitionLeftOperand implements Output {
            private String name;
            public ComparitionComparitionLeftOperand(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekComparition().setLeftOperand(popData());
            }
        }

        // comparition.setOperator(Operator operator);
        public class ComparitionComparitionOperator implements Output {
            private String name;
            public ComparitionComparitionOperator(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushOperator(); }
            public void set(Source source, int bookmark) {
                peekComparition().setOperator(popOperator());
            }
        }

        // comparition.setRightOperand(Data rightOperand);
        public class ComparitionComparitionRightOperand implements Output {
            private String name;
            public ComparitionComparitionRightOperand(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekComparition().setRightOperand(popData());
            }
        }

        // ConditionElement conditionElement.setNot(void not);
        public class ConditionElementConditionElementNot implements Output {
            private String name;
            public ConditionElementConditionElementNot(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConditionElement().setNot();
            }
        }

        // conditionElement.setComparition(Comparition comparition);
        public class ConditionElementConditionElementComparition implements Output {
            private String name;
            public ConditionElementConditionElementComparition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushComparition(); }
            public void set(Source source, int bookmark) {
                peekConditionElement().setComparition(popComparition());
            }
        }

        // conditionElement.setReference(Reference reference);
        public class ConditionElementConditionElementReference implements Output {
            private String name;
            public ConditionElementConditionElementReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekConditionElement().setReference(popReference());
            }
        }

        // conditionElement.setBoolean(BooleanData booleanCondition);
        public class ConditionElementConditionElementBooleanCondition implements Output {
            private String name;
            public ConditionElementConditionElementBooleanCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBooleanData(); }
            public void set(Source source, int bookmark) {
                peekConditionElement().setBoolean(popBooleanData());
            }
        }

        // ConditionBase conditionBase.setConditionElement(ConditionElement conditionElement);
        public class ConditionBaseConditionBaseConditionElement implements Output {
            private String name;
            public ConditionBaseConditionBaseConditionElement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConditionElement(); }
            public void set(Source source, int bookmark) {
                peekConditionBase().setConditionElement(popConditionElement());
            }
        }

        // conditionBase.setCondition(Condition condition);
        public class ConditionBaseConditionBaseCondition implements Output {
            private String name;
            public ConditionBaseConditionBaseCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCondition(); }
            public void set(Source source, int bookmark) {
                peekConditionBase().setCondition(popCondition());
            }
        }

        // ConditionAnd conditionAnd.addConditionBase(ConditionBase conditionBase);
        public class ConditionAndConditionAndConditionBase implements Output {
            private String name;
            public ConditionAndConditionAndConditionBase(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConditionBase(); }
            public void set(Source source, int bookmark) {
                peekConditionAnd().addConditionBase(popConditionBase());
            }
        }

        // Condition condition.addConditionAnd(ConditionAnd conditionAnd);
        public class ConditionConditionConditionAnd implements Output {
            private String name;
            public ConditionConditionConditionAnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConditionAnd(); }
            public void set(Source source, int bookmark) {
                peekCondition().addConditionAnd(popConditionAnd());
            }
        }

        // Ifcmd ifcmd.setCondition(Condition condition);
        public class IfcmdIfcmdCondition implements Output {
            private String name;
            public IfcmdIfcmdCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCondition(); }
            public void set(Source source, int bookmark) {
                peekIfcmd().setCondition(popCondition());
            }
        }

        // ifcmd.setBlock(Block block);
        public class IfcmdIfcmdBlock implements Output {
            private String name;
            public IfcmdIfcmdBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekIfcmd().setBlock(popBlock());
            }
        }

        // ifcmd.addElseif(Elseif elseif);
        public class IfcmdIfcmdElseif implements Output {
            private String name;
            public IfcmdIfcmdElseif(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushElseif(); }
            public void set(Source source, int bookmark) {
                peekIfcmd().addElseif(popElseif());
            }
        }

        // ifcmd.setElse(Else else);
        public class IfcmdIfcmdElse implements Output {
            private String name;
            public IfcmdIfcmdElse(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushElse(); }
            public void set(Source source, int bookmark) {
                peekIfcmd().setElse(popElse());
            }
        }

        // Elseif elseif.setCondition(Condition condition);
        public class ElseifElseifCondition implements Output {
            private String name;
            public ElseifElseifCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCondition(); }
            public void set(Source source, int bookmark) {
                peekElseif().setCondition(popCondition());
            }
        }

        // elseif.setBlock(Block block);
        public class ElseifElseifBlock implements Output {
            private String name;
            public ElseifElseifBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekElseif().setBlock(popBlock());
            }
        }

        // Else else.setBlock(Block block);
        public class ElseElseBlock implements Output {
            private String name;
            public ElseElseBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekElse().setBlock(popBlock());
            }
        }

        // Whilecmd whilecmd.setCondition(Condition condition);
        public class WhilecmdWhilecmdCondition implements Output {
            private String name;
            public WhilecmdWhilecmdCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCondition(); }
            public void set(Source source, int bookmark) {
                peekWhilecmd().setCondition(popCondition());
            }
        }

        // whilecmd.setBlock(Block block);
        public class WhilecmdWhilecmdBlock implements Output {
            private String name;
            public WhilecmdWhilecmdBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekWhilecmd().setBlock(popBlock());
            }
        }

        // Call call.setBegin(Index begin);
        public class CallCallBegin implements Output {
            private String name;
            public CallCallBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCall().setBegin(source.getIndex(bookmark));
            }
        }

        // call.setReference(CallReference callReference);
        public class CallCallCallReference implements Output {
            private String name;
            public CallCallCallReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCallReference(); }
            public void set(Source source, int bookmark) {
                peekCall().setReference(popCallReference());
            }
        }

        // call.setTargetNamespace(String targetNamespace);
        public class CallCallTargetNamespace implements Output {
            private String name;
            public CallCallTargetNamespace(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCall().setTargetNamespace(source.get(bookmark));
            }
        }

        // call.setTargetVariable(String targetVariable);
        public class CallCallTargetVariable implements Output {
            private String name;
            public CallCallTargetVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCall().setTargetVariable(source.get(bookmark));
            }
        }

        // Foreach foreach.setBegin(Index begin);
        public class ForeachForeachBegin implements Output {
            private String name;
            public ForeachForeachBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekForeach().setBegin(source.getIndex(bookmark));
            }
        }

        // foreach.setVariable(String variable);
        public class ForeachForeachVariable implements Output {
            private String name;
            public ForeachForeachVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekForeach().setVariable(source.get(bookmark));
            }
        }

        // foreach.setListData(ListData listData);
        public class ForeachForeachListData implements Output {
            private String name;
            public ForeachForeachListData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushListData(); }
            public void set(Source source, int bookmark) {
                peekForeach().setListData(popListData());
            }
        }

        // foreach.setMapDataRef(MapDataRef mapDataRef);
        public class ForeachForeachMapDataRef implements Output {
            private String name;
            public ForeachForeachMapDataRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapDataRef(); }
            public void set(Source source, int bookmark) {
                peekForeach().setMapDataRef(popMapDataRef());
            }
        }

        // foreach.setReference(Reference reference);
        public class ForeachForeachReference implements Output {
            private String name;
            public ForeachForeachReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekForeach().setReference(popReference());
            }
        }

        // foreach.setCondition(Condition condition);
        public class ForeachForeachCondition implements Output {
            private String name;
            public ForeachForeachCondition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCondition(); }
            public void set(Source source, int bookmark) {
                peekForeach().setCondition(popCondition());
            }
        }

        // foreach.setBlock(Block block);
        public class ForeachForeachBlock implements Output {
            private String name;
            public ForeachForeachBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekForeach().setBlock(popBlock());
            }
        }

        // Importcmd importcmd.setBegin(Index begin);
        public class ImportcmdImportcmdBegin implements Output {
            private String name;
            public ImportcmdImportcmdBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekImportcmd().setBegin(source.getIndex(bookmark));
            }
        }

        // importcmd.setFilename(StringExp filename);
        public class ImportcmdImportcmdFilename implements Output {
            private String name;
            public ImportcmdImportcmdFilename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringExp(); }
            public void set(Source source, int bookmark) {
                peekImportcmd().setFilename(popStringExp());
            }
        }

        // importcmd.setAsText(void asText);
        public class ImportcmdImportcmdAsText implements Output {
            private String name;
            public ImportcmdImportcmdAsText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekImportcmd().setAsText();
            }
        }

        // Macro macro.setBegin(Index begin);
        public class MacroMacroBegin implements Output {
            private String name;
            public MacroMacroBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMacro().setBegin(source.getIndex(bookmark));
            }
        }

        // macro.setName(String name);
        public class MacroMacroName implements Output {
            private String name;
            public MacroMacroName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMacro().setName(source.get(bookmark));
            }
        }

        // macro.addParameter(String parameter);
        public class MacroMacroParameter implements Output {
            private String name;
            public MacroMacroParameter(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMacro().addParameter(source.get(bookmark));
            }
        }

        // macro.setBlock(Block block);
        public class MacroMacroBlock implements Output {
            private String name;
            public MacroMacroBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekMacro().setBlock(popBlock());
            }
        }

        // Returncmd returncmd.setReturnedData(Data data);
        public class ReturncmdReturncmdData implements Output {
            private String name;
            public ReturncmdReturncmdData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushData(); }
            public void set(Source source, int bookmark) {
                peekReturncmd().setReturnedData(popData());
            }
        }

        // returncmd.setReturnedComparition(Comparition comparition);
        public class ReturncmdReturncmdComparition implements Output {
            private String name;
            public ReturncmdReturncmdComparition(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushComparition(); }
            public void set(Source source, int bookmark) {
                peekReturncmd().setReturnedComparition(popComparition());
            }
        }

        // Function function.setName(String name);
        public class FunctionFunctionName implements Output {
            private String name;
            public FunctionFunctionName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekFunction().setName(source.get(bookmark));
            }
        }

        // function.addParameter(String parameter);
        public class FunctionFunctionParameter implements Output {
            private String name;
            public FunctionFunctionParameter(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekFunction().addParameter(source.get(bookmark));
            }
        }

        // function.setBlock(Block block);
        public class FunctionFunctionBlock implements Output {
            private String name;
            public FunctionFunctionBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekFunction().setBlock(popBlock());
            }
        }

        // Namespace namespace.setName(String name);
        public class NamespaceNamespaceName implements Output {
            private String name;
            public NamespaceNamespaceName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekNamespace().setName(source.get(bookmark));
            }
        }

        // Error error.setBegin(Index begin);
        public class ErrorErrorBegin implements Output {
            private String name;
            public ErrorErrorBegin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekError().setBegin(source.getIndex(bookmark));
            }
        }

        // error.setMessage(StringExp message);
        public class ErrorErrorMessage implements Output {
            private String name;
            public ErrorErrorMessage(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringExp(); }
            public void set(Source source, int bookmark) {
                peekError().setMessage(popStringExp());
            }
        }

        // Command command.setLocal(Local local);
        public class CommandCommandLocal implements Output {
            private String name;
            public CommandCommandLocal(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushLocal(); }
            public void set(Source source, int bookmark) {
                peekCommand().setLocal(popLocal());
            }
        }

        // command.setSet(Set set);
        public class CommandCommandSet implements Output {
            private String name;
            public CommandCommandSet(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushSet(); }
            public void set(Source source, int bookmark) {
                peekCommand().setSet(popSet());
            }
        }

        // command.setWrite(Write write);
        public class CommandCommandWrite implements Output {
            private String name;
            public CommandCommandWrite(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushWrite(); }
            public void set(Source source, int bookmark) {
                peekCommand().setWrite(popWrite());
            }
        }

        // command.setIfcmd(Ifcmd ifcmd);
        public class CommandCommandIfcmd implements Output {
            private String name;
            public CommandCommandIfcmd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushIfcmd(); }
            public void set(Source source, int bookmark) {
                peekCommand().setIfcmd(popIfcmd());
            }
        }

        // command.setWhilecmd(Whilecmd whilecmd);
        public class CommandCommandWhilecmd implements Output {
            private String name;
            public CommandCommandWhilecmd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushWhilecmd(); }
            public void set(Source source, int bookmark) {
                peekCommand().setWhilecmd(popWhilecmd());
            }
        }

        // command.setForeach(Foreach foreach);
        public class CommandCommandForeach implements Output {
            private String name;
            public CommandCommandForeach(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushForeach(); }
            public void set(Source source, int bookmark) {
                peekCommand().setForeach(popForeach());
            }
        }

        // command.setImport(Importcmd importcmd);
        public class CommandCommandImportcmd implements Output {
            private String name;
            public CommandCommandImportcmd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImportcmd(); }
            public void set(Source source, int bookmark) {
                peekCommand().setImport(popImportcmd());
            }
        }

        // command.setError(Error error);
        public class CommandCommandError implements Output {
            private String name;
            public CommandCommandError(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushError(); }
            public void set(Source source, int bookmark) {
                peekCommand().setError(popError());
            }
        }

        // command.setMacro(Macro macro);
        public class CommandCommandMacro implements Output {
            private String name;
            public CommandCommandMacro(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMacro(); }
            public void set(Source source, int bookmark) {
                peekCommand().setMacro(popMacro());
            }
        }

        // command.setFunction(Function function);
        public class CommandCommandFunction implements Output {
            private String name;
            public CommandCommandFunction(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushFunction(); }
            public void set(Source source, int bookmark) {
                peekCommand().setFunction(popFunction());
            }
        }

        // command.setCall(Call call);
        public class CommandCommandCall implements Output {
            private String name;
            public CommandCommandCall(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCall(); }
            public void set(Source source, int bookmark) {
                peekCommand().setCall(popCall());
            }
        }

        // Block block.addText(String astext.text);
        public class BlockAstextText implements Output {
            private String name;
            public BlockAstextText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushText(); }
            public void set(Source source, int bookmark) {
                popText();
                peekBlock().addText(source.get(bookmark));
            }
        }

        // block.addReturncmd(Returncmd returncmd);
        public class BlockBlockReturncmd implements Output {
            private String name;
            public BlockBlockReturncmd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReturncmd(); }
            public void set(Source source, int bookmark) {
                peekBlock().addReturncmd(popReturncmd());
            }
        }

        // block.addCommand(Command command);
        public class BlockBlockCommand implements Output {
            private String name;
            public BlockBlockCommand(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCommand(); }
            public void set(Source source, int bookmark) {
                peekBlock().addCommand(popCommand());
            }
        }

        // block.addStringref(Stringref stringref);
        public class BlockBlockStringref implements Output {
            private String name;
            public BlockBlockStringref(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringref(); }
            public void set(Source source, int bookmark) {
                peekBlock().addStringref(popStringref());
            }
        }

        // block.addText(Text text);
        public class BlockBlockText implements Output {
            private String name;
            public BlockBlockText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushText(); }
            public void set(Source source, int bookmark) {
                peekBlock().addText(popText());
            }
        }

        // Template template.setNamespace(Namespace namespace);
        public class TemplateTemplateNamespace implements Output {
            private String name;
            public TemplateTemplateNamespace(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushNamespace(); }
            public void set(Source source, int bookmark) {
                peekTemplate().setNamespace(popNamespace());
            }
        }

        // template.setDefaultNamespace(void defaultNamespace);
        public class TemplateTemplateDefaultNamespace implements Output {
            private String name;
            public TemplateTemplateDefaultNamespace(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekTemplate().setDefaultNamespace();
            }
        }

        // template.setBlock(Block block);
        public class TemplateTemplateBlock implements Output {
            private String name;
            public TemplateTemplateBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBlock(); }
            public void set(Source source, int bookmark) {
                peekTemplate().setBlock(popBlock());
            }
        }

        public class ConditionElementConditionElementBooleanData implements Output {
            private String name;
            public ConditionElementConditionElementBooleanData(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushBooleanData(); }
            public void set(Source source, int bookmark) {
                popBooleanData();
            }
        }

        public class TextTextStringref implements Output {
            private String name;
            public TextTextStringref(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStringref(); }
            public void set(Source source, int bookmark) {
                popStringref();
            }
        }
    }
}
