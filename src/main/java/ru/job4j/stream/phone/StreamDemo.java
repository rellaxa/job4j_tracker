package ru.job4j.stream.phone;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<NamePhoneEmail> myList = List.of(
                new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"),
                new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com "),
                new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com")
        );
        System.out.println("Исходные значения в myList");
        myList.forEach(a -> System.out.println(a.name() + " " + a.phoneNum() + a.email()));

        System.out.println();
        Stream<NamePhone> nameAndPhone = myList.stream()
                .map(a -> new NamePhone(a.name(), a.phoneNum()));
        System.out.println("Список имен и телефонных номеров: ");
        nameAndPhone.forEach(a -> System.out.println(a.name() + " " + a.phoneNum()));
    }
}
