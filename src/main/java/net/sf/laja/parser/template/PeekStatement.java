package net.sf.laja.parser.template;

import java.util.List;

import net.sf.laja.parser.grammar.Omarg;

public class PeekStatement {
    private String className;
    private String methodName;
    private String variableName;
    private String argClass;
    private String constInterface;
    private String constName;
    private OutDatatype datatype;
    private List<Omarg> omargList;

    public PeekStatement(String className, String methodName, OutDatatype datatype, List<Omarg> omargList) {
        this.className = className;
        this.methodName = methodName;
        this.datatype = datatype;
        this.omargList = omargList;
    }

    public boolean isPeekStatement() {
        return true;
    }
    
    /**
     * @return the argClass
     */
    public String getArgClass() {
        return argClass;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @return the datatype
     */
    public OutDatatype getDatatype() {
        return datatype;
    }

    /**
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @return the omargList
     */
    public List<Omarg> getOmargList() {
        return omargList;
    }

    /**
     * @return the variableName
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * @return the constInterface
     */
    public String getConstInterface() {
        return constInterface;
    }

    /**
     * @return the constName
     */
    public String getConstName() {
        return constName;
    }
    
    public void setArgClass(String argClass) {
        this.argClass = argClass;
    }
    
    // TODO: Tag bort (ersätt) hårdkodning av interface-prefix.
    public void setConst(String constClass, String constName) {
        this.constInterface = "I" + constClass;
        this.constName = constName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public boolean isDatatypeClass() {
        return datatype == OutDatatype.CLASS;
    }
    
    public boolean isDatatypeString() {
        return datatype == OutDatatype.STRING;
    }
    
    public boolean isDatatypeIndex() {
        return datatype == OutDatatype.INDEX;
    }
    
    public boolean isDatatypeVoid() {
        return datatype == OutDatatype.VOID;
    }

    public boolean isDatatypeConst() {
        return datatype == OutDatatype.CONST;
    }

    public boolean isDatatypeVariable() {
        return datatype == OutDatatype.VARIABLE;
    }
    
	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer(500);
        
        String omargs = "[";
        String comma = "";
        for (Omarg omarg : omargList) {
            omargs += comma + omarg;
            comma = ", ";
        }
        omargs += "]";

        sb.append("PeekStatement{className=").append(className)
          .append(", methodName=").append(methodName)
          .append(", variableName=").append(variableName)
          .append(", argClass=").append(argClass)
          .append(", datatype=").append(datatype)
          .append(", omargList=").append(omargs)
          .append("}");
        
        return sb.toString();
    }
}
