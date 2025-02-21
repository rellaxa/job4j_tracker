package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                student -> student,
                                (existing, replacement) -> existing
                        ));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .filter(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(
                List.of(1, 1, 2, 2).stream()
                        .collect(
                        Collectors.toMap(
                                element -> element,
                                element -> element * element,
                                (existing, replacement) -> existing
                        ))
        );
    }
}
