package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.InvalidStateException;
import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.validator.Validator;

@State
public class HairColorState implements ImmutableState {
    public final String color;

    private static void validate(HairColorMutableState state, Object rootElement, String parent, ValidationErrors.Builder errors) {
    }

    // ===== Generated code =====

    public static final String COLOR = "color";

    public HairColorState(String color) {
        this.color = color;
    }

    public static class IllegalHairColorStateException extends InvalidStateException {
        public IllegalHairColorStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public String getColor() { return color; }

    public HairColorState withColor(String color) { return new HairColorState(color); }

    public HairColorMutableState asMutable() {
        return new HairColorMutableState(color);
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        HairColorState state = (HairColorState)that;

        if (color != null ? !color.equals(state.color) : state.color != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{color=" + color + "}";
    }

    @State(type = "mutable")
    public static class HairColorMutableState implements MutableState {
        public String color;

        public HairColorMutableState() {
        }

        public HairColorMutableState(String color) {
            this.color = color;
        }

        public String getColor() { return color; }

        public void setColor(String color) { this.color = color; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.hasErrors()) {
                throw new IllegalHairColorStateException(errors);
            }
        }

        public boolean isValid() {
            return validate().isEmpty();
        }

        public ValidationErrors validate(Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors, validators);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            if (color == null) { errors.addIsNullError(rootElement, parent, "color"); }

            HairColorState.validate(this, rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public HairColorState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new HairColorState(color);
        }

        @Override
        public int hashCode() {
            int result = color != null ? color.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            HairColorMutableState state = (HairColorMutableState)that;

            if (color != null ? !color.equals(state.color) : state.color != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{color=" + color + "}";
        }
    }
}
