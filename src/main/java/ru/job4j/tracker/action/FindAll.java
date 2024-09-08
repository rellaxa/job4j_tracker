package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class FindAll implements UserAction {

    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        output.println("=== Вывод всех заявок ===");
        List<Item> items = memTracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище не содержит заявок");
        }
        return true;
    }
}