package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MapState;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

@State
public class VehicleSizeState implements ImmutableState {
    public final int lengthInCentimeters;

    // ===== Generated code =====

    public static final String LENGTH_IN_CENTIMETERS = "lengthInCentimeters";

    public VehicleSizeState(int lengthInCentimeters) {
        this.lengthInCentimeters = lengthInCentimeters;
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

    public VehicleSizeStringState asStringState() {
        return asMutable().asStringState();
    }

    public VehicleSizeStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public VehicleSizeStringState asStringState(VehicleSizeStringStateConverter converter) {
        return asMutable().asStringState(converter);
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

        public VehicleSizeState asImmutable() {
            assertIsValid();

            return new VehicleSizeState(lengthInCentimeters);
        }

        public VehicleSizeStringState asStringState() {
            return asStringState(new VehicleSizeStringStateConverter());
        }

        public VehicleSizeStringState asStringState(StringStateConverter converter) {
            return asStringState(new VehicleSizeStringStateConverter(converter));
        }

        public VehicleSizeStringState asStringState(VehicleSizeStringStateConverter converter) {
            return new VehicleSizeStringState(converter.lengthInCentimetersToString(lengthInCentimeters));
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
        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

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

    @State(type = "map")
    public static class VehicleSizeMapState extends MapState {

        public VehicleSizeMapState() {
            put("lengthInCentimeters", 0);
        }

        public VehicleSizeMapState(int lengthInCentimeters) {
            put("lengthInCentimeters", lengthInCentimeters);
        }

        public int getLengthInCentimeters() { return (Integer) get("lengthInCentimeters"); }

        public void setLengthInCentimeters(int lengthInCentimeters) { put("lengthInCentimeters", lengthInCentimeters); }

        public VehicleSizeMapState withLengthInCentimeters(int lengthInCentimeters) { put("lengthInCentimeters", lengthInCentimeters); return this; }

        public VehicleSizeState asImmutable() {
            return asMutable().asImmutable();
        }

        public VehicleSizeMutableState asMutable() {
            return new VehicleSizeMutableState(
                    getLengthInCentimeters());
        }
    }

    @State(type = "string")
    public static class VehicleSizeStringState implements StringState {
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

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new VehicleSizeStringStateValidator());
        }

        public ValidationErrors validate(VehicleSizeStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(VehicleSizeStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateLengthInCentimeters(lengthInCentimeters, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new VehicleSizeStringStateValidator());
        }

        public void assertIsValid(VehicleSizeStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

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
        private final StringStateConverter converter;

        public VehicleSizeStringStateConverter() { converter = new StringStateConverter(); }
        public VehicleSizeStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String lengthInCentimetersToString(int lengthInCentimeters) { return converter.intToString(lengthInCentimeters); }

        public int toLengthInCentimeters(String lengthInCentimeters) { return converter.toInt(lengthInCentimeters); }
    }

    public static class VehicleSizeStringStateValidator {
        private final VehicleSizeStringStateConverter converter;

        public VehicleSizeStringStateValidator() { converter = new VehicleSizeStringStateConverter(); }
        public VehicleSizeStringStateValidator(VehicleSizeStringStateConverter converter) { this.converter = converter; }

        public void validateLengthInCentimeters(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toLengthInCentimeters(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "lengthInCentimeters", parent); }
        }
    }
}
