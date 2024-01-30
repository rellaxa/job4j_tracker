package ru.job4j.oop;

public class User {

    /**
     *  Это поле объекта. Оно доступно только конкретному оббъекту.
     */

    private String name;
    private int age;

    private boolean canDrive() {
        boolean can = false; // can - локальная переменная
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}
