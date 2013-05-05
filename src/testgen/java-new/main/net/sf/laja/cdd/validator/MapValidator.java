package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;

import java.util.Arrays;
import java.util.Map;

import static net.sf.laja.cdd.ValidationErrors.concatenate;

public class MapValidator implements Validator {

    public void validate(Object elements, String parent, String attribute, ValidationErrors.Builder errors, Validator... validators) {
        if (validators.length == 0) {
            String newParent = concatenate(parent, attribute);

            for (Object element : ((Map)elements).values()) {
                MutableState state = (MutableState)element;
                state.validate(newParent, errors);
            }
        } else {
            Validator validator = validators[0];
            Validator[] nextValidators = Arrays.copyOfRange(validators, 1, validators.length);

            for (Object element : ((Map)elements).values()) {
                validator.validate(element, parent, attribute, errors, nextValidators);
            }
        }
    }
}
