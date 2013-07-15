package net.sf.laja.example.account;

import org.junit.Test;

import static net.sf.laja.example.account.TestAccountCreator.createTestAccount;
import static org.junit.Assert.assertEquals;

public class SourceAccountTest {

    @Test
    public void shouldBePossibleToTransferMoneyFromSourceAccountToDestinationAccount() {
        TestAccount destinationTestAccount = createTestAccount().balance(400).asTestAccount();
        DestinationAccount destinationAccount = destinationTestAccount.asDestinationAccount();

        TestAccount sourceTestAccount = createTestAccount().balance(500).asTestAccount();
        SourceAccount sourceAccount = sourceTestAccount.asSourceAccount();

        sourceAccount.transferTo(destinationAccount, 300);

        assertEquals(200, sourceTestAccount.balance(), 0.001);
        assertEquals(700, destinationTestAccount.balance(), 0.001);
    }
}
