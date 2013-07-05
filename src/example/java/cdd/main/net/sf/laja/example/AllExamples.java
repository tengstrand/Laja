package net.sf.laja.example;

import net.sf.laja.example.account.AccountExample;
import net.sf.laja.example.car.CarExample;
import net.sf.laja.example.file.FileExample;
import net.sf.laja.example.person.PersonExample;
import net.sf.laja.example.repository.RepositoryExample;

public class AllExamples {

    public static void main(String... args) {
        System.out.println("*** Account ***");
        AccountExample.main();

        System.out.println("\n*** Car ***");
        CarExample.main();

        System.out.println("\n*** File ***");
        FileExample.main();

        System.out.println("\n*** Person ***");
        PersonExample.main();

        System.out.println("\n*** Repository ***");
        RepositoryExample.main();
    }
}
