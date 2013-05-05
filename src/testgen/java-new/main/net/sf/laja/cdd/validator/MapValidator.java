package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;

import java.util.Map;

import static net.sf.laja.cdd.ValidationErrors.concatenate;

public class MapValidator implements Validator {

    public void validate(Object elements, String parent, String attribute, ValidationErrors.Builder errors,
                         int validatorIndex, Validator... validators) {
        if (validators.length == 0) {
            String newParent = concatenate(parent, attribute);

            for (Object element : ((Map)elements).values()) {
                MutableState state = (MutableState)element;
                state.validate(newParent, errors);
            }
        } else {
            for (Object element : ((Map)elements).values()) {
                validators[0].validate(element, parent, attribute, errors, validatorIndex + 1, validators);
            }
        }
    }
}
