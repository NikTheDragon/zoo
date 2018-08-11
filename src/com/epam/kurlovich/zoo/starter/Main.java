package com.epam.kurlovich.zoo.starter;

import com.epam.kurlovich.zoo.cloader.CCLoader;
import com.epam.kurlovich.zoo.entity.Animal;
import com.epam.kurlovich.zoo.entity.Cat;
import com.epam.kurlovich.zoo.entity.Dog;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CCLoader ccLoader = new CCLoader();

        Class catClass = ccLoader.loadClass("com.epam.kurlovich.zoo.entity.Cat");
        Class dogClass = ccLoader.loadClass("com.epam.kurlovich.zoo.entity.Dog");

        List<Animal> animals = new ArrayList<>();

        animals.add((Cat) catClass.getConstructor(String.class).newInstance("Barsik"));
        animals.add((Cat) catClass.getConstructor(String.class).newInstance("Matroskin"));
        animals.add((Cat) catClass.getConstructor(String.class).newInstance("Behemoth"));

        animals.add((Dog) dogClass.getConstructor(String.class).newInstance("Barboss"));
        animals.add((Dog) dogClass.getConstructor(String.class).newInstance("Dogmeat"));
        animals.add((Dog) dogClass.getConstructor(String.class).newInstance("Muhtar"));

        for (Animal currentAnimal : animals) {
            currentAnimal.sound();
            currentAnimal.play();
        }
    }
}
