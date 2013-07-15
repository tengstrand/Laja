package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
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

    public static OwnerMapEntryBuilder ownerEntry(Object key, OwnerBuilder builder) {
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

    public static class OwnerBehaviour {
        public final OwnerState s;

        public OwnerBehaviour(OwnerState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerBehaviour)) return false;

            return s.equals(((OwnerBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class OwnerMutableBehaviour {
        private OwnerMutableState s;

        public OwnerMutableBehaviour(OwnerMutableState s) {
            this.s = s;
        }

        public OwnerState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof OwnerMutableBehaviour)) return false;

            return s.equals(((OwnerMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
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
