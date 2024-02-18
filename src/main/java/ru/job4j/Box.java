package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }

    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = a; // b = Integer.valueOf(a);
        System.out.println("Integer b = " + b);

        int x = 2;
        num(x);

        Integer m = 3;
        int n = m; // n = m.intValue();

        Integer k = 5;
        Integer l = 6;
        System.out.println("В методе println() перемножаться будут уже распакованные значения: " + k * l);

        Integer g = 127;
        Integer h = 127;
        System.out.println(g == h);

        Integer sum = 0;
        for (int i = 128; i < 300; i++) {
            sum += i;
        }
        System.out.println(sum);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
