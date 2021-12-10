package ru.skillbox;

public enum KeyboardType {
    MECHANIKAL("механическая"), FLEXIBlE("гибкая"), MEMBRANE("мембранная"), SCISSOR("ножничная"), OTICAL("оптическая"), SEMI_MECHANICAL("полумеханическая");

    private final String type;

    KeyboardType (String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
