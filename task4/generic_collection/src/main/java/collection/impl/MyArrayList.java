package collection.impl;

import collection.MyList;

import java.util.Arrays;

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

    public int size(){
        return size;
    }

    @Override
    public int add(T element) {
        add(element, elements, size);
        return 0;
    }

    private void add(T element, Object elements[], int size){
        if(size == elements.length){
            elements = grow(size + 1);
        }
        elements[size++] = element;
        this.size = size;
        this.elements = elements;
    }

    private Object[] grow(int minCapacity){
        return Arrays.copyOf(elements, newCapacity(minCapacity));
    }

    private int newCapacity(int oldCapacity){
        return (oldCapacity * 3) / 2 + 1;
    }


    @Override
    public void remove(int index) {

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + (size > 0 ? elements[0].toString() : ""));
        for(int i = 1; i < size; i++){
            str.append(", " + elements[i].toString());
        }
        str.append("]");
        return str.toString();
    }
}
