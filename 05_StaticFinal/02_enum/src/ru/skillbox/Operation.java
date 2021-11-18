package ru.skillbox;

public enum Operation {
    ADD("Сложение"), SUBTRACT("Вычитание"), MULTIPLY("Умножение");

    private final String title;

    Operation(String title) { //Приватный конструктор
        this.title = title;
    }

    public String toString() {
        return "Операция: " + title;
    }
}