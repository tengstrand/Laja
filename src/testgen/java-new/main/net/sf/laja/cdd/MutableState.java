package net.sf.laja.cdd;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable();
    boolean isValid();
    ValidationErrors validate();
    void validate(String parent, ValidationErrors.Builder errors);
}
