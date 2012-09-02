package net.sf.laja.example.repository.state;

public class CustomerStateTemplate {
    long ssn; // (key)
    String givenName;
    String surname; // (optional)
    int age;
    String pet; // (optional)
    AddressState $address;
    AddressStateList oldAddresses; // (optional)

    public boolean isValid() {
        return age >= 0 && ssn >= 190000000000L;
    }
}
