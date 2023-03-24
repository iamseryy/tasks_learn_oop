package ru.task6.model;

import java.util.HashMap;
import java.util.Map;

public enum PhoneNumberType {
    HOME("HOME"),
    WORK("WORK"),
    MOBILE("MOBILE");

    private static final Map<String, PhoneNumberType> BY_DESCRIPTION = new HashMap<>();

    static {
        for (PhoneNumberType e : values()) {
            BY_DESCRIPTION.put(e.description, e);
        }
    }

    private final String description;

    PhoneNumberType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static PhoneNumberType valueOfDescription(String description) {
        return BY_DESCRIPTION.get(description);
    }
}
