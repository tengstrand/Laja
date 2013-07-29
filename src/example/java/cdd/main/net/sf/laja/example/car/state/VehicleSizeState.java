package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.converter.StringConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.state.converter.StateConversion.asInt;

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

        public int getLengthInCentimeters() { return lengthInCentimeters; }

        public void setLengthInCentimeters(int lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; }

        public VehicleSizeMutableState withLengthInCentimeters(int lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; return this; }

        public VehicleSizeState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new VehicleSizeState(lengthInCentimeters);
        }

        public VehicleSizeStringState asStringState() {
            return asStringState(new StringConverter());
        }

        public VehicleSizeStringState asStringState(StringConverter c) {
            return new VehicleSizeStringState(c.intToString(lengthInCentimeters));
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
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

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidVehicleSizeStateException(errors);
            }
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

    @State(type = "string")
    public static class VehicleSizeStringState implements MutableStringState {
        public String lengthInCentimeters;

        public VehicleSizeStringState() {
        }

        public VehicleSizeStringState(String lengthInCentimeters) {
            this.lengthInCentimeters = lengthInCentimeters;
        }

        public String getLengthInCentimeters() { return lengthInCentimeters; }

        public void setLengthInCentimeters(String lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; }

        public VehicleSizeStringState withLengthInCentimeters(String lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; return this; }

        public VehicleSizeState asImmutable() {
            return asMutable().asImmutable();
        }

        public VehicleSizeMutableState asMutable() {
            return asMutable(new VehicleSizeStringStateConverter());
        }

        public VehicleSizeMutableState asMutable(VehicleSizeStringStateConverter converter) {
            return new VehicleSizeMutableState(
                    converter.toLengthInCentimeters(lengthInCentimeters));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new VehicleSizeStringStateConverter(), validators);
        }

        public ValidationErrors validate(VehicleSizeStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateConverter, this, "", errors, validators);
            return errors.build();
        }

        public void validate(VehicleSizeStringStateConverter stateConverter, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateConverter.validateLengthInCentimeters(lengthInCentimeters, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new VehicleSizeStringStateConverter(), validators);
        }

        public void assertIsValid(VehicleSizeStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors errors = validate(stateConverter, validators);

            if (errors.isInvalid()) {
                throw new InvalidVehicleSizeStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = lengthInCentimeters != null ? lengthInCentimeters.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            VehicleSizeStringState state = (VehicleSizeStringState)that;

            if (lengthInCentimeters != null ? !lengthInCentimeters.equals(state.lengthInCentimeters) : state.lengthInCentimeters != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{lengthInCentimeters=" + lengthInCentimeters + "}";
        }
    }

    public static class VehicleSizeStringStateConverter {
        public int toLengthInCentimeters(String lengthInCentimeters) { return asInt(lengthInCentimeters); }

        public void validateLengthInCentimeters(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try {
                toLengthInCentimeters(value);
            } catch (Exception e) {
                errors.addTypeConversionError(rootElement, parent, "lengthInCentimeters");
            }
        }
    }
}
