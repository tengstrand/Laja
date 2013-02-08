package net.sf.laja.example.person;

import net.sf.laja.example.person.behaviour.Person;

public class PersonExample {

    /**
     *  This example shows how to work with composition. All BMI operations is made in the behaviour class BodyMassIndex,
     *  and we let 'Person' delegate to this object in the method calculateBmi().
     */
    public static void main(String... args) {
        Person person = Person.givenName("Joakim").surname("Tengstrand").heightInCentimeters(186).weightInKilograms(82).asPerson();
        System.out.println(person);
        System.out.println("Body Mass Index: " + person.calculateBmi());
        System.out.println("Has normal weight?: " + person.hasNormalWeight());
    }
}