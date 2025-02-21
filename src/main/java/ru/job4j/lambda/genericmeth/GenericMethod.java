package ru.job4j.lambda.genericmeth;

public class GenericMethod {
    static <T> int myOp(MyFunc<T> f, T[] vales, T v) {
        return f.func(vales, v);
    }

    public static void main(String[] args) {
        Integer[] vales = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strings = {"One", "Two", "Three", "Two"};

        int count = myOp((MyArraysOps::countMatching), vales, 4);
        System.out.println("Количество элементов 4, содержащихся в vales: " + count);

        count = myOp(MyArraysOps::<String>countMatching, strings, "Two");
        System.out.println("Количество элементов Two, содержащихся в strings: " + count);
    }
}
