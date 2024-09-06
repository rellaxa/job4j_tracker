package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output output) {
        this.out = output;
    }

    public void init(Input input, Store memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Меню:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output,
                new ConsoleInput());

        try (Store memTracker = new MemTracker()) {
            List<UserAction> actions = Arrays.asList(
                    new Create(output),
                    new FindAll(output),
                    new Replace(output),
                    new Delete(output),
                    new FindById(output),
                    new FindByName(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, memTracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}