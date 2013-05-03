package net.sf.laja.cdd.validator;

public class Validators {

    public static Validator validateState() {
        return new StateValidator();
    }

    public static Validator validateCollection() {
        return new CollectionValidator();
    }

    public static Validator validateMap() {
        return new MapValidator();
    }
}
