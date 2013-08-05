package net.sf.laja.cdd.state;

import net.sf.laja.cdd.validator.ValidationErrors;

public class StateValidator {
    private final Object rootElement;
    private final String parent;
    private final ValidationErrors.Builder errors;

    public StateValidator(Object rootElement) {
        this(rootElement, "", ValidationErrors.builder());
    }

    public StateValidator(Object rootElement, String parent, ValidationErrors.Builder errors) {
        this.rootElement = rootElement;
        this.parent = parent;
        this.errors = errors;
    }

    public void verifyThat(boolean criteria, String attribute, String errorType) {
        if (!criteria) {
            errors.addError(rootElement, attribute, errorType, parent);
        }
    }

    public ValidationErrors errors() {
        return errors.build();
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}
