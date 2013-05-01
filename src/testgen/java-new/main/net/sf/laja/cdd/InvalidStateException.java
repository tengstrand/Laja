package net.sf.laja.cdd;

public class InvalidStateException extends IllegalStateException {
    public final ValidationErrors errors;

    public InvalidStateException(ValidationErrors errors) {
        this.errors = errors;
    }
}
