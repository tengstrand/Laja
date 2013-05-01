package net.sf.laja.cdd;

public class ValidationError {
    public final String attribute;
    public final String errorType;

    private static final String NULL_ERROR = "is_null";

    public static ValidationError nullError(String parent, String attribute) {
        return new ValidationError(parent, attribute, NULL_ERROR);
    }

    public static ValidationError nullError(String attribute) {
        return new ValidationError("", attribute, NULL_ERROR);
    }

    public ValidationError(String parent, String attribute, String errorType) {
        this.attribute = concatenate(parent, attribute);
        this.errorType = errorType;
    }

    public static String concatenate(String parent, String attribute) {
        return parent == null || parent.isEmpty() ? attribute : parent + "." + attribute;
    }

    public boolean isSameAs(String attribute, String errorType) {
        return this.attribute.equals(attribute) && this.errorType.equals(errorType);
    }

    public boolean isNullError(String attribute) {
        return isSameAs(attribute, NULL_ERROR);
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
