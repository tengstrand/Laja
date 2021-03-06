package net.sf.laja.example.person;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
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

import static net.sf.laja.example.person.state.BmiState.*;

@Creator
public class BmiCreator implements BmiCreatorMaker {
    private final BmiMutableState state;

    public BodyMassIndex asBmi() {
        return new BodyMassIndex(state.asImmutable());
    }

    // ===== Generated code =====

    public static BmiFactory createBmi() {
        return new BmiCreator(new BmiMutableState()).new BmiFactory();
    }

    public static BmiCreator createBmiFromMap(Map bmi) {
        return new BmiCreator(new BmiMutableState(toBmiMutableState(bmi)));
    }

    public static BmiBuilder buildBmi() {
        return new BmiBuilder();
    }

    public static BmiBuilder buildBmiFromMap(Map bmi) {
        return new BmiBuilder(new BmiMutableState(toBmiMutableState(bmi)));
    }

    public static BmiStringBuilder buildBmiFromStrings() {
        return new BmiStringBuilder();
    }

    public static BmiListBuilder createBmiList(BmiCreator... creators) {
        return new BmiListBuilder(creators);
    }

    public static BmiSetBuilder createBmiSet(BmiCreator... creators) {
        return new BmiSetBuilder(creators);
    }

    public static BmiMapBuilder createBmiMap(BmiMapEntryBuilder... builders) {
        return new BmiMapBuilder(builders);
    }

    public static BmiMapEntryBuilder createBmiEntry(Object key, BmiCreator creator) {
        return new BmiMapEntryBuilder(key, creator);
    }

    public static BmiMapEntryBuilder createBmiEntry(Object key, BmiBuilder builder) {
        return new BmiMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public BmiCreator(BmiMutableState state) {
        this.state = state;
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
            public BmiCreator weightInKilograms(int weightInKilograms) {
                state.weightInKilograms = weightInKilograms;
                return new BmiCreator(state);
            }
        }
    }

    public BmiState asState() {
        return state.asImmutable();
    }

    public BmiMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public BmiStringState asStringState() {
        return state.asStringState();
    }

    public BmiStringState asStringState(StringStateConverter stateConverter) {
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
        if (that == null || !(that instanceof BmiCreator)) return false;

        return state.equals(((BmiCreator)that).state);
    }

    @Override public String toString() {
        return "BmiCreator" + state;
    }

    // --- Behaviour ---

    public static class BmiBehaviour {
        public final BmiState state;

        public BmiBehaviour(BmiState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidBmiStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BmiBehaviour)) return false;

            return state.equals(((BmiBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class BmiMutableBehaviour {
        private BmiMutableState state;

        public BmiMutableBehaviour(BmiMutableState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidBmiStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BmiMutableBehaviour)) return false;

            return state.equals(((BmiMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class BmiBuilder implements BmiCreatorMaker {
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

        public Map asMap() {
            return state.asMap();
        }

        public BmiStringState asStringState() {
            return state.asStringState();
        }

        public BmiStringState asStringState(StringStateConverter stateConverter) {
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
            if (that == null || !(that instanceof BmiBuilder)) return false;

            return state.equals(((BmiBuilder)that).state);
        }

        @Override public String toString() {
            return "BmiBuilder" + state;
        }
    }

    // --- String builder ---

    public static class BmiStringBuilder {
        private final BmiStringState state;

        public BmiStringBuilder() {
            this.state = new BmiStringState();
        }

        public BmiStringBuilder(BmiStringState state) {
            this.state = state;
        }

        public BmiStringBuilder withHeightInCentimeters(String heightInCentimeters) { state.heightInCentimeters = heightInCentimeters; return this; }
        public BmiStringBuilder withWeightInKilograms(String weightInKilograms) { state.weightInKilograms = weightInKilograms; return this; }

        public BodyMassIndex asBmi() {
            return new BmiBuilder(state.asMutable()).asBmi();
        }

        public BmiState asState() {
            return state.asImmutable();
        }

        public BmiMutableState asMutableState() {
            return state.asMutable();
        }

        public BmiStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof BmiStringBuilder)) return false;

            return state.equals(((BmiStringBuilder)that).state);
        }

        @Override public String toString() {
            return "BmiStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class BmiListBuilder implements Iterable<BmiCreator> {
        private List<BmiCreator> creators;

        public BmiListBuilder(BmiCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BmiListBuilder(Collection<BmiCreator> creators) {
            this.creators = new ArrayList<BmiCreator>();
            this.creators.addAll(creators);
        }

        // asBmiList() : ImmutableList<BodyMassIndex>

        public ImmutableList<BodyMassIndex> asBmiList() {
            ImmutableList.Builder<BodyMassIndex> builder = ImmutableList.builder();

            for (BmiCreator creator : creators) {
                builder.add(creator.asBmi());
            }
            return builder.build();
        }

        // asBmiMutableList() : List<BodyMassIndex>

        public List<BodyMassIndex> asBmiMutableList() {
            List<BodyMassIndex> result = new ArrayList<BodyMassIndex>();

            for (BmiCreator creator : creators) {
                result.add(creator.asBmi());
            }
            return result;
        }

        // asStateList() : ImmutableList<BmiState>

        public ImmutableList<BmiState> asStateList() {
            ImmutableList.Builder<BmiState> builder = ImmutableList.builder();

            for (BmiCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<BmiMutableState>

        public List<BmiMutableState> asMutableStateList() {
            List<BmiMutableState> result = new ArrayList<BmiMutableState>();

            for (BmiCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BmiCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class BmiSetBuilder implements Iterable<BmiCreator> {
        private List<BmiCreator> creators;

        public BmiSetBuilder(BmiCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public BmiSetBuilder(Collection<BmiCreator> creators) {
            this.creators = new ArrayList<BmiCreator>();
            this.creators.addAll(creators);
        }

        // asBmiSet() : ImmutableSet<BodyMassIndex>

        public ImmutableSet<BodyMassIndex> asBmiSet() {
            ImmutableSet.Builder<BodyMassIndex> builder = ImmutableSet.builder();

            for (BmiCreator creator : creators) {
                builder.add(creator.asBmi());
            }
            return builder.build();
        }

        // asBmiMutableSet() : Set<BodyMassIndex>

        public Set<BodyMassIndex> asBmiMutableSet() {
            Set<BodyMassIndex> result = new HashSet<BodyMassIndex>();

            for (BmiCreator creator : creators) {
                result.add(creator.asBmi());
            }
            return result;
        }

        // asState()

        public ImmutableSet<BmiState> asStateSet() {
            ImmutableSet.Builder<BmiState> builder = ImmutableSet.builder();

            for (BmiCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<BmiMutableState> asMutableStateSet() {
            Set<BmiMutableState> result = new HashSet<BmiMutableState>();

            for (BmiCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<BmiCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class BmiMapEntryBuilder {
        private final Object key;
        private final BmiCreatorMaker maker;

        public BmiMapEntryBuilder(Object key, BmiCreatorMaker maker) {
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

interface BmiCreatorMaker {
    BodyMassIndex asBmi();

    BmiState asState();
    BmiMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
