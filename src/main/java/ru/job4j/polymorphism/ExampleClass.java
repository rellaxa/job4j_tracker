package ru.job4j.polymorphism;

import ru.job4j.oop.Auto;

public class ExampleClass {

    interface InnerExampleInterface {
    }

    interface Parking<T> {
        void park(T car);
    }

    class CarParking implements Parking<Auto> {
        public void park(Auto car) {

        }
    }
}
