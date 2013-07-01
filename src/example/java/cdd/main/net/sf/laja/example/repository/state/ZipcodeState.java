package net.sf.laja.example.repository.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class ZipcodeState implements ImmutableState {
    public final int zipcode;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String ZIPCODE = "zipcode";

    public ZipcodeState(int zipcode) {
        this.zipcode = zipcode;

        assertIsValid();
    }

    public static class IllegalZipcodeStateException extends InvalidStateException {
        public IllegalZipcodeStateException(String message) {
            super(message);
        }

        public IllegalZipcodeStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getZipcode() { return zipcode; }

    public ZipcodeState withZipcode(int zipcode) { return new ZipcodeState(zipcode); }

    public ZipcodeMutableState asMutable() {
        return new ZipcodeMutableState(zipcode);
    }

    @Override
    public int hashCode() {
        int result = zipcode;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        ZipcodeState state = (ZipcodeState)that;

        if (zipcode != state.zipcode) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{zipcode=" + zipcode + "}";
    }

    @State(type = "mutable")
    public static class ZipcodeMutableState implements MutableState {
        public int zipcode;

        public ZipcodeMutableState() {
        }

        public ZipcodeMutableState(int zipcode) {
            this.zipcode = zipcode;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public int getZipcode() { return zipcode; }

        public void setZipcode(int zipcode) { this.zipcode = zipcode; }

        public ZipcodeMutableState withZipcode(int zipcode) { this.zipcode = zipcode; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new IllegalZipcodeStateException(errors);
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
            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public ZipcodeState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new ZipcodeState(zipcode);
        }

        @Override
        public int hashCode() {
            int result = zipcode;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            ZipcodeMutableState state = (ZipcodeMutableState)that;

            if (zipcode != state.zipcode) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{zipcode=" + zipcode + "}";
        }
    }
}
