package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;

import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherList;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherArrayList;

import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbList;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDbArrayList;

import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiList;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGuiArrayList;

public interface CustomerList extends List<Customer> {
    CustomerMatcherList asCustomerMatcherList();
    CustomerInDbList asCustomerInDbList();
    CustomerInGuiList asCustomerInGuiList();
}
