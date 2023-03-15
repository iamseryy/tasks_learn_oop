package ru.task3.service;

import ru.task3.model.base.Figure;
import ru.task3.repository.FigureCollections;

import java.util.HashMap;
import java.util.Optional;

public interface FigureService {
    void addFigure(Optional<Figure> figure);
    void getAllFiguresPerimeters();
    void getAllFiguresAreas();
    void getAllFiguresCircumferences();
    void updateFigure();
    void removeFigure();
    void printAllFigures();
    void printFigure();
    void printAllFiguresSortedByArea();
}
