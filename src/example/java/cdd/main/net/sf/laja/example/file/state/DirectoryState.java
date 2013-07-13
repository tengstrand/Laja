package net.sf.laja.example.file.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class DirectoryState implements ImmutableState {
    public final String directoryPath;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String DIRECTORY_PATH = "directoryPath";

    public DirectoryState(String directoryPath) {
        this.directoryPath = directoryPath;

        if (directoryPath == null) throw new InvalidDirectoryStateException("'directoryPath' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidDirectoryStateException(message);
        }
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

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public String getDirectoryPath() { return directoryPath; }

        public void setDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; }

        public DirectoryMutableState withDirectoryPath(String directoryPath) { this.directoryPath = directoryPath; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidDirectoryStateException(errors);
            }
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors, validators);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            if (directoryPath == null) errors.addIsNullError(rootElement, parent, "directoryPath");

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public DirectoryState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new DirectoryState(directoryPath);
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
}