package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    public Computer(boolean multiMonitor, int ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer() {

    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " GB");
        System.out.println("Модель CPU: " + cpu);
    }

    public static void main(String[] args) {
        Computer computer = new Computer(true, 500, "Intel Core I7-10700K");
        computer.printInfo();
        System.out.println();
        Computer myComp = new Computer(true, 1500, "AND Ryzen 9 5900X");
        myComp.printInfo();
        System.out.println();
        Computer second = new Computer();
        second.printInfo();
    }
}