package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;

import java.util.Map;

import static net.sf.laja.cdd.ValidationErrors.concatenate;

public class MapValidator implements CoreValidator {

    public void validate(Object rootElement, Object elements, String parent, String attribute, ValidationErrors.Builder errors,
                         Validator[] customValidators, int index, CoreValidator... validators) {
        if (index == validators.length) {
            String newParent = concatenate(parent, attribute);

            for (Object element : ((Map)elements).values()) {
                MutableState state = (MutableState)element;
                Object root = rootElement == null ? element : rootElement;
                state.validate(root, newParent, errors);

                for (Validator validator : customValidators) {
                    validator.validate(root, state, parent, attribute, errors);
                }
            }
        } else {
            for (Object element : ((Map)elements).values()) {
                validators[0].validate(rootElement == null ? element : rootElement, element, parent, attribute, errors,
                        customValidators, index + 1, validators);
            }
        }
    }
}
