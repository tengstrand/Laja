package net.sf.laja.example.account;

import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.MutableStringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
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

    public AccountStringState asStringState() {
        return asMutable().asStringState();
    }

    public AccountStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public AccountStringState asStringState(AccountStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
            return asStringState(new AccountStringStateConverter());
        }

        public AccountStringState asStringState(StringStateConverter converter) {
            return asStringState(new AccountStringStateConverter(converter));
        }

        public AccountStringState asStringState(AccountStringStateConverter converter) {
            return new AccountStringState(converter.balanceToString(balance));
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
            return validate(new AccountStringStateValidator(), validators);
        }

        public ValidationErrors validate(AccountStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors, validators);
            return errors.build();
        }

        public void validate(AccountStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors, Validator... validators) {
            stateValidator.validateBalance(balance, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors, validators);
        }

        public void assertIsValid(Validator... validators) {
            assertIsValid(new AccountStringStateValidator(), validators);
        }

        public void assertIsValid(AccountStringStateValidator stateValidator, Validator... validators) {
            ValidationErrors errors = validate(stateValidator, validators);

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
        private final StringStateConverter c;

        public AccountStringStateConverter() { c = new StringStateConverter(); }
        public AccountStringStateConverter(StringStateConverter converter) { c = converter; }

        public String balanceToString(double balance) { return c.doubleToString(balance); }

        public double toBalance(String balance) { return c.toDouble(balance); }
    }

    public static class AccountStringStateValidator {
        private final AccountStringStateConverter c;

        public AccountStringStateValidator() { this.c = new AccountStringStateConverter(); }
        public AccountStringStateValidator(AccountStringStateConverter converter) { this.c = converter; }

        public void validateBalance(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { c.toBalance(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, parent, "balance"); }
        }
    }
}
