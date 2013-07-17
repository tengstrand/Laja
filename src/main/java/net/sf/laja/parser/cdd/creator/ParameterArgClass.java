package net.sf.laja.parser.cdd.creator;

public class ParameterArgClass implements CreatorParser.IParameterArgClass {
    public boolean isAdd;
    public String method;
    public String methodSignature;
    public String value;

    public void setAdd() {
        isAdd = true;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setMethodSignature(String parameters) {
        methodSignature = parameters;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParameterArgClass{" +
                "isAdd=" + isAdd +
                ", method='" + method + '\'' +
                ", methodSignature='" + methodSignature + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
