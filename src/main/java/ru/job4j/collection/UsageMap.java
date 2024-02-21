package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("relaxa@gmail.com", "FIO");
        map.put("qwerty@gmail.com", "hernick");
        map.put("qwerty@gmail.com", "namelick");
        map.put("testypu@gmail.com", "clessyver mind");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " --> " + value);
        }
    }
}
