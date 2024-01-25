package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int count);

    double refill(int fuel);
}
