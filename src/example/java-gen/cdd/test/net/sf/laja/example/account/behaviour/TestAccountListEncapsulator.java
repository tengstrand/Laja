package net.sf.laja.example.account.behaviour;

import java.util.*;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountListEncapsulator implements Iterable<TestAccountEncapsulator> {
    public AccountStateListBuilder stateListBuilder = new AccountStateListBuilder();
    private List<TestAccountEncapsulator> encapsulators = new ArrayList<TestAccountEncapsulator>();

    public void add(TestAccountEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TestAccountListEncapsulator(TestAccountEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestAccountEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestAccountEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestAccountList asTestAccountList() {
        List<TestAccount> result = new ArrayList<TestAccount>();

        for (TestAccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestAccount());
        }
        return new TestAccountArrayList(result);
    }

    public boolean isValid() {
        for (TestAccountEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}
