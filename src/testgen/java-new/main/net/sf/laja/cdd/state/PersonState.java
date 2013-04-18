package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableList;
import net.sf.laja.cdd.Data;
import org.joda.time.DateMidnight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class PersonState implements Serializable {
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;

    // Only increase version if making not backward compatible changes in the data structure.
    private static int VERSION = 1;

    private static void defaults(PersonMutableState state) {
        state.name = "";
        state.birthday = new DateMidnight(1999, 9, 9);
        state.children = new ArrayList<PersonMutableState>();
        state.address = AddressMutableState.create();
    }

    private void postAssertIsValid() {
        if (birthday.isAfterNow()) {
            throw new IllegalBirthdayException();
        }
    }

    // Generated code goes here...

    public static PersonMutableState.PersonToDataConverter converter = new PersonMutableState.PersonToDataConverter();

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
        address.assertIsValid();

        postAssertIsValid();
    }

    public PersonState withName(String name) { return new PersonState(name, birthday, children, address); }
    public PersonState withAge(DateMidnight birthday) { return new PersonState(name, birthday, children, address); }
    public PersonState withAddress(AddressState address) { return new PersonState(name, birthday, children, address); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(name, birthday, Converter.asMutableList(children), address.asMutable());
    }

    public Map asData() {
        return Data.build(VERSION, getClass().getCanonicalName())
                    .value("name", name)
                    .value("birthday", birthday)
                    .value("children", asDataList(children))
                    .value("address", address.asData()).map();
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

        private PersonMutableState() {
        }

        public static PersonMutableState create() {
            return new PersonMutableState();
        }

        public static PersonMutableState createWithDefaults() {
            PersonMutableState state = create();
            defaults(state);
            return state;
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

        public Map<String, Object> asData() {
            return Data.build(VERSION, PersonState.class.getCanonicalName())
                        .value("name", name)
                        .value("birthday", birthday)
                        .value("children", asDataList(children))
                        .value("address", (address == null ? null : address.asData())).map();
        }

        private List<Map> asDataList(List<PersonMutableState> list) {
            List<Map> result = new ArrayList<Map>();

            if (list != null) {
                for (PersonMutableState mutableState : list) {
                    result.add(mutableState.asData());
                }
            }
            return result;
        }

        public static class PersonToDataConverter implements Data.DataConverter<PersonMutableState> {

            public PersonMutableState convert(Map map) {
                Data data = Data.create(map);
                return buildPerson()
                        .withName(data.string("name"))
                        .withBirthday(data.dateMidnight("birthday"))
                        .withChildren(asPersonMutableState(data.list("children")))
                        .withAddress(AddressState.converter.convert(data.data("address"))).getMutableState();
            }

            private List<PersonMutableState> asPersonMutableState(List<Map> list) {
                List<PersonMutableState> result = new ArrayList<PersonMutableState>();

                for (Map map : list) {
                    result.add(convert(map));
                }
                return result;
            }
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

    private static List<Map> asDataList(ImmutableList<PersonState> list) {
        List<Map> result = new ArrayList<Map>();

        for (PersonState state : list) {
            result.add(state.asData());
        }
        return result;
    }

    public static class Converter {
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
