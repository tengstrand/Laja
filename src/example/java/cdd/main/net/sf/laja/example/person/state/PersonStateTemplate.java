package net.sf.laja.example.person.state;

public class PersonStateTemplate {
    String givenName;
    String surname;
    int weightInKilograms;
    HeightState height;

    void bmi() {
        BmiStateProjection
                .heightInCentimeters(height.getHeightInCentimeters())
                .weightInKilograms(weightInKilograms);
    }
}
