package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StateConverter;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.example.car.state.OwnerState.*;
import static net.sf.laja.example.car.state.VehicleSizeState.*;

@State
public class CarState implements ImmutableState {
    public final VehicleSizeState size;
    public final String name;
    public final OwnerState owner;
    public final String color;

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
                size != null ? size.asMutable() : null,
                name,
                owner != null ? owner.asMutable() : null,
                color);
    }

    public CarStringState asStringState() {
        return asMutable().asStringState();
    }

    public CarStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public CarStringState asStringState(CarStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
                ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                ", owner=" + owner +
                ", color=" + (color == null ? null : '\"' + color + '\"' ) + "}";
    }

    @State(type = "mutable")
    public static class CarMutableState implements MutableState {
        public VehicleSizeMutableState size;
        public String name;
        public OwnerMutableState owner;
        public String color;

        public CarMutableState() {
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

        public CarMutableState(CarMutableState state) {
            size = state.size;
            name = state.name;
            owner = state.owner;
            color = state.color;
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

        public CarState asImmutable() {
            assertIsValid();

            return new CarState(
                    size != null ? size.asImmutable() : null,
                    name,
                    owner != null ? owner.asImmutable() : null,
                    color);
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("size", size != null ? size.asMap() : null);
            result.put("name", name);
            result.put("owner", owner != null ? owner.asMap() : null);
            result.put("color", color);

            return result;
        }

        public CarStringState asStringState() {
            return asStringState(new CarStringStateConverter());
        }

        public CarStringState asStringState(StringStateConverter converter) {
            return asStringState(new CarStringStateConverter(converter));
        }

        public CarStringState asStringState(CarStringStateConverter converter) {
            return new CarStringState(
                    converter.sizeToString(size),
                    converter.nameToString(name),
                    converter.ownerToString(owner),
                    converter.colorToString(color));
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
            if (size == null) errors.addIsNullError(rootElement, "size", parent);
            if (name == null) errors.addIsNullError(rootElement, "name", parent);
            if (owner == null) errors.addIsNullError(rootElement, "owner", parent);
            if (color == null) errors.addIsNullError(rootElement, "color", parent);

            if (size != null) size.validate(rootElement, concatenate(parent, "size"), errors);
            if (owner != null) owner.validate(rootElement, concatenate(parent, "owner"), errors);

        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidCarStateException(errors);
            }
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
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", owner=" + owner +
                    ", color=" + (color == null ? null : '\"' + color + '\"' ) + "}";
        }
    }

    public static MapToCarConverter mapToCarConverter = new MapToCarConverter();

    public static CarMutableState toCarMutableState(Map map) {
        return mapToCarConverter.convert(map, 0);
    }

    public static class MapToCarConverter implements StateConverter {

        public CarMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            Map size = (Map) map.get("size");
            String name = (String) map.get("name");
            Map owner = (Map) map.get("owner");
            String color = (String) map.get("color");

            return new CarMutableState(
                    size != null ? toVehicleSizeMutableState(size) : null,
                    name,
                    owner != null ? toOwnerMutableState(owner) : null,
                    color
            );
        }
    }

    @State(type = "string")
    public static class CarStringState implements StringState {
        public VehicleSizeStringState size;
        public String name;
        public OwnerStringState owner;
        public String color;

        public CarStringState() {
        }

        public CarStringState(
                VehicleSizeStringState size,
                String name,
                OwnerStringState owner,
                String color) {
            this.size = size;
            this.name = name;
            this.owner = owner;
            this.color = color;
        }

        public VehicleSizeStringState getSize() { return size; }
        public String getName() { return name; }
        public OwnerStringState getOwner() { return owner; }
        public String getColor() { return color; }

        public void setSize(VehicleSizeStringState size) { this.size = size; }
        public void setName(String name) { this.name = name; }
        public void setOwner(OwnerStringState owner) { this.owner = owner; }
        public void setColor(String color) { this.color = color; }

        public CarStringState withSize(VehicleSizeStringState size) { this.size = size; return this; }
        public CarStringState withName(String name) { this.name = name; return this; }
        public CarStringState withOwner(OwnerStringState owner) { this.owner = owner; return this; }
        public CarStringState withColor(String color) { this.color = color; return this; }

        public CarState asImmutable() {
            return asMutable().asImmutable();
        }

        public CarMutableState asMutable() {
            return asMutable(new CarStringStateConverter());
        }

        public CarMutableState asMutable(CarStringStateConverter converter) {
            return new CarMutableState(
                    converter.toSize(size),
                    converter.toName(name),
                    converter.toOwner(owner),
                    converter.toColor(color));
        }

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new CarStringStateValidator());
        }

        public ValidationErrors validate(CarStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(CarStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateSize(size, rootElement, parent, errors);
            stateValidator.validateName(name, rootElement, parent, errors);
            stateValidator.validateOwner(owner, rootElement, parent, errors);
            stateValidator.validateColor(color, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new CarStringStateValidator());
        }

        public void assertIsValid(CarStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidCarStateException(errors);
            }
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

            CarStringState state = (CarStringState)that;

            if (size != null ? !size.equals(state.size) : state.size != null) return false;
            if (name != null ? !name.equals(state.name) : state.name != null) return false;
            if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;
            if (color != null ? !color.equals(state.color) : state.color != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{size=" + size +
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", owner=" + owner +
                    ", color=" + (color == null ? null : '\"' + color + '\"' ) + "}";
        }
    }

    public static class CarStringStateConverter {
        private final StringStateConverter converter;

        public CarStringStateConverter() { converter = new StringStateConverter(); }
        public CarStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public VehicleSizeStringState sizeToString(VehicleSizeMutableState size) { return size != null ? size.asStringState(converter) : null; }
        public String nameToString(String name) { return name; }
        public OwnerStringState ownerToString(OwnerMutableState owner) { return owner != null ? owner.asStringState(converter) : null; }
        public String colorToString(String color) { return color; }

        public VehicleSizeMutableState toSize(VehicleSizeStringState size) { return size != null ? size.asMutable() : null; }
        public String toName(String name) { return name; }
        public OwnerMutableState toOwner(OwnerStringState owner) { return owner != null ? owner.asMutable() : null; }
        public String toColor(String color) { return color; }
    }

    public static class CarStringStateValidator {
        private final CarStringStateConverter converter;

        public CarStringStateValidator() { converter = new CarStringStateConverter(); }
        public CarStringStateValidator(CarStringStateConverter converter) { this.converter = converter; }

        public void validateSize(VehicleSizeStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toSize(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "size", parent); }
        }

        public void validateName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateOwner(OwnerStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toOwner(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "owner", parent); }
        }

        public void validateColor(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
