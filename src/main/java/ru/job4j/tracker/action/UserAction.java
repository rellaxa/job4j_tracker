package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.store.Store;

public interface UserAction {

    String name();

    boolean execute(Input input, Store memTracker);
}