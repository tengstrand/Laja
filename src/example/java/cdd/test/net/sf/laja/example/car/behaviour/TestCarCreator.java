package net.sf.laja.example.car.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.OwnerState.OwnerMutableState;
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

import static net.sf.laja.example.car.state.CarState.CarMutableState;

@Creator
public class TestCarCreator implements TestCarCreatorMaker {
    private final CarMutableState state;

    public Car asCar(VehicleSize size) {
        return new Car(state.asImmutable(), size);
    }

    public TestCar asTestCar() {
        return new TestCar(state.asImmutable());
    }

    // ===== Generated code =====

    private static final String size_ = "size";
    private static final String name_ = "name";
    private static final String owner_ = "owner";
    private static final String color_ = "color";

    // --- Constructors ---

    public static CarFactory createTestCar() {
        return new TestCarCreator(new CarMutableState()).new CarFactory();
    }

    public static CarBuilder buildTestCar() {
        return new CarBuilder();
    }

    public static CarListBuilder createTestCarList(TestCarCreator... creators) {
        return new CarListBuilder(creators);
    }

    public static CarSetBuilder createTestCarSet(TestCarCreator... creators) {
        return new CarSetBuilder(creators);
    }

    public static CarMapBuilder createTestCarMap(CarMapEntryBuilder... builders) {
        return new CarMapBuilder(builders);
    }

    public static CarMapEntryBuilder createTestCarEntry(Object key, TestCarCreator creator) {
        return new CarMapEntryBuilder(key, creator);
    }

    public static CarMapEntryBuilder testCarEntry(Object key, CarBuilder builder) {
        return new CarMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class CarFactory {

        public _Name size(VehicleSizeMutableState size) {
            return new _Size().size(size);
        }

        public _Name size(VehicleSizeCreator size) {
            return new _Size().size(size);
        }

        // size
        public class _Size {
            public _Name size(VehicleSizeMutableState size) {
                state.size = size;
                return new _Name();
            }

            public _Name size(VehicleSizeCreator size) {
                state.size = size.asMutableState();
                return new _Name();
            }
        }

        // name
        public class _Name {
            public _Owner name(String name) {
                state.name = name;
                return new _Owner();
            }
        }

        // owner
        public class _Owner {
            public _Color owner(OwnerMutableState owner) {
                state.owner = owner;
                return new _Color();
            }

            public _Color owner(OwnerCreator owner) {
                state.owner = owner.asMutableState();
                return new _Color();
            }
        }

        // color
        public class _Color {
            public TestCarCreator color(String color) {
                state.color = color;
                return new TestCarCreator(state);
            }
        }
    }

    // --- Constructor ---

    public TestCarCreator(CarMutableState state) {
        this.state = state;
    }

    public CarState asState() {
        return state.asImmutable();
    }

    public CarMutableState asMutableState() {
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

    public static class CarBehaviour {
        public final CarState s;

        public CarBehaviour(CarState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CarBehaviour)) return false;

            return s.equals(((CarBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class CarMutableBehaviour {
        private CarMutableState s;

        public CarMutableBehaviour(CarMutableState s) {
            this.s = s;
        }

        public CarState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CarMutableBehaviour)) return false;

            return s.equals(((CarMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class CarBuilder implements TestCarCreatorMaker {
        private final CarMutableState state;

        public CarBuilder() {
            this.state = new CarMutableState();
        }

        public CarBuilder(CarMutableState state) {
            this.state = state;
        }

        public CarBuilder withSize(VehicleSizeMutableState size) { state.size = size; return this; }
        public CarBuilder withSize(VehicleSizeCreator.VehicleSizeBuilder size) { state.size = size.asMutableState(); return this; }
        public CarBuilder withName(String name) { state.name = name; return this; }
        public CarBuilder withOwner(OwnerMutableState owner) { state.owner = owner; return this; }
        public CarBuilder withOwner(OwnerCreator.OwnerBuilder owner) { state.owner = owner.asMutableState(); return this; }
        public CarBuilder withColor(String color) { state.color = color; return this; }

        public Car asCar(VehicleSize size) {
            return new Car(state.asImmutable(), size);
        }

        public TestCar asTestCar() {
            return new TestCar(state.asImmutable());
        }

        public CarState asState() {
            return state.asImmutable();
        }

        public CarMutableState asMutableState() {
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

    public static class CarListBuilder implements Iterable<TestCarCreator> {
        private List<TestCarCreator> creators;

        public CarListBuilder(TestCarCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CarListBuilder(Collection<TestCarCreator> creators) {
            this.creators = new ArrayList<TestCarCreator>();
            this.creators.addAll(creators);
        }

        // asCarList(VehicleSize size) : ImmutableList<Car>

        public ImmutableList<Car> asCarList(VehicleSize size) {
            ImmutableList.Builder<Car> builder = ImmutableList.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asCar(size));
            }
            return builder.build();
        }

        // asCarMutableList(VehicleSize size) : List<Car>

        public List<Car> asCarMutableList(VehicleSize size) {
            List<Car> result = new ArrayList<Car>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asCar(size));
            }
            return result;
        }

        // asTestCarList() : ImmutableList<TestCar>

        public ImmutableList<TestCar> asTestCarList() {
            ImmutableList.Builder<TestCar> builder = ImmutableList.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asTestCar());
            }
            return builder.build();
        }

        // asTestCarMutableList() : List<TestCar>

        public List<TestCar> asTestCarMutableList() {
            List<TestCar> result = new ArrayList<TestCar>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asTestCar());
            }
            return result;
        }

        // asStateList() : ImmutableList<CarState>

        public ImmutableList<CarState> asStateList() {
            ImmutableList.Builder<CarState> builder = ImmutableList.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<CarMutableState>

        public List<CarMutableState> asMutableStateList() {
            List<CarMutableState> result = new ArrayList<CarMutableState>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TestCarCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class CarSetBuilder implements Iterable<TestCarCreator> {
        private List<TestCarCreator> creators;

        public CarSetBuilder(TestCarCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CarSetBuilder(Collection<TestCarCreator> creators) {
            this.creators = new ArrayList<TestCarCreator>();
            this.creators.addAll(creators);
        }

        // asCarSet(VehicleSize size) : ImmutableSet<Car>

        public ImmutableSet<Car> asCarSet(VehicleSize size) {
            ImmutableSet.Builder<Car> builder = ImmutableSet.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asCar(size));
            }
            return builder.build();
        }

        // asCarMutableSet(VehicleSize size) : Set<Car>

        public Set<Car> asCarMutableSet(VehicleSize size) {
            Set<Car> result = new HashSet<Car>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asCar(size));
            }
            return result;
        }

        // asTestCarSet() : ImmutableSet<TestCar>

        public ImmutableSet<TestCar> asTestCarSet() {
            ImmutableSet.Builder<TestCar> builder = ImmutableSet.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asTestCar());
            }
            return builder.build();
        }

        // asTestCarMutableSet() : Set<TestCar>

        public Set<TestCar> asTestCarMutableSet() {
            Set<TestCar> result = new HashSet<TestCar>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asTestCar());
            }
            return result;
        }

        // asState()

        public ImmutableSet<CarState> asStateSet() {
            ImmutableSet.Builder<CarState> builder = ImmutableSet.builder();

            for (TestCarCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<CarMutableState> asMutableStateSet() {
            Set<CarMutableState> result = new HashSet<CarMutableState>();

            for (TestCarCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TestCarCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class CarMapEntryBuilder {
        private final Object key;
        private final TestCarCreatorMaker maker;

        public CarMapEntryBuilder(Object key, TestCarCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Car asCar(VehicleSize size) {
            return maker.asCar(size);
        }

        public TestCar asTestCar() {
            return maker.asTestCar();
        }

        public CarState asState() {
            return maker.asState();
        }

        public CarMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class CarMapBuilder {
        private final CarMapEntryBuilder[] entries;

        public CarMapBuilder(CarMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asCarMap(VehicleSize size) : ImmutableMap

        public ImmutableMap asCarMap(VehicleSize size) {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CarMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCar(size));
            }
            return builder.build();
        }

        // asCarMutableMap(VehicleSize size) : Map

        public Map asCarMutableMap(VehicleSize size) {
            Map result = new HashMap();

            for (CarMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCar(size));
            }
            return result;
        }

        // asTestCarMap() : ImmutableMap

        public ImmutableMap asTestCarMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CarMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asTestCar());
            }
            return builder.build();
        }

        // asTestCarMutableMap() : Map

        public Map asTestCarMutableMap() {
            Map result = new HashMap();

            for (CarMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asTestCar());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CarMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (CarMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface TestCarCreatorMaker {
    Car asCar(VehicleSize size);
    TestCar asTestCar();

    CarState asState();
    CarMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}