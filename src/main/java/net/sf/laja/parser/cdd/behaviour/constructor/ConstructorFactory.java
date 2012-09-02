package net.sf.laja.parser.cdd.behaviour.constructor;

public class ConstructorFactory implements ConstructorParser.IConstructorFactory {
    private Constructor constructor;


    public ConstructorParser.IConstructor createConstructor() {
        return constructor = new Constructor();
    }

    public Constructor getConstructor() {
        return constructor;
    }
}
