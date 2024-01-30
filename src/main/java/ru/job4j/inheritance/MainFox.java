package ru.job4j.inheritance;

public class MainFox {
    public static void main(String[] args) {
        Fox lisa = new Fox("Лиса", 5, 4);
        String lisaName = lisa.getName();
        int lisaAge = lisa.getAge();
        int lisaWeight = lisa.getWeight();

        System.out.println("Имя кота: " + lisaName);
        System.out.println("Возраст кота: " + lisaAge);
        System.out.println("Вес кота: " + lisaWeight);

        System.out.println();
        System.out.println("Изначальное имя кота — " + lisa.getName());
        lisa.setName("Василий");
        System.out.println("Новое имя кота — " + lisa.getName());

        System.out.println();
        lisa.setAge(-100);
        System.out.println("Возраст Лисы — " + lisa.getAge() + " лет");
    }
}
