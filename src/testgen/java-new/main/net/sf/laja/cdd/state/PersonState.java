package net.sf.laja.cdd.state;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.AddressState.AddressStringState;

public class PersonState {
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;

    public void postAssertValidState() {
        if (birthday.isBeforeNow()) {
            throw new IllegalBirthdayException();
        }
    }

    // TODO: Add support for this method.
    private void defaults(PersonMutableState state) {
        state.name = "";
        state.birthday = new DateMidnight();
        state.children = new ArrayList<PersonMutableState>();
        state.address = new AddressMutableState();
    }

    // Generated code goes here...

    public PersonState(String name, DateMidnight birthday, ImmutableList<PersonState> children, AddressState address) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
        this.address = address;
    }

    public static class IllegalPersonStateException extends RuntimeException {  }

    public static class IllegalNameException extends IllegalPersonStateException  {  }
    public static class IllegalBirthdayException extends IllegalPersonStateException {  }
    public static class IllegalChildrenException extends IllegalPersonStateException {  }
    public static class IllegalAddressException extends IllegalPersonStateException {  }

    public static class NameNullException extends IllegalPersonStateException  {  }
    public static class BirthdayNullException extends IllegalPersonStateException {  }
    public static class ChildrenNullException extends IllegalPersonStateException {  }
    public static class AddressNullException extends IllegalPersonStateException {  }

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
        address.assertValidState();
    }

    public PersonState withName(String name) { return new PersonState(name, birthday, children, address); }
    public PersonState withAge(DateMidnight birthday) { return new PersonState(name, birthday, children, address); }
    public PersonState withAddress(AddressState address) { return new PersonState(name, birthday, children, address); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(name, birthday, Converter.asMutableList(children), address.asMutable());
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

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", children=" + children +
                ", address=" + address +
                ", hashCode=" + super.hashCode() +
                '}';
    }

    public static class PersonMutableState {
        public String name;
        public DateMidnight birthday;
        public List<PersonMutableState> children;
        public AddressMutableState address;

        public PersonMutableState() {
            name = "";
            birthday = new DateMidnight();
            children = new ArrayList<PersonMutableState>();
            address = new AddressMutableState();
        }

        public PersonMutableState(String name, DateMidnight birthday, List<PersonMutableState> children, AddressMutableState address) {
            this.name = name;
            this.birthday = birthday;
            this.children = children;
            this.address = address;
        }

        public String getName() { return name; }
        public DateMidnight getBirthday() { return birthday;  }
        public List<PersonMutableState> getChildren() { return children; }
        public AddressMutableState getAddress() { return address; }

        public PersonMutableState setName(String name) { this.name = name;  return this; }
        public PersonMutableState setBirthday(DateMidnight birthday) { this.birthday = birthday; return this; }
        public PersonMutableState setChildren(List<PersonMutableState> children) { this.children = children; return this; }
        public PersonMutableState setAddress(AddressMutableState address) { this.address = address;  return this;}

        public PersonState asImmutable() {
            return new PersonState(name, birthday, Converter.asImmutableList(children), address.asImmutable());
        }

        public PersonStringState asStringState() {
            return new PersonStringState(
                    name,
                    Converter.asString(birthday),
                    asStringList(children),
                    address.asStringState()
                );
        }

        private List<PersonStringState> asStringList(List<PersonMutableState> list) {
            List<PersonStringState> result = new ArrayList<PersonStringState>();

            for (PersonMutableState mutableState : list) {
                result.add(mutableState.asStringState());
            }
            return result;
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

    public static class PersonStringState {
        public String name;
        public String birthday;
        public List<PersonStringState> children;
        public AddressStringState address;

        public PersonStringState() {
        }

        public PersonStringState(String name, String birthday, List<PersonStringState> children, AddressStringState address) {
            this.name = name;
            this.birthday = birthday;
            this.children = children;
            this.address = address;
        }

        public PersonState asState() {
            return new PersonState(
                    name,
                    Converter.asDateMidnight(birthday),
                    asImmutableList(children),
                    address.asState()
            );
        }

        public PersonMutableState asMutableState() {
            return new PersonMutableState(
                    name,
                    Converter.asDateMidnight(birthday),
                    asMutableList(children),
                    address.asMutableState()
            );
        }

        private ImmutableList<PersonState> asImmutableList(List<PersonStringState> list) {
            ImmutableList.Builder<PersonState> result = ImmutableList.builder();

            for (PersonStringState stringState : list) {
                result.add(stringState.asState());
            }
            return result.build();
        }

        public List<PersonMutableState> asMutableList(List<PersonStringState> list) {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonStringState stringState : list) {
                result.add(stringState.asMutableState());
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonStringState that = (PersonStringState) o;

            if (address != null ? !address.equals(that.address) : that.address != null) return false;
            if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
            if (children != null ? !children.equals(that.children) : that.children != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;

            return true;
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
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", children=" + children +
                    ", address=" + address +
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

        private static String DATE_MIDNIGHT_FORMAT = "yyyy-MM-dd";

        public static String asString(DateMidnight date) {
            return new SimpleDateFormat(DATE_MIDNIGHT_FORMAT).format(date.toDate());
        }

        public static DateMidnight asDateMidnight(String date) {
            return DateTimeFormat.forPattern(DATE_MIDNIGHT_FORMAT).parseDateTime(date).toDateMidnight();
        }
    }
}
