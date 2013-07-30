package net.sf.laja.example.car;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.car.state.OwnerState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.car.state.OwnerState.OwnerMutableState;
import static net.sf.laja.example.car.state.OwnerState.OwnerStringState;

@Creator
public class OwnerCreator implements OwnerCreatorMaker {
    private final OwnerMutableState state;

    public Owner asOwner() {
        return new Owner(state.asImmutable());
    }

    // ===== Generated code =====

    public static OwnerFactory createOwner() {
        return new OwnerCreator(new OwnerMutableState()).new OwnerFactory();
    }

    public static OwnerBuilder buildOwner() {
        return new OwnerBuilder();
    }

    public static OwnerStringBuilder buildStringOwner() {
        return new OwnerStringBuilder();
    }

    public static OwnerListBuilder createOwnerList(OwnerCreator... creators) {
        return new OwnerListBuilder(creators);
    }

    public static OwnerSetBuilder createOwnerSet(OwnerCreator... creators) {
        return new OwnerSetBuilder(creators);
    }

    public static OwnerMapBuilder createOwnerMap(OwnerMapEntryBuilder... builders) {
        return new OwnerMapBuilder(builders);
    }

    public static OwnerMapEntryBuilder createOwnerEntry(Object key, OwnerCreator creator) {
        return new OwnerMapEntryBuilder(key, creator);
    }

    public static OwnerMapEntryBuilder createOwnerEntry(Object key, OwnerBuilder builder) {
        return new OwnerMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class OwnerFactory {

        public _Name ssn(long ssn) {
            return new _Ssn().ssn(ssn);
        }

        // ssn
        public class _Ssn {
            public _Name ssn(long ssn) {
                state.ssn = ssn;
                return new _Name();
            }
        }

        // name
        public class _Name {
            public OwnerCreator name(String name) {
                state.name = name;
                return new OwnerCreator(state);
            }
        }
    }

    // --- Constructor ---

    public OwnerCreator(OwnerMutableState state) {
        this.state = state;
    }

    public OwnerState asState() {
        return state.asImmutable();
    }

    public OwnerMutableState asMutableState() {
        return state;
    }

        public OwnerStringState asStringState() {
            return state.asStringState();
        }

        public OwnerStringState asStringState(StringStateConverter stateConverter) {
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

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof OwnerCreator)) return false;

        return state.equals(((OwnerCreator)that).state);
    }

    @Override public String toString() {
        return "OwnerCreator" + state;
    }

    // --- Behaviour ---

    public static class OwnerBehaviour {
        public final OwnerState state;

        public OwnerBehaviour(OwnerState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerBehaviour)) return false;

            return state.equals(((OwnerBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class OwnerMutableBehaviour {
        private OwnerMutableState state;

        public OwnerMutableBehaviour(OwnerMutableState state) {
            this.state = state;
        }

        public OwnerState asState() {
            return state.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerMutableBehaviour)) return false;

            return state.equals(((OwnerMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class OwnerBuilder implements OwnerCreatorMaker {
        private final OwnerMutableState state;

        public OwnerBuilder() {
            this.state = new OwnerMutableState();
        }

        public OwnerBuilder(OwnerMutableState state) {
            this.state = state;
        }

        public OwnerBuilder withSsn(long ssn) { state.ssn = ssn; return this; }
        public OwnerBuilder withName(String name) { state.name = name; return this; }

        public Owner asOwner() {
            return new Owner(state.asImmutable());
        }

        public OwnerState asState() {
            return state.asImmutable();
        }

        public OwnerMutableState asMutableState() {
            return state;
        }

        public OwnerStringState asStringState() {
            return state.asStringState();
        }

        public OwnerStringState asStringState(StringStateConverter stateConverter) {
            return state.asStringState(stateConverter);
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

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerBuilder)) return false;

            return state.equals(((OwnerBuilder)that).state);
        }

        @Override public String toString() {
            return "OwnerBuilder" + state;
        }
    }

    // --- String builder ---

    public static class OwnerStringBuilder {
        private final OwnerStringState state;

        public OwnerStringBuilder() {
            this.state = new OwnerStringState();
        }

        public OwnerStringBuilder(OwnerStringState state) {
            this.state = state;
        }

        public OwnerStringBuilder withSsn(String ssn) { state.ssn = ssn; return this; }
        public OwnerStringBuilder withName(String name) { state.name = name; return this; }

        public Owner asOwner() {
            return new OwnerBuilder(state.asMutable()).asOwner();
        }

        public OwnerState asState() {
            return state.asImmutable();
        }

        public OwnerMutableState asMutableState() {
            return state.asMutable();
        }

        public OwnerStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerStringBuilder)) return false;

            return state.equals(((OwnerStringBuilder)that).state);
        }

        @Override public String toString() {
            return "OwnerStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class OwnerListBuilder implements Iterable<OwnerCreator> {
        private List<OwnerCreator> creators;

        public OwnerListBuilder(OwnerCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public OwnerListBuilder(Collection<OwnerCreator> creators) {
            this.creators = new ArrayList<OwnerCreator>();
            this.creators.addAll(creators);
        }

        // asOwnerList() : ImmutableList<Owner>

        public ImmutableList<Owner> asOwnerList() {
            ImmutableList.Builder<Owner> builder = ImmutableList.builder();

            for (OwnerCreator creator : creators) {
                builder.add(creator.asOwner());
            }
            return builder.build();
        }

        // asOwnerMutableList() : List<Owner>

        public List<Owner> asOwnerMutableList() {
            List<Owner> result = new ArrayList<Owner>();

            for (OwnerCreator creator : creators) {
                result.add(creator.asOwner());
            }
            return result;
        }

        // asStateList() : ImmutableList<OwnerState>

        public ImmutableList<OwnerState> asStateList() {
            ImmutableList.Builder<OwnerState> builder = ImmutableList.builder();

            for (OwnerCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<OwnerMutableState>

        public List<OwnerMutableState> asMutableStateList() {
            List<OwnerMutableState> result = new ArrayList<OwnerMutableState>();

            for (OwnerCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<OwnerCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class OwnerSetBuilder implements Iterable<OwnerCreator> {
        private List<OwnerCreator> creators;

        public OwnerSetBuilder(OwnerCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public OwnerSetBuilder(Collection<OwnerCreator> creators) {
            this.creators = new ArrayList<OwnerCreator>();
            this.creators.addAll(creators);
        }

        // asOwnerSet() : ImmutableSet<Owner>

        public ImmutableSet<Owner> asOwnerSet() {
            ImmutableSet.Builder<Owner> builder = ImmutableSet.builder();

            for (OwnerCreator creator : creators) {
                builder.add(creator.asOwner());
            }
            return builder.build();
        }

        // asOwnerMutableSet() : Set<Owner>

        public Set<Owner> asOwnerMutableSet() {
            Set<Owner> result = new HashSet<Owner>();

            for (OwnerCreator creator : creators) {
                result.add(creator.asOwner());
            }
            return result;
        }

        // asState()

        public ImmutableSet<OwnerState> asStateSet() {
            ImmutableSet.Builder<OwnerState> builder = ImmutableSet.builder();

            for (OwnerCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<OwnerMutableState> asMutableStateSet() {
            Set<OwnerMutableState> result = new HashSet<OwnerMutableState>();

            for (OwnerCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<OwnerCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class OwnerMapEntryBuilder {
        private final Object key;
        private final OwnerCreatorMaker maker;

        public OwnerMapEntryBuilder(Object key, OwnerCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Owner asOwner() {
            return maker.asOwner();
        }

        public OwnerState asState() {
            return maker.asState();
        }

        public OwnerMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class OwnerMapBuilder {
        private final OwnerMapEntryBuilder[] entries;

        public OwnerMapBuilder(OwnerMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asOwnerMap() : ImmutableMap

        public ImmutableMap asOwnerMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (OwnerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asOwner());
            }
            return builder.build();
        }

        // asOwnerMutableMap() : Map

        public Map asOwnerMutableMap() {
            Map result = new HashMap();

            for (OwnerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asOwner());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (OwnerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (OwnerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface OwnerCreatorMaker {
    Owner asOwner();

    OwnerState asState();
    OwnerMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
