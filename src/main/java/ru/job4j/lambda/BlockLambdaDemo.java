package ru.job4j.lambda;

public class BlockLambdaDemo {
    public static void main(String[] args) {
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Факториал 3 = " + factorial.func(3));
    }
}
