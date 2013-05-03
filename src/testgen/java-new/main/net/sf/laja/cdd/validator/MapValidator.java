package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;

import java.util.Arrays;
import java.util.Map;

public class MapValidator implements Validator {

    public void validate(Object elements, String parent, String attribute, ValidationErrors.Builder errors, Validator... validators) {
        Validator validator = validators[0];
        Validator[] nextValidators = Arrays.copyOfRange(validators, 1, validators.length);

        for (Object element : ((Map)elements).values()) {
            validator.validate(element, parent, attribute, errors, nextValidators);
        }
    }
}
