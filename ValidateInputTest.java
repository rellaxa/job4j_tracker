package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("WTF");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenFewTimesInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"2", "4", "9", "10", "11111"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(9);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(10);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(11111);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-777"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-777);
    }
}