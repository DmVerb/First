package ru.skillbox;

public class Car {
    String mark;
    String name;
    int horsepower;
    int torque;

    public Car(String mark, String name,int horsepower){
        this.mark= mark;
        this.name = name;
        this.horsepower = horsepower;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }
}
