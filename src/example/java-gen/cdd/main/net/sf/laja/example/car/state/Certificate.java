package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.OwnerStateImpl;
import net.sf.laja.example.car.state.OwnerStateListImpl;
import net.sf.laja.example.car.state.OwnerStateBuilderImpl;
import net.sf.laja.example.car.state.CarStateImpl;
import net.sf.laja.example.car.state.CarStateListImpl;
import net.sf.laja.example.car.state.CarStateBuilderImpl;
import net.sf.laja.example.car.state.TruckStateImpl;
import net.sf.laja.example.car.state.TruckStateListImpl;
import net.sf.laja.example.car.state.TruckStateBuilderImpl;
import net.sf.laja.example.car.state.TruckTypeStateImpl;
import net.sf.laja.example.car.state.TruckTypeStateListImpl;
import net.sf.laja.example.car.state.TruckTypeStateBuilderImpl;
import net.sf.laja.example.car.state.VehicleSizeStateImpl;
import net.sf.laja.example.car.state.VehicleSizeStateListImpl;
import net.sf.laja.example.car.state.VehicleSizeStateBuilderImpl;
import net.sf.laja.example.car.state.BusStateImpl;
import net.sf.laja.example.car.state.BusStateListImpl;
import net.sf.laja.example.car.state.BusStateBuilderImpl;

/**
 * Code generated by Laja - Do not change!
 * Version: laja2-006
 *
 *   http://laja.tengstrand.nu
 */
public class Certificate {
    Certificate() {
    }

    private static Certificate certificate(Object state) {
        if (state == null) {
            throw new IllegalArgumentException();
        }
        return new Certificate();
    }

    public static Certificate get(OwnerStateImpl state) { return certificate(state); }
    public static Certificate get(OwnerStateListImpl state) { return certificate(state); }
    public static Certificate get(OwnerStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(CarStateImpl state) { return certificate(state); }
    public static Certificate get(CarStateListImpl state) { return certificate(state); }
    public static Certificate get(CarStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(TruckStateImpl state) { return certificate(state); }
    public static Certificate get(TruckStateListImpl state) { return certificate(state); }
    public static Certificate get(TruckStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(TruckTypeStateImpl state) { return certificate(state); }
    public static Certificate get(TruckTypeStateListImpl state) { return certificate(state); }
    public static Certificate get(TruckTypeStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(VehicleSizeStateImpl state) { return certificate(state); }
    public static Certificate get(VehicleSizeStateListImpl state) { return certificate(state); }
    public static Certificate get(VehicleSizeStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(BusStateImpl state) { return certificate(state); }
    public static Certificate get(BusStateListImpl state) { return certificate(state); }
    public static Certificate get(BusStateBuilderImpl state) { return certificate(state); }
}
