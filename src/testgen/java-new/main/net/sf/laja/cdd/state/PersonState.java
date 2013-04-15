package net.sf.laja.cdd.state;

public class PersonState {
    public final int age;
    public final String name;
    public final AddressState address;
    public final AddressState address2;

    // Generated code goes here...

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

    public static class PersonMutableState {
        public int age;
        public String name;
        public AddressState.AddressMutableState address = new AddressState.AddressMutableState();
        public AddressState.AddressMutableState address2 = new AddressState.AddressMutableState();

        public PersonMutableState() {
        }

        public PersonMutableState(int age, String name, AddressState.AddressMutableState address, AddressState.AddressMutableState address2) {
            this.age = age;
            this.name = name;
            this.address = address;
            this.address2 = address;
        }

        public int getAge() { return age;  }
        public String getName() { return name; }
        public AddressState.AddressMutableState getAddress() { return address; }
        public AddressState.AddressMutableState getAddress2() { return address2; }

        public PersonMutableState setAge(int age) { this.age = age; return this; }
        public PersonMutableState setName(String name) { this.name = name;  return this; }
        public PersonMutableState setAddress(AddressState.AddressMutableState address) { this.address = address;  return this;}
        public PersonMutableState setAddress2(AddressState.AddressMutableState address2) { this.address2 = address2;  return this;}

        public PersonState asImmutable() {
            return new PersonState(age, name, address.asImmutable(), address2.asImmutable());
        }

        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (address2 != null ? address2.hashCode() : 0);
            return result;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonMutableState that = (PersonMutableState) o;

            if (age != that.age) return false;
            if (address != null ? !address.equals(that.address) : that.address != null) return false;
            if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;

            return true;
        }

        public String toString() {
            return "{age=" + age + ", name='" + name + "\''}";
        }
    }
}
