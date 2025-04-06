package ru.job4j.tracker;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.job4j.toone.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participates = new ArrayList<>();

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