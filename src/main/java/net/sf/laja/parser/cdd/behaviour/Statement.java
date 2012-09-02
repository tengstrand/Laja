package net.sf.laja.parser.cdd.behaviour;

public class Statement implements BehaviourParser.IStatement {
    public String innerStatement;

    public void setInnerStatement(String innerStatement) {
        this.innerStatement = innerStatement;
    }

    public void setStatement(String statement) {
    }

    @Override
    public String toString() {
        return "Statement{" +
                "innerStatement='" + innerStatement + '\'' +
                '}';
    }
}
