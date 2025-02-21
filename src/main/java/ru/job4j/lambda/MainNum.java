package ru.job4j.lambda;

public class MainNum {
    public static void main(String[] args) {
        MyNumber myNum;
        // Использовать лямбда -выражение в контексте присваивания.
        myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        myNum = () -> Math.random() * 100;
        System.out.println(myNum.getValue());
    }
}
