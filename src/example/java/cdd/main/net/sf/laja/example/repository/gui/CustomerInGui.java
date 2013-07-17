package net.sf.laja.example.repository.gui;

import net.sf.laja.example.repository.domain.AddressCreator;
import net.sf.laja.example.repository.domain.CustomerCreator;

import static net.sf.laja.example.repository.domain.CustomerCreator.CustomerMutableBehaviour;
import static net.sf.laja.example.repository.state.CustomerState.CustomerMutableState;

public class CustomerInGui extends CustomerMutableBehaviour {
    private StringToIntConverter age;
    private StringToIntConverter zipcode;

    final CustomerCreator.CustomerBuilder customerBuilder;
    final AddressCreator.AddressBuilder addressBuilder;

    public CustomerInGui(CustomerMutableState state) {
        super(state);

        age = new StringToIntConverter(state.age);
        zipcode = new StringToIntConverter(state.address.zipcode);

        customerBuilder = new CustomerCreator.CustomerBuilder(state);
        addressBuilder = new AddressCreator.AddressBuilder(state.address);
    }

    public void setGivenName(String givenName) {
        customerBuilder.withGivenName(givenName);
    }

    public void setSurname(String surname) {
        customerBuilder.withSurname(surname);
    }

    public void setAge(String newAge) {
        age = new StringToIntConverter(newAge);
        if (age.isValid()) {
            customerBuilder.withAge(age.value());
        }
    }

    public void setZipcode(String newZipcode) {
        zipcode = new StringToIntConverter(newZipcode);
        if (zipcode.isValid()) {
            addressBuilder.withZipcode(zipcode.value());
        }
    }

    public boolean isValid() {
        return age.isValid() && zipcode.isValid() && customerBuilder.isValid();
    }
}
