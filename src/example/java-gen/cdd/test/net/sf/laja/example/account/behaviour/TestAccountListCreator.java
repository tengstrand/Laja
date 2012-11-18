package net.sf.laja.example.account.behaviour;

import java.util.*;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountListCreator implements Iterable<TestAccountEncapsulator> {
    public AccountStateListBuilder stateList = new AccountStateListBuilder();
    private List<TestAccountEncapsulator> encapsulators = new ArrayList<TestAccountEncapsulator>();

    public void add(TestAccountEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TestAccountListCreator(TestAccountEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestAccountEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
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
}
