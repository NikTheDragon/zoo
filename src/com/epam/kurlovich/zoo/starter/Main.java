package com.epam.kurlovich.zoo.starter;

import com.epam.kurlovich.zoo.cloader.CCLoader;
import com.epam.kurlovich.zoo.entity.Animal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CCLoader ccLoader = new CCLoader();

        Class catClass = ccLoader.loadClass("com.epam.kurlovich.zoo.entity.impl.Cat");
        Class dogClass = ccLoader.loadClass("com.epam.kurlovich.zoo.entity.impl.Dog");

        List<Animal> animals = new ArrayList<>();

        animals.add((Animal) catClass.getConstructor(String.class).newInstance("Barsik"));
        animals.add((Animal) catClass.getConstructor(String.class).newInstance("Matroskin"));
        animals.add((Animal) catClass.getConstructor(String.class).newInstance("Behemoth"));

        animals.add((Animal) dogClass.getConstructor(String.class).newInstance("Barboss"));
        animals.add((Animal) dogClass.getConstructor(String.class).newInstance("Dogmeat"));
        animals.add((Animal) dogClass.getConstructor(String.class).newInstance("Muhtar"));

        printAnimals(animals);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal currentAnimal : animals) {
            currentAnimal.sound();
            currentAnimal.play();
        }
    }
}
