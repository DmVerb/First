package ru.skillbox;

public class Ram {
    private int volume;
    public static int weight;
    public RamType ramType;

    public Ram(RamType ramType, int volume, int weight) {
        this.volume = volume;
        this.weight = weight;
        this.ramType = ramType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public static void setWeight(int weight) {
        Ram.weight = weight;
    }

    public RamType getRamType() {
        return ramType;
    }

    public void setRamType(RamType ramType) {
        this.ramType = ramType;
    }

    public static int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "объем " + volume +
                ", тип " + ramType;
    }
}
