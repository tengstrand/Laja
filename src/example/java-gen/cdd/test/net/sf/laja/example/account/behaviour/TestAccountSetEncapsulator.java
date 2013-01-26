package net.sf.laja.example.account.behaviour;

import java.util.*;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountSetEncapsulator implements Iterable<TestAccountEncapsulator> {
    public AccountStateSetBuilder stateSetBuilder = new AccountStateSetBuilder();
    private List<TestAccountEncapsulator> encapsulators = new ArrayList<TestAccountEncapsulator>();

    public void add(TestAccountEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestAccountSetEncapsulator(TestAccountEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestAccountEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestAccountEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestAccountSet asTestAccountSet() {
        List<TestAccount> result = new ArrayList<TestAccount>();

        for (TestAccountEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestAccount());
        }
        return new TestAccountHashSet(result);
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
        return stateSetBuilder.toString();
    }
}
