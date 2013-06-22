package net.sf.laja.cdd;

public class InvalidStateException extends IllegalStateException {
    public final String message;
    public final ValidationErrors errors;

    public InvalidStateException(String message) {
        this.message = message;
        errors = ValidationErrors.builder().build();
    }

    public InvalidStateException(ValidationErrors errors) {
        this.errors = errors;
        message = "";
    }
}
