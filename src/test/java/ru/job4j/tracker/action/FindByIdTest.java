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

class FindByIdTest {

    @Test
    public void whenFoundSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("item"));
        FindById findById = new FindById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        findById.execute(input, store);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ==="
                        + ln + item + ln
        );
    }

    @Test
    public void whenNotFound() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        FindById findById = new FindById(output);

        Input input = mock(Input.class);

        findById.execute(input, store);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ==="
                        + ln + "Заявка с введенным id: " + 0 + " не найдена." + ln
        );
    }

}