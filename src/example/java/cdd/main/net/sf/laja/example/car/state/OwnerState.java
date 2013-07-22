package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.stateconverter.StateConversion.asLongPrimitive;

@State
public class OwnerState implements ImmutableState {
    public final long ssn;
    public final String name;

    public void assertIsValid() {
        assertThat(ssn >= 190000000000L, "SSN must be >= 1900...");
    }

    // ===== Generated code =====

    public static final String SSN = "ssn";
    public static final String NAME = "name";

    public OwnerState(
            long ssn,
            String name) {
        this.ssn = ssn;
        this.name = name;

        if (name == null) throw new InvalidOwnerStateException("'name' can not be null");

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidOwnerStateException(message);
        }
    }

    public static class InvalidOwnerStateException extends InvalidStateException {
        public InvalidOwnerStateException(String message) {
            super(message);
        }

        public InvalidOwnerStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public long getSsn() { return ssn; }
    public String getName() { return name; }

    public OwnerState withSsn(long ssn) { return new OwnerState(ssn, name); }
    public OwnerState withName(String name) { return new OwnerState(ssn, name); }

    public OwnerMutableState asMutable() {
        return new OwnerMutableState(
                ssn,
                name);
    }

    @Override
    public int hashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        OwnerState state = (OwnerState)that;

        if (ssn != state.ssn) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", name='" + name + "'}";
    }

    @State(type = "mutable")
    public static class OwnerMutableState implements MutableState {
        public long ssn;
        public String name;

        public OwnerMutableState() {
        }

        public OwnerMutableState(
                long ssn,
                String name) {
            this.ssn = ssn;
            this.name = name;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public long getSsn() { return ssn; }
        public String getName() { return name; }

        public void setSsn(long ssn) { this.ssn = ssn; }
        public void setName(String name) { this.name = name; }

        public OwnerMutableState withSsn(long ssn) { this.ssn = ssn; return this; }
        public OwnerMutableState withName(String name) { this.name = name; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidOwnerStateException(errors);
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

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public OwnerState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new OwnerState(
                    ssn,
                    name);
        }

        @Override
        public int hashCode() {
            int result = (int)(ssn ^ (ssn >>> 32));
            result = 31 * result + (name != null ? name.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            OwnerMutableState state = (OwnerMutableState)that;

            if (ssn != state.ssn) return false;
            if (name != null ? !name.equals(state.name) : state.name != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{ssn=" + ssn +
                    ", name='" + name + "'}";
        }
    }

    @State(type = "string")
    public static class OwnerStringState {
        public String ssn;
        public String name;

        public OwnerStringState() {
        }

        public OwnerStringState(
                String ssn,
                String name) {
            this.ssn = ssn;
            this.name = name;
        }

        public String getSsn() { return ssn; }
        public String getName() { return name; }

        public void setSsn(String ssn) { this.ssn = ssn; }
        public void setName(String name) { this.name = name; }

        public OwnerStringState withSsn(String ssn) { this.ssn = ssn; return this; }
        public OwnerStringState withName(String name) { this.name = name; return this; }

        public OwnerMutableState asMutable() {
            return asMutable(new OwnerStringStateConverter());
        }

        public OwnerMutableState asMutable(OwnerStringStateConverter converter) {
            return new OwnerMutableState(
                    converter.toSsn(ssn),
                    converter.toName(name));
        }
    }

    public static class OwnerStringStateConverter {
        public long toSsn(String ssn) { return asLongPrimitive(ssn); }
        public String toName(String name) { return name; }
    }
}
