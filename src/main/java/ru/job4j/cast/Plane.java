package ru.job4j.cast;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void engine() {
        System.out.println(getClass().getSimpleName() + " летит с помощью турбин.");
    }
}
