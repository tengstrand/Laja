package net.sf.laja.cdd.testgen.state;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Id;
import net.sf.laja.cdd.annotation.Optional;
import net.sf.laja.cdd.annotation.State;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.InvalidStateException;
import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;
import net.sf.laja.cdd.state.converter.StateConverter;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.converter.StateConverters.*;
import static net.sf.laja.cdd.testgen.state.AddressState.*;
import static net.sf.laja.cdd.validator.ValidationErrors.concatenate;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static net.sf.laja.cdd.validator.Validators.mapValidator;

@State(version = 2)
public class PersonState implements ImmutableState {
    @Id public final int id;
    public final String name;
    @Optional
    public final LocalDate dateOfBirth;
    public final String hairColor;
    public final ImmutableSet<PersonState> children;
    public final AddressState address;
    @Optional
    public final AddressState oldAddress;
    @Optional(defaultValue = "new LinkedHashSet<AddressMutableState>()")
    public final ImmutableSet<AddressState> oldAddresses;
    public final ImmutableMap<String,AddressState> groupedAddresses;
    @Optional
    public final ImmutableList<ImmutableSet<AddressState>> listOfSetOfState;
    public final ImmutableList<ImmutableSet<ImmutableMap<String,Integer>>> listOfSetOfMapOfIntegers;

    // ===== Generated code =====

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DATE_OF_BIRTH = "dateOfBirth";
    public static final String HAIR_COLOR = "hairColor";
    public static final String CHILDREN = "children";
    public static final String ADDRESS = "address";
    public static final String OLD_ADDRESS = "oldAddress";
    public static final String OLD_ADDRESSES = "oldAddresses";
    public static final String GROUPED_ADDRESSES = "groupedAddresses";
    public static final String LIST_OF_SET_OF_STATE = "listOfSetOfState";
    public static final String LIST_OF_SET_OF_MAP_OF_INTEGERS = "listOfSetOfMapOfIntegers";

    public PersonState(
            int id,
            String name,
            LocalDate dateOfBirth,
            String hairColor,
            ImmutableSet<PersonState> children,
            AddressState address,
            AddressState oldAddress,
            ImmutableSet<AddressState> oldAddresses,
            ImmutableMap<String,AddressState> groupedAddresses,
            ImmutableList<ImmutableSet<AddressState>> listOfSetOfState,
            ImmutableList<ImmutableSet<ImmutableMap<String,Integer>>> listOfSetOfMapOfIntegers) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.hairColor = hairColor;
        this.children = children;
        this.address = address;
        this.oldAddress = oldAddress;
        this.oldAddresses = oldAddresses;
        this.groupedAddresses = groupedAddresses;
        this.listOfSetOfState = listOfSetOfState;
        this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;

        if (name == null) throw new InvalidPersonStateException("'name' can not be null");
        if (hairColor == null) throw new InvalidPersonStateException("'hairColor' can not be null");
        if (children == null) throw new InvalidPersonStateException("'children' can not be null");
        if (address == null) throw new InvalidPersonStateException("'address' can not be null");
        if (groupedAddresses == null) throw new InvalidPersonStateException("'groupedAddresses' can not be null");
        if (listOfSetOfMapOfIntegers == null) throw new InvalidPersonStateException("'listOfSetOfMapOfIntegers' can not be null");
    }

    public static class InvalidPersonStateException extends InvalidStateException {
        public InvalidPersonStateException(String message) {
            super(message);
        }

        public InvalidPersonStateException(ValidationErrors errors) {
            super(errors);
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getHairColor() { return hairColor; }
    public ImmutableSet<PersonState> getChildren() { return children; }
    public AddressState getAddress() { return address; }
    public AddressState getOldAddress() { return oldAddress; }
    public ImmutableSet<AddressState> getOldAddresses() { return oldAddresses; }
    public ImmutableMap<String,AddressState> getGroupedAddresses() { return groupedAddresses; }
    public ImmutableList<ImmutableSet<AddressState>> getListOfSetOfState() { return listOfSetOfState; }
    public ImmutableList<ImmutableSet<ImmutableMap<String,Integer>>> getListOfSetOfMapOfIntegers() { return listOfSetOfMapOfIntegers; }

    public PersonState withId(int id) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withName(String name) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withDateOfBirth(LocalDate dateOfBirth) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withHairColor(String hairColor) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withChildren(ImmutableSet<PersonState> children) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withAddress(AddressState address) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withOldAddress(AddressState oldAddress) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withOldAddresses(ImmutableSet<AddressState> oldAddresses) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withGroupedAddresses(ImmutableMap<String,AddressState> groupedAddresses) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withListOfSetOfState(ImmutableList<ImmutableSet<AddressState>> listOfSetOfState) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }
    public PersonState withListOfSetOfMapOfIntegers(ImmutableList<ImmutableSet<ImmutableMap<String,Integer>>> listOfSetOfMapOfIntegers) { return new PersonState(id, name, dateOfBirth, hairColor, children, address, oldAddress, oldAddresses, groupedAddresses, listOfSetOfState, listOfSetOfMapOfIntegers); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(
                id,
                name,
                dateOfBirth,
                hairColor,
                asMutableSet(children, toMutable),
                address != null ? address.asMutable() : null,
                oldAddress != null ? oldAddress.asMutable() : null,
                asMutableSet(oldAddresses, toMutable),
                asMutableMap(groupedAddresses, toMutable),
                asMutableList(listOfSetOfState, toMutableSet, toMutable),
                asMutableList(listOfSetOfMapOfIntegers, toMutableSet, toMutableMap)
        );
    }

    public PersonStringState asStringState() {
        return asMutable().asStringState();
    }

    public PersonStringState asStringState(StringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    public PersonStringState asStringState(PersonStringStateConverter converter) {
        return asMutable().asStringState(converter);
    }

    @Override
    public int hashCode() {
        int result = id;

        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        PersonState state = (PersonState)that;

        if (id != state.id) return false;

        return true;
    }

    public int hashCodeValue() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (oldAddress != null ? oldAddress.hashCode() : 0);
        result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);
        result = 31 * result + (groupedAddresses != null ? groupedAddresses.hashCode() : 0);
        result = 31 * result + (listOfSetOfState != null ? listOfSetOfState.hashCode() : 0);
        result = 31 * result + (listOfSetOfMapOfIntegers != null ? listOfSetOfMapOfIntegers.hashCode() : 0);

        return result;
    }

    public boolean equalsValue(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        PersonState state = (PersonState)that;

        if (id != state.id) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(state.dateOfBirth) : state.dateOfBirth != null) return false;
        if (hairColor != null ? !hairColor.equals(state.hairColor) : state.hairColor != null) return false;
        if (children != null ? !children.equals(state.children) : state.children != null) return false;
        if (address != null ? !address.equals(state.address) : state.address != null) return false;
        if (oldAddress != null ? !oldAddress.equals(state.oldAddress) : state.oldAddress != null) return false;
        if (oldAddresses != null ? !oldAddresses.equals(state.oldAddresses) : state.oldAddresses != null) return false;
        if (groupedAddresses != null ? !groupedAddresses.equals(state.groupedAddresses) : state.groupedAddresses != null) return false;
        if (listOfSetOfState != null ? !listOfSetOfState.equals(state.listOfSetOfState) : state.listOfSetOfState != null) return false;
        if (listOfSetOfMapOfIntegers != null ? !listOfSetOfMapOfIntegers.equals(state.listOfSetOfMapOfIntegers) : state.listOfSetOfMapOfIntegers != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                ", dateOfBirth=" + dateOfBirth +
                ", hairColor=" + (hairColor == null ? null : '\"' + hairColor + '\"' ) +
                ", children=" + children +
                ", address=" + address +
                ", oldAddress=" + oldAddress +
                ", oldAddresses=" + oldAddresses +
                ", groupedAddresses=" + groupedAddresses +
                ", listOfSetOfState=" + listOfSetOfState +
                ", listOfSetOfMapOfIntegers=" + listOfSetOfMapOfIntegers + '}';
    }

    @State(version = 2, type = "mutable")
    public static class PersonMutableState implements MutableState {
        @Id public int id;
        public String name;
        @Optional
        public LocalDate dateOfBirth;
        public String hairColor;
        public Set<PersonMutableState> children;
        public AddressMutableState address;
        @Optional
        public AddressMutableState oldAddress;
        @Optional(defaultValue = "new LinkedHashSet<AddressMutableState>()")
        public Set<AddressMutableState> oldAddresses;
        public Map<String,AddressMutableState> groupedAddresses;
        @Optional
        public List<Set<AddressMutableState>> listOfSetOfState;
        public List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers;

        public PersonMutableState() {
            oldAddresses = new LinkedHashSet<AddressMutableState>();
        }

        public PersonMutableState(
                int id,
                String name,
                LocalDate dateOfBirth,
                String hairColor,
                Set<PersonMutableState> children,
                AddressMutableState address,
                AddressMutableState oldAddress,
                Set<AddressMutableState> oldAddresses,
                Map<String,AddressMutableState> groupedAddresses,
                List<Set<AddressMutableState>> listOfSetOfState,
                List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.hairColor = hairColor;
            this.children = children;
            this.address = address;
            this.oldAddress = oldAddress;
            this.oldAddresses = oldAddresses;
            this.groupedAddresses = groupedAddresses;
            this.listOfSetOfState = listOfSetOfState;
            this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;
        }

        public PersonMutableState(PersonMutableState state) {
            id = state.id;
            name = state.name;
            dateOfBirth = state.dateOfBirth;
            hairColor = state.hairColor;
            children = state.children;
            address = state.address;
            oldAddress = state.oldAddress;
            oldAddresses = state.oldAddresses;
            groupedAddresses = state.groupedAddresses;
            listOfSetOfState = state.listOfSetOfState;
            listOfSetOfMapOfIntegers = state.listOfSetOfMapOfIntegers;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public String getHairColor() { return hairColor; }
        public Set<PersonMutableState> getChildren() { return children; }
        public AddressMutableState getAddress() { return address; }
        public AddressMutableState getOldAddress() { return oldAddress; }
        public Set<AddressMutableState> getOldAddresses() { return oldAddresses; }
        public Map<String,AddressMutableState> getGroupedAddresses() { return groupedAddresses; }
        public List<Set<AddressMutableState>> getListOfSetOfState() { return listOfSetOfState; }
        public List<Set<Map<String,Integer>>> getListOfSetOfMapOfIntegers() { return listOfSetOfMapOfIntegers; }

        public void setId(int id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
        public void setHairColor(String hairColor) { this.hairColor = hairColor; }
        public void setChildren(Set<PersonMutableState> children) { this.children = children; }
        public void setAddress(AddressMutableState address) { this.address = address; }
        public void setOldAddress(AddressMutableState oldAddress) { this.oldAddress = oldAddress; }
        public void setOldAddresses(Set<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses; }
        public void setGroupedAddresses(Map<String,AddressMutableState> groupedAddresses) { this.groupedAddresses = groupedAddresses; }
        public void setListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) { this.listOfSetOfState = listOfSetOfState; }
        public void setListOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) { this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; }

        public PersonMutableState withId(int id) { this.id = id; return this; }
        public PersonMutableState withName(String name) { this.name = name; return this; }
        public PersonMutableState withDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public PersonMutableState withHairColor(String hairColor) { this.hairColor = hairColor; return this; }
        public PersonMutableState withChildren() { this.children = new HashSet<PersonMutableState>(); return this; }
        public PersonMutableState withChildren(Set<PersonMutableState> children) { this.children = children; return this; }
        public PersonMutableState withAddress(AddressMutableState address) { this.address = address; return this; }
        public PersonMutableState withOldAddress(AddressMutableState oldAddress) { this.oldAddress = oldAddress; return this; }
        public PersonMutableState withOldAddresses() { this.oldAddresses = new HashSet<AddressMutableState>(); return this; }
        public PersonMutableState withOldAddresses(Set<AddressMutableState> oldAddresses) { this.oldAddresses = oldAddresses; return this; }
        public PersonMutableState withGroupedAddresses() { this.groupedAddresses = new HashMap<String,AddressMutableState>(); return this; }
        public PersonMutableState withGroupedAddresses(Map<String,AddressMutableState> groupedAddresses) { this.groupedAddresses = groupedAddresses; return this; }
        public PersonMutableState withListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) { this.listOfSetOfState = listOfSetOfState; return this; }
        public PersonMutableState withListOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) { this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; return this; }

        public PersonState asImmutable() {
            assertIsValid();

            return new PersonState(
                    id,
                    name,
                    dateOfBirth,
                    hairColor,
                    asImmutableSet(children, toImmutable),
                    address != null ? address.asImmutable() : null,
                    oldAddress != null ? oldAddress.asImmutable() : null,
                    asImmutableSet(oldAddresses, toImmutable),
                    asImmutableMap(groupedAddresses, toImmutable),
                    asImmutableList(listOfSetOfState, toImmutableSet, toImmutable),
                    asImmutableList(listOfSetOfMapOfIntegers, toImmutableSet, toImmutableMap)
            );
        }

        public Map asMap() {
            Map result = new LinkedHashMap();

            result.put("id", id);
            result.put("name", name);
            result.put("dateOfBirth", dateOfBirth);
            result.put("hairColor", hairColor);
            result.put("children", asMutableSet(children, toMap));
            result.put("address", address != null ? address.asMap() : null);
            result.put("oldAddress", oldAddress != null ? oldAddress.asMap() : null);
            result.put("oldAddresses", asMutableSet(oldAddresses, toMap));
            result.put("groupedAddresses", asMutableMap(groupedAddresses, toMap));
            result.put("listOfSetOfState", asMutableList(listOfSetOfState, toMutableSet, toMap));
            result.put("listOfSetOfMapOfIntegers", asMutableList(listOfSetOfMapOfIntegers, toMutableSet, toMutableMap));

            return result;
        }

        public PersonStringState asStringState() {
            return asStringState(new PersonStringStateConverter());
        }

        public PersonStringState asStringState(StringStateConverter converter) {
            return asStringState(new PersonStringStateConverter(converter));
        }

        public PersonStringState asStringState(PersonStringStateConverter converter) {
            return new PersonStringState(
                    converter.idToString(id),
                    converter.nameToString(name),
                    converter.dateOfBirthToString(dateOfBirth),
                    converter.hairColorToString(hairColor),
                    converter.childrenToString(children),
                    converter.addressToString(address),
                    converter.oldAddressToString(oldAddress),
                    converter.oldAddressesToString(oldAddresses),
                    converter.groupedAddressesToString(groupedAddresses),
                    converter.listOfSetOfStateToString(listOfSetOfState),
                    converter.listOfSetOfMapOfIntegersToString(listOfSetOfMapOfIntegers)
            );
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
            if (name == null) errors.addIsNullError(rootElement, "name", parent);
            if (hairColor == null) errors.addIsNullError(rootElement, "hairColor", parent);
            if (children == null) errors.addIsNullError(rootElement, "children", parent);
            if (address == null) errors.addIsNullError(rootElement, "address", parent);
            if (groupedAddresses == null) errors.addIsNullError(rootElement, "groupedAddresses", parent);
            if (listOfSetOfMapOfIntegers == null) errors.addIsNullError(rootElement, "listOfSetOfMapOfIntegers", parent);

            if (children != null) collectionValidator.validate(rootElement, children, parent, "children", errors, 0);
            if (address != null) address.validate(rootElement, concatenate(parent, "address"), errors);
            if (oldAddress != null) oldAddress.validate(rootElement, concatenate(parent, "oldAddress"), errors);
            if (oldAddresses != null) collectionValidator.validate(rootElement, oldAddresses, parent, "oldAddresses", errors, 0);
            if (groupedAddresses != null) mapValidator.validate(rootElement, groupedAddresses, parent, "groupedAddresses", errors, 0);
            if (listOfSetOfState != null) collectionValidator.validate(rootElement, listOfSetOfState, parent, "listOfSetOfState", errors, 0);
        }

        public void assertIsValid() {
            ValidationErrors errors = validate();

            if (errors.isInvalid()) {
                throw new InvalidPersonStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = id;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonMutableState state = (PersonMutableState)that;

            if (id != state.id) return false;

            return true;
        }

    public int hashCodeValue() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
            result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (oldAddress != null ? oldAddress.hashCode() : 0);
            result = 31 * result + (oldAddresses != null ? oldAddresses.hashCode() : 0);
            result = 31 * result + (groupedAddresses != null ? groupedAddresses.hashCode() : 0);
            result = 31 * result + (listOfSetOfState != null ? listOfSetOfState.hashCode() : 0);
            result = 31 * result + (listOfSetOfMapOfIntegers != null ? listOfSetOfMapOfIntegers.hashCode() : 0);

            return result;
    }

    public boolean equalsValue(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonMutableState state = (PersonMutableState)that;

            if (id != state.id) return false;
            if (name != null ? !name.equals(state.name) : state.name != null) return false;
            if (dateOfBirth != null ? !dateOfBirth.equals(state.dateOfBirth) : state.dateOfBirth != null) return false;
            if (hairColor != null ? !hairColor.equals(state.hairColor) : state.hairColor != null) return false;
            if (children != null ? !children.equals(state.children) : state.children != null) return false;
            if (address != null ? !address.equals(state.address) : state.address != null) return false;
            if (oldAddress != null ? !oldAddress.equals(state.oldAddress) : state.oldAddress != null) return false;
            if (oldAddresses != null ? !oldAddresses.equals(state.oldAddresses) : state.oldAddresses != null) return false;
            if (groupedAddresses != null ? !groupedAddresses.equals(state.groupedAddresses) : state.groupedAddresses != null) return false;
            if (listOfSetOfState != null ? !listOfSetOfState.equals(state.listOfSetOfState) : state.listOfSetOfState != null) return false;
            if (listOfSetOfMapOfIntegers != null ? !listOfSetOfMapOfIntegers.equals(state.listOfSetOfMapOfIntegers) : state.listOfSetOfMapOfIntegers != null) return false;

            return true;
    }

        @Override
        public String toString() {
            return "{id=" + id +
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", dateOfBirth=" + dateOfBirth +
                    ", hairColor=" + (hairColor == null ? null : '\"' + hairColor + '\"' ) +
                    ", children=" + children +
                    ", address=" + address +
                    ", oldAddress=" + oldAddress +
                    ", oldAddresses=" + oldAddresses +
                    ", groupedAddresses=" + groupedAddresses +
                    ", listOfSetOfState=" + listOfSetOfState +
                    ", listOfSetOfMapOfIntegers=" + listOfSetOfMapOfIntegers + '}';
        }
    }

    public static MapToPersonConverter mapToPersonConverter = new MapToPersonConverter();

    public static PersonMutableState toPersonMutableState(Map map) {
        return mapToPersonConverter.convert(map, 0);
    }

    public static class MapToPersonConverter implements StateConverter {

        public PersonMutableState convert(Object from, int index, StateConverter... converters) {
            Map map = (Map)from;

            int id = (Integer) map.get("id");
            String name = (String) map.get("name");
            LocalDate dateOfBirth = (LocalDate) map.get("dateOfBirth");
            String hairColor = (String) map.get("hairColor");
            Set children = (Set) map.get("children");
            Map address = (Map) map.get("address");
            Map oldAddress = (Map) map.get("oldAddress");
            Set oldAddresses = (Set) map.get("oldAddresses");
            Map groupedAddresses = (Map) map.get("groupedAddresses");
            List listOfSetOfState = (List) map.get("listOfSetOfState");
            List listOfSetOfMapOfIntegers = (List) map.get("listOfSetOfMapOfIntegers");

            return new PersonMutableState(
                    id,
                    name,
                    dateOfBirth,
                    hairColor,
                    asMutableSet(children, mapToPersonConverter),
                    address != null ? toAddressMutableState(address) : null,
                    oldAddress != null ? toAddressMutableState(oldAddress) : null,
                    asMutableSet(oldAddresses, mapToAddressConverter),
                    asMutableMap(groupedAddresses, mapToAddressConverter),
                    asMutableList(listOfSetOfState, toMutableSet, mapToAddressConverter),
                    asMutableList(listOfSetOfMapOfIntegers, toMutableSet, toMutableMap)
            );
        }
    }

    @State(version = 2, type = "string")
    public static class PersonStringState implements StringState {
        @Id public String id;
        public String name;
        @Optional
        public String dateOfBirth;
        public String hairColor;
        public Set<PersonStringState> children;
        public AddressStringState address;
        @Optional
        public AddressStringState oldAddress;
        @Optional(defaultValue = "new LinkedHashSet<AddressStringState>()")
        public Set<AddressStringState> oldAddresses;
        public Map<String,AddressStringState> groupedAddresses;
        @Optional
        public List<Set<AddressStringState>> listOfSetOfState;
        public List<Set<Map<String,String>>> listOfSetOfMapOfIntegers;

        public PersonStringState() {
            oldAddresses = new LinkedHashSet<AddressStringState>();
        }

        public PersonStringState(
                String id,
                String name,
                String dateOfBirth,
                String hairColor,
                Set<PersonStringState> children,
                AddressStringState address,
                AddressStringState oldAddress,
                Set<AddressStringState> oldAddresses,
                Map<String,AddressStringState> groupedAddresses,
                List<Set<AddressStringState>> listOfSetOfState,
                List<Set<Map<String,String>>> listOfSetOfMapOfIntegers) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.hairColor = hairColor;
            this.children = children;
            this.address = address;
            this.oldAddress = oldAddress;
            this.oldAddresses = oldAddresses;
            this.groupedAddresses = groupedAddresses;
            this.listOfSetOfState = listOfSetOfState;
            this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public String getDateOfBirth() { return dateOfBirth; }
        public String getHairColor() { return hairColor; }
        public Set<PersonStringState> getChildren() { return children; }
        public AddressStringState getAddress() { return address; }
        public AddressStringState getOldAddress() { return oldAddress; }
        public Set<AddressStringState> getOldAddresses() { return oldAddresses; }
        public Map<String,AddressStringState> getGroupedAddresses() { return groupedAddresses; }
        public List<Set<AddressStringState>> getListOfSetOfState() { return listOfSetOfState; }
        public List<Set<Map<String,String>>> getListOfSetOfMapOfIntegers() { return listOfSetOfMapOfIntegers; }

        public void setId(String id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
        public void setHairColor(String hairColor) { this.hairColor = hairColor; }
        public void setChildren(Set<PersonStringState> children) { this.children = children; }
        public void setAddress(AddressStringState address) { this.address = address; }
        public void setOldAddress(AddressStringState oldAddress) { this.oldAddress = oldAddress; }
        public void setOldAddresses(Set<AddressStringState> oldAddresses) { this.oldAddresses = oldAddresses; }
        public void setGroupedAddresses(Map<String,AddressStringState> groupedAddresses) { this.groupedAddresses = groupedAddresses; }
        public void setListOfSetOfState(List<Set<AddressStringState>> listOfSetOfState) { this.listOfSetOfState = listOfSetOfState; }
        public void setListOfSetOfMapOfIntegers(List<Set<Map<String,String>>> listOfSetOfMapOfIntegers) { this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; }

        public PersonStringState withId(String id) { this.id = id; return this; }
        public PersonStringState withName(String name) { this.name = name; return this; }
        public PersonStringState withDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public PersonStringState withHairColor(String hairColor) { this.hairColor = hairColor; return this; }
        public PersonStringState withChildren() { this.children = new HashSet<PersonStringState>(); return this; }
        public PersonStringState withChildren(Set<PersonStringState> children) { this.children = children; return this; }
        public PersonStringState withAddress(AddressStringState address) { this.address = address; return this; }
        public PersonStringState withOldAddress(AddressStringState oldAddress) { this.oldAddress = oldAddress; return this; }
        public PersonStringState withOldAddresses() { this.oldAddresses = new HashSet<AddressStringState>(); return this; }
        public PersonStringState withOldAddresses(Set<AddressStringState> oldAddresses) { this.oldAddresses = oldAddresses; return this; }
        public PersonStringState withGroupedAddresses() { this.groupedAddresses = new HashMap<String,AddressStringState>(); return this; }
        public PersonStringState withGroupedAddresses(Map<String,AddressStringState> groupedAddresses) { this.groupedAddresses = groupedAddresses; return this; }
        public PersonStringState withListOfSetOfState(List<Set<AddressStringState>> listOfSetOfState) { this.listOfSetOfState = listOfSetOfState; return this; }
        public PersonStringState withListOfSetOfMapOfIntegers(List<Set<Map<String,String>>> listOfSetOfMapOfIntegers) { this.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; return this; }

        public PersonState asImmutable() {
            return asMutable().asImmutable();
        }

        public PersonState asImmutable(PersonStringStateConverter converter) {
            return asMutable(converter).asImmutable();
        }

        public PersonMutableState asMutable() {
            return asMutable(new PersonStringStateConverter());
        }

        public PersonMutableState asMutable(PersonStringStateConverter converter) {
            return new PersonMutableState(
                    converter.toId(id),
                    converter.toName(name),
                    converter.toDateOfBirth(dateOfBirth),
                    converter.toHairColor(hairColor),
                    converter.toChildren(children),
                    converter.toAddress(address),
                    converter.toOldAddress(oldAddress),
                    converter.toOldAddresses(oldAddresses),
                    converter.toGroupedAddresses(groupedAddresses),
                    converter.toListOfSetOfState(listOfSetOfState),
                    converter.toListOfSetOfMapOfIntegers(listOfSetOfMapOfIntegers)
            );
        }

        public Map asMap() {
            return asMutable().asMap();
        }

        public boolean isValid() {
            return validate().isValid();
        }

        public ValidationErrors validate() {
            return validate(new PersonStringStateValidator());
        }

        public ValidationErrors validate(PersonStringStateValidator stateValidator) {
            ValidationErrors.Builder errors = ValidationErrors.builder();
            validate(stateValidator, this, "", errors);
            return errors.build();
        }

        public void validate(PersonStringStateValidator stateValidator, Object rootElement, String parent, ValidationErrors.Builder errors) {
            stateValidator.validateId(id, rootElement, parent, errors);
            stateValidator.validateName(name, rootElement, parent, errors);
            stateValidator.validateDateOfBirth(dateOfBirth, rootElement, parent, errors);
            stateValidator.validateHairColor(hairColor, rootElement, parent, errors);
            stateValidator.validateChildren(children, rootElement, parent, errors);
            stateValidator.validateAddress(address, rootElement, parent, errors);
            stateValidator.validateOldAddress(oldAddress, rootElement, parent, errors);
            stateValidator.validateOldAddresses(oldAddresses, rootElement, parent, errors);
            stateValidator.validateGroupedAddresses(groupedAddresses, rootElement, parent, errors);
            stateValidator.validateListOfSetOfState(listOfSetOfState, rootElement, parent, errors);
            stateValidator.validateListOfSetOfMapOfIntegers(listOfSetOfMapOfIntegers, rootElement, parent, errors);

            asMutable().validate(rootElement, parent, errors);
        }

        public void assertIsValid() {
            assertIsValid(new PersonStringStateValidator());
        }

        public void assertIsValid(PersonStringStateValidator stateValidator) {
            ValidationErrors errors = validate(stateValidator);

            if (errors.isInvalid()) {
                throw new InvalidPersonStateException(errors);
            }
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;

            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            PersonStringState state = (PersonStringState)that;

            if (id != null ? !id.equals(state.id) : state.id != null) return false;

            return true;
        }

        @Override
        public String toString() {
            return "{id=" + (id == null ? null : '\"' + id + '\"' ) +
                    ", name=" + (name == null ? null : '\"' + name + '\"' ) +
                    ", dateOfBirth=" + (dateOfBirth == null ? null : '\"' + dateOfBirth + '\"' ) +
                    ", hairColor=" + (hairColor == null ? null : '\"' + hairColor + '\"' ) +
                    ", children=" + children +
                    ", address=" + address +
                    ", oldAddress=" + oldAddress +
                    ", oldAddresses=" + oldAddresses +
                    ", groupedAddresses=" + groupedAddresses +
                    ", listOfSetOfState=" + listOfSetOfState +
                    ", listOfSetOfMapOfIntegers=" + listOfSetOfMapOfIntegers + '}';
        }
    }

    public static class PersonStringStateConverter {
        private final StringStateConverter converter;

        public PersonStringStateConverter() { converter = new StringStateConverter(); }
        public PersonStringStateConverter(StringStateConverter converter) { this.converter = converter; }

        public String idToString(int id) { return converter.intToString(id); }
        public String nameToString(String name) { return name; }
        public String dateOfBirthToString(LocalDate dateOfBirth) { return converter.toString(dateOfBirth); }
        public String hairColorToString(String hairColor) { return hairColor; }
        public Set<PersonStringState> childrenToString(Set<PersonMutableState> children) { return asMutableSet(children, toMutableString); }
        public AddressStringState addressToString(AddressMutableState address) { return address != null ? address.asStringState(converter) : null; }
        public AddressStringState oldAddressToString(AddressMutableState oldAddress) { return oldAddress != null ? oldAddress.asStringState(converter) : null; }
        public Set<AddressStringState> oldAddressesToString(Set<AddressMutableState> oldAddresses) { return asMutableSet(oldAddresses, toMutableString); }
        public Map<String,AddressStringState> groupedAddressesToString(Map<String,AddressMutableState> groupedAddresses) { return asMutableMap(groupedAddresses, toMutableString); }
        public List<Set<AddressStringState>> listOfSetOfStateToString(List<Set<AddressMutableState>> listOfSetOfState) { return asMutableList(listOfSetOfState, toMutableSet, toMutableString); }
        public List<Set<Map<String,String>>> listOfSetOfMapOfIntegersToString(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) { return asMutableList(listOfSetOfMapOfIntegers, toMutableSet, toMutableMap, converter.objectToStringConverter()); }

        public int toId(String id) { return converter.toInt(id); }
        public String toName(String name) { return name; }
        public LocalDate toDateOfBirth(String dateOfBirth) { return converter.toLocalDate(dateOfBirth); }
        public String toHairColor(String hairColor) { return hairColor; }
        public Set<PersonMutableState> toChildren(Set<PersonStringState> children) { return asMutableSet(children, toMutable); }
        public AddressMutableState toAddress(AddressStringState address) { return address != null ? address.asMutable() : null; }
        public AddressMutableState toOldAddress(AddressStringState oldAddress) { return oldAddress != null ? oldAddress.asMutable() : null; }
        public Set<AddressMutableState> toOldAddresses(Set<AddressStringState> oldAddresses) { return asMutableSet(oldAddresses, toMutable); }
        public Map<String,AddressMutableState> toGroupedAddresses(Map<String,AddressStringState> groupedAddresses) { return asMutableMap(groupedAddresses, toMutable); }
        public List<Set<AddressMutableState>> toListOfSetOfState(List<Set<AddressStringState>> listOfSetOfState) { return asMutableList(listOfSetOfState, toMutableSet, toMutable); }
        public List<Set<Map<String,Integer>>> toListOfSetOfMapOfIntegers(List<Set<Map<String,String>>> listOfSetOfMapOfIntegers) { return asMutableList(listOfSetOfMapOfIntegers, toMutableSet, toMutableMap, toInteger); }
    }

    public static class PersonStringStateValidator {
        private final PersonStringStateConverter converter;

        public PersonStringStateValidator() { converter = new PersonStringStateConverter(); }
        public PersonStringStateValidator(PersonStringStateConverter converter) { this.converter = converter; }

        public void validateId(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toId(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "id", parent); }
        }

        public void validateName(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateDateOfBirth(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toDateOfBirth(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "dateOfBirth", parent); }
        }

        public void validateHairColor(String value, Object rootElement, String parent, ValidationErrors.Builder errors) {
        }

        public void validateChildren(Set<PersonStringState> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toChildren(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "children", parent); }
        }

        public void validateAddress(AddressStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toAddress(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "address", parent); }
        }

        public void validateOldAddress(AddressStringState value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toOldAddress(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "oldAddress", parent); }
        }

        public void validateOldAddresses(Set<AddressStringState> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toOldAddresses(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "oldAddresses", parent); }
        }

        public void validateGroupedAddresses(Map<String,AddressStringState> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toGroupedAddresses(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "groupedAddresses", parent); }
        }

        public void validateListOfSetOfState(List<Set<AddressStringState>> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toListOfSetOfState(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "listOfSetOfState", parent); }
        }

        public void validateListOfSetOfMapOfIntegers(List<Set<Map<String,String>>> value, Object rootElement, String parent, ValidationErrors.Builder errors) {
            try { converter.toListOfSetOfMapOfIntegers(value); } catch (Exception e) { errors.addTypeConversionError(rootElement, "listOfSetOfMapOfIntegers", parent); }
        }
    }
}
