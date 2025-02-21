package ru.job4j.polymorphism;

public class MainFunctionMessage {
    public static void main(String[] args) {
        FunctionMessage functionMessage = new FunctionMessage();
        functionMessage.functionMessage();
        System.out.println(functionMessage.getAverage(new int[]{1, 2, 3, 10, 8}));
        System.out.println(functionMessage.getDoubleSum(new int[]{1, 2, 3, 10, 8}));
    }
}
