 package net.sf.laja.cdd;

 import com.google.common.collect.ImmutableSet;

 import java.util.Iterator;

 public class ValidationErrors implements Iterable<ValidationErrors.ValidationError> {
    private final ImmutableSet<ValidationError> errors;

    private static final String NULL_ERROR = "is_null";

    public static String concatenate(String parent, String attribute) {
        return parent == null || parent.isEmpty() ? attribute : parent + "." + attribute;
    }

    public static Builder builder() {
        return new Builder();
    }

    private ValidationErrors(ImmutableSet<ValidationError> errors) {
        this.errors = errors;
    }

    public Iterator<ValidationError> iterator() {
        return errors.iterator();
    }

    public boolean isEmpty() {
        return errors.isEmpty();
    }

    public boolean hasErrors() {
        return !isEmpty();
    }

    public int size() {
        return errors.size();
    }

    public ValidationError first() {
        return iterator().next();
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
        return errors.toString();
    }

    public static class Builder {
        private int size;
        private final ImmutableSet.Builder<ValidationError> errors = ImmutableSet.<ValidationError>builder();

        private Builder() {
        }

        public ValidationErrors build() {
            return new ValidationErrors(errors.build());
        }

        public Builder addIsNullError(String attribute) {
            size++;
            errors.add(new ValidationError("", attribute, NULL_ERROR));
            return this;
        }

        public Builder addIsNullError(String parent, String attribute) {
            size++;
            errors.add(new ValidationError(parent, attribute, NULL_ERROR));
            return this;
        }

        public Builder addError(String parent, String attribute, String errorType) {
            size++;
            errors.add(new ValidationError(parent, attribute, errorType));
            return this;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static class ValidationError implements Comparable<ValidationError> {
        public final String attribute;
        public final String errorType;

        public ValidationError(String attribute, String errorType) {
            this.attribute = attribute;
            this.errorType = errorType;
        }

        public ValidationError(String parent, String attribute, String errorType) {
            this.attribute = concatenate(parent, attribute);
            this.errorType = errorType;
        }

        public boolean isSameAs(String attribute, String errorType) {
            return this.attribute.equals(attribute) && this.errorType.equals(errorType);
        }

        public boolean isNullError(String attribute) {
            return isSameAs(attribute, NULL_ERROR);
        }

        public int compareTo(ValidationError error) {
            return (attribute + ":" + errorType).compareTo(error.attribute + ":" + error.errorType);
        }

        @Override
        public int hashCode() {
            int result = attribute != null ? attribute.hashCode() : 0;
            result = 31 * result + (errorType != null ? errorType.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ValidationError)) return false;

            ValidationError result = (ValidationError) o;

            if (attribute != null ? !attribute.equals(result.attribute) : result.attribute != null) return false;
            if (errorType != null ? !errorType.equals(result.errorType) : result.errorType != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "ValidationError{" +
                    "attribute='" + attribute + '\'' +
                    ", errorType='" + errorType + '\'' +
                    '}';
        }
    }
}
