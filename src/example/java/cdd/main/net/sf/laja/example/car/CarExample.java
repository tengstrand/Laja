package net.sf.laja.example.car;

import static net.sf.laja.example.car.BusCreator.createBus;
import static net.sf.laja.example.car.CarColor.RED;
import static net.sf.laja.example.car.CarCreator.buildCar;
import static net.sf.laja.example.car.CarCreator.createCar;
import static net.sf.laja.example.car.OwnerCreator.buildOwner;
import static net.sf.laja.example.car.OwnerCreator.createOwner;
import static net.sf.laja.example.car.VehicleSizeCreator.buildVehicleSize;

public class CarExample {

    /**
     * This example show how to:
     *   - Create objects composed by other objects (a car with an owner), named 'aggregates' in Domain Driven Design.
     *   - State objects can be composed by other state objects, see CarStateTemplate.length
     *     and BusStateTemplate.length. These two length attributes uses 'VehicleSizeState' in the state definition.
     *     The behaviour class VehicleSize gathers all business logic related to length which are used
     *     by Car and Bus (attribute 'size').
     * ´ - Support different formats/types for attributes, 'car.color' and 'owner.ssn' in this example, see
     *     method 'convertColor' in 'CarStateTemplate' and 'OwnerStateTemplate'.
     *  - All attributes are mandatory by default if not marked as optional. The state attribute weightInKilograms,
     *    defined in BusStateTemplate, are marked as optional and is not part of the mandatory attributes
     *    in the chained constructor but can by populated by the builder method 'withWeightInKilograms'.
     */
    public static void main(String... args) {
        // Use the chained constructor to create the car.
        Car volvo = createCar().lengthInCentimeters(479).name("Volvo").owner(createOwner().ssn(197506071234L).name("Bill")).color(RED.name()).asCar();

        // Use the builder to create the car.
        Car saab = buildCar().withSize(buildVehicleSize().withLengthInCentimeters(434)).withName("Saab").withColor("Blue").withOwner(
                buildOwner().withSsn(197707071122L).withName("Bull")).asCar();

        // Name and lengthInCentimeters are mandatory, weightInKilograms is optional.
        Bus bus = createBus().name("Some").lengthInCentimeters(5100).withWeightInKilograms(3200).asBus();

        System.out.println(volvo);
        System.out.println(saab);
        System.out.println(bus);
        System.out.println("Volvo is big: " + volvo.isBig());
    }
}
