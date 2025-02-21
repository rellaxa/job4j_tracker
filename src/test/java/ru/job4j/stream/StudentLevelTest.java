package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentLevelTest {

    @Test
    public void whenSortedScore20() {
        List<Student> input = new ArrayList<>() {{
            add(new Student(28, "Masha"));
            add(new Student(128, "Petya"));
            add(new Student(97, "Andrey"));
        }};
        List<Student> expected = List.of(
                new Student(128, "Petya"),
                new Student(97, "Andrey"),
                new Student(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expected);
    }

    @Test
    public void whenSortedScore20HasNull() {
        List<Student> input = new ArrayList<>() {{
            add(null);
            add(new Student(28, "Masha"));
            add(null);
            add(new Student(128, "Petya"));
            add(null);
            add(new Student(97, "Andrey"));
            add(null);
        }};
        List<Student> expected = List.of(
                new Student(128, "Petya"),
                new Student(97, "Andrey"),
                new Student(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expected);
    }

    @Test
    public void whenSortedScore65() {
        List<Student> input = new ArrayList<>() {{
            add(new Student(46, "Masha"));
            add(new Student(101, "Petya"));
            add(new Student(32, "Andrey"));
            add(new Student(84, "Boris"));
            add(new Student(78, "Yana"));
            add(new Student(65, "Nikolai"));
        }};
        List<Student> expected = List.of(
                new Student(101, "Petya"),
                new Student(84, "Boris"),
                new Student(78, "Yana"),
                new Student(65, "Nikolai"));
        assertThat(StudentLevel.levelOf(input, 65)).containsSequence(expected);
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>() {{
            add(null);
            add(null);
            add(null);
        }};
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expected);
    }
}