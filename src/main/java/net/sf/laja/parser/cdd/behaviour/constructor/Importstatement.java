package net.sf.laja.parser.cdd.behaviour.constructor;

import net.sf.laja.parser.cdd.behaviour.BehaviourParser;

public class Importstatement implements BehaviourParser.IImportstatement {
    public String statement;
    public boolean isStatic;
    public String fullclassname;

    public boolean endsWithType(String type) {
        return fullclassname != null && fullclassname.endsWith("." + type);
    }

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
        return "Importstatement{" +
                "statement='" + statement + '\'' +
                ", isStatic=" + isStatic +
                ", fullclassname='" + fullclassname + '\'' +
                '}';
    }
}
