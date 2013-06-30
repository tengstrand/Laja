package net.sf.laja.cdd.validator;

public interface Validator<T> {
    void validate(Object rootElement, T state, String parent, String attribute, ValidationErrors.Builder errors);
}
