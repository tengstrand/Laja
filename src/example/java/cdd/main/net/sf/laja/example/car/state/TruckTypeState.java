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

@State
public class TruckTypeState implements ImmutableState {
    public final int numberOfWheels;
    public final String truckName;

    // ===== Generated code =====

    public static final String NUMBER_OF_WHEELS = "numberOfWheels";
    public static final String TRUCK_NAME = "truckName";

    public TruckTypeState(
            int numberOfWheels,
            String truckName) {
        this.numberOfWheels = numberOfWheels;
        this.truckName = truckName;

        if (truckName == null) throw new InvalidTruckTypeStateException("'truckName' can not be null");
    }

    public static class InvalidTruckTypeStateException extends InvalidStateException {
        public InvalidTruckTypeStateException(String message) {
            super(message);
        }

        public InvalidTruckTypeStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getNumberOfWheels() { return numberOfWheels; }
    public String getTruckName() { return truckName; }

    public TruckTypeState withNumberOfWheels(int numberOfWheels) { return new TruckTypeState(numberOfWheels, truckName); }
    public TruckTypeState withTruckName(String truckName) { return new TruckTypeState(numberOfWheels, truckName); }

    public TruckTypeMutableState asMutable() {
        return new TruckTypeMutableState(
                numberOfWheels,
                truckName
        );
    }

    public TruckTypeStringState asStringState() {
        return asMutable().asStringState();
    }

    public TruckTypeStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public TruckTypeStringState asStringState(TruckTypeStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = numberOfWheels;
        result = 31 * result + (truckName != null ? truckName.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        TruckTypeState state = (TruckTypeState)that;

        if (numberOfWheels != state.numberOfWheels) return false;
        if (truckName != null ? !truckName.equals(state.truckName) : state.truckName != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{numberOfWheels=" + numberOfWheels +
                ", truckName=" + (truckName == null ? null : '\"' + truckName + '\"' ) + "}";
    }

    @State(type = "mutable")
    public static class TruckTypeMutableState implements MutableState {
        public int numberOfWheels;
        public String truckName;

        public TruckTypeMutableState() {
        }

        public TruckTypeMutableState(
                int numberOfWheels,
                String truckName) {
            this.numberOfWheels = numberOfWheels;
            this.truckName = truckName;
        }

        public TruckTypeMutableState(TruckTypeMutableState state) {
            numberOfWheels = state.numberOfWheels;
            truckName = state.truckName;
        }

        public int getNumberOfWheels() { return numberOfWheels; }
        public String getTruckName() { return truckName; }

        public void setNumberOfWheels(int numberOfWheels) { this.numberOfWheels = numberOfWheels; }
        public void setTruckName(String truckName) { this.truckName = truckName; }

        public TruckTypeMutableState withNumberOfWheels(int numberOfWheels) { this.numberOfWheels = numberOfWheels; return this; }
        public TruckTypeMutableState withTruckName(String truckName) { this.truckName = truckName; return this; }

        public TruckTypeState asImmutable() {
            assertIsValid();

            return new TruckTypeState(
                    numberOfWheels,
                    truckName
            );
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("numberOfWheels", numberOfWheels);
            result.put("truckName", truckName);

            return result;
        }

        public TruckTypeStringState asStringState() {
            return asStringState(new TruckTypeStringStateConverter());
        }

        public TruckTypeStringState asStringState(StringStateConverter converter) {
            return asStringState(new TruckTypeStringStateConverter(converter));
        }

        public TruckTypeStringState asStringState(TruckTypeStringStateConverter converter) {
            return new TruckTypeStringState(
                    converter.numberOfWheelsToString(numberOfWheels),
                    converter.truckNameToString(truckName)
            );
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
            if (truckName == null) errors.addIsNullError(rootElement, "truckName", parent);

        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidTruckTypeStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = numberOfWheels;
            result = 31 * result + (truckName != null ? truckName.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            TruckTypeMutableState state = (TruckTypeMutableState)that;

            if (numberOfWheels != state.numberOfWheels) return false;
            if (truckName != null ? !truckName.equals(state.truckName) : state.truckName != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{numberOfWheels=" + numberOfWheels +
                    ", truckName=" + (truckName == null ? null : '\"' + truckName + '\"' ) + "}";
        }
    }

    public static MapToTruckTypeConverter mapToTruckTypeConverter = new MapToTruckTypeConverter();

    public static TruckTypeMutableState toTruckTypeMutableState(Map map) {
        return mapToTruckTypeConverter.convert(map, 0);
    }

    public static class MapToTruckTypeConverter implements StateConverter {

        public TruckTypeMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            int numberOfWheels = (Integer) map.get("numberOfWheels");
            String truckName = (String) map.get("truckName");

            return new TruckTypeMutableState(
                    numberOfWheels,
                    truckName
            );
        }
    }

    @State(type = "string")
    public static class TruckTypeStringState implements StringState {
        public String numberOfWheels;
        public String truckName;

        public TruckTypeStringState() {
        }

        public TruckTypeStringState(
                String numberOfWheels,
                String truckName) {
            this.numberOfWheels = numberOfWheels;
            this.truckName = truckName;
        }

        public String getNumberOfWheels() { return numberOfWheels; }
        public String getTruckName() { return truckName; }

        public void setNumberOfWheels(String numberOfWheels) { this.numberOfWheels = numberOfWheels; }
        public void setTruckName(String truckName) { this.truckName = truckName; }

        public TruckTypeStringState withNumberOfWheels(String numberOfWheels) { this.numberOfWheels = numberOfWheels; return this; }
        public TruckTypeStringState withTruckName(String truckName) { this.truckName = truckName; return this; }

        public TruckTypeState asImmutable() {
            return asMutable().asImmutable();
        }

        public TruckTypeState asImmutable(TruckTypeStringStateConverter converter) {
            return asMutable(converter).asImmutable();
        }

        public TruckTypeMutableState asMutable() {
            return asMutable(new TruckTypeStringStateConverter());
        }

        public TruckTypeMutableState asMutable(TruckTypeStringStateConverter converter) {
            return new TruckTypeMutableState(
                    converter.toNumberOfWheels(numberOfWheels),
                    converter.toTruckName(truckName)
            );
        }

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new TruckTypeStringStateValidator());
        }

        public ValidationErrors validate(TruckTypeStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(TruckTypeStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateNumberOfWheels(numberOfWheels, rootElement, parent, errors);
            stateValidator.validateTruckName(truckName, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new TruckTypeStringStateValidator());
        }

        public void assertIsValid(TruckTypeStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidTruckTypeStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = numberOfWheels != null ? numberOfWheels.hashCode() : 0;
            result = 31 * result + (truckName != null ? truckName.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            TruckTypeStringState state = (TruckTypeStringState)that;

            if (numberOfWheels != null ? !numberOfWheels.equals(state.numberOfWheels) : state.numberOfWheels != null) return false;
            if (truckName != null ? !truckName.equals(state.truckName) : state.truckName != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{numberOfWheels=" + (numberOfWheels == null ? null : '\"' + numberOfWheels + '\"' ) +
                    ", truckName=" + (truckName == null ? null : '\"' + truckName + '\"' ) + "}";
        }
    }

    public static class TruckTypeStringStateConverter {
        private final StringStateConverter converter;

        public TruckTypeStringStateConverter() { converter = new StringStateConverter(); }
        public TruckTypeStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String numberOfWheelsToString(int numberOfWheels) { return converter.intToString(numberOfWheels); }
        public String truckNameToString(String truckName) { return truckName; }

        public int toNumberOfWheels(String numberOfWheels) { return converter.toInt(numberOfWheels); }
        public String toTruckName(String truckName) { return truckName; }
    }

    public static class TruckTypeStringStateValidator {
        private final TruckTypeStringStateConverter converter;

        public TruckTypeStringStateValidator() { converter = new TruckTypeStringStateConverter(); }
        public TruckTypeStringStateValidator(TruckTypeStringStateConverter converter) { this.converter = converter; }

        public void validateNumberOfWheels(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toNumberOfWheels(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "numberOfWheels", parent); }
        }

        public void validateTruckName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
