package com.datagenerator;

public class Person {
    private PersonName personName;
    private UsaAddress address;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public Person(PersonName personName, UsaAddress usaAddress, Gender gender) {
        this.personName = personName;
        address = usaAddress;
        this.gender = gender;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public UsaAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName=" + personName +
                ", address=" + address +
                ", gender=" + gender +
                '}';
    }
}
