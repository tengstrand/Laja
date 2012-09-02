package net.sf.laja.example.account;

import net.sf.laja.example.account.behaviour.Account;
import net.sf.laja.example.account.behaviour.DestinationAccount;
import net.sf.laja.example.account.behaviour.SourceAccount;

public class AccountExample {

    /**
     * Shows how to transfer money from a source account to a destination account.
     *
     * The "transfer money" example is commonly used to explain the DCI pattern
     * (Data Context Interaction) created by Trygve Reenskaug.
     *
     * Note that this is CDD (Context Driven Development) created by Joakim Tengstrand.
     * CDD does not use roles, only state and behaviour.
     *
     * Classes included in this example:
     *   - AcccountExample       (user story)
     *   - Account               (factory)
     *   - SourceAccount         (behaviour)
     *   - DestinationAccount    (behaviour)
     *   - AccountStateTemplate  (state)
     */
    public static void main(String... args) {
        SourceAccount sourceAccount = Account.balance(1000).asSourceAccount();
        DestinationAccount destinationAccount = Account.balance(100).asDestinationAccount();

        System.out.println("=== before transaction ===");
        System.out.println(sourceAccount);
        System.out.println(destinationAccount);

        System.out.println("\n=== transfer 400 ===");
        sourceAccount.transferTo(destinationAccount, 400);

        System.out.println("\n=== after transaction ===");
        System.out.println(sourceAccount);
        System.out.println(destinationAccount);
    }
}
