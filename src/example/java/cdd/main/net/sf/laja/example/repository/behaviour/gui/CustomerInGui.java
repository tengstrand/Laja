package net.sf.laja.example.repository.behaviour.gui;

import net.sf.laja.example.repository.behaviour.domain.AddressBuilder;
import net.sf.laja.example.repository.behaviour.domain.CustomerBuilder;
import net.sf.laja.example.repository.behaviour.domain.ZipcodeBuilder;
import net.sf.laja.example.repository.state.CustomerBehaviour;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerInGui extends CustomerBehaviour {
    private StringToIntConverter age;
    private StringToIntConverter zipcode;

    final CustomerBuilder customerBuilder;
    final AddressBuilder addressBuilder;
    final ZipcodeBuilder zipcodeBuilder;

    public CustomerInGui(CustomerState state) {
        super(state);

        age = new StringToIntConverter(state.getAge());
        zipcode = new StringToIntConverter(state.getAddress().getZipcode().getZipcode());

        customerBuilder = new CustomerBuilder(state, this);
        addressBuilder = new AddressBuilder(state.getAddress(), this);
        zipcodeBuilder = new ZipcodeBuilder(state.getAddress().getZipcode(), this);
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
