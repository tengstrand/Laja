package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.stateconverter.StringConversion;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable(Validator... validators);
    MutableStringState asStringState();
    MutableStringState asStringState(StringConversion c);
    boolean isValid(Validator... validators);
    ValidationErrors validate(Validator... validators);
    void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators);
}
