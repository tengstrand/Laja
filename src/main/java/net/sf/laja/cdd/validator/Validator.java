package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.testgen.ValidationErrors;

public interface Validator<T> {
    void validate(Object rootElement, T state, String parent, String attribute, ValidationErrors.Builder errors);
}
