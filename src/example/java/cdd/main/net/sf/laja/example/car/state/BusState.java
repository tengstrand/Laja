package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeStringState;

@State
public class BusState implements ImmutableState {
    public final String name;
    public final VehicleSizeState size;
    @Optional public final int weightInKilograms;

    // ===== Generated code =====

    public static final String NAME = "name";
    public static final String SIZE = "size";
    public static final String WEIGHT_IN_KILOGRAMS = "weightInKilograms";

    public BusState(
            String name,
            VehicleSizeState size,
            int weightInKilograms) {
        this.name = name;
        this.size = size;
        this.weightInKilograms = weightInKilograms;

        if (name == null) throw new InvalidBusStateException("'name' can not be null");
        if (size == null) throw new InvalidBusStateException("'size' can not be null");
    }

    public static class InvalidBusStateException extends InvalidStateException {
        public InvalidBusStateException(String message) {
            super(message);
        }

        public InvalidBusStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public String getName() { return name; }
    public VehicleSizeState getSize() { return size; }
    public int getWeightInKilograms() { return weightInKilograms; }

    public BusState withName(String name) { return new BusState(name, size, weightInKilograms); }
    public BusState withSize(VehicleSizeState size) { return new BusState(name, size, weightInKilograms); }
    public BusState withWeightInKilograms(int weightInKilograms) { return new BusState(name, size, weightInKilograms); }

    public BusMutableState asMutable() {
        return new BusMutableState(
                name,
                size != null ? size.asMutable() : null,
                weightInKilograms);
    }

    public BusStringState asStringState() {
        return asMutable().asStringState();
    }

    public BusStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public BusStringState asStringState(BusStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + weightInKilograms;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        BusState state = (BusState)that;

        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (size != null ? !size.equals(state.size) : state.size != null) return false;
        if (weightInKilograms != state.weightInKilograms) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{name=" + (name == null ? null : '\"' + name + '\"' ) +
                ", size=" + size +
                ", weightInKilograms=" + weightInKilograms + '}';
    }

    @State(type = "mutable")
    public static class BusMutableState implements MutableState {
        public String name;
        public VehicleSizeMutableState size;
        @Optional public int weightInKilograms;

        public BusMutableState() {
        }

        public BusMutableState(
                String name,
                VehicleSizeMutableState size,
                int weightInKilograms) {
            this.name = name;
            this.size = size;
            this.weightInKilograms = weightInKilograms;
        }

        public String getName() { return name; }
        public VehicleSizeMutableState getSize() { return size; }
        public int getWeightInKilograms() { return weightInKilograms; }

        public void setName(String name) { this.name = name; }
        public void setSize(VehicleSizeMutableState size) { this.size = size; }
        public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public BusMutableState withName(String name) { this.name = name; return this; }
        public BusMutableState withSize(VehicleSizeMutableState size) { this.size = size; return this; }
        public BusMutableState withWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public BusState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new BusState(
                    name,
                    size != null ? size.asImmutable() : null,
                    weightInKilograms);
        }

        public BusStringState asStringState() {
            return asStringState(new BusStringStateConverter());
        }

        public BusStringState asStringState(StringStateConverter converter) {
            return asStringState(new BusStringStateConverter(converter));
        }

        public BusStringState asStringState(BusStringStateConverter converter) {
            return new BusStringState(
                    converter.nameToString(name),
                    converter.sizeToString(size),
                    converter.weightInKilogramsToString(weightInKilograms));
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
            if (name == null) errors.addIsNullError(rootElement, "name", parent);
            if (size == null) errors.addIsNullError(rootElement, "size", parent);

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidBusStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (size != null ? size.hashCode() : 0);
            result = 31 * result + weightInKilograms;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            BusMutableState state = (BusMutableState)that;

            if (name != null ? !name.equals(state.name) : state.name != null) return false;
            if (size != null ? !size.equals(state.size) : state.size != null) return false;
            if (weightInKilograms != state.weightInKilograms) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", size=" + size +
                    ", weightInKilograms=" + weightInKilograms + '}';
        }
    }

    @State(type = "string")
    public static class BusStringState implements StringState {
        public String name;
        public VehicleSizeStringState size;
        @Optional public String weightInKilograms;

        public BusStringState() {
        }

        public BusStringState(
                String name,
                VehicleSizeStringState size,
                String weightInKilograms) {
            this.name = name;
            this.size = size;
            this.weightInKilograms = weightInKilograms;
        }

        public String getName() { return name; }
        public VehicleSizeStringState getSize() { return size; }
        public String getWeightInKilograms() { return weightInKilograms; }

        public void setName(String name) { this.name = name; }
        public void setSize(VehicleSizeStringState size) { this.size = size; }
        public void setWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public BusStringState withName(String name) { this.name = name; return this; }
        public BusStringState withSize(VehicleSizeStringState size) { this.size = size; return this; }
        public BusStringState withWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public BusState asImmutable() {
            return asMutable().asImmutable();
        }

        public BusMutableState asMutable() {
            return asMutable(new BusStringStateConverter());
        }

        public BusMutableState asMutable(BusStringStateConverter converter) {
            return new BusMutableState(
                    converter.toName(name),
                    converter.toSize(size),
                    converter.toWeightInKilograms(weightInKilograms));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new BusStringStateValidator(), validators);
        }

        public ValidationErrors validate(BusStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(BusStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateName(name, rootElement, parent, errors);
            stateValidator.validateSize(size, rootElement, parent, errors);
            stateValidator.validateWeightInKilograms(weightInKilograms, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new BusStringStateValidator(), validators);
        }

        public void assertIsValid(BusStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

            if (errors.isInvalid()) {
                throw new InvalidBusStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (size != null ? size.hashCode() : 0);
            result = 31 * result + (weightInKilograms != null ? weightInKilograms.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            BusStringState state = (BusStringState)that;

            if (name != null ? !name.equals(state.name) : state.name != null) return false;
            if (size != null ? !size.equals(state.size) : state.size != null) return false;
            if (weightInKilograms != null ? !weightInKilograms.equals(state.weightInKilograms) : state.weightInKilograms != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", size=" + size +
                    ", weightInKilograms=" + (weightInKilograms == null ? null : '\"' + weightInKilograms + '\"' ) + "}";
        }
    }

    public static class BusStringStateConverter {
        private final StringStateConverter converter;

        public BusStringStateConverter() { converter = new StringStateConverter(); }
        public BusStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String nameToString(String name) { return name; }
        public VehicleSizeStringState sizeToString(VehicleSizeMutableState size) { return size != null ? size.asStringState(converter) : null; }
        public String weightInKilogramsToString(int weightInKilograms) { return converter.intToString(weightInKilograms); }

        public String toName(String name) { return name; }
        public VehicleSizeMutableState toSize(VehicleSizeStringState size) { return size != null ? size.asMutable() : null; }
        public int toWeightInKilograms(String weightInKilograms) { return converter.toInt(weightInKilograms); }
    }

    public static class BusStringStateValidator {
        private final BusStringStateConverter converter;

        public BusStringStateValidator() { converter = new BusStringStateConverter(); }
        public BusStringStateValidator(BusStringStateConverter converter) { this.converter = converter; }

        public void validateName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateSize(VehicleSizeStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toSize(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "size", parent); }
        }

        public void validateWeightInKilograms(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toWeightInKilograms(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "weightInKilograms", parent); }
        }
    }
}
