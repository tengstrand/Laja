package net.sf.laja.example.repository.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerStateImpl implements CustomerState {
    protected long ssn; // (key)
    protected String givenName;
    protected String surname; // (optional)
    protected int age;
    protected String pet; // (optional)
    protected AddressState address;
    protected AddressStateList oldAddresses; // (optional)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    CustomerStateImpl() {
        oldAddresses = AddressStateArrayList.emptyList();
    }

    public CustomerStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static CustomerStateBuilder build() {
        return new CustomerStateBuilderImpl();
    }

    public static CustomerStateBuilder build(CustomerState state) {
        return new CustomerStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (givenName == null
                || (address == null || !address.isValid())
                || (oldAddresses != null && !oldAddresses.isValid())) {
            return false;
        }
        return age >= 0 && ssn >= 190000000000L;
    }

    // Getters
    public long getSsn() { return ssn; }
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public String getPet() { return pet; }
    public AddressState getAddress() { return address; }
    public AddressStateList getOldAddresses() { return oldAddresses; }

    // Setters
    public void setSsn(long ssn, Object mutator) { checkMutator(mutator); this.ssn = ssn; }
    public void setGivenName(String givenName, Object mutator) { checkMutator(mutator); this.givenName = givenName; }
    public void setSurname(String surname, Object mutator) { checkMutator(mutator); this.surname = surname; }
    public void setAge(int age, Object mutator) { checkMutator(mutator); this.age = age; }
    public void setPet(String pet, Object mutator) { checkMutator(mutator); this.pet = pet; }
    public void setAddress(AddressState address, Object mutator) { checkMutator(mutator); this.address = address; }
    public void setOldAddresses(AddressStateList oldAddresses, Object mutator) { checkMutator(mutator); this.oldAddresses.clear(); this.oldAddresses.addAll(oldAddresses); }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by current instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }

    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof CustomerStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        CustomerStateImpl state = (CustomerStateImpl)value;

        if (ssn != state.getSsn()) return false;
        if (givenName != null ? !givenName.equals(state.getGivenName()) : state.getGivenName() != null) return false;
        if (surname != null ? !surname.equals(state.getSurname()) : state.getSurname() != null) return false;
        if (age != state.getAge()) return false;
        if (pet != null ? !pet.equals(state.getPet()) : state.getPet() != null) return false;
        if (address != null ? !address.equals(state.getAddress()) : state.getAddress() != null) return false;
        if (oldAddresses != null ? !oldAddresses.equals(state.getOldAddresses()) : state.getOldAddresses() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", givenName=" + (givenName == null ? null : '\'' + givenName + '\'' ) +
                ", surname=" + (surname == null ? null : '\'' + surname + '\'' ) +
                ", age=" + age +
                ", pet=" + (pet == null ? null : '\'' + pet + '\'' ) +
                ", address=" + address +
                ", oldAddresses=" + oldAddresses + "}";
    }
}
