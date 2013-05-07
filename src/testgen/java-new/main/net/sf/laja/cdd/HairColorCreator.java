package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.HairColorState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.HairColorState.HairColorMutableState;

@Creator
public class HairColorCreator implements HairColorMaker {
    private final HairColorMutableState state;

    public HairColor asHairColor() {
        return HairColor.valueOf(state.color.toUpperCase());
    }

    public static HairColorCreator createHairColor(HairColor color) {
        return createHairColor(color.name());
    }

    // ------ Generated code ------

    public static HairColorCreator createHairColor(String color) {
        return new HairColorFactory.Factory().new Color().color(color);
    }

    public static HairColorBuilder buildHairColor() {
        return HairColorBuilder.create();
    }

    public static HairColorListBuilder createHairColorList(String... colorList) {
        return new HairColorListBuilder(colorList);
    }

    public static HairColorListBuilder createHairColorList(HairColorCreator... creators) {
        return new HairColorListBuilder(creators);
    }

    public static HairColorSetBuilder createHairColorSet(HairColorCreator... creators) {
        return new HairColorSetBuilder(creators);
    }

    public static HairColorMapBuilder createHairColorMap(HairColorMapEntryBuilder... builders) {
        return new HairColorMapBuilder(builders);
    }

    public static HairColorMapEntryBuilder hairColorEntry(Object key, String color) {
        return new HairColorMapEntryBuilder(key, createHairColor(color));
    }

    public static HairColorMapEntryBuilder hairColorEntry(Object key, HairColor color) {
        return new HairColorMapEntryBuilder(key, createHairColor(color));
    }

    public static HairColorMapEntryBuilder hairColorEntry(Object key, HairColorCreator creator) {
        return new HairColorMapEntryBuilder(key, creator);
    }

    public static HairColorMapEntryBuilder hairColorEntry(Object key, HairColorBuilder builder) {
        return new HairColorMapEntryBuilder(key, builder);
    }

    public HairColorCreator(HairColorMutableState state) {
        this.state = state;
    }

    public HairColorState asState() {
        return state.asImmutable();
    }

    public String asValue() {
        return state.color;
    }

    public HairColorMutableState asMutableState() {
        return state;
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

    public static class HairColorBehaviour {
        public final HairColorState state;

        public HairColorBehaviour(HairColorState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof HairColorBehaviour)) return false;

            return state.equals(((HairColorBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    public static class HairColorMutableBehaviour {
        private HairColorMutableState state;

        public HairColorMutableBehaviour(HairColorMutableState state) {
            this.state = state;
        }

        public HairColorState state() {
            return state.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof HairColorMutableBehaviour)) return false;

            return state.equals(((HairColorMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    public static class HairColorFactory {

        private static class Factory {
            private final HairColorMutableState state = new HairColorMutableState();

            public class Color {

                public HairColorCreator color(String color) {
                    state.color = color;
                    return new HairColorCreator(state);
                }
            }
        }
    }

    public static class HairColorBuilder implements HairColorMaker {
        private final HairColorMutableState state;

        private HairColorBuilder(HairColorMutableState state) {
            this.state = state;
        }

        public static HairColorBuilder create() {
            return new HairColorBuilder(new HairColorMutableState());
        }

        public HairColorBuilder withColor(String color) {
            state.color = color;
            return this;
        }

        public HairColor asHairColor() {
            return HairColor.valueOf(state.color.toUpperCase());
        }

        public HairColorState asState() {
            return state.asImmutable();
        }

        public HairColorMutableState asMutableState() {
            return state;
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
    }

    public static class HairColorListBuilder {
        private String[] colorList;
        private HairColorCreator[] creators;

        public HairColorListBuilder(String... colorList) {
            this.colorList = colorList;
        }

        public HairColorListBuilder(HairColorCreator... creators) {
            this.creators = creators;
        }

        // HairColor

        public ImmutableList<HairColor> asHairColorList() {
            if (colorList != null) {
                return asListFromElements();
            }
            return asListFromCreators();
        }

        private ImmutableList<HairColor> asListFromElements() {
            ImmutableList.Builder<HairColor> builder = ImmutableList.builder();

            for (String element : colorList) {
                builder.add(createHairColor(element).asHairColor());
            }
            return builder.build();
        }

        private ImmutableList<HairColor> asListFromCreators() {
            ImmutableList.Builder<HairColor> builder = ImmutableList.builder();

            for (HairColorCreator creator : creators) {
                builder.add(creator.asHairColor());
            }
            return builder.build();
        }

        // TODO: follow the same pattern as for asList.

        public List<HairColor> asHairColorMutableList() {
            List<HairColor> result = new ArrayList<HairColor>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asHairColor());
            }
            return result;
        }

        // TODO: follow the same pattern as for asList.

        public List<HairColor> asMutableList() {
            List<HairColor> result = new ArrayList<HairColor>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asHairColor());
            }
            return result;
        }


        // State

        // TODO: follow the same pattern as for asList.

        public ImmutableList<HairColorState> asStateList() {
            ImmutableList.Builder<HairColorState> builder = ImmutableList.builder();

            for (HairColorCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // TODO: follow the same pattern as for asList.

        public List<HairColorState.HairColorMutableState> asMutableStateList() {
            List<HairColorState.HairColorMutableState> result = new ArrayList<HairColorState.HairColorMutableState>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    public static class HairColorSetBuilder {
        private HairColorCreator[] creators;

        public HairColorSetBuilder(HairColorCreator... creators) {
            this.creators = creators;
        }

        // HairColor

        // TODO: follow the same pattern as for asList...

        public ImmutableSet<HairColor> asHairColorSet() {
            ImmutableSet.Builder<HairColor> builder = ImmutableSet.builder();

            for (HairColorCreator creator : creators) {
                builder.add(creator.asHairColor());
            }
            return builder.build();
        }

        public Set<HairColor> asHairColorMutableSet() {
            Set<HairColor> result = new HashSet<HairColor>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asHairColor());
            }
            return result;
        }

        // State

        public Set<HairColorState> asStateSet() {
            Set<HairColorState> result = new HashSet<HairColorState>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asState());
            }
            return result;
        }

        public Set<HairColorState.HairColorMutableState> asMutableStateSet() {
            Set<HairColorState.HairColorMutableState> result = new HashSet<HairColorState.HairColorMutableState>();

            for (HairColorCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    public static class HairColorMapEntryBuilder {
        private final Object key;
        private final HairColorMaker maker;

        public HairColorMapEntryBuilder(Object key, HairColorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public HairColor asHairColor() {
            return maker.asHairColor();
        }

        public HairColorState asState() {
            return maker.asState();
        }

        public HairColorMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    public static class HairColorMapBuilder {
        private final HairColorMapEntryBuilder[] entries;

        public HairColorMapBuilder(HairColorMapEntryBuilder... entries) {
            this.entries = entries;
        }

        public ImmutableMap asHairColorMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (HairColorMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asHairColor());
            }
            return builder.build();
        }

        public Map asHairColorMutableMap() {
            Map result = new HashMap();

            for (HairColorMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asHairColor());
            }
            return result;
        }

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (HairColorMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (HairColorMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

interface HairColorMaker {
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
    HairColor asHairColor();
    HairColorState asState();
    HairColorMutableState asMutableState();
}
