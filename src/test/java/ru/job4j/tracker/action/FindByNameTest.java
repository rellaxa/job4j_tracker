package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameTest {

    @Test
    public void whenFoundByName() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Item"));
        FindByName findByName = new FindByName(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findByName.execute(input, store);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ==="
                + ln + item + ln
        );
    }

}