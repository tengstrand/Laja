package net.sf.laja.example.file.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

@State
public class FileState implements ImmutableState {
    public final String filename;

    // ===== Generated code =====

    public static final String FILENAME = "filename";

    public FileState(String filename) {
        this.filename = filename;

        if (filename == null) throw new InvalidFileStateException("'filename' can not be null");
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

    public FileStringState asStringState() {
        return asMutable().asStringState();
    }

    public FileStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public FileStringState asStringState(FileStringStateConverter converter) {
        return asMutable().asStringState(converter);
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

        public String getFilename() { return filename; }

        public void setFilename(String filename) { this.filename = filename; }

        public FileMutableState withFilename(String filename) { this.filename = filename; return this; }

        public FileState asImmutable() {
            assertIsValid();

            return new FileState(filename);
        }

        public FileStringState asStringState() {
            return asStringState(new FileStringStateConverter());
        }

        public FileStringState asStringState(StringStateConverter converter) {
            return asStringState(new FileStringStateConverter(converter));
        }

        public FileStringState asStringState(FileStringStateConverter converter) {
            return new FileStringState(converter.filenameToString(filename));
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
            if (filename == null) errors.addIsNullError(rootElement, "filename", parent);

        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidFileStateException(errors);
            }
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
    public static class FileStringState implements StringState {
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

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new FileStringStateValidator());
        }

        public ValidationErrors validate(FileStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(FileStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateFilename(filename, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new FileStringStateValidator());
        }

        public void assertIsValid(FileStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidFileStateException(errors);
            }
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
        private final StringStateConverter converter;

        public FileStringStateConverter() { converter = new StringStateConverter(); }
        public FileStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String filenameToString(String filename) { return filename; }

        public String toFilename(String filename) { return filename; }
    }

    public static class FileStringStateValidator {
        private final FileStringStateConverter converter;

        public FileStringStateValidator() { converter = new FileStringStateConverter(); }
        public FileStringStateValidator(FileStringStateConverter converter) { this.converter = converter; }

        public void validateFilename(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
