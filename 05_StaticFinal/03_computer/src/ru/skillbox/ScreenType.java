package ru.skillbox;

public enum ScreenType {
    IPS("IPS"), TN("TN"), VA("VA");

    private final String tittle;

    ScreenType(String tittle) {
        this.tittle = tittle;
    }

    public String toString() {
        return tittle ;
    }
}
