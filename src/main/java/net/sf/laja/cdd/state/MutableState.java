package net.sf.laja.cdd.state;

import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable(Validator... validators);
    MutableStringState asStringState();
    boolean isValid(Validator... validators);
    ValidationErrors validate(Validator... validators);
    void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators);
}
