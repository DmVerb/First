package ru.skillbox;

public class Keyboard {
    private static int weight;
    public IlluminationKeboard light;
    KeyboardType keyboardType;

    public Keyboard(int weight, IlluminationKeboard light, KeyboardType keyboardType) {
        this.weight = weight;
        this.light = light;
        this.keyboardType = keyboardType;
    }


    public static void setWeight(int weight) {
        Keyboard.weight = weight;
    }

    public void setLight(IlluminationKeboard light) {
        this.light = light;
    }

    public IlluminationKeboard getLight() {
        return light;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(KeyboardType keyboardType) {
        this.keyboardType = keyboardType;
    }

    public static int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "тип " + keyboardType +
                ", подсветка " + light;
    }
}
