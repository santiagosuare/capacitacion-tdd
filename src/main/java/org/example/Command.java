package org.example;

public enum Command {
    FORWARD("F"),
    BACKWARD("B"),
    LEFT("L"),
    RIGHT("R");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
