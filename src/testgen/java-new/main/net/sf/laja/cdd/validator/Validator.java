package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;

public interface Validator {
    void validate(Object element, String parent, String attribute, ValidationErrors.Builder errors,
                  int validatorIndex, Validator... validators);
}
