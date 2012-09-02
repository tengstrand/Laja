package net.sf.laja.parser.cdd.statetemplate;

public class IsValid implements StateTemplateParser.IIsValid {
    private Statement statement;
    
    public void setStatement(StateTemplateParser.IStatement istatement) {
        this.statement = (Statement)istatement;
    }
    
    public String getStatement() {
        return statement.innerStatement;
    }

    @Override
    public String toString() {
        return "IsValid{" +
                "statement=" + statement +
                '}';
    }
}
