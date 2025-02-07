package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.StubOutput;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteTest {

    @Test
    public void whenDeleteDSuccessfully() {
        Output output = new StubOutput();
        Store store = new SqlTracker();
        Item item = store.add(new Item("Deleted item"));
        Delete deleteAction = new Delete(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        deleteAction.execute(input, store);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln);
    }

    @Test
    public void whenDeleteDFail() {
        Output output = new StubOutput();
        Store store = new SqlTracker();
        Delete deleteAction = new Delete(output);

        Input input = mock(Input.class);

        deleteAction.execute(input, store);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln);
    }
}