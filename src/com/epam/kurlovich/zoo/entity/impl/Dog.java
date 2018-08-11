package com.epam.kurlovich.zoo.entity.impl;

import com.epam.kurlovich.zoo.entity.Animal;

public class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " plays with bone.");
    }

    @Override
    public void sound() {
        System.out.println(name + " says woof!");
    }
}
