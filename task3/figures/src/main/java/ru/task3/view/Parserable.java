package ru.task3.view;

@FunctionalInterface
public interface Parserable <T> {
    T parse(String line);
}
