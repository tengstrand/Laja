package net.sf.laja.example.account;

import org.junit.Test;

import static net.sf.laja.example.account.TestAccountCreator.createTestAccount;
import static org.junit.Assert.assertEquals;

public class DestinationAccountTest {

    @Test
    public void givenBalanceIs400AndDepositing200ThenBalanceShouldBe600() {
        TestAccount destinationTestAccount = createTestAccount().balance(400).asTestAccount();

        DestinationAccount destinationAccount = destinationTestAccount.asDestinationAccount();
        destinationAccount.deposit(200);

        assertEquals(600, destinationTestAccount.balance(), 0.001);
    }
}
