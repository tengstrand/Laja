package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.car.state.OwnerState.OwnerMutableState;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;

@State
public class CarState implements ImmutableState {
    public final VehicleSizeState size;
    public final String name;
    public final OwnerState owner;
    public final String color;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String SIZE = "size";
    public static final String NAME = "name";
    public static final String OWNER = "owner";
    public static final String COLOR = "color";

    public CarState(
            VehicleSizeState size,
            String name,
            OwnerState owner,
            String color) {
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.color = color;

        if (size == null) throw new InvalidCarStateException("'size' can not be null");
        if (name == null) throw new InvalidCarStateException("'name' can not be null");
        if (owner == null) throw new InvalidCarStateException("'owner' can not be null");
        if (color == null) throw new InvalidCarStateException("'color' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidCarStateException(message);
        }
    }

    public static class InvalidCarStateException extends InvalidStateException {
        public InvalidCarStateException(String message) {
            super(message);
        }

        public InvalidCarStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public VehicleSizeState getSize() { return size; }
    public String getName() { return name; }
    public OwnerState getOwner() { return owner; }
    public String getColor() { return color; }

    public CarState withSize(VehicleSizeState size) { return new CarState(size, name, owner, color); }
    public CarState withName(String name) { return new CarState(size, name, owner, color); }
    public CarState withOwner(OwnerState owner) { return new CarState(size, name, owner, color); }
    public CarState withColor(String color) { return new CarState(size, name, owner, color); }

    public CarMutableState asMutable() {
        return new CarMutableState(
                size.asMutable(),
                name,
                owner.asMutable(),
                color);
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        CarState state = (CarState)that;

        if (size != null ? !size.equals(state.size) : state.size != null) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{size=" + size +
                ", name=" + (name == null ? null : '\'' + name + '\'' ) +
                ", owner=" + owner +
                ", color='" + color + "'}";
    }

    @State(type = "mutable")
    public static class CarMutableState implements MutableState {
        public VehicleSizeMutableState size;
        public String name;
        public OwnerMutableState owner;
        public String color;

        public CarMutableState() {
            size = new VehicleSizeMutableState();
            owner = new OwnerMutableState();
        }

        public CarMutableState(
                VehicleSizeMutableState size,
                String name,
                OwnerMutableState owner,
                String color) {
            this.size = size;
            this.name = name;
            this.owner = owner;
            this.color = color;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public VehicleSizeMutableState getSize() { return size; }
        public String getName() { return name; }
        public OwnerMutableState getOwner() { return owner; }
        public String getColor() { return color; }

        public void setSize(VehicleSizeMutableState size) { this.size = size; }
        public void setName(String name) { this.name = name; }
        public void setOwner(OwnerMutableState owner) { this.owner = owner; }
        public void setColor(String color) { this.color = color; }

        public CarMutableState withSize(VehicleSizeMutableState size) { this.size = size; return this; }
        public CarMutableState withName(String name) { this.name = name; return this; }
        public CarMutableState withOwner(OwnerMutableState owner) { this.owner = owner; return this; }
        public CarMutableState withColor(String color) { this.color = color; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidCarStateException(errors);
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
            if (name == null) errors.addIsNullError(rootElement, parent, "name");
            if (owner == null) errors.addIsNullError(rootElement, parent, "owner");
            if (color == null) errors.addIsNullError(rootElement, parent, "color");

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);
            if (owner != null) owner.validate(rootElement, concatenate(parent, "owner"), errors);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public CarState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new CarState(
                    size != null ? size.asImmutable() : null,
                    name,
                    owner != null ? owner.asImmutable() : null,
                    color);
        }

        @Override
        public int hashCode() {
            int result = size != null ? size.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (owner != null ? owner.hashCode() : 0);
            result = 31 * result + (color != null ? color.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            CarMutableState state = (CarMutableState)that;

            if (size != null ? !size.equals(state.size) : state.size != null) return false;
            if (name != null ? !name.equals(state.name) : state.name != null) return false;
            if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;
            if (color != null ? !color.equals(state.color) : state.color != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{size=" + size +
                    ", name=" + (name == null ? null : '\'' + name + '\'' ) +
                    ", owner=" + owner +
                    ", color='" + color + "'}";
        }
    }
}
