package ru.task6.model;

public record Phone(int personId, String phone, PhoneNumberType type) {
    @Override
    public String toString() {
        return  personId + ";" +
                phone + ';' +
                type.getDescription();
    }
}
