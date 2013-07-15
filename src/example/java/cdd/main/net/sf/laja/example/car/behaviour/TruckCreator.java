package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.car.state.OwnerState.OwnerMutableState;
import net.sf.laja.example.car.state.TruckState;
import net.sf.laja.example.car.state.TruckTypeState.TruckTypeMutableState;
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

import static net.sf.laja.example.car.state.TruckState.TruckMutableState;

@Creator
public class TruckCreator implements TruckCreatorMaker {
    private final TruckMutableState state;

    public Truck asTruck() {
        return new Truck(state.asImmutable());
    }

    // ===== Generated code =====

    public static TruckFactory createTruck() {
        return new TruckCreator(new TruckMutableState()).new TruckFactory();
    }

    public static TruckBuilder buildTruck() {
        return new TruckBuilder();
    }

    public static TruckListBuilder createTruckList(TruckCreator... creators) {
        return new TruckListBuilder(creators);
    }

    public static TruckSetBuilder createTruckSet(TruckCreator... creators) {
        return new TruckSetBuilder(creators);
    }

    public static TruckMapBuilder createTruckMap(TruckMapEntryBuilder... builders) {
        return new TruckMapBuilder(builders);
    }

    public static TruckMapEntryBuilder createTruckEntry(Object key, TruckCreator creator) {
        return new TruckMapEntryBuilder(key, creator);
    }

    public static TruckMapEntryBuilder truckEntry(Object key, TruckBuilder builder) {
        return new TruckMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class TruckFactory {

        public _WeightInKilograms size(VehicleSizeMutableState size) {
            return new _Size().size(size);
        }

        public _WeightInKilograms size(VehicleSizeCreator size) {
            return new _Size().size(size);
        }

        // size
        public class _Size {
            public _WeightInKilograms size(VehicleSizeMutableState size) {
                state.size = size;
                return new _WeightInKilograms();
            }

            public _WeightInKilograms size(VehicleSizeCreator size) {
                state.size = size.asMutableState();
                return new _WeightInKilograms();
            }
        }

        // weightInKilograms
        public class _WeightInKilograms {
            public _Type weightInKilograms(int weightInKilograms) {
                state.weightInKilograms = weightInKilograms;
                return new _Type();
            }
        }

        // type
        public class _Type {
            public _Color type(TruckTypeMutableState type) {
                state.type = type;
                return new _Color();
            }

            public _Color type(TruckTypeCreator type) {
                state.type = type.asMutableState();
                return new _Color();
            }
        }

        // color
        public class _Color {
            public _Owner color(String color) {
                state.color = color;
                return new _Owner();
            }
        }

        // owner
        public class _Owner {
            public TruckCreator owner(OwnerMutableState owner) {
                state.owner = owner;
                return new TruckCreator(state);
            }

            public TruckCreator owner(OwnerCreator owner) {
                state.owner = owner.asMutableState();
                return new TruckCreator(state);
            }
        }
    }

    // --- Constructor ---

    public TruckCreator(TruckMutableState state) {
        this.state = state;
    }

    public TruckState asState() {
        return state.asImmutable();
    }

    public TruckMutableState asMutableState() {
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

    public static class TruckBehaviour {
        public final TruckState s;

        public TruckBehaviour(TruckState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckBehaviour)) return false;

            return s.equals(((TruckBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class TruckMutableBehaviour {
        private TruckMutableState s;

        public TruckMutableBehaviour(TruckMutableState s) {
            this.s = s;
        }

        public TruckState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof TruckMutableBehaviour)) return false;

            return s.equals(((TruckMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class TruckBuilder implements TruckCreatorMaker {
        private final TruckMutableState state;

        public TruckBuilder() {
            this.state = new TruckMutableState();
        }

        public TruckBuilder(TruckMutableState state) {
            this.state = state;
        }

        public TruckBuilder withSize(VehicleSizeMutableState size) { state.size = size; return this; }
        public TruckBuilder withSize(VehicleSizeCreator.VehicleSizeBuilder size) { state.size = size.asMutableState(); return this; }
        public TruckBuilder withWeightInKilograms(int weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }
        public TruckBuilder withType(TruckTypeMutableState type) { state.type = type; return this; }
        public TruckBuilder withType(TruckTypeCreator.TruckTypeBuilder type) { state.type = type.asMutableState(); return this; }
        public TruckBuilder withColor(String color) { state.color = color; return this; }
        public TruckBuilder withOwner(OwnerMutableState owner) { state.owner = owner; return this; }
        public TruckBuilder withOwner(OwnerCreator.OwnerBuilder owner) { state.owner = owner.asMutableState(); return this; }

        public Truck asTruck() {
            return new Truck(state.asImmutable());
        }

        public TruckState asState() {
            return state.asImmutable();
        }

        public TruckMutableState asMutableState() {
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

    public static class TruckListBuilder implements Iterable<TruckCreator> {
        private List<TruckCreator> creators;

        public TruckListBuilder(TruckCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public TruckListBuilder(Collection<TruckCreator> creators) {
            this.creators = new ArrayList<TruckCreator>();
            this.creators.addAll(creators);
        }

        // asTruckList() : ImmutableList<Truck>

        public ImmutableList<Truck> asTruckList() {
            ImmutableList.Builder<Truck> builder = ImmutableList.builder();

            for (TruckCreator creator : creators) {
                builder.add(creator.asTruck());
            }
            return builder.build();
        }

        // asTruckMutableList() : List<Truck>

        public List<Truck> asTruckMutableList() {
            List<Truck> result = new ArrayList<Truck>();

            for (TruckCreator creator : creators) {
                result.add(creator.asTruck());
            }
            return result;
        }

        // asStateList() : ImmutableList<TruckState>

        public ImmutableList<TruckState> asStateList() {
            ImmutableList.Builder<TruckState> builder = ImmutableList.builder();

            for (TruckCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<TruckMutableState>

        public List<TruckMutableState> asMutableStateList() {
            List<TruckMutableState> result = new ArrayList<TruckMutableState>();

            for (TruckCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TruckCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class TruckSetBuilder implements Iterable<TruckCreator> {
        private List<TruckCreator> creators;

        public TruckSetBuilder(TruckCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public TruckSetBuilder(Collection<TruckCreator> creators) {
            this.creators = new ArrayList<TruckCreator>();
            this.creators.addAll(creators);
        }

        // asTruckSet() : ImmutableSet<Truck>

        public ImmutableSet<Truck> asTruckSet() {
            ImmutableSet.Builder<Truck> builder = ImmutableSet.builder();

            for (TruckCreator creator : creators) {
                builder.add(creator.asTruck());
            }
            return builder.build();
        }

        // asTruckMutableSet() : Set<Truck>

        public Set<Truck> asTruckMutableSet() {
            Set<Truck> result = new HashSet<Truck>();

            for (TruckCreator creator : creators) {
                result.add(creator.asTruck());
            }
            return result;
        }

        // asState()

        public ImmutableSet<TruckState> asStateSet() {
            ImmutableSet.Builder<TruckState> builder = ImmutableSet.builder();

            for (TruckCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<TruckMutableState> asMutableStateSet() {
            Set<TruckMutableState> result = new HashSet<TruckMutableState>();

            for (TruckCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TruckCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class TruckMapEntryBuilder {
        private final Object key;
        private final TruckCreatorMaker maker;

        public TruckMapEntryBuilder(Object key, TruckCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Truck asTruck() {
            return maker.asTruck();
        }

        public TruckState asState() {
            return maker.asState();
        }

        public TruckMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class TruckMapBuilder {
        private final TruckMapEntryBuilder[] entries;

        public TruckMapBuilder(TruckMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asTruckMap() : ImmutableMap

        public ImmutableMap asTruckMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (TruckMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asTruck());
            }
            return builder.build();
        }

        // asTruckMutableMap() : Map

        public Map asTruckMutableMap() {
            Map result = new HashMap();

            for (TruckMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asTruck());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (TruckMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (TruckMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface TruckCreatorMaker {
    Truck asTruck();

    TruckState asState();
    TruckMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
