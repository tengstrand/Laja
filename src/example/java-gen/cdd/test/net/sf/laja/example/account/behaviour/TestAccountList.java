package net.sf.laja.example.account.behaviour;

import java.util.List;

public interface TestAccountList extends List<TestAccount> {
    SourceAccountList asSourceAccountList();
    DestinationAccountList asDestinationAccountList();
}
