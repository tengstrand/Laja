package net.sf.laja.cdd.state;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateMidnight;

public class XState {
    public String name;
    public DateMidnight birthday;
    public ImmutableList<PersonState> children;
    public AddressState address;
    public ImmutableSet<AddressState> oldAddresses; // (optional)
    public ImmutableMap<String,AddressState> groupedAddresses; // (optional)
}
