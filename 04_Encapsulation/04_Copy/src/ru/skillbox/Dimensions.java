package ru.skillbox;

public class Dimensions {
    private final int width;
    private final int height;
    private final int length;
    int volume;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getVolume(){
        volume = (width*height*length);
        return volume;
    }


}
