package net.sf.laja.example.person;

import net.sf.laja.example.person.behaviour.Height;
import net.sf.laja.example.person.behaviour.Person;

public class PersonExample {

    /**
     * This example shows two things:
     *   - How to create and use state projections. In this example we use the two attributes 'int weightInKilograms' and
     *     'HeightState length' to represent a Person state (defined in PersonStateTemplate). We have intentionally
     *     stored one value as a primitive type (weightInKilograms) and the other as an object (height) to demonstrate the
     *     use of state projection. We have the concept BMI with the state representation defined in BmiStateTemplate which
     *     consists of the attributes 'int weightInKilograms' and 'int heightInCentimeters'. The method stateBmi() defined
     *     in PersonStateTemplate describes how each BMI attribute is mapped to an attribute in "Person state".
     *  - How to work with composition. In this case we gather all BMI calculations in the behaviour class BodyMassIndex
     *    and then we let 'Person' delegate to this object in the method calculateBmi().
     */
    public static void main(String... args) {
        Person person = Person.givenName("Joakim").surname("Tengstrand").weightInKilograms(82).height(Height.heightInCentimeters(186)).asPerson();
        System.out.println(person);
        System.out.println("Body Mass Index: " + person.calculateBmi());
        System.out.println("Has normal weight?: " + person.hasNormalWeight());
    }
}