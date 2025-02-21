package ru.job4j.collection.car;

import java.util.Comparator;

public class MaxSpeedCarComparator implements Comparator<Car> {
    @Override
    public int compare(Car left, Car right) {
        return left.getMaxSpeed() - right.getMaxSpeed();
    }
}
