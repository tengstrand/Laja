package net.sf.laja.example.account.behaviour;

import java.util.*;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountListEncapsulator implements Iterable<AccountEncapsulator> {
    public AccountStateListBuilder stateList = new AccountStateListBuilder();
    private List<AccountEncapsulator> encapsulators = new ArrayList<AccountEncapsulator>();

    public void add(AccountEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public AccountListEncapsulator(AccountEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AccountEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<AccountEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public SourceAccountList asSourceAccountList() {
        List<SourceAccount> result = new ArrayList<SourceAccount>();

        for (AccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asSourceAccount());
        }
        return new SourceAccountArrayList(result);
    }

    public DestinationAccountList asDestinationAccountList() {
        List<DestinationAccount> result = new ArrayList<DestinationAccount>();

        for (AccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asDestinationAccount());
        }
        return new DestinationAccountArrayList(result);
    }

    public boolean isValid() {
        for (AccountEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
