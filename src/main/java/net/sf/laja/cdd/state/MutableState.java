package net.sf.laja.cdd.state;

import net.sf.laja.cdd.validator.ValidationErrors;

import java.io.Serializable;
import java.util.Map;

public interface MutableState extends Serializable {
    ImmutableState asImmutable();
    Map asMap();
    StringState asStringState();
    boolean isValid();
    ValidationErrors validate();
    void validate(Object rootElement, String parent, ValidationErrors.Builder errors);
}
