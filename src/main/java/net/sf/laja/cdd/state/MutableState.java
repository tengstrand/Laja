package net.sf.laja.cdd.state;

import net.sf.laja.cdd.validator.ValidationErrors;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable();
    StringState asStringState();
    boolean isValid();
    ValidationErrors validate();
    void validate(Object rootElement, String parent, ValidationErrors.Builder errors);
}
