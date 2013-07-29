package net.sf.laja.example.account;

import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.converter.StringConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import static net.sf.laja.cdd.state.converter.StateConversion.asDoublePrimitive;

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

        public double getBalance() { return balance; }

        public void setBalance(double balance) { this.balance = balance; }

        public AccountMutableState withBalance(double balance) { this.balance = balance; return this; }

        public AccountState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new AccountState(balance);
        }

        public AccountStringState asStringState() {
            return asStringState(new StringConverter());
        }

        public AccountStringState asStringState(StringConverter c) {
            return new AccountStringState(c.doubleToString(balance));
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
            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new InvalidAccountStateException(errors);
            }
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

    @State(type = "string")
    public static class AccountStringState implements MutableStringState {
        @Key public String balance;

        public AccountStringState() {
        }

        public AccountStringState(String balance) {
            this.balance = balance;
        }

        public String getBalance() { return balance; }

        public void setBalance(String balance) { this.balance = balance; }

        public AccountStringState withBalance(String balance) { this.balance = balance; return this; }

        public AccountState asImmutable() {
            return asMutable().asImmutable();
        }

        public AccountMutableState asMutable() {
            return asMutable(new AccountStringStateConverter());
        }

        public AccountMutableState asMutable(AccountStringStateConverter converter) {
            return new AccountMutableState(
                    converter.toBalance(balance));
        }

        public boolean isValid(Validator... validators) {
            return validate(validators).isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return validate(new AccountStringStateConverter(), validators);
        }

        public ValidationErrors validate(AccountStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateConverter, this, "", errors, validators);
            return errors.build();
        }

        public void validate(AccountStringStateConverter stateConverter, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateConverter.validateBalance(balance, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new AccountStringStateConverter(), validators);
        }

        public void assertIsValid(AccountStringStateConverter stateConverter, Validator... validators) {
            ValidationErrors errors = validate(stateConverter, validators);

            if (errors.isInvalid()) {
                throw new InvalidAccountStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = balance != null ? balance.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            AccountStringState state = (AccountStringState)that;

            if (balance != null ? !balance.equals(state.balance) : state.balance != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{balance=" + balance + "}";
        }
    }

    public static class AccountStringStateConverter {
        public double toBalance(String balance) { return asDoublePrimitive(balance); }

        public void validateBalance(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try {
                toBalance(value);
            } catch (Exception e) {
                errors.addTypeConversionError(rootElement, parent, "balance");
            }
        }
    }
}
