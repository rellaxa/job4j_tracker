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

class ReplaceTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Replace replaceAction = new Replace(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Замена заявки ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

}