package net.sf.laja.example.repository.state;

import com.google.common.collect.ImmutableList;
import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.InvalidStateException;
import net.sf.laja.cdd.testgen.MutableState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.cdd.stateconverter.StateConversion.asImmutableList;
import static net.sf.laja.cdd.stateconverter.StateConversion.asMutableList;
import static net.sf.laja.cdd.stateconverter.StateConverters.toImmutable;
import static net.sf.laja.cdd.stateconverter.StateConverters.toMutable;
import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static net.sf.laja.example.repository.state.AddressState.AddressMutableState;

@State
public class CustomerState implements ImmutableState {
    @Key public final long ssn;
    public final String givenName;
    @Optional public final String surname;
    public final int age;
    @Optional public final String pet;
    public final AddressState address;
    @Optional public final ImmutableList<AddressState> oldAddresses;

    public boolean isValid() {
        return age >= 0 && ssn >= 190000000000L;
    }

    public void assertIsValid() {
    }

    // ===== Generated code =====

    public static final String SSN = "ssn";
    public static final String GIVEN_NAME = "givenName";
    public static final String SURNAME = "surname";
    public static final String AGE = "age";
    public static final String PET = "pet";
    public static final String ADDRESS = "address";
    public static final String OLD_ADDRESSES = "oldAddresses";

    public CustomerState(
            long ssn,
            String givenName,
            String surname,
            int age,
            String pet,
            AddressState address,
            ImmutableList<AddressState> oldAddresses) {
        this.ssn = ssn;
        this.givenName = givenName;
        this.surname = surname;
        this.age = age;
        this.pet = pet;
        this.address = address;
        this.oldAddresses = oldAddresses;

        if (givenName == null) throw new IllegalCustomerStateException("'givenName' can not be null");
        if (address == null) throw new IllegalCustomerStateException("'address' can not be null");

        assertIsValid();
    }

    public static class IllegalCustomerStateException extends InvalidStateException {
        public IllegalCustomerStateException(String message) {
            super(message);
        }

        public IllegalCustomerStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public long getSsn() { return ssn; }
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public String getPet() { return pet; }
    public AddressState getAddress() { return address; }
    public ImmutableList<AddressState> getOldAddresses() { return oldAddresses; }

    public CustomerState withSsn(long ssn) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withGivenName(String givenName) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withSurname(String surname) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withAge(int age) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withPet(String pet) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withAddress(AddressState address) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }
    public CustomerState withOldAddresses(ImmutableList<AddressState> oldAddresses) { return new CustomerState(ssn, givenName, surname, age, pet, address, oldAddresses); }

    public CustomerMutableState asMutable() {
        return new CustomerMutableState(
                ssn,
                givenName,
                surname,
                age,
                pet,
                address.asMutable(),
                asMutableList(oldAddresses, toMutable));
    }

    @Override
    public int hashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        CustomerState state = (CustomerState)that;

        if (ssn != state.ssn) return false;

        return true;
    }

    public int hashCodeValue() {
        int result = (int)(ssn ^ (ssn >>> 32));
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        CustomerState state = (CustomerState)that;

        if (ssn != state.ssn) return false;
        if (givenName != null ? !givenName.equals(state.givenName) : state.givenName != null) return false;
        if (surname != null ? !surname.equals(state.surname) : state.surname != null) return false;
        if (age != state.age) return false;
        if (pet != null ? !pet.equals(state.pet) : state.pet != null) return false;
        if (address != null ? !address.equals(state.address) : state.address != null) return false;
        if (oldAddresses != null ? !oldAddresses.equals(state.oldAddresses) : state.oldAddresses != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", age=" + age +
                ", pet=" + (pet == null ? null : '\'' + pet + '\'' ) +
                ", address=" + address +
                ", oldAddresses=" + oldAddresses + '}';
    }

    @State(type = "mutable")
    public static class CustomerMutableState implements MutableState {
        @Key public long ssn;
        public String givenName;
        @Optional public String surname;
        public int age;
        @Optional public String pet;
        public AddressMutableState address;
        @Optional public List<AddressMutableState> oldAddresses;

        public CustomerMutableState() {
            address = new AddressMutableState();
            oldAddresses = new ArrayList<AddressMutableState>();
        }

        public CustomerMutableState(
                long ssn,
                String givenName,
                String surname,
                int age,
                String pet,
                AddressMutableState address,
                List<AddressMutableState> oldAddresses) {
            this.ssn = ssn;
            this.givenName = givenName;
            this.surname = surname;
            this.age = age;
            this.pet = pet;
            this.address = address;
            this.oldAddresses = oldAddresses;
        }

        /**
         * Put validations here (this comment can be removed or modified).
         */
        private void validate(Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public long getSsn() { return ssn; }
        public String getGivenName() { return givenName; }
        public String getSurname() { return surname; }
        public int getAge() { return age; }
        public String getPet() { return pet; }
        public AddressMutableState getAddress() { return address; }
        public List<AddressMutableState> getOldAddresses() { return oldAddresses; }

        public void setSsn(long ssn) { this.ssn = ssn; }
        public void setGivenName(String givenName) { this.givenName = givenName; }
        public void setSurname(String surname) { this.surname = surname; }
        public void setAge(int age) { this.age = age; }
        public void setPet(String pet) { this.pet = pet; }
        public void setAddress(AddressMutableState address) { this.address = address; }
        public void setOldAddresses(List<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses; }

        public CustomerMutableState withSsn(long ssn) { this.ssn = ssn; return this; }
        public CustomerMutableState withGivenName(String givenName) { this.givenName = givenName; return this; }
        public CustomerMutableState withSurname(String surname) { this.surname = surname; return this; }
        public CustomerMutableState withAge(int age) { this.age = age; return this; }
        public CustomerMutableState withPet(String pet) { this.pet = pet; return this; }
        public CustomerMutableState withAddress(AddressMutableState address) { this.address = address; return this; }
        public CustomerMutableState withOldAddresses(List<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses; return this; }

        public void assertIsValid(Validator... validators) {
            ValidationErrors errors = validate(validators);

            if (errors.isInvalid()) {
                throw new IllegalCustomerStateException(errors);
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
            if (givenName == null) errors.addIsNullError(rootElement, parent, "givenName");
            if (address == null) errors.addIsNullError(rootElement, parent, "address");

            if (address != null) address.validate(rootElement, concatenate(parent, "address"), errors);
            if (oldAddresses != null) collectionValidator().validate(rootElement, oldAddresses, parent, "oldAddresses", errors, 0);

            validate(rootElement, parent, errors);

            for (Validator validator : validators) {
                validator.validate(rootElement, this, parent, "", errors);
            }
        }

        public CustomerState asImmutable(Validator... validators) {
            assertIsValid(validators);

            return new CustomerState(
                    ssn,
                    givenName,
                    surname,
                    age,
                    pet,
                    address != null ? address.asImmutable() : null,
                    asImmutableList(oldAddresses, toImmutable));
        }

        @Override
        public int hashCode() {
            int result = (int)(ssn ^ (ssn >>> 32));

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            CustomerMutableState state = (CustomerMutableState)that;

            if (ssn != state.ssn) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{ssn=" + ssn +
                    ", givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                    ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                    ", age=" + age +
                    ", pet=" + (pet == null ? null : '\'' + pet + '\'' ) +
                    ", address=" + address +
                    ", oldAddresses=" + oldAddresses + '}';
        }
    }
}
