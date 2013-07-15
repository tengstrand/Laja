package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.car.state.VehicleSizeState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeMutableState;

@Creator
public class VehicleSizeCreator implements VehicleSizeCreatorMaker {
    private final VehicleSizeMutableState state;

    public VehicleSize asVehicleSize() {
        return new VehicleSize(state.asImmutable());
    }

    // ===== Generated code =====

    public static VehicleSizeFactory createVehicleSize() {
        return new VehicleSizeCreator(new VehicleSizeMutableState()).new VehicleSizeFactory();
    }

    public static VehicleSizeBuilder buildVehicleSize() {
        return new VehicleSizeBuilder();
    }

    public static VehicleSizeListBuilder createVehicleSizeList(VehicleSizeCreator... creators) {
        return new VehicleSizeListBuilder(creators);
    }

    public static VehicleSizeSetBuilder createVehicleSizeSet(VehicleSizeCreator... creators) {
        return new VehicleSizeSetBuilder(creators);
    }

    public static VehicleSizeMapBuilder createVehicleSizeMap(VehicleSizeMapEntryBuilder... builders) {
        return new VehicleSizeMapBuilder(builders);
    }

    public static VehicleSizeMapEntryBuilder createVehicleSizeEntry(Object key, VehicleSizeCreator creator) {
        return new VehicleSizeMapEntryBuilder(key, creator);
    }

    public static VehicleSizeMapEntryBuilder vehicleSizeEntry(Object key, VehicleSizeBuilder builder) {
        return new VehicleSizeMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class VehicleSizeFactory {

        public VehicleSizeCreator lengthInCentimeters(int lengthInCentimeters) {
            return new _LengthInCentimeters().lengthInCentimeters(lengthInCentimeters);
        }

        // lengthInCentimeters
        public class _LengthInCentimeters {
            public VehicleSizeCreator lengthInCentimeters(int lengthInCentimeters) {
                state.lengthInCentimeters = lengthInCentimeters;
                return new VehicleSizeCreator(state);
            }
        }
    }

    // --- Constructor ---

    public VehicleSizeCreator(VehicleSizeMutableState state) {
        this.state = state;
    }

    public VehicleSizeState asState() {
        return state.asImmutable();
    }

    public VehicleSizeMutableState asMutableState() {
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

    public static class VehicleSizeBehaviour {
        public final VehicleSizeState s;

        public VehicleSizeBehaviour(VehicleSizeState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof VehicleSizeBehaviour)) return false;

            return s.equals(((VehicleSizeBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class VehicleSizeMutableBehaviour {
        private VehicleSizeMutableState s;

        public VehicleSizeMutableBehaviour(VehicleSizeMutableState s) {
            this.s = s;
        }

        public VehicleSizeState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof VehicleSizeMutableBehaviour)) return false;

            return s.equals(((VehicleSizeMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class VehicleSizeBuilder implements VehicleSizeCreatorMaker {
        private final VehicleSizeMutableState state;

        public VehicleSizeBuilder() {
            this.state = new VehicleSizeMutableState();
        }

        public VehicleSizeBuilder(VehicleSizeMutableState state) {
            this.state = state;
        }

        public VehicleSizeBuilder withLengthInCentimeters(int lengthInCentimeters) { state.lengthInCentimeters = lengthInCentimeters; return this; }

        public VehicleSize asVehicleSize() {
            return new VehicleSize(state.asImmutable());
        }

        public VehicleSizeState asState() {
            return state.asImmutable();
        }

        public VehicleSizeMutableState asMutableState() {
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

    public static class VehicleSizeListBuilder implements Iterable<VehicleSizeCreator> {
        private List<VehicleSizeCreator> creators;

        public VehicleSizeListBuilder(VehicleSizeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public VehicleSizeListBuilder(Collection<VehicleSizeCreator> creators) {
            this.creators = new ArrayList<VehicleSizeCreator>();
            this.creators.addAll(creators);
        }

        // asVehicleSizeList() : ImmutableList<VehicleSize>

        public ImmutableList<VehicleSize> asVehicleSizeList() {
            ImmutableList.Builder<VehicleSize> builder = ImmutableList.builder();

            for (VehicleSizeCreator creator : creators) {
                builder.add(creator.asVehicleSize());
            }
            return builder.build();
        }

        // asVehicleSizeMutableList() : List<VehicleSize>

        public List<VehicleSize> asVehicleSizeMutableList() {
            List<VehicleSize> result = new ArrayList<VehicleSize>();

            for (VehicleSizeCreator creator : creators) {
                result.add(creator.asVehicleSize());
            }
            return result;
        }

        // asStateList() : ImmutableList<VehicleSizeState>

        public ImmutableList<VehicleSizeState> asStateList() {
            ImmutableList.Builder<VehicleSizeState> builder = ImmutableList.builder();

            for (VehicleSizeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<VehicleSizeMutableState>

        public List<VehicleSizeMutableState> asMutableStateList() {
            List<VehicleSizeMutableState> result = new ArrayList<VehicleSizeMutableState>();

            for (VehicleSizeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<VehicleSizeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class VehicleSizeSetBuilder implements Iterable<VehicleSizeCreator> {
        private List<VehicleSizeCreator> creators;

        public VehicleSizeSetBuilder(VehicleSizeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public VehicleSizeSetBuilder(Collection<VehicleSizeCreator> creators) {
            this.creators = new ArrayList<VehicleSizeCreator>();
            this.creators.addAll(creators);
        }

        // asVehicleSizeSet() : ImmutableSet<VehicleSize>

        public ImmutableSet<VehicleSize> asVehicleSizeSet() {
            ImmutableSet.Builder<VehicleSize> builder = ImmutableSet.builder();

            for (VehicleSizeCreator creator : creators) {
                builder.add(creator.asVehicleSize());
            }
            return builder.build();
        }

        // asVehicleSizeMutableSet() : Set<VehicleSize>

        public Set<VehicleSize> asVehicleSizeMutableSet() {
            Set<VehicleSize> result = new HashSet<VehicleSize>();

            for (VehicleSizeCreator creator : creators) {
                result.add(creator.asVehicleSize());
            }
            return result;
        }

        // asState()

        public ImmutableSet<VehicleSizeState> asStateSet() {
            ImmutableSet.Builder<VehicleSizeState> builder = ImmutableSet.builder();

            for (VehicleSizeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<VehicleSizeMutableState> asMutableStateSet() {
            Set<VehicleSizeMutableState> result = new HashSet<VehicleSizeMutableState>();

            for (VehicleSizeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<VehicleSizeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class VehicleSizeMapEntryBuilder {
        private final Object key;
        private final VehicleSizeCreatorMaker maker;

        public VehicleSizeMapEntryBuilder(Object key, VehicleSizeCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public VehicleSize asVehicleSize() {
            return maker.asVehicleSize();
        }

        public VehicleSizeState asState() {
            return maker.asState();
        }

        public VehicleSizeMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class VehicleSizeMapBuilder {
        private final VehicleSizeMapEntryBuilder[] entries;

        public VehicleSizeMapBuilder(VehicleSizeMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asVehicleSizeMap() : ImmutableMap

        public ImmutableMap asVehicleSizeMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (VehicleSizeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asVehicleSize());
            }
            return builder.build();
        }

        // asVehicleSizeMutableMap() : Map

        public Map asVehicleSizeMutableMap() {
            Map result = new HashMap();

            for (VehicleSizeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asVehicleSize());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (VehicleSizeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (VehicleSizeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface VehicleSizeCreatorMaker {
    VehicleSize asVehicleSize();

    VehicleSizeState asState();
    VehicleSizeMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
