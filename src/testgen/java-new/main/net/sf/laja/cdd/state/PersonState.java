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

    // Only increase version if making changes that is not backward compatible.
    private static int VERSION = 1;

    private void postAssertIsValid() {
        if (birthday.isAfterNow()) {
            throw new IllegalBirthdayException();
        }
    }

    // Generated code goes here...

    public static PersonToDataConverter converter = new PersonToDataConverter();

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
        return converter.asDataFromState(this);
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
            return converter.asDataFromMutableState(this);
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

    public static class PersonToDataConverter implements Data.DataConverter<PersonState,PersonMutableState> {

        public PersonState asState(Map map) {
            return asMutableState(map).asImmutable();
        }

        public PersonMutableState asMutableState(Map map) {
            Data data = new Data(map);
            return buildPerson()
                    .withName(data.string("name"))
                    .withBirthday(data.dateMidnight("birthday"))
                    .withChildren(asPersonMutableState(data.list("children")))
                    .withAddress(AddressState.converter.asMutableState(data.data("address"))).getMutableState();
        }

        public Map asDataFromState(PersonState state) {
            return Data.build(VERSION, PersonState.class.getCanonicalName())
                    .value("name", state.name)
                    .value("birthday", state.birthday)
                    .value("children", asDataFromList(state.children))
                    .value("address", (state.address == null ? null : state.address.asData())).map();
        }

        public Map asDataFromMutableState(PersonMutableState state) {
            return Data.build(VERSION, PersonState.class.getCanonicalName())
                    .value("name", state.name)
                    .value("birthday", state.birthday)
                    .value("children", asDataFromMutableList(state.children))
                    .value("address", (state.address == null ? null : state.address.asData())).map();
        }

        private List<PersonMutableState> asPersonMutableState(List<Map> list) {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (Map map : list) {
                result.add(asMutableState(map));
            }
            return result;
        }

        private List<Map> asDataFromList(ImmutableList<PersonState> list) {
            List<Map> result = new ArrayList<Map>();

            if (list != null) {
                for (PersonState state : list) {
                    result.add(state.asData());
                }
            }
            return result;
        }

        private List<Map> asDataFromMutableList(List<PersonMutableState> list) {
            List<Map> result = new ArrayList<Map>();

            if (list != null) {
                for (PersonMutableState mutableState : list) {
                    result.add(mutableState.asData());
                }
            }
            return result;
        }
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
