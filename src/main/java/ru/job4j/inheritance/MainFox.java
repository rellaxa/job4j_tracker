package ru.job4j.inheritance;

public class MainFox {
    public static void main(String[] args) {
        Fox lisa = new Fox("Лиса", 5, 4);
        String lisaName = lisa.getName();
        int lisaAge = lisa.getAge();
        int lisaWeight = lisa.getWeight();

        System.out.println("Имя лисы: " + lisaName);
        System.out.println("Возраст лисы: " + lisaAge);
        System.out.println("Вес лисы: " + lisaWeight);

        System.out.println();
        System.out.println("Изначальное имя лисы — " + lisa.getName());
        lisa.setName("Василий");
        System.out.println("Новое имя лисы — " + lisa.getName());

        System.out.println();
        lisa.setAge(-100);
        System.out.println("Возраст Лисы — " + lisa.getAge() + " лет");
    }
}