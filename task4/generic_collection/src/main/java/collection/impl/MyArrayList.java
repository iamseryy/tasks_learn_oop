package collection.impl;

import collection.MyList;
import collection.ToNumberFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public MyArrayList(T[] array){
        if (array == null){
            size = 0;
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            size = array.length;
            elements = Arrays.copyOf(array, this.size);
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        if(size == elements.length){
            elements = grow(size + 1);
        }
        elements[size++] = element;
        size = size;
        elements = elements;

        return true;
    }

    @Override
    public boolean add(int index, T t) {
        if(index < 0) return false;

        if(size + 1 >= elements.length){
            elements = grow(size + 1);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = t;
        size++;

        return true;
    }

    private Object[] grow(int minCapacity){
        return Arrays.copyOf(elements, newCapacity(minCapacity));
    }

    private int newCapacity(int oldCapacity){
        return (oldCapacity * 3) / 2 + 1;
    }

    @Override
    public Optional<T> get(int index) {
        if (index >= 0 && index < size) {
            return Optional.ofNullable((T) elements[index]);
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(int index) {
        if (index >= 0 && index < size) {
            Object obj = get(index);
            shiftToLeft(index);
            return Optional.ofNullable((T) obj);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(T t) {
        if (size == 0) return false;

        boolean removingSuccessful = false;
        for (int i = 0; i < size; i++){
            if ((elements[i] != null && elements[i].equals(t) || (elements[i] == null && t == null))){
                shiftToLeft(i);
                removingSuccessful = true;
            }
        }

        return removingSuccessful;
    }

    private void shiftToLeft(int indexStart) {
        size--;
        if (size <= 0) {
            return;
        }

        if (size != indexStart) {
            System.arraycopy(elements, indexStart + 1, elements, indexStart, size - indexStart);
        }

        elements[size] = null;
    }

    @Override
    public Optional<T> min(Comparator<T> comparator) {
        if (size == 0) return Optional.empty();

        int indexMin = 0;
        for(int i = 0; i < size - 1; i++){
            if(comparator.compare((T) elements[i], (T) elements[i + 1]) > 0){
                indexMin = i;
            }
        }
        return Optional.ofNullable((T) elements[indexMin]);
    }

    @Override
    public Optional<T> max(Comparator<T> comparator) {
        if (size == 0) return Optional.empty();

        int indexMax = 0;
        for(int i = 0; i < size - 1; i++){
            if(comparator.compare((T) elements[i + 1], (T) elements[i]) > 0){
                indexMax = i + 1;
            }
        }
        return Optional.ofNullable((T) elements[indexMax]);
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public int indexOf(Object object) {
        return indexOfRange(object, 0, size);
    }

    private int indexOfRange(Object object, int start, int end) {
        Object[] es = elements;
        if (object == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (object.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void sortBubble(Comparator<T> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                if(comparator.compare((T) elements[j], (T) elements[j + 1]) > 0) {
                    Object swap = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = swap;
                }
            }
        }
    }

    @Override
    public void sortInsertion(Comparator<T> comparator) {
        for (int i = 1; i < size; i++){
            Object value = elements[i];
            int j = i;
            while (j > 0 && comparator.compare((T) elements[j - 1], (T) value) > 0){
                elements[j] = elements[j - 1];
                j--;
            }
            elements[j] = value;
        }
    }

    @Override
    public void sortSelection(Comparator<T> comparator) {
        for (int i = 0; i < size; i++) {
            int pos = i;
            Object min = elements[i];
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare((T) elements[j], (T) min) < 0) {
                    pos = j;
                    min = elements[j];
                }
            }
            elements[pos] = elements[i];
            elements[i] = min;
        }
    }

    @Override
    public Optional<T> set(int index, T element) {
        if ((index < size) && (index >= 0)) {
            Object oldElement = elements[index];
            elements[index] = element;
            return Optional.ofNullable((T) oldElement);
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> sum(ToNumberFunction<? super T> mapper) {
        if (size == 0) return Optional.empty();

        if(mapper.applyAsNumber((T) elements[0]) instanceof Byte){
            long sum = 0;
            for (int i = 0; i < size; i++) sum += (Byte) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if(mapper.applyAsNumber((T) elements[0]) instanceof Short){
            long sum = 0;
            for (int i = 0; i < size; i++) sum += (Short) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Integer){
            long sum = 0;
            for (int i = 0; i < size; i++) sum += (Integer) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Long){
            long sum = 0;
            for (int i = 0; i < size; i++) sum += (Long) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Float){
            double sum = 0;
            for (int i = 0; i < size; i++) sum += (Float) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Double){
            double sum = 0;
            for (int i = 0; i < size; i++) sum += (Double) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        return Optional.empty();
    }

    @Override
    public Optional<T> product(ToNumberFunction<? super T> mapper) {
        if (size == 0) return Optional.empty();

        if(mapper.applyAsNumber((T) elements[0]) instanceof Byte){
            long sum = 1;
            for (int i = 0; i < size; i++) sum *= (Byte) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if(mapper.applyAsNumber((T) elements[0]) instanceof Short){
            long sum = 1;
            for (int i = 0; i < size; i++) sum *= (Short) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Integer){
            long sum = 1;
            for (int i = 0; i < size; i++) sum *= (Integer) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Long){
            long sum = 1;
            for (int i = 0; i < size; i++) sum *= (Long) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Float){
            double sum = 1;
            for (int i = 0; i < size; i++) sum *= (Float) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        else if (mapper.applyAsNumber((T) elements[0]) instanceof Double){
            double sum = 1;
            for (int i = 0; i < size; i++) sum *= (Double) (mapper.applyAsNumber((T) elements[i]));
            return (Optional<T>) Optional.ofNullable(sum);
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + (size > 0 ? elements[0].toString() : ""));
        for(int i = 1; i < size; i++){
            str.append(", " + (elements[i] != null ? elements[i].toString() : "null"));
        }
        str.append("]");
        return str.toString();
    }
}
