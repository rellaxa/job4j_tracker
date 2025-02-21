package ru.job4j.polymorphism;

import java.util.Comparator;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static class Comparator implements java.util.Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 500);
        Employee employee1 = new Employee("Jane Doe", 500);
        Comparator comparator = new Comparator();
        comparator.compare(employee, employee);
    }
}

