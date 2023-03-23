package model;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    HIRED("HIRED"),
    FIRED("FIRED");


    private static final Map<String, Status> BY_DESCRIPTION = new HashMap<>();

    static {
        for (Status e : values()) {
            BY_DESCRIPTION.put(e.description, e);
        }
    }

    private final String description;

    Status(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static Status valueOfDescription(String description) {
        return BY_DESCRIPTION.get(description);
    }

}
