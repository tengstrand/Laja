package net.sf.laja.example.car.state;

public class OwnerStateTemplate {
    long ssn;
    String name;

    public boolean isValid() {
        return ssn >= 190000000000L;
    }
}
