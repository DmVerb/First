package ru.skillbox;

public enum ManufacturerCPU {
    AMD("AMD"), INTEL("INTEL");

    private final String title;

    ManufacturerCPU(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

