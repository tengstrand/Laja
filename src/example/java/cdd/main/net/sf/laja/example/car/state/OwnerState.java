package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.converter.StringConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.state.converter.StateConversion.asLongPrimitive;

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
                ", name=" + (name == null ? null : '\"' + name + '\"' ) + "}";
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

        public long getSsn() { return ssn; }
        public String getName() { return name; }

        public void setSsn(long ssn) { this.ssn = ssn; }
        public void setName(String name) { this.name = name; }

        public OwnerMutableState withSsn(long ssn) { this.ssn = ssn; return this; }
        public OwnerMutableState withName(String name) { this.name = name; return this; }

        public OwnerState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new OwnerState(
                    ssn,
                    name);
        }

        public OwnerStringState asStringState() {
            return asStringState(new StringConverter());
        }

        public OwnerStringState asStringState(StringConverter c) {
            return new OwnerStringState(
                    c.longToString(ssn),
                    name);
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
            if (name == null) errors.addIsNullError(rootElement, parent, "name");

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidOwnerStateException(errors);
            }
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
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) + "}";
        }
    }

    @State(type = "string")
    public static class OwnerStringState implements MutableStringState {
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

        public OwnerState asImmutable() {
            return asMutable().asImmutable();
        }

        public OwnerMutableState asMutable() {
            return asMutable(new OwnerStringStateConverter());
        }

        public OwnerMutableState asMutable(OwnerStringStateConverter converter) {
            return new OwnerMutableState(
                    converter.toSsn(ssn),
                    converter.toName(name));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new OwnerStringStateConverter(), validators);
        }

        public ValidationErrors validate(OwnerStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateConverter, this, "", errors, validators);
            return errors.build();
        }

        public void validate(OwnerStringStateConverter stateConverter, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateConverter.validateSsn(ssn, rootElement, parent, errors);
            stateConverter.validateName(name, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new OwnerStringStateConverter(), validators);
        }

        public void assertIsValid(OwnerStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors errors = validate(stateConverter, validators);

            if (errors.isInvalid()) {
                throw new InvalidOwnerStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = ssn != null ? ssn.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            OwnerStringState state = (OwnerStringState)that;

            if (ssn != null ? !ssn.equals(state.ssn) : state.ssn != null) return false;
            if (name != null ? !name.equals(state.name) : state.name != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{ssn=" + (ssn == null ? null : '\"' + ssn + '\"' ) +
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) + "}";
        }
    }

    public static class OwnerStringStateConverter {
        public long toSsn(String ssn) { return asLongPrimitive(ssn); }
        public String toName(String name) { return name; }

        public void validateSsn(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try {
                toSsn(value);
            } catch (Exception e) {
                errors.addTypeConversionError(rootElement, parent, "ssn");
            }
        }

        public void validateName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
