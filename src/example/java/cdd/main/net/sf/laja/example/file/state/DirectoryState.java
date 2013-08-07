package net.sf.laja.example.file.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MapState;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

@State
public class DirectoryState implements ImmutableState {
    public final String directoryPath;

    // ===== Generated code =====

    public static final String DIRECTORY_PATH = "directoryPath";

    public DirectoryState(String directoryPath) {
        this.directoryPath = directoryPath;

        if (directoryPath == null) throw new InvalidDirectoryStateException("'directoryPath' can not be null");
    }

    public static class InvalidDirectoryStateException extends InvalidStateException {
        public InvalidDirectoryStateException(String message) {
            super(message);
        }

        public InvalidDirectoryStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public String getDirectoryPath() { return directoryPath; }

    public DirectoryState withDirectoryPath(String directoryPath) { return new DirectoryState(directoryPath); }

    public DirectoryMutableState asMutable() {
        return new DirectoryMutableState(directoryPath);
    }

    public DirectoryStringState asStringState() {
        return asMutable().asStringState();
    }

    public DirectoryStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public DirectoryStringState asStringState(DirectoryStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = directoryPath != null ? directoryPath.hashCode() : 0;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        DirectoryState state = (DirectoryState)that;

        if (directoryPath != null ? !directoryPath.equals(state.directoryPath) : state.directoryPath != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{directoryPath=" + directoryPath + "}";
    }

    @State(type = "mutable")
    public static class DirectoryMutableState implements MutableState {
        public String directoryPath;

        public DirectoryMutableState() {
        }

        public DirectoryMutableState(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public String getDirectoryPath() { return directoryPath; }

        public void setDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; }

        public DirectoryMutableState withDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; return this; }

        public DirectoryState asImmutable() {
            assertIsValid();

            return new DirectoryState(directoryPath);
        }

        public DirectoryStringState asStringState() {
            return asStringState(new DirectoryStringStateConverter());
        }

        public DirectoryStringState asStringState(StringStateConverter converter) {
            return asStringState(new DirectoryStringStateConverter(converter));
        }

        public DirectoryStringState asStringState(DirectoryStringStateConverter converter) {
            return new DirectoryStringState(converter.directoryPathToString(directoryPath));
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
            if (directoryPath == null) errors.addIsNullError(rootElement, "directoryPath", parent);

        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidDirectoryStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = directoryPath != null ? directoryPath.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            DirectoryMutableState state = (DirectoryMutableState)that;

            if (directoryPath != null ? !directoryPath.equals(state.directoryPath) : state.directoryPath != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{directoryPath=" + directoryPath + "}";
        }
    }

    @State(type = "map")
    public static class DirectoryMapState extends MapState {

        public DirectoryMapState() {
        }

        public DirectoryMapState(String directoryPath) {
            put("directoryPath", directoryPath);
        }

        public String getDirectoryPath() { return (String) get("directoryPath"); }

        public void setDirectoryPath(String directoryPath) { put("directoryPath", directoryPath); }

        public DirectoryMapState withDirectoryPath(String directoryPath) { put("directoryPath", directoryPath); return this; }

        public DirectoryState asImmutable() {
            return asMutable().asImmutable();
        }

        public DirectoryMutableState asMutable() {
            return new DirectoryMutableState(
                    getDirectoryPath());
        }
    }

    @State(type = "string")
    public static class DirectoryStringState implements StringState {
        public String directoryPath;

        public DirectoryStringState() {
        }

        public DirectoryStringState(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public String getDirectoryPath() { return directoryPath; }

        public void setDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; }

        public DirectoryStringState withDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; return this; }

        public DirectoryState asImmutable() {
            return asMutable().asImmutable();
        }

        public DirectoryMutableState asMutable() {
            return asMutable(new DirectoryStringStateConverter());
        }

        public DirectoryMutableState asMutable(DirectoryStringStateConverter converter) {
            return new DirectoryMutableState(
                    converter.toDirectoryPath(directoryPath));
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new DirectoryStringStateValidator());
        }

        public ValidationErrors validate(DirectoryStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(DirectoryStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateDirectoryPath(directoryPath, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new DirectoryStringStateValidator());
        }

        public void assertIsValid(DirectoryStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidDirectoryStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = directoryPath != null ? directoryPath.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            DirectoryStringState state = (DirectoryStringState)that;

            if (directoryPath != null ? !directoryPath.equals(state.directoryPath) : state.directoryPath != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{directoryPath=" + directoryPath + "}";
        }
    }

    public static class DirectoryStringStateConverter {
        private final StringStateConverter converter;

        public DirectoryStringStateConverter() { converter = new StringStateConverter(); }
        public DirectoryStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String directoryPathToString(String directoryPath) { return directoryPath; }

        public String toDirectoryPath(String directoryPath) { return directoryPath; }
    }

    public static class DirectoryStringStateValidator {
        private final DirectoryStringStateConverter converter;

        public DirectoryStringStateValidator() { converter = new DirectoryStringStateConverter(); }
        public DirectoryStringStateValidator(DirectoryStringStateConverter converter) { this.converter = converter; }

        public void validateDirectoryPath(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
