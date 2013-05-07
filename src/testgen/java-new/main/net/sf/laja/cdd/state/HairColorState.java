package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.InvalidStateException;
import net.sf.laja.cdd.MutableState;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HairColorState implements ImmutableState {
    private String color;

    private static void setDefaults(HairColorMutableState state) {
    }

    private static void validate(HairColorMutableState state, Object rootElement, String parent, ValidationErrors.Builder errors) {
    }

    // ------ Generated code ------

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

    public HairColorMutableState asMutable() {
        return new HairColorMutableState(color);
    }

    public HairColorState withColor(String color) { return new HairColorState(color); }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HairColorState)) return false;

        HairColorState that = (HairColorState) o;

        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "color='" + color + '\'' +
                '}';
    }

    public static class HairColorMutableState implements MutableState {
        public String color;

        public HairColorMutableState() {
            setDefaults(this);
        }

        public HairColorMutableState(String color) {
            this.color = color;
        }

        public static HairColorMutableState hairColorMutableState() {
            return new HairColorMutableState();
        }

        public static List<HairColorMutableState> hairColorMutableStateArrayList(HairColorMutableState... states) {
            return new ArrayList<HairColorMutableState>(Arrays.asList(states));
        }

        public static Set<HairColorMutableState> hairColorMutableStateHashSet(HairColorMutableState... states) {
            return new HashSet<HairColorMutableState>(Arrays.asList(states));
        }

        public String getColor() { return color; }

        public void setColor(String color) { this.color = color; }

        public void assertIsValid() {
            ValidationErrors errors = validate();

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

        public HairColorState asImmutable() {
            assertIsValid();

            return new HairColorState(color);
        }

        @Override
        public int hashCode() {
            return color != null ? color.hashCode() : 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HairColorMutableState)) return false;

            HairColorMutableState that = (HairColorMutableState) o;

            if (color != null ? !color.equals(that.color) : that.color != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }
}
