package ru.job4j.collection;

import com.sun.source.tree.UsesTree;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                if (!temp.contains(start)) {
                    temp.add(element);
                    start = element;
                } else {
                    temp.add(start + "/" + element);
                    start += "/" + element;
                }
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}