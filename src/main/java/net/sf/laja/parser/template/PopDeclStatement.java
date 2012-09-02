package net.sf.laja.parser.template;

public class PopDeclStatement {
    private String className;
    private String variableName;
    private String argClassName;

    public PopDeclStatement(String className, String variableName, String argClassName) {
        this.className = className;
        this.variableName = variableName;
        this.argClassName = argClassName;
    }

    public boolean isPopDeclStatement() {
        return true;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @return the argumentName
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * @return the argClassName
     */
    public String getArgClassName() {
        return argClassName;
    }
    
	@Override
    public String toString() {
        return "PopDeclStatement{className=" + className +
                ", variableName=" + variableName +
                ", argClassName=" + argClassName + "}";
    }
}
