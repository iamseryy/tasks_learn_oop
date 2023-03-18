package collection;

import java.util.Comparator;
import java.util.Optional;


public interface MyList<T> {
    boolean add(T object);
    boolean add(int index, T object);
    Optional<T> get(int index);
    Optional<T> remove(int index);
    boolean remove(T object);
    int size();
    Optional<T> min(Comparator<T> comparator);
    Optional<T> max(Comparator<T> comparator);
    Optional<T> sum(ToNumberFunction<? super T> mapper);
    Optional<T> product(ToNumberFunction<? super T> mapper);
    int indexOf(T object);
    boolean contains(T object);
    void sortBubble(Comparator<T> comparator);
    void sortInsertion(Comparator<T> comparator);
    void sortSelection(Comparator<T> comparator);
    Optional<T> set(int index, T object);








}
