package net.sf.laja.example.person.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.stateconverter.StringConverter;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.testgen.MutableStringState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.stateconverter.StateConversion.asInt;

@State
public class BmiState implements ImmutableState {
    public final int heightInCentimeters;
    public final int weightInKilograms;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String HEIGHT_IN_CENTIMETERS = "heightInCentimeters";
    public static final String WEIGHT_IN_KILOGRAMS = "weightInKilograms";

    public BmiState(
            int heightInCentimeters,
            int weightInKilograms) {
        this.heightInCentimeters = heightInCentimeters;
        this.weightInKilograms = weightInKilograms;

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidBmiStateException(message);
        }
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
                weightInKilograms);
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

        public int getHeightInCentimeters() { return heightInCentimeters; }
        public int getWeightInKilograms() { return weightInKilograms; }

        public void setHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; }
        public void setWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; }

        public BmiMutableState withHeightInCentimeters(int heightInCentimeters) { this.heightInCentimeters = heightInCentimeters; return this; }
        public BmiMutableState withWeightInKilograms(int weightInKilograms) { this.weightInKilograms = weightInKilograms; return this; }

        public BmiState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new BmiState(
                    heightInCentimeters,
                    weightInKilograms);
        }

        public BmiStringState asStringState() {
            return asStringState(new StringConverter());
        }

        public BmiStringState asStringState(StringConverter c) {
            return new BmiStringState(
                    c.intToString(heightInCentimeters),
                    c.intToString(weightInKilograms));
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

    @State(type = "string")
    public static class BmiStringState implements MutableStringState {
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

        public BmiMutableState asMutable() {
            return asMutable(new BmiStringStateConverter());
        }

        public BmiMutableState asMutable(BmiStringStateConverter converter) {
            return new BmiMutableState(
                    converter.toHeightInCentimeters(heightInCentimeters),
                    converter.toWeightInKilograms(weightInKilograms));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new BmiStringStateConverter(), validators);
        }

        public ValidationErrors validate(BmiStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateConverter, this, "", errors, validators);
            return errors.build();
        }

        public void validate(BmiStringStateConverter stateConverter, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateConverter.validateHeightInCentimeters(heightInCentimeters, rootElement, parent, errors);
            stateConverter.validateWeightInKilograms(weightInKilograms, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new BmiStringStateConverter(), validators);
        }

        public void assertIsValid(BmiStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors errors = validate(stateConverter, validators);

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
        public int toHeightInCentimeters(String heightInCentimeters) { return asInt(heightInCentimeters); }
        public int toWeightInKilograms(String weightInKilograms) { return asInt(weightInKilograms); }

        public void validateHeightInCentimeters(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try {
                toHeightInCentimeters(value);
            } catch (Exception e) {
                errors.addTypeConversionError(rootElement, parent, "heightInCentimeters");
            }
        }

        public void validateWeightInKilograms(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try {
                toWeightInKilograms(value);
            } catch (Exception e) {
                errors.addTypeConversionError(rootElement, parent, "weightInKilograms");
            }
        }
    }
}
