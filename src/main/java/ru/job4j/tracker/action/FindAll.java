package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

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
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище не содержит заявок");
        }
        return true;
    }
}