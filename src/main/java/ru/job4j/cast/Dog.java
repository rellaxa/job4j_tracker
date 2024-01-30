package ru.job4j.cast;

public class Dog implements Animal {
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Гав-гав.");
    }
}
