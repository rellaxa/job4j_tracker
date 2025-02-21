package ru.job4j.lambda;

public class MyStringOps {
    static String strReverse(String str) {
        StringBuilder rsl = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rsl.append(str.charAt(i));
        }
        return rsl.toString();
    }
}
