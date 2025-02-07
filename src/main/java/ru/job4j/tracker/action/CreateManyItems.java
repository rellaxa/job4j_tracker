package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.store.Store;

public class CreateManyItems implements UserAction {

    private final Output output;

    public CreateManyItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        output.println("=== Create many items ===");
        int count = input.askInt("Введите количество заявок: ");
        for (int i = 0; i < count; i++) {
            memTracker.add(new Item("Заявка № " + i));
        }
        output.println("Добавлено заявок: " + count);
        return true;
    }
}
