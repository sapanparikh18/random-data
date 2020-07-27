package com.datagenerator;

public class PersonName {
    private String firstName;
    private String lastName;
    private String middleInitial;

    public PersonName(String firstName, String lastName, String middleInitial) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getMiddleInitial() {
        return middleInitial;
    }

    @Override
    public String toString() {
        return "PersonName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial=" + middleInitial +
                '}';
    }
}
