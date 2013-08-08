package net.sf.laja.example.repository.state;

import com.google.common.collect.ImmutableList;
import net.sf.laja.cdd.annotation.Key;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MapState;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;

import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.cdd.state.converter.StateConverters.*;
import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static net.sf.laja.example.repository.state.AddressState.*;

@State
public class CustomerState implements ImmutableState {
    @Key public final long ssn;
    public final String givenName;
    @Optional public final String surname;
    public final int age;
    @Optional public final String pet;
    public final AddressState address;
    @Optional public final ImmutableList<AddressState> oldAddresses;

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

        if (givenName == null) throw new InvalidCustomerStateException("'givenName' can not be null");
        if (address == null) throw new InvalidCustomerStateException("'address' can not be null");
    }

    public static class InvalidCustomerStateException extends InvalidStateException {
        public InvalidCustomerStateException(String message) {
            super(message);
        }

        public InvalidCustomerStateException(ValidationErrors errors) {
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
                address != null ? address.asMutable() : null,
                asMutableList(oldAddresses, toMutable));
    }

    public CustomerStringState asStringState() {
        return asMutable().asStringState();
    }

    public CustomerStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public CustomerStringState asStringState(CustomerStringStateConverter converter) {
        return asMutable().asStringState(converter);
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
                ", givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                ", age=" + age +
                ", pet=" + (pet == null ? null : '\"' + pet + '\"' ) +
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

        public CustomerState asImmutable() {
            assertIsValid();

            return new CustomerState(
                    ssn,
                    givenName,
                    surname,
                    age,
                    pet,
                    address != null ? address.asImmutable() : null,
                    asImmutableList(oldAddresses, toImmutable));
        }

        public CustomerStringState asStringState() {
            return asStringState(new CustomerStringStateConverter());
        }

        public CustomerStringState asStringState(StringStateConverter converter) {
            return asStringState(new CustomerStringStateConverter(converter));
        }

        public CustomerStringState asStringState(CustomerStringStateConverter converter) {
            return new CustomerStringState(
                    converter.ssnToString(ssn),
                    converter.givenNameToString(givenName),
                    converter.surnameToString(surname),
                    converter.ageToString(age),
                    converter.petToString(pet),
                    converter.addressToString(address),
                    converter.oldAddressesToString(oldAddresses));
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
            if (givenName == null) errors.addIsNullError(rootElement, "givenName", parent);
            if (address == null) errors.addIsNullError(rootElement, "address", parent);

            if (address != null) address.validate(rootElement, concatenate(parent, "address"), errors);
            if (oldAddresses != null) collectionValidator().validate(rootElement, oldAddresses, parent, "oldAddresses", errors, 0);

        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidCustomerStateException(errors);
            }
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
                    ", givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                    ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                    ", age=" + age +
                    ", pet=" + (pet == null ? null : '\"' + pet + '\"' ) +
                    ", address=" + address +
                    ", oldAddresses=" + oldAddresses + '}';
        }
    }

    @State(type = "map")
    public static class CustomerMapState extends MapState {

        public CustomerMapState() {
            put("ssn", 0);
            put("age", 0);
            put("oldAddresses", new ArrayList<AddressMapState>());
        }

        public CustomerMapState(
                long ssn,
                String givenName,
                String surname,
                int age,
                String pet,
                AddressMapState address,
                List<AddressMapState> oldAddresses) {
            put("ssn", ssn);
            put("givenName", givenName);
            put("surname", surname);
            put("age", age);
            put("pet", pet);
            put("address", address);
            put("oldAddresses", oldAddresses);
        }

        public long getSsn() { return (Long) get("ssn"); }
        public String getGivenName() { return (String) get("givenName"); }
        public String getSurname() { return (String) get("surname"); }
        public int getAge() { return (Integer) get("age"); }
        public String getPet() { return (String) get("pet"); }
        public AddressMapState getAddress() { return (AddressMapState) get("address"); }
        public List<AddressMapState> getOldAddresses() { return (List<AddressMapState>) get("oldAddresses"); }

        public void setSsn(long ssn) { put("ssn", ssn); }
        public void setGivenName(String givenName) { put("givenName", givenName); }
        public void setSurname(String surname) { put("surname", surname); }
        public void setAge(int age) { put("age", age); }
        public void setPet(String pet) { put("pet", pet); }
        public void setAddress(AddressMapState address) { put("address", address); }
        public void setOldAddresses(List<AddressMapState> oldAddresses) { put("oldAddresses", oldAddresses); }

        public CustomerMapState withSsn(long ssn) { put("ssn", ssn); return this; }
        public CustomerMapState withGivenName(String givenName) { put("givenName", givenName); return this; }
        public CustomerMapState withSurname(String surname) { put("surname", surname); return this; }
        public CustomerMapState withAge(int age) { put("age", age); return this; }
        public CustomerMapState withPet(String pet) { put("pet", pet); return this; }
        public CustomerMapState withAddress(AddressMapState address) { put("address", address); return this; }
        public CustomerMapState withOldAddresses(List<AddressMapState> oldAddresses) { put("oldAddresses", oldAddresses); return this; }

        public CustomerState asImmutable() {
            return asMutable().asImmutable();
        }

        public CustomerMutableState asMutable() {
            return new CustomerMutableState(
                    getSsn(),
                    getGivenName(),
                    getSurname(),
                    getAge(),
                    getPet(),
                    getAddress() != null ? getAddress().asMutable() : null,
                    asMutableList(getOldAddresses(), toMutable));
        }
    }

    @State(type = "string")
    public static class CustomerStringState implements StringState {
        @Key public String ssn;
        public String givenName;
        @Optional public String surname;
        public String age;
        @Optional public String pet;
        public AddressStringState address;
        @Optional public List<AddressStringState> oldAddresses;

        public CustomerStringState() {
            oldAddresses = new ArrayList<AddressStringState>();
        }

        public CustomerStringState(
                String ssn,
                String givenName,
                String surname,
                String age,
                String pet,
                AddressStringState address,
                List<AddressStringState> oldAddresses) {
            this.ssn = ssn;
            this.givenName = givenName;
            this.surname = surname;
            this.age = age;
            this.pet = pet;
            this.address = address;
            this.oldAddresses = oldAddresses;
        }

        public String getSsn() { return ssn; }
        public String getGivenName() { return givenName; }
        public String getSurname() { return surname; }
        public String getAge() { return age; }
        public String getPet() { return pet; }
        public AddressStringState getAddress() { return address; }
        public List<AddressStringState> getOldAddresses() { return oldAddresses; }

        public void setSsn(String ssn) { this.ssn = ssn; }
        public void setGivenName(String givenName) { this.givenName = givenName; }
        public void setSurname(String surname) { this.surname = surname; }
        public void setAge(String age) { this.age = age; }
        public void setPet(String pet) { this.pet = pet; }
        public void setAddress(AddressStringState address) { this.address = address; }
        public void setOldAddresses(List<AddressStringState> oldAddresses) { this.oldAddresses = oldAddresses; }

        public CustomerStringState withSsn(String ssn) { this.ssn = ssn; return this; }
        public CustomerStringState withGivenName(String givenName) { this.givenName = givenName; return this; }
        public CustomerStringState withSurname(String surname) { this.surname = surname; return this; }
        public CustomerStringState withAge(String age) { this.age = age; return this; }
        public CustomerStringState withPet(String pet) { this.pet = pet; return this; }
        public CustomerStringState withAddress(AddressStringState address) { this.address = address; return this; }
        public CustomerStringState withOldAddresses(List<AddressStringState> oldAddresses) { this.oldAddresses = oldAddresses; return this; }

        public CustomerState asImmutable() {
            return asMutable().asImmutable();
        }

        public CustomerMutableState asMutable() {
            return asMutable(new CustomerStringStateConverter());
        }

        public CustomerMutableState asMutable(CustomerStringStateConverter converter) {
            return new CustomerMutableState(
                    converter.toSsn(ssn),
                    converter.toGivenName(givenName),
                    converter.toSurname(surname),
                    converter.toAge(age),
                    converter.toPet(pet),
                    converter.toAddress(address),
                    converter.toOldAddresses(oldAddresses));
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new CustomerStringStateValidator());
        }

        public ValidationErrors validate(CustomerStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(CustomerStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateSsn(ssn, rootElement, parent, errors);
            stateValidator.validateGivenName(givenName, rootElement, parent, errors);
            stateValidator.validateSurname(surname, rootElement, parent, errors);
            stateValidator.validateAge(age, rootElement, parent, errors);
            stateValidator.validatePet(pet, rootElement, parent, errors);
            stateValidator.validateAddress(address, rootElement, parent, errors);
            stateValidator.validateOldAddresses(oldAddresses, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new CustomerStringStateValidator());
        }

        public void assertIsValid(CustomerStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidCustomerStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = ssn != null ? ssn.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            CustomerStringState state = (CustomerStringState)that;

            if (ssn != null ? !ssn.equals(state.ssn) : state.ssn != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{ssn=" + (ssn == null ? null : '\"' + ssn + '\"' ) +
                    ", givenName=" + (givenName == null ? null : '\"' + givenName + '\"' ) +
                    ", surname=" + (surname == null ? null : '\"' + surname + '\"' ) +
                    ", age=" + (age == null ? null : '\"' + age + '\"' ) +
                    ", pet=" + (pet == null ? null : '\"' + pet + '\"' ) +
                    ", address=" + address +
                    ", oldAddresses=" + oldAddresses + '}';
        }
    }

    public static class CustomerStringStateConverter {
        private final StringStateConverter converter;

        public CustomerStringStateConverter() { converter = new StringStateConverter(); }
        public CustomerStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String ssnToString(long ssn) { return converter.longToString(ssn); }
        public String givenNameToString(String givenName) { return givenName; }
        public String surnameToString(String surname) { return surname; }
        public String ageToString(int age) { return converter.intToString(age); }
        public String petToString(String pet) { return pet; }
        public AddressStringState addressToString(AddressMutableState address) { return address != null ? address.asStringState(converter) : null; }
        public List<AddressStringState> oldAddressesToString(List<AddressMutableState> oldAddresses) { return asMutableList(oldAddresses, toMutableString); }

        public long toSsn(String ssn) { return converter.toLong(ssn); }
        public String toGivenName(String givenName) { return givenName; }
        public String toSurname(String surname) { return surname; }
        public int toAge(String age) { return converter.toInt(age); }
        public String toPet(String pet) { return pet; }
        public AddressMutableState toAddress(AddressStringState address) { return address != null ? address.asMutable() : null; }
        public List<AddressMutableState> toOldAddresses(List<AddressStringState> oldAddresses) { return asMutableList(oldAddresses, toMutable); }
    }

    public static class CustomerStringStateValidator {
        private final CustomerStringStateConverter converter;

        public CustomerStringStateValidator() { converter = new CustomerStringStateConverter(); }
        public CustomerStringStateValidator(CustomerStringStateConverter converter) { this.converter = converter; }

        public void validateSsn(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toSsn(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "ssn", parent); }
        }

        public void validateGivenName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateSurname(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateAge(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toAge(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "age", parent); }
        }

        public void validatePet(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateAddress(AddressStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toAddress(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "address", parent); }
        }

        public void validateOldAddresses(List<AddressStringState> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toOldAddresses(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "oldAddresses", parent); }
        }
    }
}
