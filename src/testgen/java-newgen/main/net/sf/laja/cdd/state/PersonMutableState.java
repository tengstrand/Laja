package net.sf.laja.cdd.state;

public class PersonMutableState {
    public int age;
    public String name;
    public AddressMutableState address = new AddressMutableState();
    public AddressMutableState address2 = new AddressMutableState();

    public PersonMutableState() {
    }

    public PersonMutableState(int age, String name, AddressMutableState address, AddressMutableState address2) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.address2 = address;
    }

    public int getAge() { return age;  }
    public String getName() { return name; }
    public AddressMutableState getAddress() { return address; }
    public AddressMutableState getAddress2() { return address2; }

    public PersonMutableState setAge(int age) { this.age = age; return this; }
    public PersonMutableState setName(String name) { this.name = name;  return this; }
    public PersonMutableState setAddress(AddressMutableState address) { this.address = address;  return this;}
    public PersonMutableState setAddress2(AddressMutableState address2) { this.address2 = address2;  return this;}

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
