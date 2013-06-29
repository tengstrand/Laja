package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.testgen.ValidationErrors;

public interface CoreValidator {
    void validate(Object rootElement, Object element, String parent, String attribute, ValidationErrors.Builder errors,
                  int index, CoreValidator... validators);
}
