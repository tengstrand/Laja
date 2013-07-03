package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;

@State
public class BusState implements ImmutableState {
    public final String name;
    public final VehicleSizeState size;
    @Optional public final int weightInKilograms;

    public void assertIsValid() {
    }

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

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidBusStateException(message);
        }
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
                size.asMutable(),
                weightInKilograms);
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
        return "{name=" + (name == null ? null : '\'' + name + '\'' ) +
                ", size=" + size +
                ", weightInKilograms=" + weightInKilograms + '}';
    }

    @State(type = "mutable")
    public static class BusMutableState implements MutableState {
        public String name;
        public VehicleSizeMutableState size;
        @Optional public int weightInKilograms;

        public BusMutableState() {
            size = new VehicleSizeMutableState();
        }

        public BusMutableState(
                String name,
                VehicleSizeMutableState size,
                int weightInKilograms) {
            this.name = name;
            this.size = size;
            this.weightInKilograms = weightInKilograms;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
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

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidBusStateException(errors);
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
            if (name == null) errors.addIsNullError(rootElement, parent, "name");
            if (size == null) errors.addIsNullError(rootElement, parent, "size");

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public BusState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new BusState(
                    name,
                    size != null ? size.asImmutable() : null,
                    weightInKilograms);
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
            return "{name=" + (name == null ? null : '\'' + name + '\'' ) +
                    ", size=" + size +
                    ", weightInKilograms=" + weightInKilograms + '}';
        }
    }
}
