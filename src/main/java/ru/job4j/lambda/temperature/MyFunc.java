package ru.job4j.lambda.temperature;

public interface MyFunc<T> {
    boolean func(T v1, T v2);
}
