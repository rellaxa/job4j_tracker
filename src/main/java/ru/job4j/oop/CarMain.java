package ru.job4j.oop;

public class CarMain {

    public static void main(String[] args) {
        Auto car = new Auto("Марка", "Модель");
        Auto.Transmission transmission = car.new Transmission();
        Auto.Brakes brakes = car.new Brakes();
        Auto.TripComputer tripComputer = car.new TripComputer();
        tripComputer.getInfo();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
    }
}
