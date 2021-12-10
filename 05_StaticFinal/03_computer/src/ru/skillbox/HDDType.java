package ru.skillbox;

public enum HDDType {
    HDD("HDD"), SSD("SSD");

    private final String title;

    HDDType(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}
