package com.datagenerator;

public class RandomPerson {
    public Person next() {
        Gender[] values = Gender.values();
        int index = (int)Math.round(Math.random());
        return new Person(new RandomPersonName().next(values[index]), new RandomUsaAddress().next(),values[index]);
    }
}
