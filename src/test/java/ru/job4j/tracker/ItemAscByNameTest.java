package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenAscByName() {
        List<Item> items = Arrays.asList(
                new Item("3"),
                new Item("2"),
                new Item("4"),
                new Item("1")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("1"),
                new Item("2"),
                new Item("3"),
                new Item("4")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
   public void whenDescByName() {
        List<Item> items = Arrays.asList(
                new Item("3"),
                new Item("2"),
                new Item("4"),
                new Item("1")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("4"),
                new Item("3"),
                new Item("2"),
                new Item("1")
        );
        assertThat(items).isEqualTo(expected);
    }
}