package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.validator.Validator;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable(Validator... validators);
    boolean isValid();
    ValidationErrors validate(Validator... validators);
    void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators);
}
