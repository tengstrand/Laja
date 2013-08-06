package net.sf.laja.example.repository.state;

import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class ZipcodeState implements ImmutableState {
    public final int code;

    // ===== Generated code =====

    public static final String CODE = "code";

    public ZipcodeState(int code) {
        this.code = code;
    }

    public static class InvalidZipcodeStateException extends InvalidStateException {
        public InvalidZipcodeStateException(String message) {
            super(message);
        }

        public InvalidZipcodeStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getCode() { return code; }

    public ZipcodeState withCode(int code) { return new ZipcodeState(code); }

    public ZipcodeMutableState asMutable() {
        return new ZipcodeMutableState(code);
    }

    public ZipcodeStringState asStringState() {
        return asMutable().asStringState();
    }

    public ZipcodeStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public ZipcodeStringState asStringState(ZipcodeStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = code;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        ZipcodeState state = (ZipcodeState)that;

        if (code != state.code) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{code=" + code + "}";
    }

    @State(type = "mutable")
    public static class ZipcodeMutableState implements MutableState {
        public int code;

        public ZipcodeMutableState() {
        }

        public ZipcodeMutableState(int code) {
            this.code = code;
        }

        public int getCode() { return code; }

        public void setCode(int code) { this.code = code; }

        public ZipcodeMutableState withCode(int code) { this.code = code; return this; }

        public ZipcodeState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new ZipcodeState(code);
        }

        public ZipcodeStringState asStringState() {
            return asStringState(new ZipcodeStringStateConverter());
        }

        public ZipcodeStringState asStringState(StringStateConverter converter) {
            return asStringState(new ZipcodeStringStateConverter(converter));
        }

        public ZipcodeStringState asStringState(ZipcodeStringStateConverter converter) {
            return new ZipcodeStringState(converter.codeToString(code));
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
            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidZipcodeStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = code;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            ZipcodeMutableState state = (ZipcodeMutableState)that;

            if (code != state.code) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{code=" + code + "}";
        }
    }

    @State(type = "string")
    public static class ZipcodeStringState implements StringState {
        public String code;

        public ZipcodeStringState() {
        }

        public ZipcodeStringState(String code) {
            this.code = code;
        }

        public String getCode() { return code; }

        public void setCode(String code) { this.code = code; }

        public ZipcodeStringState withCode(String code) { this.code = code; return this; }

        public ZipcodeState asImmutable() {
            return asMutable().asImmutable();
        }

        public ZipcodeMutableState asMutable() {
            return asMutable(new ZipcodeStringStateConverter());
        }

        public ZipcodeMutableState asMutable(ZipcodeStringStateConverter converter) {
            return new ZipcodeMutableState(
                    converter.toCode(code));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new ZipcodeStringStateValidator(), validators);
        }

        public ValidationErrors validate(ZipcodeStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(ZipcodeStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateCode(code, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new ZipcodeStringStateValidator(), validators);
        }

        public void assertIsValid(ZipcodeStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

            if (errors.isInvalid()) {
                throw new InvalidZipcodeStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = code != null ? code.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            ZipcodeStringState state = (ZipcodeStringState)that;

            if (code != null ? !code.equals(state.code) : state.code != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{code=" + code + "}";
        }
    }

    public static class ZipcodeStringStateConverter {
        private final StringStateConverter converter;

        public ZipcodeStringStateConverter() { converter = new StringStateConverter(); }
        public ZipcodeStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String codeToString(int code) { return converter.intToString(code); }

        public int toCode(String code) { return converter.toInt(code); }
    }

    public static class ZipcodeStringStateValidator {
        private final ZipcodeStringStateConverter converter;

        public ZipcodeStringStateValidator() { converter = new ZipcodeStringStateConverter(); }
        public ZipcodeStringStateValidator(ZipcodeStringStateConverter converter) { this.converter = converter; }

        public void validateCode(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toCode(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "code", parent); }
        }
    }
}
