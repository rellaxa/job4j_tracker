package ru.job4j.lambda;

public class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Массив пуст");
    }
}
