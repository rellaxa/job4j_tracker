package ru.job4j.polymorphism;

public class BusMain {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(10);
        System.out.println("Цена бензина: " + bus.refill(50));
    }
}
