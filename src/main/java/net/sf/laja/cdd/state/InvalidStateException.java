package net.sf.laja.cdd.state;

import net.sf.laja.cdd.validator.ValidationErrors;

public class InvalidStateException extends IllegalStateException {
    public final ValidationErrors errors;

    public InvalidStateException(String message) {
        super(message);
        errors = ValidationErrors.builder().build();
    }

    public InvalidStateException(ValidationErrors errors) {
        super(errors.getErrorMessage());
        this.errors = errors;
    }
}
