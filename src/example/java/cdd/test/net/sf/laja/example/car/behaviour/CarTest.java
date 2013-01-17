package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarState;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
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

        Car car = TestCar.lengthInCentimeters(100).name("Volvo").owner(Owner.ssn(197007071234L).name("Kalle")).color("Red").asCar(size);

        assertTrue(car.isBig());
    }

    @Test
    public void mockingStateAndBehaviourCompositeMember() {
        CarState state = mock(CarState.class);

        VehicleSize size = mock(VehicleSize.class);
        when(size.isBig()).thenReturn(true);

        Car car = new Car(state, size);

        assertTrue(car.isBig());
    }
}
