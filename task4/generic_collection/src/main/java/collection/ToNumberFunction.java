package collection;


@FunctionalInterface
public interface ToNumberFunction <T>{
    Number applyAsNumber(T value);
}
