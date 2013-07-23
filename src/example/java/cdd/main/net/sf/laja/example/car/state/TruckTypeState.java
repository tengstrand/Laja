package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.stateconverter.StateConversion.asInt;

@State
public class TruckTypeState implements ImmutableState {
    public final int numberOfWheels;
    public final String truckName;

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String NUMBER_OF_WHEELS = "numberOfWheels";
    public static final String TRUCK_NAME = "truckName";

    public TruckTypeState(
            int numberOfWheels,
            String truckName) {
        this.numberOfWheels = numberOfWheels;
        this.truckName = truckName;

        if (truckName == null) throw new InvalidTruckTypeStateException("'truckName' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidTruckTypeStateException(message);
        }
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
                truckName);
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
                ", truckName='" + truckName + "'}";
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

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public int getNumberOfWheels() { return numberOfWheels; }
        public String getTruckName() { return truckName; }

        public void setNumberOfWheels(int numberOfWheels) { this.numberOfWheels = numberOfWheels; }
        public void setTruckName(String truckName) { this.truckName = truckName; }

        public TruckTypeMutableState withNumberOfWheels(int numberOfWheels) { this.numberOfWheels = numberOfWheels; return this; }
        public TruckTypeMutableState withTruckName(String truckName) { this.truckName = truckName; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidTruckTypeStateException(errors);
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
            if (truckName == null) errors.addIsNullError(rootElement, parent, "truckName");

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public TruckTypeState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new TruckTypeState(
                    numberOfWheels,
                    truckName);
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
                    ", truckName='" + truckName + "'}";
        }
    }

    @State(type = "string")
    public static class TruckTypeStringState {
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

        public TruckTypeMutableState asMutable() {
            return asMutable(new TruckTypeStringStateConverter());
        }

        public TruckTypeMutableState asMutable(TruckTypeStringStateConverter converter) {
            return new TruckTypeMutableState(
                    converter.toNumberOfWheels(numberOfWheels),
                    converter.toTruckName(truckName));
        }
    }

    public static class TruckTypeStringStateConverter {
        public int toNumberOfWheels(String numberOfWheels) { return asInt(numberOfWheels); }
        public String toTruckName(String truckName) { return truckName; }
    }
}
