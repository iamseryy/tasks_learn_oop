package repository.impl;

import config.AppConfig;
import model.Position;
import repository.Positions;
import utils.FileUtils;

import java.util.*;

public class PositionsImpl implements Positions {
    private static Optional<HashSet<Position>> positions = initCollection();

    private static PositionsImpl instance;

    private PositionsImpl(){}

    public static PositionsImpl getInstance() {
        if (instance == null) {
            instance = new PositionsImpl();
        }
        return instance;
    }

    @Override
    public int add(Object entity) {
        return 0;
    }

    @Override
    public Optional<Position> findById(int id) {
        if (this.positions.isEmpty()){
            return Optional.empty();
        }

        return this.positions.get().stream().filter(position -> position.id() == id).findAny();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<HashSet<Position>> findAll() {
        return this.positions;
    }

    private static Optional<HashSet<Position>> initCollection() {
        HashSet<Position> positions = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.positions"));

        if (data.isEmpty()){
            return Optional.empty();
        }

        for (String line: data) {
            String[] values = line.split(";");
            positions.add(new Position(Integer.parseInt(values[0]), values[1]));
        }

        return Optional.ofNullable(positions);
    }
}
