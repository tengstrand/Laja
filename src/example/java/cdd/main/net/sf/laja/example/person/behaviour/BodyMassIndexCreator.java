package net.sf.laja.example.person.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.person.state.BmiState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.person.state.BmiState.BmiMutableState;

@Creator
public class BodyMassIndexCreator implements BodyMassIndexCreatorMaker {
    private final BmiMutableState state;

    public BodyMassIndex asBmi() {
        return new BodyMassIndex(state.asImmutable());
    }

    // ===== Generated code =====

    private static final String heightInCentimeters_ = "heightInCentimeters";
    private static final String weightInKilograms_ = "weightInKilograms";

    // --- Constructors ---

    public static BmiFactory createBodyMassIndex() {
        return new BodyMassIndexCreator(new BmiMutableState()).new BmiFactory();
    }

    public static BmiBuilder buildBodyMassIndex() {
        return new BmiBuilder();
    }

    public static BmiListBuilder createBodyMassIndexList(BodyMassIndexCreator... creators) {
        return new BmiListBuilder(creators);
    }

    public static BmiSetBuilder createBodyMassIndexSet(BodyMassIndexCreator... creators) {
        return new BmiSetBuilder(creators);
    }

    public static BmiMapBuilder createBodyMassIndexMap(BmiMapEntryBuilder... builders) {
        return new BmiMapBuilder(builders);
    }

    public static BmiMapEntryBuilder createBodyMassIndexEntry(Object key, BodyMassIndexCreator creator) {
        return new BmiMapEntryBuilder(key, creator);
    }

    public static BmiMapEntryBuilder bodyMassIndexEntry(Object key, BmiBuilder builder) {
        return new BmiMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class BmiFactory {

        public _WeightInKilograms heightInCentimeters(int heightInCentimeters) {
            return new _HeightInCentimeters().heightInCentimeters(heightInCentimeters);
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
            public BodyMassIndexCreator weightInKilograms(int weightInKilograms) {
                state.weightInKilograms = weightInKilograms;
                return new BodyMassIndexCreator(state);
            }
        }
    }

    // --- Constructor ---

    public BodyMassIndexCreator(BmiMutableState state) {
        this.state = state;
    }

    public BmiState asState() {
        return state.asImmutable();
    }

    public BmiMutableState asMutableState() {
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

    public static class BmiBehaviour {
        public final BmiState s;

        public BmiBehaviour(BmiState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BmiBehaviour)) return false;

            return s.equals(((BmiBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class BmiMutableBehaviour {
        private BmiMutableState s;

        public BmiMutableBehaviour(BmiMutableState s) {
            this.s = s;
        }

        public BmiState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BmiMutableBehaviour)) return false;

            return s.equals(((BmiMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class BmiBuilder implements BodyMassIndexCreatorMaker {
        private final BmiMutableState state;

        public BmiBuilder() {
            this.state = new BmiMutableState();
        }

        public BmiBuilder(BmiMutableState state) {
            this.state = state;
        }

        public BmiBuilder withHeightInCentimeters(int heightInCentimeters) { state.heightInCentimeters = heightInCentimeters; return this; }
        public BmiBuilder withWeightInKilograms(int weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }

        public BodyMassIndex asBmi() {
            return new BodyMassIndex(state.asImmutable());
        }

        public BmiState asState() {
            return state.asImmutable();
        }

        public BmiMutableState asMutableState() {
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

    public static class BmiListBuilder implements Iterable<BodyMassIndexCreator> {
        private List<BodyMassIndexCreator> creators;

        public BmiListBuilder(BodyMassIndexCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BmiListBuilder(Collection<BodyMassIndexCreator> creators) {
            this.creators = new ArrayList<BodyMassIndexCreator>();
            this.creators.addAll(creators);
        }

        // asBmiList() : ImmutableList<BodyMassIndex>

        public ImmutableList<BodyMassIndex> asBmiList() {
            ImmutableList.Builder<BodyMassIndex> builder = ImmutableList.builder();

            for (BodyMassIndexCreator creator : creators) {
                builder.add(creator.asBmi());
            }
            return builder.build();
        }

        // asBmiMutableList() : List<BodyMassIndex>

        public List<BodyMassIndex> asBmiMutableList() {
            List<BodyMassIndex> result = new ArrayList<BodyMassIndex>();

            for (BodyMassIndexCreator creator : creators) {
                result.add(creator.asBmi());
            }
            return result;
        }

        // asStateList() : ImmutableList<BmiState>

        public ImmutableList<BmiState> asStateList() {
            ImmutableList.Builder<BmiState> builder = ImmutableList.builder();

            for (BodyMassIndexCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<BmiMutableState>

        public List<BmiMutableState> asMutableStateList() {
            List<BmiMutableState> result = new ArrayList<BmiMutableState>();

            for (BodyMassIndexCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BodyMassIndexCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class BmiSetBuilder implements Iterable<BodyMassIndexCreator> {
        private List<BodyMassIndexCreator> creators;

        public BmiSetBuilder(BodyMassIndexCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BmiSetBuilder(Collection<BodyMassIndexCreator> creators) {
            this.creators = new ArrayList<BodyMassIndexCreator>();
            this.creators.addAll(creators);
        }

        // asBmiSet() : ImmutableSet<BodyMassIndex>

        public ImmutableSet<BodyMassIndex> asBmiSet() {
            ImmutableSet.Builder<BodyMassIndex> builder = ImmutableSet.builder();

            for (BodyMassIndexCreator creator : creators) {
                builder.add(creator.asBmi());
            }
            return builder.build();
        }

        // asBmiMutableSet() : Set<BodyMassIndex>

        public Set<BodyMassIndex> asBmiMutableSet() {
            Set<BodyMassIndex> result = new HashSet<BodyMassIndex>();

            for (BodyMassIndexCreator creator : creators) {
                result.add(creator.asBmi());
            }
            return result;
        }

        // asState()

        public ImmutableSet<BmiState> asStateSet() {
            ImmutableSet.Builder<BmiState> builder = ImmutableSet.builder();

            for (BodyMassIndexCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<BmiMutableState> asMutableStateSet() {
            Set<BmiMutableState> result = new HashSet<BmiMutableState>();

            for (BodyMassIndexCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BodyMassIndexCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class BmiMapEntryBuilder {
        private final Object key;
        private final BodyMassIndexCreatorMaker maker;

        public BmiMapEntryBuilder(Object key, BodyMassIndexCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public BodyMassIndex asBmi() {
            return maker.asBmi();
        }

        public BmiState asState() {
            return maker.asState();
        }

        public BmiMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class BmiMapBuilder {
        private final BmiMapEntryBuilder[] entries;

        public BmiMapBuilder(BmiMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asBmiMap() : ImmutableMap

        public ImmutableMap asBmiMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (BmiMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asBmi());
            }
            return builder.build();
        }

        // asBmiMutableMap() : Map

        public Map asBmiMutableMap() {
            Map result = new HashMap();

            for (BmiMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asBmi());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (BmiMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (BmiMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface BodyMassIndexCreatorMaker {
    BodyMassIndex asBmi();

    BmiState asState();
    BmiMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
