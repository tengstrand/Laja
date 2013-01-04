package net.sf.laja.example.car;

import net.sf.laja.example.car.behaviour.Bus;
import net.sf.laja.example.car.behaviour.Car;
import net.sf.laja.example.car.behaviour.Owner;

import static net.sf.laja.example.car.behaviour.CarColor.RED;

public class CarExample {

    /**
     * This example show how to:
     *   - Create objects composed by other objects (a car with an owner), named 'aggregates' in Domain Driven Design.
     *   - State objects can be composed by other state objects (expanded and merged), see CarStateTemplate.length
     *     and BusStateTemplate.length. These two length attributes uses 'VehicleSizeState' in the state definition.
     *     The behaviour class VehicleSize gathers all business logic related to length which are used
     *     by Car and Bus (attribute 'size'). When a state expands another state it will implement that interface
     *     of that state, that is why CarState and BusState implements VehicleSizeState and why the behaviour class
     *     VehicleSize can wrap them.
     * ´ - Support different formats/types for attributes, 'car.color' and 'owner.ssn' in this example, see
     *     method 'convertColor' in 'CarStateTemplate' and 'OwnerStateTemplate'.
     *  - All attributes are mandatory by default if not marked as optional. The state attribute weightInKilograms,
     *    defined in BusStateTemplate, are marked as optional and is not part of the mandatory attributes
     *    in the chained constructor but can by populated by the builder method 'withWeightInKilograms'.
     */
    public static void main(String... args) {
        // Use the chained constructor to create the car.
        Car volvo = Car.lengthInCentimeters(479).name("Volvo").owner(Owner.ssn(197506071234L).name("Bill")).color(RED.name()).asCar();

        // Use the builder to create the car.
        Car saab = Car.build().withLengthInCentimeters(434).withName("Saab").withColor("Blue").withOwner(
                Owner.build().withSsn(197707071122L).withName("Bull")).asCar();

        // Name and lengthInCentimeters are mandatory, weightInKilograms is optional.
        Bus bus = Bus.name("Some").lengthInCentimeters(5100).withWeightInKilograms(3200).asBus();

        System.out.println(volvo);
        System.out.println(saab);
        System.out.println(bus);
        System.out.println("Volvo is big: " + volvo.isBig());
    }
}
