package net.sf.laja.cdd.validator;

public interface CoreValidator {
    void validate(Object rootElement, Object element, String parent, String attribute, ValidationErrors.Builder errors,
                  int index, CoreValidator... validators);
}
