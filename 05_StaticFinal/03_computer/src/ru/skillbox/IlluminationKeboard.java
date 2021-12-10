package ru.skillbox;

public enum IlluminationKeboard {
    YES("есть"), NO("нет");

    private final String title;

    IlluminationKeboard(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

}
