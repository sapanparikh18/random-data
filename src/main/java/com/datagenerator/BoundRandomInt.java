package com.datagenerator;

public class BoundRandomInt {
    public int getRandomInteger(int minimum, int maximum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }
}
