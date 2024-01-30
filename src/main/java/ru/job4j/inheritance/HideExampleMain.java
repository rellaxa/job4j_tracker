package ru.job4j.inheritance;

public class HideExampleMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal panda = new Panda();
        animal.instanceInvoke();
        panda.instanceInvoke();
        Animal.staticInvoke();
        Panda.staticInvoke();
        panda.staticInvoke();

        System.out.println();
        panda.staticInvoke();
        Animal other = null;
        other.staticInvoke();
        Panda kitty = new Panda();
        kitty.staticInvoke();
    }
}
