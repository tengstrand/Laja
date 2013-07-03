package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class VehicleSizeState implements ImmutableState {
    public final int lengthInCentimeters;

    public void assertIsValid() {
        assertThat(lengthInCentimeters >= 0, "Length must be a value >= 0");
    }

    // ===== Generated code =====

    public static final String LENGTH_IN_CENTIMETERS = "lengthInCentimeters";

    public VehicleSizeState(int lengthInCentimeters) {
        this.lengthInCentimeters = lengthInCentimeters;

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidVehicleSizeStateException(message);
        }
    }

    public static class InvalidVehicleSizeStateException extends InvalidStateException {
        public InvalidVehicleSizeStateException(String message) {
            super(message);
        }

        public InvalidVehicleSizeStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getLengthInCentimeters() { return lengthInCentimeters; }

    public VehicleSizeState withLengthInCentimeters(int lengthInCentimeters) { return new VehicleSizeState(lengthInCentimeters); }

    public VehicleSizeMutableState asMutable() {
        return new VehicleSizeMutableState(lengthInCentimeters);
    }

    @Override
    public int hashCode() {
        int result = lengthInCentimeters;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        VehicleSizeState state = (VehicleSizeState)that;

        if (lengthInCentimeters != state.lengthInCentimeters) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{lengthInCentimeters=" + lengthInCentimeters + "}";
    }

    @State(type = "mutable")
    public static class VehicleSizeMutableState implements MutableState {
        public int lengthInCentimeters;

        public VehicleSizeMutableState() {
        }

        public VehicleSizeMutableState(int lengthInCentimeters) {
            this.lengthInCentimeters = lengthInCentimeters;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public int getLengthInCentimeters() { return lengthInCentimeters; }

        public void setLengthInCentimeters(int lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; }

        public VehicleSizeMutableState withLengthInCentimeters(int lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidVehicleSizeStateException(errors);
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

        public VehicleSizeState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new VehicleSizeState(lengthInCentimeters);
        }

        @Override
        public int hashCode() {
            int result = lengthInCentimeters;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            VehicleSizeMutableState state = (VehicleSizeMutableState)that;

            if (lengthInCentimeters != state.lengthInCentimeters) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{lengthInCentimeters=" + lengthInCentimeters + "}";
        }
    }
}
