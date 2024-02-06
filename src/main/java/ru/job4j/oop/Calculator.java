package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int m) {
        return m - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int sum) {
        return sum(sum) + multiply(sum) + minus(sum) + divide(sum);
    }

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        double temp = add(second, third);
        return add(first, temp);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("sum: " + sum(10));
        System.out.println("multiply: " + calculator.multiply(5));
        System.out.println("minus: " + minus(10));
        System.out.println("divide: " + calculator.divide(50));
        System.out.println("sumAllOperation: " + calculator.sumAllOperation(20));
    }
}