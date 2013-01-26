package net.sf.laja.example.account.behaviour;

import java.util.*;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountSetEncapsulator implements Iterable<AccountEncapsulator> {
    public AccountStateSetBuilder stateSetBuilder = new AccountStateSetBuilder();
    private List<AccountEncapsulator> encapsulators = new ArrayList<AccountEncapsulator>();

    public void add(AccountEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public AccountSetEncapsulator(AccountEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AccountEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<AccountEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public SourceAccountSet asSourceAccountSet() {
        List<SourceAccount> result = new ArrayList<SourceAccount>();

        for (AccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asSourceAccount());
        }
        return new SourceAccountHashSet(result);
    }

    public DestinationAccountSet asDestinationAccountSet() {
        List<DestinationAccount> result = new ArrayList<DestinationAccount>();

        for (AccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asDestinationAccount());
        }
        return new DestinationAccountHashSet(result);
    }

    public boolean isValid() {
        for (AccountEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateSetBuilder.toString();
    }
}
