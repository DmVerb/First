package ru.skillbox;

public class HDD {
    private int volume;
    public static int weight;
    private HDDType HDDType;

    public HDD(HDDType HDDType, int volume, int weight) {
        this.volume = volume;
        this.weight = weight;
        this.HDDType = HDDType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public static void setWeight(int weight) {
        HDD.weight = weight;
    }

    public HDDType getHDDType() {
        return HDDType;
    }

    public void setHDDType(HDDType HDDType) {
        this.HDDType = HDDType;
    }

    public static int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "объем " + volume +
                ", тип " + HDDType ;
    }
}
