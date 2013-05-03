package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;

import static net.sf.laja.cdd.ValidationErrors.concatenate;

public class StateValidator implements Validator {

    public void validate(Object element, String parent, String attribute, ValidationErrors.Builder errors, Validator... validators) {
        MutableState state = (MutableState)element;
        state.validate(concatenate(parent, attribute), errors);
    }
}
