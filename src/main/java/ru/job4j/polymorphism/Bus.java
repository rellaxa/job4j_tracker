package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едет со скоростью 60 км/ч");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Вмещает в себя: " + count);
    }

    @Override
    public double refill(int litres) {
        return 1.24 * litres;
    }
}