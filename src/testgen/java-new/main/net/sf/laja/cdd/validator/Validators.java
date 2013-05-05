package net.sf.laja.cdd.validator;

public class Validators {

    public static Validator collectionValidator() {
        return new CollectionValidator();
    }

    public static Validator mapValidator() {
        return new MapValidator();
    }
}
