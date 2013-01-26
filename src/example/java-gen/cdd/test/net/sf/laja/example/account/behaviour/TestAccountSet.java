package net.sf.laja.example.account.behaviour;

import java.util.Set;

public interface TestAccountSet extends Set<TestAccount> {
    SourceAccountSet asSourceAccountSet();
    DestinationAccountSet asDestinationAccountSet();
}
