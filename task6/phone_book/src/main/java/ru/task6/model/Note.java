package ru.task6.model;

public record Note(int personId, String note) {
    @Override
    public String toString() {
        return  personId + ";" +
                note;
    }
}
