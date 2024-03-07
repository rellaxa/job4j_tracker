package ru.job4j.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> binaryOperator = (first, second) -> first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + binaryOperator.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
