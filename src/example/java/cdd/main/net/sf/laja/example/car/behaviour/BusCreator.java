package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.car.state.BusState;
import net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.car.state.BusState.BusMutableState;

@Creator
public class BusCreator implements BusCreatorMaker {
    private final BusMutableState state;

    public Bus asBus() {
        return new Bus(state.asImmutable());
    }

    // ===== Generated code =====

    public static BusFactory createBus() {
        return new BusCreator(new BusMutableState()).new BusFactory();
    }

    public static BusBuilder buildBus() {
        return new BusBuilder();
    }

    public static BusListBuilder createBusList(BusCreator... creators) {
        return new BusListBuilder(creators);
    }

    public static BusSetBuilder createBusSet(BusCreator... creators) {
        return new BusSetBuilder(creators);
    }

    public static BusMapBuilder createBusMap(BusMapEntryBuilder... builders) {
        return new BusMapBuilder(builders);
    }

    public static BusMapEntryBuilder createBusEntry(Object key, BusCreator creator) {
        return new BusMapEntryBuilder(key, creator);
    }

    public static BusMapEntryBuilder createBusEntry(Object key, BusBuilder builder) {
        return new BusMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class BusFactory {

        public _Size name(String name) {
            return new _Name().name(name);
        }

        // name
        public class _Name {
            public _Size name(String name) {
                state.name = name;
                return new _Size();
            }
        }

        // size
        public class _Size {
            public BusCreator size(VehicleSizeMutableState size) {
                state.size = size;
                return new BusCreator(state);
            }

            public BusCreator size(VehicleSizeCreator size) {
                state.size = size.asMutableState();
                return new BusCreator(state);
            }
        }
    }

    // --- Constructor ---

    public BusCreator(BusMutableState state) {
        this.state = state;
    }

    public BusState asState() {
        return state.asImmutable();
    }

    public BusMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    public BusCreator withWeightInKilograms(int weightInKilograms) {
        state.weightInKilograms = weightInKilograms;
        return this;
    }

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

    public static class BusBehaviour {
        public final BusState s;

        public BusBehaviour(BusState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BusBehaviour)) return false;

            return s.equals(((BusBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class BusMutableBehaviour {
        private BusMutableState s;

        public BusMutableBehaviour(BusMutableState s) {
            this.s = s;
        }

        public BusState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BusMutableBehaviour)) return false;

            return s.equals(((BusMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class BusBuilder implements BusCreatorMaker {
        private final BusMutableState state;

        public BusBuilder() {
            this.state = new BusMutableState();
        }

        public BusBuilder(BusMutableState state) {
            this.state = state;
        }

        public BusBuilder withName(String name) { state.name = name; return this; }
        public BusBuilder withSize(VehicleSizeMutableState size) { state.size = size; return this; }
        public BusBuilder withSize(VehicleSizeCreator.VehicleSizeBuilder size) { state.size = size.asMutableState(); return this; }
        public BusBuilder withWeightInKilograms(int weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }

        public Bus asBus() {
            return new Bus(state.asImmutable());
        }

        public BusState asState() {
            return state.asImmutable();
        }

        public BusMutableState asMutableState() {
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

    public static class BusListBuilder implements Iterable<BusCreator> {
        private List<BusCreator> creators;

        public BusListBuilder(BusCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BusListBuilder(Collection<BusCreator> creators) {
            this.creators = new ArrayList<BusCreator>();
            this.creators.addAll(creators);
        }

        // asBusList() : ImmutableList<Bus>

        public ImmutableList<Bus> asBusList() {
            ImmutableList.Builder<Bus> builder = ImmutableList.builder();

            for (BusCreator creator : creators) {
                builder.add(creator.asBus());
            }
            return builder.build();
        }

        // asBusMutableList() : List<Bus>

        public List<Bus> asBusMutableList() {
            List<Bus> result = new ArrayList<Bus>();

            for (BusCreator creator : creators) {
                result.add(creator.asBus());
            }
            return result;
        }

        // asStateList() : ImmutableList<BusState>

        public ImmutableList<BusState> asStateList() {
            ImmutableList.Builder<BusState> builder = ImmutableList.builder();

            for (BusCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<BusMutableState>

        public List<BusMutableState> asMutableStateList() {
            List<BusMutableState> result = new ArrayList<BusMutableState>();

            for (BusCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BusCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class BusSetBuilder implements Iterable<BusCreator> {
        private List<BusCreator> creators;

        public BusSetBuilder(BusCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BusSetBuilder(Collection<BusCreator> creators) {
            this.creators = new ArrayList<BusCreator>();
            this.creators.addAll(creators);
        }

        // asBusSet() : ImmutableSet<Bus>

        public ImmutableSet<Bus> asBusSet() {
            ImmutableSet.Builder<Bus> builder = ImmutableSet.builder();

            for (BusCreator creator : creators) {
                builder.add(creator.asBus());
            }
            return builder.build();
        }

        // asBusMutableSet() : Set<Bus>

        public Set<Bus> asBusMutableSet() {
            Set<Bus> result = new HashSet<Bus>();

            for (BusCreator creator : creators) {
                result.add(creator.asBus());
            }
            return result;
        }

        // asState()

        public ImmutableSet<BusState> asStateSet() {
            ImmutableSet.Builder<BusState> builder = ImmutableSet.builder();

            for (BusCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<BusMutableState> asMutableStateSet() {
            Set<BusMutableState> result = new HashSet<BusMutableState>();

            for (BusCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BusCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class BusMapEntryBuilder {
        private final Object key;
        private final BusCreatorMaker maker;

        public BusMapEntryBuilder(Object key, BusCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Bus asBus() {
            return maker.asBus();
        }

        public BusState asState() {
            return maker.asState();
        }

        public BusMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class BusMapBuilder {
        private final BusMapEntryBuilder[] entries;

        public BusMapBuilder(BusMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asBusMap() : ImmutableMap

        public ImmutableMap asBusMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (BusMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asBus());
            }
            return builder.build();
        }

        // asBusMutableMap() : Map

        public Map asBusMutableMap() {
            Map result = new HashMap();

            for (BusMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asBus());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (BusMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (BusMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface BusCreatorMaker {
    Bus asBus();

    BusState asState();
    BusMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
