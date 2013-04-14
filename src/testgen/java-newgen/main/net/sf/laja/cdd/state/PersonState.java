package net.sf.laja.cdd.state;

public final class PersonState {
    public final int age;
    public final String name;
    public final AddressState address;
    public final AddressState address2;

    public PersonState(int age, String name, AddressState address, AddressState address2) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.address2 = address2;
    }

    public PersonState withAge(int age) { return new PersonState(age, name, address, address2); }
    public PersonState withName(String name) { return new PersonState(age, name, address, address2); }
    public PersonState withAddress(AddressState address) { return new PersonState(age, name, address, address2); }
    public PersonState withAddress2(AddressState address2) { return new PersonState(age, name, address, address2); }

    public PersonMutableState asMutable() {
        return new PersonMutableState(age, name, address.asMutable(), address2.asMutable());
    }

    public int superHashCode() {
        return super.hashCode();
    }

    public boolean superEquals(Object o) {
        return super.equals(o);
    }

    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonState that = (PersonState) o;

        if (age != that.age) return false;
        if (!address.equals(that.address)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    public String toString() {
        return "{age=" + age + ", name='" + name + "\'', address=" + address + "}";
    }
}
