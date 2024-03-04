package ru.job4j.collection;

import java.util.Comparator;
import java.util.Set;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] l = left.split("/");
        String[] r = right.split("/");
        int result = r[0].compareTo(l[0]);
        return result == 0 ? left.compareTo(right) : result;
    }
}
