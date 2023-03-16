package collection;

public interface MyList<T> {
    int add(T t);
    T get(int index);
    T remove(int index);
}
