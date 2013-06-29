package net.sf.laja.cdd.validator;

public class Validators {

    public static CoreValidator collectionValidator() {
        return new CollectionValidator();
    }

    public static CoreValidator mapValidator() {
        return new MapValidator();
    }
}
