package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator summa = new ArithmeticCalculator(5,6);
        summa.calculate(Operation.SUBTRACT);
        System.out.println(Operation.SUBTRACT);
    }
}
