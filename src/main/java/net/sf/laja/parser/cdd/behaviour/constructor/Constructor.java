package net.sf.laja.parser.cdd.behaviour.constructor;

public class Constructor implements ConstructorParser.IConstructor {
    public String codeBlock;
    public String firstPart;
    public String lastPart;

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }

    public void setLastPart(String lastPart) {
        this.lastPart = lastPart;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "codeBlock='" + codeBlock + '\'' +
                ", firstPart='" + firstPart + '\'' +
                ", lastPart='" + lastPart + '\'' +
                '}';
    }
}
