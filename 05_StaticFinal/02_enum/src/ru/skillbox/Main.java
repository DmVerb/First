package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator summa = new ArithmeticCalculator(5,6);
        summa.calculate(Operation.ADD);
        System.out.println(Operation.ADD);
    }
}
