package net.sf.laja.parser.template;

public class PopStatement {
    private String className;

    public PopStatement(String className) {
        this.className = className;
    }
    
    public boolean isPopStatement() {
        return true;
    }
    
    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

	@Override
    public String toString() {
        return "PopStatement{className=" + className + "}";
    }
}
