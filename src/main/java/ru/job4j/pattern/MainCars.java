package ru.job4j.pattern;

public class MainCars {
    public static void main(String[] args) {
        CarsFactory factory;
        factory = new ToyotaFactory();
        System.out.println(factory.createSedan());
    }
}
