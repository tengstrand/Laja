package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;

import java.util.Arrays;
import java.util.Collection;

public class CollectionValidator implements Validator {

    public void validate(Object elements, String parent, String attribute, ValidationErrors.Builder errors, Validator... validators) {
        Validator validator = validators[0];
        Validator[] nextValidators = Arrays.copyOfRange(validators, 1, validators.length);

        for (Object element : (Collection)elements) {
            validator.validate(element, parent, attribute, errors, nextValidators);
        }
    }
}
