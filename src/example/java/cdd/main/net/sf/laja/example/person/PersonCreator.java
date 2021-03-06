package net.sf.laja.example.person;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.example.person.state.PersonState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.person.state.PersonState.*;

@Creator
public class PersonCreator implements PersonCreatorMaker {
    private final PersonMutableState state;

    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    // ===== Generated code =====

    public static PersonFactory createPerson() {
        return new PersonCreator(new PersonMutableState()).new PersonFactory();
    }

    public static PersonCreator createPersonFromMap(Map person) {
        return new PersonCreator(new PersonMutableState(toPersonMutableState(person)));
    }

    public static PersonBuilder buildPerson() {
        return new PersonBuilder();
    }

    public static PersonBuilder buildPersonFromMap(Map person) {
        return new PersonBuilder(new PersonMutableState(toPersonMutableState(person)));
    }

    public static PersonStringBuilder buildPersonFromStrings() {
        return new PersonStringBuilder();
    }

    public static PersonListBuilder createPersonList(PersonCreator... creators) {
        return new PersonListBuilder(creators);
    }

    public static PersonSetBuilder createPersonSet(PersonCreator... creators) {
        return new PersonSetBuilder(creators);
    }

    public static PersonMapBuilder createPersonMap(PersonMapEntryBuilder... builders) {
        return new PersonMapBuilder(builders);
    }

    public static PersonMapEntryBuilder createPersonEntry(Object key, PersonCreator creator) {
        return new PersonMapEntryBuilder(key, creator);
    }

    public static PersonMapEntryBuilder createPersonEntry(Object key, PersonBuilder builder) {
        return new PersonMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public PersonCreator(PersonMutableState state) {
        this.state = state;
    }

    // --- Factory ----

    public class PersonFactory {

        public _Surname givenName(String givenName) {
            return new _GivenName().givenName(givenName);
        }

        // givenName
        public class _GivenName {
            public _Surname givenName(String givenName) {
                state.givenName = givenName;
                return new _Surname();
            }
        }

        // surname
        public class _Surname {
            public _HeightInCentimeters surname(String surname) {
                state.surname = surname;
                return new _HeightInCentimeters();
            }
        }

        // heightInCentimeters
        public class _HeightInCentimeters {
            public _WeightInKilograms heightInCentimeters(int heightInCentimeters) {
                state.heightInCentimeters = heightInCentimeters;
                return new _WeightInKilograms();
            }
        }

        // weightInKilograms
        public class _WeightInKilograms {
            public PersonCreator weightInKilograms(int weightInKilograms) {
                state.weightInKilograms = weightInKilograms;
                return new PersonCreator(state);
            }
        }
    }

    public PersonState asState() {
        return state.asImmutable();
    }

    public PersonMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public PersonStringState asStringState() {
        return state.asStringState();
    }

    public PersonStringState asStringState(StringStateConverter stateConverter) {
        return state.asStringState(stateConverter);
    }

    // --- With methods ---

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate() {
        return state.validate();
    }

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof PersonCreator)) return false;

        return state.equals(((PersonCreator)that).state);
    }

    @Override public String toString() {
        return "PersonCreator" + state;
    }

    // --- Behaviour ---

    public static class PersonBehaviour {
        public final PersonState state;

        public PersonBehaviour(PersonState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidPersonStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonBehaviour)) return false;

            return state.equals(((PersonBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class PersonMutableBehaviour {
        private PersonMutableState state;

        public PersonMutableBehaviour(PersonMutableState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidPersonStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonMutableBehaviour)) return false;

            return state.equals(((PersonMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class PersonBuilder implements PersonCreatorMaker {
        private final PersonMutableState state;

        public PersonBuilder() {
            this.state = new PersonMutableState();
        }

        public PersonBuilder(PersonMutableState state) {
            this.state = state;
        }

        public PersonBuilder withGivenName(String givenName) { state.givenName = givenName; return this; }
        public PersonBuilder withSurname(String surname) { state.surname = surname; return this; }
        public PersonBuilder withHeightInCentimeters(int heightInCentimeters) { state.heightInCentimeters = heightInCentimeters; return this; }
        public PersonBuilder withWeightInKilograms(int weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }

        public Person asPerson() {
            return new Person(state.asImmutable());
        }

        public PersonState asState() {
            return state.asImmutable();
        }

        public PersonMutableState asMutableState() {
            return state;
        }

        public Map asMap() {
            return state.asMap();
        }

        public PersonStringState asStringState() {
            return state.asStringState();
        }

        public PersonStringState asStringState(StringStateConverter stateConverter) {
            return state.asStringState(stateConverter);
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate() {
            return state.validate();
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonBuilder)) return false;

            return state.equals(((PersonBuilder)that).state);
        }

        @Override public String toString() {
            return "PersonBuilder" + state;
        }
    }

    // --- String builder ---

    public static class PersonStringBuilder {
        private final PersonStringState state;

        public PersonStringBuilder() {
            this.state = new PersonStringState();
        }

        public PersonStringBuilder(PersonStringState state) {
            this.state = state;
        }

        public PersonStringBuilder withGivenName(String givenName) { state.givenName = givenName; return this; }
        public PersonStringBuilder withSurname(String surname) { state.surname = surname; return this; }
        public PersonStringBuilder withHeightInCentimeters(String heightInCentimeters) { state.heightInCentimeters = heightInCentimeters; return this; }
        public PersonStringBuilder withWeightInKilograms(String weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }

        public Person asPerson() {
            return new PersonBuilder(state.asMutable()).asPerson();
        }

        public PersonState asState() {
            return state.asImmutable();
        }

        public PersonMutableState asMutableState() {
            return state.asMutable();
        }

        public PersonStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonStringBuilder)) return false;

            return state.equals(((PersonStringBuilder)that).state);
        }

        @Override public String toString() {
            return "PersonStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class PersonListBuilder implements Iterable<PersonCreator> {
        private List<PersonCreator> creators;

        public PersonListBuilder(PersonCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public PersonListBuilder(Collection<PersonCreator> creators) {
            this.creators = new ArrayList<PersonCreator>();
            this.creators.addAll(creators);
        }

        // asPersonList() : ImmutableList<Person>

        public ImmutableList<Person> asPersonList() {
            ImmutableList.Builder<Person> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableList() : List<Person>

        public List<Person> asPersonMutableList() {
            List<Person> result = new ArrayList<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // asStateList() : ImmutableList<PersonState>

        public ImmutableList<PersonState> asStateList() {
            ImmutableList.Builder<PersonState> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<PersonMutableState>

        public List<PersonMutableState> asMutableStateList() {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<PersonCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class PersonSetBuilder implements Iterable<PersonCreator> {
        private List<PersonCreator> creators;

        public PersonSetBuilder(PersonCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public PersonSetBuilder(Collection<PersonCreator> creators) {
            this.creators = new ArrayList<PersonCreator>();
            this.creators.addAll(creators);
        }

        // asPersonSet() : ImmutableSet<Person>

        public ImmutableSet<Person> asPersonSet() {
            ImmutableSet.Builder<Person> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableSet() : Set<Person>

        public Set<Person> asPersonMutableSet() {
            Set<Person> result = new HashSet<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // asState()

        public ImmutableSet<PersonState> asStateSet() {
            ImmutableSet.Builder<PersonState> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<PersonMutableState> asMutableStateSet() {
            Set<PersonMutableState> result = new HashSet<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<PersonCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class PersonMapEntryBuilder {
        private final Object key;
        private final PersonCreatorMaker maker;

        public PersonMapEntryBuilder(Object key, PersonCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Person asPerson() {
            return maker.asPerson();
        }

        public PersonState asState() {
            return maker.asState();
        }

        public PersonMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class PersonMapBuilder {
        private final PersonMapEntryBuilder[] entries;

        public PersonMapBuilder(PersonMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asPersonMap() : ImmutableMap

        public ImmutableMap asPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableMap() : Map

        public Map asPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asPerson());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface PersonCreatorMaker {
    Person asPerson();

    PersonState asState();
    PersonMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
