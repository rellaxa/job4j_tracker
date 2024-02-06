package ru.job4j.ex;

import java.util.Arrays;

public class BackArray {
    public String[] turn(String[] names) {
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            names[index] = names[names.length - (index + 1)];
            names[names.length - (index + 1)] = temp;
        }
        return names;
    }

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        String[] result =  new BackArray().turn(names);
        System.out.println(Arrays.toString(result));
    }
}