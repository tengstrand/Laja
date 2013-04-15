package net.sf.laja.cdd.state;

public class PersonStateValidator {

    public static void throwExceptionIfInvalid(PersonState state) {
        if (state.age < 0 || state.age > 150) {
            throw new IllegalStateException("Age must be in the range 0..150");
        }
    }
}
