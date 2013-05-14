package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;

public interface CoreValidator {
    void validate(Object rootElement, Object element, String parent, String attribute, ValidationErrors.Builder errors,
                  Validator[] customValidators, int index, CoreValidator... validators);
}
