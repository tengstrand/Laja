 package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Iterator;

public class ValidationErrors implements Iterable<ValidationError> {
    private final ImmutableList.Builder<ValidationError> errors = ImmutableList.<ValidationError>builder();

    public ValidationErrors() {
    }

    public ValidationErrors(ValidationError... errors) {
        this.errors.addAll(Arrays.asList(errors));
    }

    public Iterator<ValidationError> iterator() {
        return errors.build().iterator();
    }

    public boolean isEmpty() {
        return errors.build().isEmpty();
    }

    public boolean hasErrors() {
        return !isEmpty();
    }

    public int size() {
        return errors.build().size();
    }

    public ValidationError first() {
        return iterator().next();
    }

    public void addError(String parent, String attribute, String errorType) {
        errors.add(new ValidationError(parent, attribute, errorType));
    }

    public void addIsNullError(String parent, String attribute) {
        errors.add(ValidationError.nullError(parent, attribute));
    }

    @Override
    public int hashCode() {
        return errors != null ? errors.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ValidationErrors)) return false;

        ValidationErrors that = (ValidationErrors) obj;

        if (errors != null ? !errors.equals(that.errors) : that.errors != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return errors.build().toString();
    }
}
