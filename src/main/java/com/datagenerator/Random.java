package com.datagenerator;

public class Random {
    public Person nextPerson() {
        return new RandomPerson().next();
    }

    public PersonName nextPersonName(Gender gender) {
        return new RandomPersonName().next(gender);
    }

    public String nextUsaState() {
        return new RandomUsaState().next();
    }

    public UsaAddress nextUsaAddress() {
        return new RandomUsaAddress().next();
    }

}
