package net.sf.laja.parser.cdd.statetemplate;

public class StateTemplateFactory implements StateTemplateParser.IStateTemplateFactory {
    private StateTemplate stateTemplate;
    private String templateClassname;

    public StateTemplateFactory(String templateClassname) {
        this.templateClassname = templateClassname;
    }

    public StateTemplateParser.IStatement createStatement() {
        return new Statement();
    }

    public StateTemplateParser.IIsValid createIsValid() {
        return new IsValid();
    }

    public StateTemplateParser.IImportstatement createImportstatement() {
        return new Importstatement();
    }

    public StateTemplateParser.IImports createImports() {
        return new Imports();
    }

    public StateTemplateParser.IAttribute createAttribute() {
        return new Attribute();
    }

    public StateTemplateParser.IClassStatement createClassStatement() {
        return new ClassStatement();
    }

    public StateTemplateParser.IStateTemplate createStateTemplate() {
        return stateTemplate = new StateTemplate(templateClassname);
    }

    public StateTemplate getStateTemplate() {
        return stateTemplate;
    }
}
