package net.sf.laja.example.car;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.annotation.Parameter;
import net.sf.laja.cdd.annotation.Parameters;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
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

import static net.sf.laja.example.car.VehicleSizeCreator.createVehicleSize;
import static net.sf.laja.example.car.state.CarState.*;
import static net.sf.laja.example.car.state.OwnerState.OwnerStringState;
import static net.sf.laja.example.car.state.VehicleSizeState.VehicleSizeStringState;

@Creator
public class CarCreator implements CarCreatorMaker {
    private final CarMutableState state;

    public Car asCar() {
        return new Car(state.asImmutable());
    }

    @Parameters({
        @Parameter(attribute = "size", method = "lengthInCentimeters", methodSignature = "int lengthInCentimeters", value = "createVehicleSize().lengthInCentimeters(lengthInCentimeters).asMutableState()")
    })

    // ===== Generated code =====

    public static CarFactory createCar() {
        return new CarCreator(new CarMutableState()).new CarFactory();
    }

    public static CarBuilder buildCar() {
        return new CarBuilder();
    }

    public static CarStringBuilder buildStringCar() {
        return new CarStringBuilder();
    }

    public static CarListBuilder createCarList(CarCreator... creators) {
        return new CarListBuilder(creators);
    }

    public static CarSetBuilder createCarSet(CarCreator... creators) {
        return new CarSetBuilder(creators);
    }

    public static CarMapBuilder createCarMap(CarMapEntryBuilder... builders) {
        return new CarMapBuilder(builders);
    }

    public static CarMapEntryBuilder createCarEntry(Object key, CarCreator creator) {
        return new CarMapEntryBuilder(key, creator);
    }

    public static CarMapEntryBuilder createCarEntry(Object key, CarBuilder builder) {
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

        public _Name lengthInCentimeters(int lengthInCentimeters) {
            return new _Size().lengthInCentimeters(lengthInCentimeters);
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

            public _Name lengthInCentimeters(int lengthInCentimeters) {
                state.size = createVehicleSize().lengthInCentimeters(lengthInCentimeters).asMutableState();
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
            public CarCreator color(String color) {
                state.color = color;
                return new CarCreator(state);
            }
        }
    }

    // --- Constructor ---

    public CarCreator(CarMutableState state) {
        this.state = state;
    }

    public CarState asState() {
        return state.asImmutable();
    }

    public CarMutableState asMutableState() {
        return state;
    }

        public CarStringState asStringState() {
            return state.asStringState();
        }

        public CarStringState asStringState(StringStateConverter stateConverter) {
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
        if (that == null || !(that instanceof CarCreator)) return false;

        return state.equals(((CarCreator)that).state);
    }

    @Override public String toString() {
        return "CarCreator" + state;
    }

    // --- Behaviour ---

    public static class CarBehaviour {
        public final CarState state;

        public CarBehaviour(CarState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute) {
            assertThat(condition, attribute, (attribute == null ? "" : "invalid-" + attribute.toLowerCase()));
        }

        public void assertThat(boolean condition, String attribute, String errorType) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorType, "");
                throw new InvalidCarStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CarBehaviour)) return false;

            return state.equals(((CarBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class CarMutableBehaviour {
        private CarMutableState state;

        public CarMutableBehaviour(CarMutableState state) {
            this.state = state;
        }

        public CarState asState() {
            return state.asImmutable();
        }

        public void assertThat(boolean condition, String attribute) {
            assertThat(condition, attribute, (attribute == null ? "" : "invalid-" + attribute.toLowerCase()));
        }

        public void assertThat(boolean condition, String attribute, String errorType) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorType, "");
                throw new InvalidCarStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CarMutableBehaviour)) return false;

            return state.equals(((CarMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class CarBuilder implements CarCreatorMaker {
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

        public Car asCar() {
            return new Car(state.asImmutable());
        }

        public CarState asState() {
            return state.asImmutable();
        }

        public CarMutableState asMutableState() {
            return state;
        }

        public CarStringState asStringState() {
            return state.asStringState();
        }

        public CarStringState asStringState(StringStateConverter stateConverter) {
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
            if (that == null || !(that instanceof CarBuilder)) return false;

            return state.equals(((CarBuilder)that).state);
        }

        @Override public String toString() {
            return "CarBuilder" + state;
        }
    }

    // --- String builder ---

    public static class CarStringBuilder {
        private final CarStringState state;

        public CarStringBuilder() {
            this.state = new CarStringState();
        }

        public CarStringBuilder(CarStringState state) {
            this.state = state;
        }

        public CarStringBuilder withSize(VehicleSizeStringState size) { state.size = size; return this; }
        public CarStringBuilder withSize(VehicleSizeCreator.VehicleSizeStringBuilder size) { state.size = size.asStringState(); return this; }
        public CarStringBuilder withName(String name) { state.name = name; return this; }
        public CarStringBuilder withOwner(OwnerStringState owner) { state.owner = owner; return this; }
        public CarStringBuilder withOwner(OwnerCreator.OwnerStringBuilder owner) { state.owner = owner.asStringState(); return this; }
        public CarStringBuilder withColor(String color) { state.color = color; return this; }

        public Car asCar() {
            return new CarBuilder(state.asMutable()).asCar();
        }

        public CarState asState() {
            return state.asImmutable();
        }

        public CarMutableState asMutableState() {
            return state.asMutable();
        }

        public CarStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CarStringBuilder)) return false;

            return state.equals(((CarStringBuilder)that).state);
        }

        @Override public String toString() {
            return "CarStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class CarListBuilder implements Iterable<CarCreator> {
        private List<CarCreator> creators;

        public CarListBuilder(CarCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CarListBuilder(Collection<CarCreator> creators) {
            this.creators = new ArrayList<CarCreator>();
            this.creators.addAll(creators);
        }

        // asCarList() : ImmutableList<Car>

        public ImmutableList<Car> asCarList() {
            ImmutableList.Builder<Car> builder = ImmutableList.builder();

            for (CarCreator creator : creators) {
                builder.add(creator.asCar());
            }
            return builder.build();
        }

        // asCarMutableList() : List<Car>

        public List<Car> asCarMutableList() {
            List<Car> result = new ArrayList<Car>();

            for (CarCreator creator : creators) {
                result.add(creator.asCar());
            }
            return result;
        }

        // asStateList() : ImmutableList<CarState>

        public ImmutableList<CarState> asStateList() {
            ImmutableList.Builder<CarState> builder = ImmutableList.builder();

            for (CarCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<CarMutableState>

        public List<CarMutableState> asMutableStateList() {
            List<CarMutableState> result = new ArrayList<CarMutableState>();

            for (CarCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<CarCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class CarSetBuilder implements Iterable<CarCreator> {
        private List<CarCreator> creators;

        public CarSetBuilder(CarCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CarSetBuilder(Collection<CarCreator> creators) {
            this.creators = new ArrayList<CarCreator>();
            this.creators.addAll(creators);
        }

        // asCarSet() : ImmutableSet<Car>

        public ImmutableSet<Car> asCarSet() {
            ImmutableSet.Builder<Car> builder = ImmutableSet.builder();

            for (CarCreator creator : creators) {
                builder.add(creator.asCar());
            }
            return builder.build();
        }

        // asCarMutableSet() : Set<Car>

        public Set<Car> asCarMutableSet() {
            Set<Car> result = new HashSet<Car>();

            for (CarCreator creator : creators) {
                result.add(creator.asCar());
            }
            return result;
        }

        // asState()

        public ImmutableSet<CarState> asStateSet() {
            ImmutableSet.Builder<CarState> builder = ImmutableSet.builder();

            for (CarCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<CarMutableState> asMutableStateSet() {
            Set<CarMutableState> result = new HashSet<CarMutableState>();

            for (CarCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<CarCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class CarMapEntryBuilder {
        private final Object key;
        private final CarCreatorMaker maker;

        public CarMapEntryBuilder(Object key, CarCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Car asCar() {
            return maker.asCar();
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

        // asCarMap() : ImmutableMap

        public ImmutableMap asCarMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CarMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCar());
            }
            return builder.build();
        }

        // asCarMutableMap() : Map

        public Map asCarMutableMap() {
            Map result = new HashMap();

            for (CarMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCar());
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

interface CarCreatorMaker {
    Car asCar();

    CarState asState();
    CarMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
