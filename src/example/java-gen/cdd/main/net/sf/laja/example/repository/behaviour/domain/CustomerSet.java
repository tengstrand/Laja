package net.sf.laja.example.repository.behaviour.domain;

import java.util.Set;

import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherHashSet;

import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbHashSet;

import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiSet;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiHashSet;

public interface CustomerSet extends Set<Customer> {
    CustomerMatcherSet asCustomerMatcherSet();
    CustomerInDbSet asCustomerInDbSet();
    CustomerInGuiSet asCustomerInGuiSet();
}
