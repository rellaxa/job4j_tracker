package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "items")
@Data
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id = " + id + '\''
                + ", name = '" + name + '\''
                + ", created = " + created.format(FORMATTER) + '\''
                + '}';
    }
}