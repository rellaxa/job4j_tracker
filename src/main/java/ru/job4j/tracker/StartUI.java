package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println("До форматирования: " + item.getCreated());
        System.out.println("После форматирования: "
                + item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        item = new Item(1, "First");
        System.out.println(item);
    }
}
