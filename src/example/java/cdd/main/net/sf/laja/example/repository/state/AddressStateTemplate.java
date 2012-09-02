package net.sf.laja.example.repository.state;

public class AddressStateTemplate {
    int addressId; // (id)
    String streetName;
    ZipcodeState $zipcode;
    String city;

    public boolean isValid() {
        return city.length() > 0 && Character.isLetter(city.subSequence(0, 1).charAt(0));
    }
}
