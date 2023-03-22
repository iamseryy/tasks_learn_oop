package service.impl;


import model.Position;
import repository.impl.PositionsImpl;
import service.PositionService;
import repository.Positions;

import java.util.HashSet;
import java.util.Optional;

public class PositionServiceImpl implements PositionService {
    private static Positions positions = PositionsImpl.getInstance();

    @Override
    public int addPosition(Position position) {
        return 0;
    }

    @Override
    public boolean removePositionById(int id) {
        return false;
    }

    @Override
    public boolean updatePosition(int id) {
        return false;
    }

    @Override
    public Optional<Position> findPositionById(int id) {
        return positions.findById(id);
    }

    public Optional<HashSet<Position>> findAllPosition() {
        return positions.findAll();
    }
}
