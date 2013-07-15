package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
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

import static net.sf.laja.example.car.state.TruckTypeState.TruckTypeMutableState;

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

    public static TruckTypeBuilder buildTruckType() {
        return new TruckTypeBuilder();
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

    // --- Constructor ---

    public TruckTypeCreator(TruckTypeMutableState state) {
        this.state = state;
    }

    public TruckTypeState asState() {
        return state.asImmutable();
    }

    public TruckTypeMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    // --- Behaviour ---

    public static class TruckTypeBehaviour {
        public final TruckTypeState s;

        public TruckTypeBehaviour(TruckTypeState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckTypeBehaviour)) return false;

            return s.equals(((TruckTypeBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class TruckTypeMutableBehaviour {
        private TruckTypeMutableState s;

        public TruckTypeMutableBehaviour(TruckTypeMutableState s) {
            this.s = s;
        }

        public TruckTypeState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckTypeMutableBehaviour)) return false;

            return s.equals(((TruckTypeMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
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

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return state.validate(validators);
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
    ValidationErrors validate(Validator... validators);
}
