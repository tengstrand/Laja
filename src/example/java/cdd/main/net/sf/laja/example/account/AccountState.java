package net.sf.laja.example.account;

import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StateConverter;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

import java.util.LinkedHashMap;
import java.util.Map;

@State
public class AccountState implements ImmutableState {
    @Key public final double balance;

    // ===== Generated code =====

    public static final String BALANCE = "balance";

    public AccountState(double balance) {
        this.balance = balance;
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

        public AccountMutableState(AccountMutableState state) {
            balance = state.balance;
        }

        public double getBalance() { return balance; }

        public void setBalance(double balance) { this.balance = balance; }

        public AccountMutableState withBalance(double balance) { this.balance = balance; return this; }

        public AccountState asImmutable() {
            assertIsValid();

            return new AccountState(balance);
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("balance", balance);

            return result;
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

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(this, "", errors);
            return errors.build();
        }

        public void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

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

    public static MapToAccountConverter mapToAccountConverter = new MapToAccountConverter();

    public static AccountMutableState toAccountMutableState(Map map) {
        return mapToAccountConverter.convert(map, 0);
    }

    public static class MapToAccountConverter implements StateConverter {

        public AccountMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            double balance = (Double) map.get("balance");

            return new AccountMutableState(
                    balance
            );
        }
    }

    @State(type = "string")
    public static class AccountStringState implements StringState {
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

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new AccountStringStateValidator());
        }

        public ValidationErrors validate(AccountStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(AccountStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateBalance(balance, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new AccountStringStateValidator());
        }

        public void assertIsValid(AccountStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

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
        private final StringStateConverter converter;

        public AccountStringStateConverter() { converter = new StringStateConverter(); }
        public AccountStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String balanceToString(double balance) { return converter.doubleToString(balance); }

        public double toBalance(String balance) { return converter.toDouble(balance); }
    }

    public static class AccountStringStateValidator {
        private final AccountStringStateConverter converter;

        public AccountStringStateValidator() { converter = new AccountStringStateConverter(); }
        public AccountStringStateValidator(AccountStringStateConverter converter) { this.converter = converter; }

        public void validateBalance(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toBalance(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "balance", parent); }
        }
    }
}
