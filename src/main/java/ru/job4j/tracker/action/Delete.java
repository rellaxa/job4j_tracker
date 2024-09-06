package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        output.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        Item item = memTracker.findById(id);
        memTracker.delete(id);
        output.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        return true;
    }
}