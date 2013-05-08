package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

// Kalle kula

public class XState {
    public String name;
    public DateMidnight birthday;
    public ImmutableList<PersonState> children;
    public AddressState address;
    public ImmutableSet<AddressState> oldAddresses; // (optional)
    public ImmutableMap<String,AddressState> groupedAddresses; // (optional)
    public ImmutableList<ImmutableSet<Integer>> listOfSetOfInteger;

    private static void setDefaults(PersonMutableState state) {
        state.children = new ArrayList<PersonMutableState>();
        state.address = new AddressMutableState();
        state.oldAddresses = new HashSet<AddressMutableState>();
        state.groupedAddresses = new HashMap<String, AddressMutableState>();
        state.listOfSetOfMapOfIntegers = new ArrayList<Set<Map<String,Integer>>>();
    }
}
