package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.state.MutableState;

import java.util.Collection;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;

public class CollectionValidator implements CoreValidator {

    public void validate(Object rootElement, Object elements, String parent, String attribute, ValidationErrors.Builder errors,
                         int index, CoreValidator... validators) {
        if (index == validators.length) {
            String newParent = concatenate(parent, attribute);

            for (Object element : (Collection)elements) {
                MutableState state = (MutableState)element;
                Object root = rootElement == null ? element : rootElement;
                state.validate(root, newParent, errors);
            }
        } else {
            for (Object element : (Collection)elements) {
                validators[index].validate(rootElement == null ? element : rootElement, element, parent, attribute, errors, index + 1, validators);
            }
        }
    }
}
