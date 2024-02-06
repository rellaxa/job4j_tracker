package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Иван", 30);
        System.out.println("Имя: " + person.getName() + ", возраст: " + person.getAge());
        System.out.println(person);
        PersonRecord record = new PersonRecord("Иван", 30);
        System.out.println("Имя: " + person.getName() + ", возраст: " + person.getAge());
        System.out.println(record);
        PersonRecord record1 = new PersonRecord("Иван", 30);
        System.out.println(record1.equals(record));
        PersonRecord newRecord = new PersonRecord(record.name(), 35);
        System.out.println(newRecord);
    }
}