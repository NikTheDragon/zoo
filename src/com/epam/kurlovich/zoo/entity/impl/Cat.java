package com.epam.kurlovich.zoo.entity.impl;

import com.epam.kurlovich.zoo.entity.Animal;

public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " plays with mouse.");
    }

    @Override
    public void sound() {
        System.out.println(name + " says meow!");
    }
}
