package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] transport = new Vehicle[]{plane, train, bus};
        for (Vehicle o : transport) {
            o.move();
            o.engine();
        }
    }
}