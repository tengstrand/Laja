package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateMidnight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.AddressState.AddressStateConverter;

public class PersonState implements Serializable {
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;
    public final ImmutableSet<AddressState> oldAddresses;

    private void postAssertIsValid() {
        if (birthday.isAfterNow()) {
            throw new IllegalBirthdayException();
        }
    }

    // Generated code goes here...

    public PersonState(
            String name,
            DateMidnight birthday,
            ImmutableList<PersonState> children,
            AddressState address,
            ImmutableSet<AddressState> oldAddresses) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
        this.address = address;
        this.oldAddresses = oldAddresses;
    }

    public static class IllegalPersonStateException extends RuntimeException {  }
    public static class IllegalPersonNullException extends IllegalPersonStateException {  }

    public static class IllegalNameException extends IllegalPersonStateException  {  }
    public static class IllegalBirthdayException extends IllegalPersonStateException {  }
    public static class IllegalChildrenException extends IllegalPersonStateException {  }
    public static class IllegalAddressException extends IllegalPersonStateException {  }
    public static class IllegalOldAddressesException extends IllegalPersonStateException {  }

    public static class NameNullException extends IllegalPersonNullException  {  }
    public static class BirthdayNullException extends IllegalPersonNullException {  }
    public static class ChildrenNullException extends IllegalPersonNullException {  }
    public static class AddressNullException extends IllegalPersonNullException {  }
    public static class OldAddressesNullException extends IllegalPersonNullException {  }

    public void assertIsValid() {
        if (name == null) {
            throw new NameNullException();
        }
        if (birthday == null) {
            throw new BirthdayNullException();
        }
        if (children == null) {
            throw new ChildrenNullException();
        }
        if (address == null) {
            throw new AddressNullException();
        }
        if (oldAddresses == null) {
            throw new OldAddressesNullException();
        }
        address.assertIsValid();

        postAssertIsValid();
    }

    public PersonState withName(String name) { return new PersonState(name, birthday, children, address, oldAddresses); }
    public PersonState withAge(DateMidnight birthday) { return new PersonState(name, birthday, children, address, oldAddresses); }
    public PersonState withAddress(AddressState address) { return new PersonState(name, birthday, children, address, oldAddresses); }
    public PersonState withOldAddresses(ImmutableSet<AddressState> oldAddresses) { return new PersonState(name, birthday, children, address, oldAddresses); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(
                name,
                birthday,
                PersonStateConverter.asMutableList(children),
                address.asMutable(),
                AddressStateConverter.asMutableSet(oldAddresses));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonState that = (PersonState) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (children != null ? !children.equals(that.children) : that.children != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (oldAddresses != null ? !oldAddresses.equals(that.oldAddresses) : that.oldAddresses != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", children=" + children +
                ", address=" + address +
                ", oldAddresses=" + oldAddresses +
                '}';
    }

    public static class PersonMutableState {
        public String name;
        public DateMidnight birthday;
        public List<PersonMutableState> children;
        public AddressMutableState address;
        public Set<AddressMutableState> oldAddresses;

        private PersonMutableState() {
        }

        public static PersonMutableState create() {
            return new PersonMutableState();
        }

        public PersonMutableState(String name, DateMidnight birthday, List<PersonMutableState> children, AddressMutableState address,
                                  Set<AddressMutableState> oldAddresses) {
            this.name = name;
            this.birthday = birthday;
            this.children = children;
            this.address = address;
            this.oldAddresses = oldAddresses;
        }

        public String getName() { return name; }
        public DateMidnight getBirthday() { return birthday;  }
        public List<PersonMutableState> getChildren() { return children; }
        public AddressMutableState getAddress() { return address; }
        public Set<AddressMutableState> getOldAddresses() { return oldAddresses; }

        public PersonMutableState setName(String name) { this.name = name;  return this; }
        public PersonMutableState setBirthday(DateMidnight birthday) { this.birthday = birthday; return this; }
        public PersonMutableState setChildren(List<PersonMutableState> children) { this.children = children; return this; }
        public PersonMutableState setAddress(AddressMutableState address) { this.address = address;  return this;}
        public PersonMutableState setOldAddresses(Set<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses;  return this;}

        public PersonState asImmutable() {
            return new PersonState(
                    name,
                    birthday,
                    PersonStateConverter.asImmutableList(children),
                    address.asImmutable(),
                    AddressStateConverter.asImmutableSet(oldAddresses));
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonMutableState that = (PersonMutableState) o;

            if (address != null ? !address.equals(that.address) : that.address != null) return false;
            if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
            if (children != null ? !children.equals(that.children) : that.children != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    ", children=" + children +
                    ", address=" + address +
                    '}';
        }
    }

    public static class PersonStateConverter {
        public static ImmutableList<PersonState> asImmutableList(List<PersonMutableState> list) {
            ImmutableList.Builder<PersonState> builder = ImmutableList.<PersonState>builder();
            if (list != null) {
                for (PersonMutableState state : list) {
                    builder.add(state.asImmutable());
                }
            }
            return builder.build();
        }

        public static List<PersonMutableState> asMutableList(ImmutableList<PersonState> list) {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonState state : list) {
                result.add(state.asMutable());
            }
            return result;
        }
    }
}
