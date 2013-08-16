package net.sf.laja.example.person.state;

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
public class BmiState implements ImmutableState {
    public final int heightInCentimeters;
    public final int weightInKilograms;

    // ===== Generated code =====

    public static final String HEIGHT_IN_CENTIMETERS = "heightInCentimeters";
    public static final String WEIGHT_IN_KILOGRAMS = "weightInKilograms";

    public BmiState(
            int heightInCentimeters,
            int weightInKilograms) {
        this.heightInCentimeters = heightInCentimeters;
        this.weightInKilograms = weightInKilograms;
    }

    public static class InvalidBmiStateException extends InvalidStateException {
        public InvalidBmiStateException(String message) {
            super(message);
        }

        public InvalidBmiStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getHeightInCentimeters() { return heightInCentimeters; }
    public int getWeightInKilograms() { return weightInKilograms; }

    public BmiState withHeightInCentimeters(int heightInCentimeters) { return new BmiState(heightInCentimeters, weightInKilograms); }
    public BmiState withWeightInKilograms(int weightInKilograms) { return new BmiState(heightInCentimeters, weightInKilograms); }

    public BmiMutableState asMutable() {
        return new BmiMutableState(
                heightInCentimeters,
                weightInKilograms
        );
    }

    public BmiStringState asStringState() {
        return asMutable().asStringState();
    }

    public BmiStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public BmiStringState asStringState(BmiStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = heightInCentimeters;
        result = 31 * result + weightInKilograms;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        BmiState state = (BmiState)that;

        if (heightInCentimeters != state.heightInCentimeters) return false;
        if (weightInKilograms != state.weightInKilograms) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{heightInCentimeters=" + heightInCentimeters +
                ", weightInKilograms=" + weightInKilograms + '}';
    }

    @State(type = "mutable")
    public static class BmiMutableState implements MutableState {
        public int heightInCentimeters;
        public int weightInKilograms;

        public BmiMutableState() {
        }

        public BmiMutableState(
                int heightInCentimeters,
                int weightInKilograms) {
            this.heightInCentimeters = heightInCentimeters;
            this.weightInKilograms = weightInKilograms;
        }

        public BmiMutableState(BmiMutableState state) {
            heightInCentimeters = state.heightInCentimeters;
            weightInKilograms = state.weightInKilograms;
        }

        public int getHeightInCentimeters() { return heightInCentimeters; }
        public int getWeightInKilograms() { return weightInKilograms; }

        public void setHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
        public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public BmiMutableState withHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; return this; }
        public BmiMutableState withWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public BmiState asImmutable() {
            assertIsValid();

            return new BmiState(
                    heightInCentimeters,
                    weightInKilograms
            );
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("heightInCentimeters", heightInCentimeters);
            result.put("weightInKilograms", weightInKilograms);

            return result;
        }

        public BmiStringState asStringState() {
            return asStringState(new BmiStringStateConverter());
        }

        public BmiStringState asStringState(StringStateConverter converter) {
            return asStringState(new BmiStringStateConverter(converter));
        }

        public BmiStringState asStringState(BmiStringStateConverter converter) {
            return new BmiStringState(
                    converter.heightInCentimetersToString(heightInCentimeters),
                    converter.weightInKilogramsToString(weightInKilograms)
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
        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidBmiStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = heightInCentimeters;
            result = 31 * result + weightInKilograms;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            BmiMutableState state = (BmiMutableState)that;

            if (heightInCentimeters != state.heightInCentimeters) return false;
            if (weightInKilograms != state.weightInKilograms) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{heightInCentimeters=" + heightInCentimeters +
                    ", weightInKilograms=" + weightInKilograms + '}';
        }
    }

    public static MapToBmiConverter mapToBmiConverter = new MapToBmiConverter();

    public static BmiMutableState toBmiMutableState(Map map) {
        return mapToBmiConverter.convert(map, 0);
    }

    public static class MapToBmiConverter implements StateConverter {

        public BmiMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            int heightInCentimeters = (Integer) map.get("heightInCentimeters");
            int weightInKilograms = (Integer) map.get("weightInKilograms");

            return new BmiMutableState(
                    heightInCentimeters,
                    weightInKilograms
            );
        }
    }

    @State(type = "string")
    public static class BmiStringState implements StringState {
        public String heightInCentimeters;
        public String weightInKilograms;

        public BmiStringState() {
        }

        public BmiStringState(
                String heightInCentimeters,
                String weightInKilograms) {
            this.heightInCentimeters = heightInCentimeters;
            this.weightInKilograms = weightInKilograms;
        }

        public String getHeightInCentimeters() { return heightInCentimeters; }
        public String getWeightInKilograms() { return weightInKilograms; }

        public void setHeightInCentimeters(String heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
        public void setWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public BmiStringState withHeightInCentimeters(String heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; return this; }
        public BmiStringState withWeightInKilograms(String weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public BmiState asImmutable() {
            return asMutable().asImmutable();
        }

        public BmiState asImmutable(BmiStringStateConverter converter) {
            return asMutable(converter).asImmutable();
        }

        public BmiMutableState asMutable() {
            return asMutable(new BmiStringStateConverter());
        }

        public BmiMutableState asMutable(BmiStringStateConverter converter) {
            return new BmiMutableState(
                    converter.toHeightInCentimeters(heightInCentimeters),
                    converter.toWeightInKilograms(weightInKilograms)
            );
        }

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new BmiStringStateValidator());
        }

        public ValidationErrors validate(BmiStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(BmiStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateHeightInCentimeters(heightInCentimeters, rootElement, parent, errors);
            stateValidator.validateWeightInKilograms(weightInKilograms, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new BmiStringStateValidator());
        }

        public void assertIsValid(BmiStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidBmiStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = heightInCentimeters != null ? heightInCentimeters.hashCode() : 0;
            result = 31 * result + (weightInKilograms != null ? weightInKilograms.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            BmiStringState state = (BmiStringState)that;

            if (heightInCentimeters != null ? !heightInCentimeters.equals(state.heightInCentimeters) : state.heightInCentimeters != null) return false;
            if (weightInKilograms != null ? !weightInKilograms.equals(state.weightInKilograms) : state.weightInKilograms != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{heightInCentimeters=" + (heightInCentimeters == null ? null : '\"' + heightInCentimeters + '\"' ) +
                    ", weightInKilograms=" + (weightInKilograms == null ? null : '\"' + weightInKilograms + '\"' ) + "}";
        }
    }

    public static class BmiStringStateConverter {
        private final StringStateConverter converter;

        public BmiStringStateConverter() { converter = new StringStateConverter(); }
        public BmiStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String heightInCentimetersToString(int heightInCentimeters) { return converter.intToString(heightInCentimeters); }
        public String weightInKilogramsToString(int weightInKilograms) { return converter.intToString(weightInKilograms); }

        public int toHeightInCentimeters(String heightInCentimeters) { return converter.toInt(heightInCentimeters); }
        public int toWeightInKilograms(String weightInKilograms) { return converter.toInt(weightInKilograms); }
    }

    public static class BmiStringStateValidator {
        private final BmiStringStateConverter converter;

        public BmiStringStateValidator() { converter = new BmiStringStateConverter(); }
        public BmiStringStateValidator(BmiStringStateConverter converter) { this.converter = converter; }

        public void validateHeightInCentimeters(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toHeightInCentimeters(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "heightInCentimeters", parent); }
        }

        public void validateWeightInKilograms(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toWeightInKilograms(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "weightInKilograms", parent); }
        }
    }
}
