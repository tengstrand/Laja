package net.sf.laja.example.car.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.StateValidator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class OwnerState implements ImmutableState {
    public final long ssn;
    public final String name;

    public static class OwnerValidator extends StateValidator {
        public OwnerValidator(Object rootElement) { super(rootElement); }
        public OwnerValidator(Object rootElement, String parent, ValidationErrors.Builder errors) { super(rootElement, parent, errors); }

        public void validate(OwnerState state) {
            validateSsn(state.ssn);
        }

        public void validate(OwnerMutableState state) {
            validateSsn(state.ssn);
        }

        private void validateSsn(long ssn) {
            if (ssn < 190000000000L) {
                addError(SSN, "ssn-before-1900");
            }
        }
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

        OwnerValidator validator = new OwnerValidator(this);

        if (!validator.isValid()) {
            throw new InvalidOwnerStateException(validator.errors());
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

    public OwnerStringState asStringState() {
        return asMutable().asStringState();
    }

    public OwnerStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public OwnerStringState asStringState(OwnerStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
            return asStringState(new OwnerStringStateConverter());
        }

        public OwnerStringState asStringState(StringStateConverter converter) {
            return asStringState(new OwnerStringStateConverter(converter));
        }

        public OwnerStringState asStringState(OwnerStringStateConverter converter) {
            return new OwnerStringState(
                    converter.ssnToString(ssn),
                    converter.nameToString(name));
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
            if (name == null) errors.addIsNullError(rootElement, "name", parent);

            new OwnerValidator(rootElement, parent, errors).validate(this);

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
            return validate(new OwnerStringStateValidator(), validators);
        }

        public ValidationErrors validate(OwnerStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(OwnerStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateSsn(ssn, rootElement, parent, errors);
            stateValidator.validateName(name, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new OwnerStringStateValidator(), validators);
        }

        public void assertIsValid(OwnerStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

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
        private final StringStateConverter c;

        public OwnerStringStateConverter() { c = new StringStateConverter(); }
        public OwnerStringStateConverter(StringStateConverter converter) { c = converter; }

        public String ssnToString(long ssn) { return c.longToString(ssn); }
        public String nameToString(String name) { return name; }

        public long toSsn(String ssn) { return c.toLong(ssn); }
        public String toName(String name) { return name; }
    }

    public static class OwnerStringStateValidator {
        private final OwnerStringStateConverter c;

        public OwnerStringStateValidator() { this.c = new OwnerStringStateConverter(); }
        public OwnerStringStateValidator(OwnerStringStateConverter converter) { this.c = converter; }

        public void validateSsn(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { c.toSsn(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "ssn", parent); }
        }

        public void validateName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }
    }
}
