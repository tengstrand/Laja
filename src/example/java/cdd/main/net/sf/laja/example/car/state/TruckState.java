package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.stateconverter.StateConversion.asInt;
import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.car.state.OwnerState.OwnerMutableState;
import static net.sf.laja.example.car.state.OwnerState.OwnerStringState;
import static net.sf.laja.example.car.state.TruckTypeState.TruckTypeMutableState;
import static net.sf.laja.example.car.state.TruckTypeState.TruckTypeStringState;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeStringState;

@State
public class TruckState implements ImmutableState {
    public final VehicleSizeState size;
    public final int weightInKilograms;
    public final TruckTypeState type;
    public final String color;
    public final OwnerState owner;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String SIZE = "size";
    public static final String WEIGHT_IN_KILOGRAMS = "weightInKilograms";
    public static final String TYPE = "type";
    public static final String COLOR = "color";
    public static final String OWNER = "owner";

    public TruckState(
            VehicleSizeState size,
            int weightInKilograms,
            TruckTypeState type,
            String color,
            OwnerState owner) {
        this.size = size;
        this.weightInKilograms = weightInKilograms;
        this.type = type;
        this.color = color;
        this.owner = owner;

        if (size == null) throw new InvalidTruckStateException("'size' can not be null");
        if (type == null) throw new InvalidTruckStateException("'type' can not be null");
        if (color == null) throw new InvalidTruckStateException("'color' can not be null");
        if (owner == null) throw new InvalidTruckStateException("'owner' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidTruckStateException(message);
        }
    }

    public static class InvalidTruckStateException extends InvalidStateException {
        public InvalidTruckStateException(String message) {
            super(message);
        }

        public InvalidTruckStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public VehicleSizeState getSize() { return size; }
    public int getWeightInKilograms() { return weightInKilograms; }
    public TruckTypeState getType() { return type; }
    public String getColor() { return color; }
    public OwnerState getOwner() { return owner; }

    public TruckState withSize(VehicleSizeState size) { return new TruckState(size, weightInKilograms, type, color, owner); }
    public TruckState withWeightInKilograms(int weightInKilograms) { return new TruckState(size, weightInKilograms, type, color, owner); }
    public TruckState withType(TruckTypeState type) { return new TruckState(size, weightInKilograms, type, color, owner); }
    public TruckState withColor(String color) { return new TruckState(size, weightInKilograms, type, color, owner); }
    public TruckState withOwner(OwnerState owner) { return new TruckState(size, weightInKilograms, type, color, owner); }

    public TruckMutableState asMutable() {
        return new TruckMutableState(
                size.asMutable(),
                weightInKilograms,
                type.asMutable(),
                color,
                owner.asMutable());
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + weightInKilograms;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        TruckState state = (TruckState)that;

        if (size != null ? !size.equals(state.size) : state.size != null) return false;
        if (weightInKilograms != state.weightInKilograms) return false;
        if (type != null ? !type.equals(state.type) : state.type != null) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{size=" + size +
                ", weightInKilograms=" + weightInKilograms +
                ", type=" + type +
                ", color=" + (color == null ? null : '\'' + color + '\'' ) +
                ", owner=" + owner + '}';
    }

    @State(type = "mutable")
    public static class TruckMutableState implements MutableState {
        public VehicleSizeMutableState size;
        public int weightInKilograms;
        public TruckTypeMutableState type;
        public String color;
        public OwnerMutableState owner;

        public TruckMutableState() {
        }

        public TruckMutableState(
                VehicleSizeMutableState size,
                int weightInKilograms,
                TruckTypeMutableState type,
                String color,
                OwnerMutableState owner) {
            this.size = size;
            this.weightInKilograms = weightInKilograms;
            this.type = type;
            this.color = color;
            this.owner = owner;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public VehicleSizeMutableState getSize() { return size; }
        public int getWeightInKilograms() { return weightInKilograms; }
        public TruckTypeMutableState getType() { return type; }
        public String getColor() { return color; }
        public OwnerMutableState getOwner() { return owner; }

        public void setSize(VehicleSizeMutableState size) { this.size = size; }
        public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }
        public void setType(TruckTypeMutableState type) { this.type = type; }
        public void setColor(String color) { this.color = color; }
        public void setOwner(OwnerMutableState owner) { this.owner = owner; }

        public TruckMutableState withSize(VehicleSizeMutableState size) { this.size = size; return this; }
        public TruckMutableState withWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }
        public TruckMutableState withType(TruckTypeMutableState type) { this.type = type; return this; }
        public TruckMutableState withColor(String color) { this.color = color; return this; }
        public TruckMutableState withOwner(OwnerMutableState owner) { this.owner = owner; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidTruckStateException(errors);
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
            if (size == null) errors.addIsNullError(rootElement, parent, "size");
            if (type == null) errors.addIsNullError(rootElement, parent, "type");
            if (color == null) errors.addIsNullError(rootElement, parent, "color");
            if (owner == null) errors.addIsNullError(rootElement, parent, "owner");

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);
            if (type != null) type.validate(rootElement, concatenate(parent, "type"), errors);
            if (owner != null) owner.validate(rootElement, concatenate(parent, "owner"), errors);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public TruckState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new TruckState(
                    size != null ? size.asImmutable() : null,
                    weightInKilograms,
                    type != null ? type.asImmutable() : null,
                    color,
                    owner != null ? owner.asImmutable() : null);
        }

        @Override
        public int hashCode() {
            int result = size != null ? size.hashCode() : 0;
            result = 31 * result + weightInKilograms;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            result = 31 * result + (color != null ? color.hashCode() : 0);
            result = 31 * result + (owner != null ? owner.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            TruckMutableState state = (TruckMutableState)that;

            if (size != null ? !size.equals(state.size) : state.size != null) return false;
            if (weightInKilograms != state.weightInKilograms) return false;
            if (type != null ? !type.equals(state.type) : state.type != null) return false;
            if (color != null ? !color.equals(state.color) : state.color != null) return false;
            if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{size=" + size +
                    ", weightInKilograms=" + weightInKilograms +
                    ", type=" + type +
                    ", color=" + (color == null ? null : '\'' + color + '\'' ) +
                    ", owner=" + owner + '}';
        }
    }

    @State(type = "string")
    public static class TruckStringState {
        public VehicleSizeStringState size;
        public String weightInKilograms;
        public TruckTypeStringState type;
        public String color;
        public OwnerStringState owner;

        public TruckStringState() {
        }

        public TruckStringState(
                VehicleSizeStringState size,
                String weightInKilograms,
                TruckTypeStringState type,
                String color,
                OwnerStringState owner) {
            this.size = size;
            this.weightInKilograms = weightInKilograms;
            this.type = type;
            this.color = color;
            this.owner = owner;
        }

        public VehicleSizeStringState getSize() { return size; }
        public String getWeightInKilograms() { return weightInKilograms; }
        public TruckTypeStringState getType() { return type; }
        public String getColor() { return color; }
        public OwnerStringState getOwner() { return owner; }

        public void setSize(VehicleSizeStringState size) { this.size = size; }
        public void setWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; }
        public void setType(TruckTypeStringState type) { this.type = type; }
        public void setColor(String color) { this.color = color; }
        public void setOwner(OwnerStringState owner) { this.owner = owner; }

        public TruckStringState withSize(VehicleSizeStringState size) { this.size = size; return this; }
        public TruckStringState withWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }
        public TruckStringState withType(TruckTypeStringState type) { this.type = type; return this; }
        public TruckStringState withColor(String color) { this.color = color; return this; }
        public TruckStringState withOwner(OwnerStringState owner) { this.owner = owner; return this; }

        public TruckState asImmutable() {
            return asMutable().asImmutable();
        }

        public TruckMutableState asMutable() {
            return asMutable(new TruckStringStateConverter());
        }

        public TruckMutableState asMutable(TruckStringStateConverter converter) {
            return new TruckMutableState(
                    converter.toSize(size),
                    converter.toWeightInKilograms(weightInKilograms),
                    converter.toType(type),
                    converter.toColor(color),
                    converter.toOwner(owner));
        }
    }

    public static class TruckStringStateConverter {
        public VehicleSizeMutableState toSize(VehicleSizeStringState size) { return size != null ? size.asMutable() : null; }
        public int toWeightInKilograms(String weightInKilograms) { return asInt(weightInKilograms); }
        public TruckTypeMutableState toType(TruckTypeStringState type) { return type != null ? type.asMutable() : null; }
        public String toColor(String color) { return color; }
        public OwnerMutableState toOwner(OwnerStringState owner) { return owner != null ? owner.asMutable() : null; }
    }
}
