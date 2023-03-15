package ru.task3.repository;

import ru.task3.model.base.Figure;

import java.util.HashMap;
import java.util.Optional;

public interface FigureCollections {
    int add(Figure figure);
    Optional<Figure> findById(int id);
    void deleteById(int id);
    Optional<HashMap<Integer, Figure>> findAll();
    void update(int id, Figure updatedFigure);
}
