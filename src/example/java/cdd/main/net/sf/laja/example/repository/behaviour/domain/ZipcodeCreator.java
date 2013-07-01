package net.sf.laja.example.repository.behaviour.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.repository.state.ZipcodeState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.repository.state.ZipcodeState.ZipcodeMutableState;

@Creator
public class ZipcodeCreator implements ZipcodeMaker {
    private final ZipcodeMutableState state;

    public Zipcode asZipcode() {
        return new Zipcode(state.asImmutable());
    }

    // ===== Generated code =====

    private static final String zipcode_ = "zipcode";

    // --- Constructors ---

    public static ZipcodeFactory createZipcode() {
        return new ZipcodeCreator(new ZipcodeMutableState()).new ZipcodeFactory();
    }

    public static ZipcodeBuilder buildZipcode() {
        return new ZipcodeBuilder();
    }

    public static ZipcodeListBuilder createZipcodeList(ZipcodeCreator... creators) {
        return new ZipcodeListBuilder(creators);
    }

    public static ZipcodeSetBuilder createZipcodeSet(ZipcodeCreator... creators) {
        return new ZipcodeSetBuilder(creators);
    }

    public static ZipcodeMapBuilder createZipcodeMap(ZipcodeMapEntryBuilder... builders) {
        return new ZipcodeMapBuilder(builders);
    }

    public static ZipcodeMapEntryBuilder zipcodeEntry(Object key, ZipcodeCreator creator) {
        return new ZipcodeMapEntryBuilder(key, creator);
    }

    public static ZipcodeMapEntryBuilder zipcodeEntry(Object key, ZipcodeBuilder builder) {
        return new ZipcodeMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class ZipcodeFactory {

        public ZipcodeCreator zipcode(int zipcode) {
            return new _Zipcode().zipcode(zipcode);
        }

        // zipcode
        public class _Zipcode {
            public ZipcodeCreator zipcode(int zipcode) {
                state.zipcode = zipcode;
                return new ZipcodeCreator(state);
            }
        }
    }

    // --- Constructor ---

    public ZipcodeCreator(ZipcodeMutableState state) {
        this.state = state;
    }

    public ZipcodeState asState() {
        return state.asImmutable();
    }

    public ZipcodeMutableState asMutableState() {
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

    public static class ZipcodeBehaviour {
        public final ZipcodeState s;

        public ZipcodeBehaviour(ZipcodeState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof ZipcodeBehaviour)) return false;

            return s.equals(((ZipcodeBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class ZipcodeMutableBehaviour {
        private ZipcodeMutableState s;

        public ZipcodeMutableBehaviour(ZipcodeMutableState s) {
            this.s = s;
        }

        public ZipcodeState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof ZipcodeMutableBehaviour)) return false;

            return s.equals(((ZipcodeMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class ZipcodeBuilder implements ZipcodeMaker {
        private final ZipcodeMutableState state;

        public ZipcodeBuilder() {
            this.state = new ZipcodeMutableState();
        }

        public ZipcodeBuilder(ZipcodeMutableState state) {
            this.state = state;
        }

        public ZipcodeBuilder withZipcode(int zipcode) { state.zipcode = zipcode; return this; }

        public Zipcode asZipcode() {
            return new Zipcode(state.asImmutable());
        }

        public ZipcodeState asState() {
            return state.asImmutable();
        }

        public ZipcodeMutableState asMutableState() {
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

    public static class ZipcodeListBuilder implements Iterable<ZipcodeCreator> {
        private List<ZipcodeCreator> creators;

        public ZipcodeListBuilder(ZipcodeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public ZipcodeListBuilder(Collection<ZipcodeCreator> creators) {
            this.creators = new ArrayList<ZipcodeCreator>();
            this.creators.addAll(creators);
        }

        // asZipcodeList() : ImmutableList<Zipcode>

        public ImmutableList<Zipcode> asZipcodeList() {
            ImmutableList.Builder<Zipcode> builder = ImmutableList.builder();

            for (ZipcodeCreator creator : creators) {
                builder.add(creator.asZipcode());
            }
            return builder.build();
        }

        // asZipcodeMutableList() : List<Zipcode>

        public List<Zipcode> asZipcodeMutableList() {
            List<Zipcode> result = new ArrayList<Zipcode>();

            for (ZipcodeCreator creator : creators) {
                result.add(creator.asZipcode());
            }
            return result;
        }

        // asStateList() : ImmutableList<ZipcodeState>

        public ImmutableList<ZipcodeState> asStateList() {
            ImmutableList.Builder<ZipcodeState> builder = ImmutableList.builder();

            for (ZipcodeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<ZipcodeMutableState>

        public List<ZipcodeMutableState> asMutableStateList() {
            List<ZipcodeMutableState> result = new ArrayList<ZipcodeMutableState>();

            for (ZipcodeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<ZipcodeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class ZipcodeSetBuilder implements Iterable<ZipcodeCreator> {
        private List<ZipcodeCreator> creators;

        public ZipcodeSetBuilder(ZipcodeCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public ZipcodeSetBuilder(Collection<ZipcodeCreator> creators) {
            this.creators = new ArrayList<ZipcodeCreator>();
            this.creators.addAll(creators);
        }

        // asZipcodeSet() : ImmutableSet<Zipcode>

        public ImmutableSet<Zipcode> asZipcodeSet() {
            ImmutableSet.Builder<Zipcode> builder = ImmutableSet.builder();

            for (ZipcodeCreator creator : creators) {
                builder.add(creator.asZipcode());
            }
            return builder.build();
        }

        // asZipcodeMutableSet() : Set<Zipcode>

        public Set<Zipcode> asZipcodeMutableSet() {
            Set<Zipcode> result = new HashSet<Zipcode>();

            for (ZipcodeCreator creator : creators) {
                result.add(creator.asZipcode());
            }
            return result;
        }

        // asState()

        public ImmutableSet<ZipcodeState> asStateSet() {
            ImmutableSet.Builder<ZipcodeState> builder = ImmutableSet.builder();

            for (ZipcodeCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<ZipcodeMutableState> asMutableStateSet() {
            Set<ZipcodeMutableState> result = new HashSet<ZipcodeMutableState>();

            for (ZipcodeCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<ZipcodeCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class ZipcodeMapEntryBuilder {
        private final Object key;
        private final ZipcodeMaker maker;

        public ZipcodeMapEntryBuilder(Object key, ZipcodeMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Zipcode asZipcode() {
            return maker.asZipcode();
        }

        public ZipcodeState asState() {
            return maker.asState();
        }

        public ZipcodeMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class ZipcodeMapBuilder {
        private final ZipcodeMapEntryBuilder[] entries;

        public ZipcodeMapBuilder(ZipcodeMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asZipcodeMap() : ImmutableMap

        public ImmutableMap asZipcodeMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (ZipcodeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asZipcode());
            }
            return builder.build();
        }

        // asZipcodeMutableMap() : Map

        public Map asZipcodeMutableMap() {
            Map result = new HashMap();

            for (ZipcodeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asZipcode());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (ZipcodeMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (ZipcodeMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface ZipcodeMaker {
    Zipcode asZipcode();

    ZipcodeState asState();
    ZipcodeMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
