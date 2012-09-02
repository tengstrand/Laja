package net.sf.laja.example.computer;

import net.sf.laja.example.computer.behaviour.*;

public class ComputerExample {

    /**
     * The class Computer is the factory class for the different computer models
     * (from the 80's and the early 90's).
     *
     * This example demonstrates how to use interface in the behaviour "layer".
     * The models Atari ST and Atari Falcon030 are handled by the concrete classes
     * AtariST and AtariFalcon030, while the Amiga models are handled by the
     * interface Amiga.
     *
     * When getting an instance of Amiga by calling asAmiga() we send in a context object,
     * Configuration, that is used to decide which concrete class should be returned.
     * Amiga is an interface and we want to encapsulate the decision of which concrete
     * class that should be returned (which will hide the implementation details).
     */
    public static void main(String... args) {
        Amiga standardAmiga = AmigaFactory.owner("Joakim").asAmiga(Configuration.STANDARD);
        Amiga fastAmiga = AmigaFactory.owner("Riku").asAmiga(Configuration.FAST);
        AtariST atariST = Atari.owner("Mike").asAtariST();
        AtariFalcon030 falcon = Atari.owner("Thomas").asAtariFalcon030();

        System.out.println(standardAmiga);
        System.out.println(fastAmiga);
        System.out.println(atariST);
        System.out.println(falcon);
    }
}
