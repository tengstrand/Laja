package net.sf.laja.cdd;

public class Main {
    public static void main(String[] args) {

//        HairColorCreator.createHairColor("red").asHairColor();

        Address address = AddressCreator.createAddress().withStreetName("First street").withCity("Uppsala").asAddress();

        System.out.println(address);
    }
}
