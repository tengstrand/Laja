package net.sf.laja.parser.cdd.state;

public class ImportStatement implements StateParser.IImportstatement {
    public String statement;
    public boolean isStatic;
    public String fullclassname;

    public void setStatement(String importstatement) {
        statement = importstatement;
    }

    public void setStatic() {
        isStatic = true;
    }

    public void setFullclassname(String fullclassname) {
        this.fullclassname = fullclassname;
    }

    @Override
    public String toString() {
        return "ImportStatement{" +
                "statement='" + statement + '\'' +
                ", isStatic=" + isStatic +
                ", fullclassname='" + fullclassname + '\'' +
                '}';
    }
}
