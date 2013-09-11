package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.validator.ValidationErrors;

public interface StateValue {
    void validate(String attributeName, Object rootElement, String parent, ValidationErrors.Builder errors);
}
