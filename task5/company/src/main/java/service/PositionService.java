package service;

import model.Position;

import java.util.HashSet;
import java.util.Optional;


public interface PositionService {
    int addPosition(Position position);
    boolean removePositionById(int id);
    boolean updatePosition(int id);
    Optional<Position> findPositionById(int id);
    public Optional<HashSet<Position>> findAllPosition();
}
