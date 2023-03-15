package ru.task3.view.inputcard;

import ru.task3.model.base.Figure;

import java.util.Optional;

public interface EntityCard {
    Optional<Figure> get(String header);
}
