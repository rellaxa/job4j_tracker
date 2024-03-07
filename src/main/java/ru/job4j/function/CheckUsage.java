package ru.job4j.function;

import java.util.function.Function;

public class CheckUsage {
    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();

        /* ---------------- Predicate -------------- */
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.isEmpty(), ""
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.startsWith("Fun"), "Functional interface"
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        string -> string.contains("rn"), "Surname Name"
                )
        );

        /* ---------------- Function -------------- */
        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        string -> string.toUpperCase(), "aBCdEfghKLmnpRstU"
                )
        );
        System.out.println(
                usage.transform(
                        string -> string.concat("работает корректно."), "Строка после преобразования: "
                )
        );
        System.out.println(
                usage.transform(
                        string -> string.trim(), "    aBC dEfghK Lmnp RstU        "
                )
        );
    }
}
