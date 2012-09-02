package net.sf.laja.example.account.behaviour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DestinationAccountTest {

    @Test
    public void deposit() {
        TestAccount testAccount = TestAccount.balance(400).asTestAccount();

        DestinationAccount destinationAccount = testAccount.asDestinationAccount();
        destinationAccount.deposit(200);

        assertEquals(600, testAccount.balance(), 0.001);
    }
}
