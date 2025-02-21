package ru.job4j.lambda.genericmeth;

public class MyArraysOps {
    static <T> int countMatching(T[] vales, T v) {
        int count = 0;
        for (T vale : vales) {
            if (vale == v) {
                count++;
            }
        }
        return count;
    }
}
