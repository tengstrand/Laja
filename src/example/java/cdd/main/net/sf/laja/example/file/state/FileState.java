package net.sf.laja.example.file.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class FileState implements ImmutableState {
    public final String filename;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String FILENAME = "filename";

    public FileState(String filename) {
        this.filename = filename;

        if (filename == null) throw new InvalidFileStateException("'filename' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidFileStateException(message);
        }
    }

    public static class InvalidFileStateException extends InvalidStateException {
        public InvalidFileStateException(String message) {
            super(message);
        }

        public InvalidFileStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public String getFilename() { return filename; }

    public FileState withFilename(String filename) { return new FileState(filename); }

    public FileMutableState asMutable() {
        return new FileMutableState(filename);
    }

    @Override
    public int hashCode() {
        int result = filename != null ? filename.hashCode() : 0;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        FileState state = (FileState)that;

        if (filename != null ? !filename.equals(state.filename) : state.filename != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{filename=" + filename + "}";
    }

    @State(type = "mutable")
    public static class FileMutableState implements MutableState {
        public String filename;

        public FileMutableState() {
        }

        public FileMutableState(String filename) {
            this.filename = filename;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public String getFilename() { return filename; }

        public void setFilename(String filename) { this.filename = filename; }

        public FileMutableState withFilename(String filename) { this.filename = filename; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidFileStateException(errors);
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
            if (filename == null) errors.addIsNullError(rootElement, parent, "filename");

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public FileState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new FileState(filename);
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            FileMutableState state = (FileMutableState)that;

            if (filename != null ? !filename.equals(state.filename) : state.filename != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{filename=" + filename + "}";
        }
    }

    @State(type = "string")
    public static class FileStringState {
        public String filename;

        public FileStringState() {
        }

        public FileStringState(String filename) {
            this.filename = filename;
        }

        public String getFilename() { return filename; }

        public void setFilename(String filename) { this.filename = filename; }

        public FileStringState withFilename(String filename) { this.filename = filename; return this; }

        public FileState asImmutable() {
            return asMutable().asImmutable();
        }

        public FileMutableState asMutable() {
            return asMutable(new FileStringStateConverter());
        }

        public FileMutableState asMutable(FileStringStateConverter converter) {
            return new FileMutableState(
                    converter.toFilename(filename));
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            FileStringState state = (FileStringState)that;

            if (filename != null ? !filename.equals(state.filename) : state.filename != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{filename=" + filename + "}";
        }
    }

    public static class FileStringStateConverter {
        public String toFilename(String filename) { return filename; }
    }
}
