package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateMidnight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.AddressState.AddressStateConverter;

public class PersonState implements Serializable {
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;
    public final ImmutableSet<AddressState> oldAddresses; // (optional)
    public final ImmutableMap<String,AddressState> groupedAddresses; // (optional)

    private static void setDefaults(PersonMutableState state) {
        state.children = new ArrayList<PersonMutableState>();
        state.address = new AddressMutableState();
        state.oldAddresses = new HashSet<AddressMutableState>();
        state.groupedAddresses = new HashMap<String, AddressMutableState>();
    }

    private static void assertIsValid(PersonMutableState state) {
        if (state.birthday.isAfterNow()) {
            throw new IllegalPersonStateBirthdayException();
        }
    }

    // Generated code goes here...

    public PersonState(
            String name,
            DateMidnight birthday,
            ImmutableList<PersonState> children,
            AddressState address,
            ImmutableSet<AddressState> oldAddresses,
            ImmutableMap<String,AddressState> groupedAddresses) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
        this.address = address;
        this.oldAddresses = oldAddresses;
        this.groupedAddresses = groupedAddresses;
    }

    public static class IllegalPersonStateException extends IllegalStateException {  }
    public static class IllegalPersonStateIsNullException extends IllegalPersonStateException {  }

    public static class IllegalPersonStateNameException extends IllegalPersonStateException  {  }
    public static class IllegalPersonStateBirthdayException extends IllegalPersonStateException {  }
    public static class IllegalPersonStateChildrenException extends IllegalPersonStateException {  }
    public static class IllegalPersonStateAddressException extends IllegalPersonStateException {  }
    public static class IllegalPersonStateOldAddressesException extends IllegalPersonStateException {  }
    public static class IllegalPersonStateGroupedAddressesException extends IllegalPersonStateException {  }

    public static class IllegalPersonStateNameIsNullException extends IllegalPersonStateIsNullException {  }
    public static class IllegalPersonStateBirthdayIsNullException extends IllegalPersonStateIsNullException {  }
    public static class IllegalPersonStateChildrenIsNullException extends IllegalPersonStateIsNullException {  }
    public static class IllegalPersonStateAddressIsNullException extends IllegalPersonStateIsNullException {  }
    public static class IllegalPersonStateOldAddressesIsNullException extends IllegalPersonStateIsNullException {  }
    public static class IllegalPersonStateGroupedAddressesIsNullException extends IllegalPersonStateIsNullException {  }

    public PersonState withName(String name) { return new PersonState(name, birthday, children, address, oldAddresses, groupedAddresses); }
    public PersonState withAge(DateMidnight birthday) { return new PersonState(name, birthday, children, address, oldAddresses, groupedAddresses); }
    public PersonState withAddress(AddressState address) { return new PersonState(name, birthday, children, address, oldAddresses, groupedAddresses); }
    public PersonState withOldAddresses(ImmutableSet<AddressState> oldAddresses) { return new PersonState(name, birthday, children, address, oldAddresses, groupedAddresses); }
    public PersonState withGroupedAddresses(ImmutableMap<String,AddressState> groupedAddresses) { return new PersonState(name, birthday, children, address, oldAddresses, groupedAddresses); }

    public PersonMutableState asMutableState() {
        return new PersonMutableState(
                name,
                birthday,
                PersonStateConverter.asMutableList(children),
                address.asMutableState(),
                AddressStateConverter.asMutableSet(oldAddresses),
                AddressStateConverter.asMutableMap(groupedAddresses));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);
        result = 31 * result + (groupedAddresses != null ? groupedAddresses.hashCode() : 0);
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
        if (groupedAddresses != null ? !groupedAddresses.equals(that.groupedAddresses) : that.groupedAddresses != null)
            return false;
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
                ", groupedAddresses=" + groupedAddresses +
                '}';
    }

    public static class PersonMutableState {
        public String name;
        public DateMidnight birthday;
        public List<PersonMutableState> children;
        public AddressMutableState address;
        public Set<AddressMutableState> oldAddresses;
        public Map<String, AddressMutableState> groupedAddresses;

        public PersonMutableState() {
            PersonState.setDefaults(this);
        }

        public PersonMutableState(String name, DateMidnight birthday, List<PersonMutableState> children, AddressMutableState address,
                                  Set<AddressMutableState> oldAddresses, Map<String, AddressMutableState> groupedAddresses) {
            this.name = name;
            this.birthday = birthday;
            this.children = children;
            this.address = address;
            this.oldAddresses = oldAddresses;
            this.groupedAddresses = groupedAddresses;
        }

        public String getName() { return name; }
        public DateMidnight getBirthday() { return birthday;  }
        public List<PersonMutableState> getChildren() { return children; }
        public AddressMutableState getAddress() { return address; }
        public Set<AddressMutableState> getOldAddresses() { return oldAddresses; }
        public Map<String, AddressMutableState> getGroupedAddresses() { return groupedAddresses; }

        public void setName(String name) { this.name = name; }
        public void setBirthday(DateMidnight birthday) { this.birthday = birthday; }
        public void setChildren(List<PersonMutableState> children) { this.children = children; }
        public void setAddress(AddressMutableState address) { this.address = address; }
        public void setOldAddresses(Set<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses; }
        public void setGroupedAddresses(Map<String, AddressMutableState> groupedAddresses) { this.groupedAddresses = groupedAddresses; }

        public void assertIsValid() {
            assertNotNull();
            address.assertIsValid();
            PersonState.assertIsValid(this);
        }

        private void assertNotNull() {
            if (name == null) {
                throw new IllegalPersonStateNameIsNullException();
            }
            if (birthday == null) {
                throw new IllegalPersonStateBirthdayIsNullException();
            }
            if (children == null) {
                throw new IllegalPersonStateChildrenIsNullException();
            }
            if (address == null) {
                throw new IllegalPersonStateAddressIsNullException();
            }
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);
            result = 31 * result + (groupedAddresses != null ? groupedAddresses.hashCode() : 0);
            return result;
        }

        public PersonState asState() {
            assertIsValid();

            return new PersonState(
                    name,
                    birthday,
                    PersonStateConverter.asImmutableList(children),
                    address.asState(),
                    AddressStateConverter.asImmutableSet(oldAddresses),
                    AddressStateConverter.asImmutableMap(groupedAddresses));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonMutableState that = (PersonMutableState) o;

            if (address != null ? !address.equals(that.address) : that.address != null) return false;
            if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
            if (children != null ? !children.equals(that.children) : that.children != null) return false;
            if (groupedAddresses != null ? !groupedAddresses.equals(that.groupedAddresses) : that.groupedAddresses != null)
                return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            if (oldAddresses != null ? !oldAddresses.equals(that.oldAddresses) : that.oldAddresses != null)
                return false;

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
                    ", groupedAddresses=" + groupedAddresses +
                    '}';
        }
    }

    public static class PersonStateConverter {
        public static ImmutableList<PersonState> asImmutableList(List<PersonMutableState> list) {
            ImmutableList.Builder<PersonState> builder = ImmutableList.<PersonState>builder();
            if (list != null) {
                for (PersonMutableState state : list) {
                    builder.add(state.asState());
                }
            }
            return builder.build();
        }

        public static List<PersonMutableState> asMutableList(ImmutableList<PersonState> list) {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonState state : list) {
                result.add(state.asMutableState());
            }
            return result;
        }
    }
}
