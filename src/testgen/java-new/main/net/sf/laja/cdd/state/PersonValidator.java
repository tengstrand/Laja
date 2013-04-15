package net.sf.laja.cdd.state;

public class PersonValidator {

    public static void throwExceptionIfNotValid(PersonState state) {
        if (state.age < 0 || state.age > 150) {
            throw new IllegalStateException("Age must be in the range 0..150");
        }
    }
}
