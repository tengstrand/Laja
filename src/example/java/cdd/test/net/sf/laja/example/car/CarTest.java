package net.sf.laja.example.car;

import net.sf.laja.example.car.behaviour.Car;
import net.sf.laja.example.car.behaviour.VehicleSize;
import net.sf.laja.example.car.state.CarState;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.example.car.behaviour.CarColor.RED;
import static net.sf.laja.example.car.behaviour.OwnerCreator.createOwner;
import static net.sf.laja.example.car.behaviour.VehicleSizeCreator.createVehicleSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The two tests are not an example of a good test, it only illustrates how
 * composition behaviour members can be mocked (which can be a good idea in some situations).
 *
 * The to tests verifies that the method Car.isBig() is delegating to VehicleSize.isBig().
 * If we follow the best practice TDD rule "Too simple to break" then we should not add tests
 * for these type of single statement delegations.
 */
public class CarTest {

    @Test
    public void mockingBehaviourCompositeMember() {
        VehicleSize size = mock(VehicleSize.class);
        when(size.isBig()).thenReturn(true);

        Car car = TestCarCreator.createTestCar()
                        .size(createVehicleSize()
                                .lengthInCentimeters(100))
                        .name("Volvo")
                        .owner(createOwner()
                                .ssn(197007071234L)
                                .name("Kalle"))
                        .color(RED).asCar(size);

        assertTrue(car.isBig());
    }

    @Test
    public void mockingStateAndBehaviourCompositeMember() {
        CarState carState = mock(CarState.class);

        VehicleSize size = mock(VehicleSize.class);
        when(size.isBig()).thenReturn(true);

        Car car = new Car(carState, size);

        assertTrue(car.isBig());
    }
}
