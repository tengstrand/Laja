package net.sf.laja.parser.cdd.statetemplate;

public class Statement implements StateTemplateParser.IStatement {
    public String innerStatement;
    private Statement statement;

    public void setInnerStatement(String innerStatement) {
        this.innerStatement = innerStatement;
    }

    public void setStatement(StateTemplateParser.IStatement istatement) {
        this.statement = (Statement)istatement;
    }
}
