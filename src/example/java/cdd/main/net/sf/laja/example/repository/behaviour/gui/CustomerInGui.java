package net.sf.laja.example.repository.behaviour.gui;

import net.sf.laja.example.repository.behaviour.domain.CustomerBuilder;
import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.state.CustomerValue;

public class CustomerInGui extends CustomerValue {
    private String givenName;
    private String surname;
    private StringToIntConverter age;
    private String streetName;
    private StringToIntConverter zipcode;

    final CustomerBuilder customerBuilder;

    public CustomerInGui(CustomerState state) {
        super(state);

        givenName = state.getGivenName();
        surname = state.getSurname();
        age = new StringToIntConverter(state.getAge());
        streetName = state.getStreetName();
        zipcode = new StringToIntConverter(state.getZipcode());

        customerBuilder = new CustomerBuilder(state, this);
    }

    public void setGivenName(String givenName) {
        this.setGivenName(givenName);
    }

    public void setSurname(String surname) {
        customerBuilder.withSurname(surname);
    }

    public void setAge(String age) {
        this.age = new StringToIntConverter(age);
        if (this.age.isValid()) {
            customerBuilder.withAge(this.age.value());
        }
    }

    public void setZipcode(String zipcode) {
        this.zipcode = new StringToIntConverter(zipcode);
        if (this.zipcode.isValid()) {
            customerBuilder.withZipcode(this.zipcode.value());
        }
    }

    private CustomerBuilder getInstance() {
        return customerBuilder.withGivenName(givenName).withSurname(surname).withAge(age.value())
                .withStreetName(streetName).withZipcode(zipcode.value());
    }

    public boolean isValid() {
        return age.isValid() && zipcode.isValid() && getInstance().isValid();
    }
}
