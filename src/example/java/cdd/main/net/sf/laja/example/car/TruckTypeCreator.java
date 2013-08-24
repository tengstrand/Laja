package net.sf.laja.example.car;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.example.car.state.TruckTypeState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.car.state.TruckTypeState.*;

@Creator
public class TruckTypeCreator implements TruckTypeCreatorMaker {
    private final TruckTypeMutableState state;

    public TruckType asTruckType() {
        return new TruckType(state.asImmutable());
    }

    // ===== Generated code =====

    public static TruckTypeFactory createTruckType() {
        return new TruckTypeCreator(new TruckTypeMutableState()).new TruckTypeFactory();
    }

    public static TruckTypeCreator createTruckTypeFromMap(Map truckType) {
        return new TruckTypeCreator(new TruckTypeMutableState(toTruckTypeMutableState(truckType)));
    }

    public static TruckTypeBuilder buildTruckType() {
        return new TruckTypeBuilder();
    }

    public static TruckTypeBuilder buildTruckTypeFromMap(Map truckType) {
        return new TruckTypeBuilder(new TruckTypeMutableState(toTruckTypeMutableState(truckType)));
    }

    public static TruckTypeStringBuilder buildTruckTypeFromStrings() {
        return new TruckTypeStringBuilder();
    }

    public static TruckTypeListBuilder createTruckTypeList(TruckTypeCreator... creators) {
        return new TruckTypeListBuilder(creators);
    }

    public static TruckTypeSetBuilder createTruckTypeSet(TruckTypeCreator... creators) {
        return new TruckTypeSetBuilder(creators);
    }

    public static TruckTypeMapBuilder createTruckTypeMap(TruckTypeMapEntryBuilder... builders) {
        return new TruckTypeMapBuilder(builders);
    }

    public static TruckTypeMapEntryBuilder createTruckTypeEntry(Object key, TruckTypeCreator creator) {
        return new TruckTypeMapEntryBuilder(key, creator);
    }

    public static TruckTypeMapEntryBuilder createTruckTypeEntry(Object key, TruckTypeBuilder builder) {
        return new TruckTypeMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public TruckTypeCreator(TruckTypeMutableState state) {
        this.state = state;
    }

    // --- Factory ----

    public class TruckTypeFactory {

        public _TruckName numberOfWheels(int numberOfWheels) {
            return new _NumberOfWheels().numberOfWheels(numberOfWheels);
        }

        // numberOfWheels
        public class _NumberOfWheels {
            public _TruckName numberOfWheels(int numberOfWheels) {
                state.numberOfWheels = numberOfWheels;
                return new _TruckName();
            }
        }

        // truckName
        public class _TruckName {
            public TruckTypeCreator truckName(String truckName) {
                state.truckName = truckName;
                return new TruckTypeCreator(state);
            }
        }
    }
    public TruckTypeState asState() {
        return state.asImmutable();
    }

    public TruckTypeMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public TruckTypeStringState asStringState() {
        return state.asStringState();
    }

    public TruckTypeStringState asStringState(StringStateConverter stateConverter) {
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
        if (that == null || !(that instanceof TruckTypeCreator)) return false;

        return state.equals(((TruckTypeCreator)that).state);
    }

    @Override public String toString() {
        return "TruckTypeCreator" + state;
    }

    // --- Behaviour ---

    public static class TruckTypeBehaviour {
        public final TruckTypeState state;

        public TruckTypeBehaviour(TruckTypeState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidTruckTypeStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckTypeBehaviour)) return false;

            return state.equals(((TruckTypeBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class TruckTypeMutableBehaviour {
        private TruckTypeMutableState state;

        public TruckTypeMutableBehaviour(TruckTypeMutableState state) {
            this.state = state;
        }

        public TruckTypeState asState() {
            return state.asImmutable();
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidTruckTypeStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckTypeMutableBehaviour)) return false;

            return state.equals(((TruckTypeMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class TruckTypeBuilder implements TruckTypeCreatorMaker {
        private final TruckTypeMutableState state;

        public TruckTypeBuilder() {
            this.state = new TruckTypeMutableState();
        }

        public TruckTypeBuilder(TruckTypeMutableState state) {
            this.state = state;
        }

        public TruckTypeBuilder withNumberOfWheels(int numberOfWheels) { state.numberOfWheels = numberOfWheels; return this; }
        public TruckTypeBuilder withTruckName(String truckName) { state.truckName = truckName; return this; }

        public TruckType asTruckType() {
            return new TruckType(state.asImmutable());
        }

        public TruckTypeState asState() {
            return state.asImmutable();
        }

        public TruckTypeMutableState asMutableState() {
            return state;
        }

        public Map asMap() {
            return state.asMap();
        }

        public TruckTypeStringState asStringState() {
            return state.asStringState();
        }

        public TruckTypeStringState asStringState(StringStateConverter stateConverter) {
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
            if (that == null || !(that instanceof TruckTypeBuilder)) return false;

            return state.equals(((TruckTypeBuilder)that).state);
        }

        @Override public String toString() {
            return "TruckTypeBuilder" + state;
        }
    }

    // --- String builder ---

    public static class TruckTypeStringBuilder {
        private final TruckTypeStringState state;

        public TruckTypeStringBuilder() {
            this.state = new TruckTypeStringState();
        }

        public TruckTypeStringBuilder(TruckTypeStringState state) {
            this.state = state;
        }

        public TruckTypeStringBuilder withNumberOfWheels(String numberOfWheels) { state.numberOfWheels = numberOfWheels; return this; }
        public TruckTypeStringBuilder withTruckName(String truckName) { state.truckName = truckName; return this; }

        public TruckType asTruckType() {
            return new TruckTypeBuilder(state.asMutable()).asTruckType();
        }

        public TruckTypeState asState() {
            return state.asImmutable();
        }

        public TruckTypeMutableState asMutableState() {
            return state.asMutable();
        }

        public TruckTypeStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckTypeStringBuilder)) return false;

            return state.equals(((TruckTypeStringBuilder)that).state);
        }

        @Override public String toString() {
            return "TruckTypeStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class TruckTypeListBuilder implements Iterable<TruckTypeCreator> {
        private List<TruckTypeCreator> creators;

        public TruckTypeListBuilder(TruckTypeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public TruckTypeListBuilder(Collection<TruckTypeCreator> creators) {
            this.creators = new ArrayList<TruckTypeCreator>();
            this.creators.addAll(creators);
        }

        // asTruckTypeList() : ImmutableList<TruckType>

        public ImmutableList<TruckType> asTruckTypeList() {
            ImmutableList.Builder<TruckType> builder = ImmutableList.builder();

            for (TruckTypeCreator creator : creators) {
                builder.add(creator.asTruckType());
            }
            return builder.build();
        }

        // asTruckTypeMutableList() : List<TruckType>

        public List<TruckType> asTruckTypeMutableList() {
            List<TruckType> result = new ArrayList<TruckType>();

            for (TruckTypeCreator creator : creators) {
                result.add(creator.asTruckType());
            }
            return result;
        }

        // asStateList() : ImmutableList<TruckTypeState>

        public ImmutableList<TruckTypeState> asStateList() {
            ImmutableList.Builder<TruckTypeState> builder = ImmutableList.builder();

            for (TruckTypeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<TruckTypeMutableState>

        public List<TruckTypeMutableState> asMutableStateList() {
            List<TruckTypeMutableState> result = new ArrayList<TruckTypeMutableState>();

            for (TruckTypeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TruckTypeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class TruckTypeSetBuilder implements Iterable<TruckTypeCreator> {
        private List<TruckTypeCreator> creators;

        public TruckTypeSetBuilder(TruckTypeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public TruckTypeSetBuilder(Collection<TruckTypeCreator> creators) {
            this.creators = new ArrayList<TruckTypeCreator>();
            this.creators.addAll(creators);
        }

        // asTruckTypeSet() : ImmutableSet<TruckType>

        public ImmutableSet<TruckType> asTruckTypeSet() {
            ImmutableSet.Builder<TruckType> builder = ImmutableSet.builder();

            for (TruckTypeCreator creator : creators) {
                builder.add(creator.asTruckType());
            }
            return builder.build();
        }

        // asTruckTypeMutableSet() : Set<TruckType>

        public Set<TruckType> asTruckTypeMutableSet() {
            Set<TruckType> result = new HashSet<TruckType>();

            for (TruckTypeCreator creator : creators) {
                result.add(creator.asTruckType());
            }
            return result;
        }

        // asState()

        public ImmutableSet<TruckTypeState> asStateSet() {
            ImmutableSet.Builder<TruckTypeState> builder = ImmutableSet.builder();

            for (TruckTypeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<TruckTypeMutableState> asMutableStateSet() {
            Set<TruckTypeMutableState> result = new HashSet<TruckTypeMutableState>();

            for (TruckTypeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TruckTypeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class TruckTypeMapEntryBuilder {
        private final Object key;
        private final TruckTypeCreatorMaker maker;

        public TruckTypeMapEntryBuilder(Object key, TruckTypeCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public TruckType asTruckType() {
            return maker.asTruckType();
        }

        public TruckTypeState asState() {
            return maker.asState();
        }

        public TruckTypeMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class TruckTypeMapBuilder {
        private final TruckTypeMapEntryBuilder[] entries;

        public TruckTypeMapBuilder(TruckTypeMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asTruckTypeMap() : ImmutableMap

        public ImmutableMap asTruckTypeMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (TruckTypeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asTruckType());
            }
            return builder.build();
        }

        // asTruckTypeMutableMap() : Map

        public Map asTruckTypeMutableMap() {
            Map result = new HashMap();

            for (TruckTypeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asTruckType());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (TruckTypeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (TruckTypeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface TruckTypeCreatorMaker {
    TruckType asTruckType();

    TruckTypeState asState();
    TruckTypeMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
