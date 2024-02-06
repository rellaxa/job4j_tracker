package ru.job4j.cast;

public class Goose implements Animal {
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Га-га");
    }
}