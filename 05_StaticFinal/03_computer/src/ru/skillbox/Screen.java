package ru.skillbox;

public class Screen {
    private int diagonal;
    private static int weight;
    public ScreenType screenType;

    public Screen(int diagonal, ScreenType screenType, int weight) {
        this.diagonal = diagonal;
        this.weight = weight;
        this.screenType = screenType;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public static void setWeight(int weight) {
        Screen.weight = weight;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public static int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "диагональ " + diagonal +
                ", тип матрицы " + screenType;
    }
}
