package ru.job4j.pattern.factory;

public interface MyFunc<R, T> {
    R func(T n);
}
