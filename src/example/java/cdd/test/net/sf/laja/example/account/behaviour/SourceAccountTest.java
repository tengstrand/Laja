package net.sf.laja.example.account.behaviour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SourceAccountTest {

    @Test
    public void transferTo() {
        TestAccount destinationTestAccount = TestAccount.balance(400).asTestAccount();
        DestinationAccount destinationAccount = destinationTestAccount.asDestinationAccount();

        TestAccount sourceTestAccount = TestAccount.balance(500).asTestAccount();
        SourceAccount sourceAccount = sourceTestAccount.asSourceAccount();

        sourceAccount.transferTo(destinationAccount, 300);

        assertEquals(200, sourceTestAccount.balance(), 0.001);
        assertEquals(700, destinationTestAccount.balance(), 0.001);
    }
}
