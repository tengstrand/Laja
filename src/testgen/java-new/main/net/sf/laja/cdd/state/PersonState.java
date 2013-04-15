package net.sf.laja.cdd.state;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.joda.time.DateMidnight;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class PersonState {
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;
    public final AddressState address2;

    public void postAssertValidState() {
        if (birthday.isBeforeNow()) {
            throw new IllegalBirthdayException();
        }
    }

    // Generated code goes here...

    public PersonState(String name, DateMidnight birthday, ImmutableList<PersonState> children, AddressState address, AddressState address2) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
        this.address = address;
        this.address2 = address2;
    }

    public static class IllegalPersonStateException extends RuntimeException {  }

    public static class IllegalNameException extends IllegalPersonStateException  {  }
    public static class IllegalBirthdayException extends IllegalPersonStateException {  }
    public static class IllegalChildrenException extends IllegalPersonStateException {  }
    public static class IllegalAddressException extends IllegalPersonStateException {  }
    public static class IllegalAddress2Exception extends IllegalPersonStateException {  }

    public static class NameNullException extends IllegalPersonStateException  {  }
    public static class BirthdayNullException extends IllegalPersonStateException {  }
    public static class ChildrenNullException extends IllegalPersonStateException {  }
    public static class AddressNullException extends IllegalPersonStateException {  }
    public static class Address2NullException extends IllegalPersonStateException {  }

    public void assertValidState() {
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
        if (address2 == null) {
            throw new Address2NullException();
        }
        address.assertValidState();
        address2.assertValidState();
    }

    public PersonState withName(String name) { return new PersonState(name, birthday, children, address, address2); }
    public PersonState withAge(DateMidnight birthday) { return new PersonState(name, birthday, children, address, address2); }
    public PersonState withAddress(AddressState address) { return new PersonState(name, birthday, children, address, address2); }
    public PersonState withAddress2(AddressState address2) { return new PersonState(name, birthday, children, address, address2); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(name, birthday, Converter.asMutableList(children), address.asMutable(), address2.asMutable());
    }

    public int superHashCode() {
        return super.hashCode();
    }

    public boolean superEquals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonState that = (PersonState) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
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
                ", address2=" + address2 +
                '}';
    }

    public static class PersonMutableState {
        public String name;
        public DateMidnight birthday;
        public List<PersonMutableState> children;
        public AddressMutableState address;
        public AddressMutableState address2;

        public PersonMutableState() {
            children = new ArrayList<PersonMutableState>();
            address = new AddressMutableState();
            address2 = new AddressMutableState();
        }

        public PersonMutableState(String name, DateMidnight birthday, List<PersonMutableState> children, AddressMutableState address, AddressMutableState address2) {
            this.name = name;
            this.birthday = birthday;
            this.children = children;
            this.address = address;
            this.address2 = address;
        }

        public String getName() { return name; }
        public DateMidnight getBirthday() { return birthday;  }
        public List<PersonMutableState> getChildren() { return children; }
        public AddressMutableState getAddress() { return address; }
        public AddressMutableState getAddress2() { return address2; }

        public PersonMutableState setName(String name) { this.name = name;  return this; }
        public PersonMutableState setBirthday(DateMidnight birthday) { this.birthday = birthday; return this; }
        public PersonMutableState setChildren(List<PersonMutableState> children) { this.children = children; return this; }
        public PersonMutableState setAddress(AddressMutableState address) { this.address = address;  return this;}
        public PersonMutableState setAddress2(AddressMutableState address2) { this.address2 = address2;  return this;}

        public PersonState asImmutable() {
            return new PersonState(name, birthday, Converter.asImmutableList(children), address.asImmutable(), address2.asImmutable());
        }



        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (address2 != null ? address2.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonMutableState that = (PersonMutableState) o;

            if (address != null ? !address.equals(that.address) : that.address != null) return false;
            if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
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
                    ", address2=" + address2 +
                    '}';
        }
    }

    public static class Converter {
        public static ImmutableList<PersonState> asImmutableList(List<PersonMutableState> list) {
            ImmutableList.Builder<PersonState> builder = ImmutableList.<PersonState>builder();
            for (PersonMutableState state : list) {
                builder.add(state.asImmutable());
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
