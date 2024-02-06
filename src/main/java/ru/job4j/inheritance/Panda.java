package ru.job4j.inheritance;

public class Panda extends Animal {

    @Override
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Panda");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Panda");
    }
}