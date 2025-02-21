package ru.job4j.collection.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainCar {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(1990, "Ferrari 360 Spider", 310),
                new Car(2012, "Lamborghini Gallardo", 290),
                new Car(2010, "Bugatti Veyron", 350)
        );

        Collections.sort(cars);
        System.out.println(cars);

        Comparator speedComparator = new MaxSpeedCarComparator();
        Collections.sort(cars, speedComparator);
        System.out.println(cars);
    }
}
