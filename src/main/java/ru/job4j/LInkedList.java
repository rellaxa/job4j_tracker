package ru.job4j;

import java.util.LinkedList;

public class LInkedList {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<String>();
        names.add(0, "Petr");
        names.add(0, "Ivan");
        names.add(0, "Stepan");
        for (String string : names) {
            System.out.println(string);
        }
    }
}
