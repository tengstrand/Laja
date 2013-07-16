package net.sf.laja.example.account;

import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

@State
public class AccountState implements ImmutableState {
    @Key public final double balance;

    public void assertIsValid() {
        assertThat(balance >= 0, "Balance must be >= 0");
    }

    // ===== Generated code =====

    public static final String BALANCE = "balance";

    public AccountState(double balance) {
        this.balance = balance;

        assertIsValid();
    }

    private void assertThat(boolean condition, String message) {
        if (!condition) {
            throw new InvalidAccountStateException(message);
        }
    }

    public static class InvalidAccountStateException extends InvalidStateException {
        public InvalidAccountStateException(String message) {
            super(message);
        }

        public InvalidAccountStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public double getBalance() { return balance; }

    public AccountState withBalance(double balance) { return new AccountState(balance); }

    public AccountMutableState asMutable() {
        return new AccountMutableState(balance);
    }

    @Override
    public int hashCode() {
        int result = (int)balance;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AccountState state = (AccountState)that;

        if (balance != state.balance) return false;

        return true;
    }

    public int hashCodeValue() {
        int result = (int)balance;

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        AccountState state = (AccountState)that;

        if (balance != state.balance) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{balance=" + balance + "}";
    }

    @State(type = "mutable")
    public static class AccountMutableState implements MutableState {
        @Key public double balance;

        public AccountMutableState() {
        }

        public AccountMutableState(double balance) {
            this.balance = balance;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public double getBalance() { return balance; }

        public void setBalance(double balance) { this.balance = balance; }

        public AccountMutableState withBalance(double balance) { this.balance = balance; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidAccountStateException(errors);
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
            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public AccountState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AccountState(balance);
        }

        @Override
        public int hashCode() {
            int result = (int)balance;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AccountMutableState state = (AccountMutableState)that;

            if (balance != state.balance) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{balance=" + balance + "}";
        }
    }
}
