package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.testgen.ValidationErrors;

import java.util.Map;

import static net.sf.laja.cdd.testgen.ValidationErrors.concatenate;

public class MapValidator implements CoreValidator {

    public void validate(Object rootElement, Object elements, String parent, String attribute, ValidationErrors.Builder errors,
                         int index, CoreValidator... validators) {
        if (index == validators.length) {
            String newParent = concatenate(parent, attribute);

            for (Object element : ((Map)elements).values()) {
                MutableState state = (MutableState)element;
                Object root = rootElement == null ? element : rootElement;
                state.validate(root, newParent, errors);
            }
        } else {
            for (Object element : ((Map)elements).values()) {
                validators[index].validate(rootElement == null ? element : rootElement, element, parent, attribute, errors, index + 1, validators);
            }
        }
    }
}
