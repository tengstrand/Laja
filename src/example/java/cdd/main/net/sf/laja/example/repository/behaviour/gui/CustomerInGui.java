package net.sf.laja.example.repository.behaviour.gui;

import net.sf.laja.example.repository.behaviour.domain.AddressCreator;
import net.sf.laja.example.repository.behaviour.domain.CustomerCreator;
import net.sf.laja.example.repository.behaviour.domain.ZipcodeCreator;

import static net.sf.laja.example.repository.behaviour.domain.CustomerCreator.CustomerMutableBehaviour;
import static net.sf.laja.example.repository.state.CustomerState.CustomerMutableState;

public class CustomerInGui extends CustomerMutableBehaviour {
    private StringToIntConverter age;
    private StringToIntConverter zipcode;

    final CustomerCreator.CustomerBuilder customerBuilder;
    final AddressCreator.AddressBuilder addressBuilder;
    final ZipcodeCreator.ZipcodeBuilder zipcodeBuilder;

    public CustomerInGui(CustomerMutableState state) {
        super(state);

        age = new StringToIntConverter(state.getAge());
        zipcode = new StringToIntConverter(state.getAddress().getZipcode().getZipcode());

        customerBuilder = new CustomerCreator.CustomerBuilder(state);
        addressBuilder = new AddressCreator.AddressBuilder(state.address);
        zipcodeBuilder = new ZipcodeCreator.ZipcodeBuilder(state.address.zipcode);
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
            zipcodeBuilder.withZipcode(zipcode.value());
        }
    }

    public boolean isValid() {
        return age.isValid() && zipcode.isValid() && customerBuilder.isValid();
    }
}
