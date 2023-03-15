package ru.task3.repository.impl;

import ru.task3.model.base.Figure;
import ru.task3.repository.FigureCollections;

import java.util.HashMap;
import java.util.Optional;

public class FigureCollectionsImpl implements FigureCollections {
    private static HashMap<Integer, Figure> figureCollection = new HashMap<>();
    private static FigureCollectionsImpl instance;

    private FigureCollectionsImpl(){}

    public static FigureCollectionsImpl getInstance() {
        if (instance == null) {
            instance = new FigureCollectionsImpl();
        }
        return instance;
    }

    @Override
    public int add(Figure figure) {
        int id;
        if (this.figureCollection.isEmpty()){
            id = 0;
        }else {
            id = this.figureCollection.entrySet().stream()
                    .max((animal1, animal2) -> animal1.getKey() - animal2.getKey())
                    .get()
                    .getKey();
        }

        this.figureCollection.put(id + 1 , figure);

        return id + 1;
    }

    @Override
    public void update(int id, Figure updatedFigure) {
        this.figureCollection.put(id , updatedFigure);
    }

    @Override
    public Optional<Figure> findById(int id) {
        if (this.figureCollection.isEmpty()){
            return Optional.empty();
        }else {
            var figure = this.figureCollection.get(id);

            return Optional.ofNullable(figure);
        }
    }

    @Override
    public void deleteById(int id) {
        if (!this.figureCollection.isEmpty()){
            this.figureCollection.remove(id);
        }
    }

    @Override
    public Optional<HashMap<Integer, Figure>> findAll() {
        if (this.figureCollection.isEmpty()){
            return Optional.empty();
        }

        return Optional.ofNullable(this.figureCollection);
    }
}
