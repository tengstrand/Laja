package net.sf.laja.parser.cdd.statetemplate;

public class Importstatement implements StateTemplateParser.IImportstatement {
    public String statement;
    public boolean isStatic;
    public String fullclassname;

    public Importstatement() {
    }

    public Importstatement(String fullclassname) {
        this.fullclassname = fullclassname;
    }

    public boolean endsWithType(String type) {
        return fullclassname.endsWith("." + type);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Importstatement that = (Importstatement) o;

        if (isStatic != that.isStatic) return false;
        if (fullclassname != null ? !fullclassname.equals(that.fullclassname) : that.fullclassname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (isStatic ? 1 : 0);
        result = 31 * result + (fullclassname != null ? fullclassname.hashCode() : 0);
        return result;
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
