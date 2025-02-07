package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class DeleteAllItems implements UserAction {

    private final Output output;

    public DeleteAllItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        output.println("=== Delete all items ===");
        List<Item> allItems = memTracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId)
                .toList();
        for (Integer id : collect) {
            memTracker.delete(id);
        }
        output.println("=== Все заявки удалены ===");
        return true;
    }
}
