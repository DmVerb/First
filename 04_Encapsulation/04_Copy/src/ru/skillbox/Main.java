package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(5,5,5);
        Dimensions dimensions1 = new Dimensions(6,6,6);
        Cargo cargo = new Cargo(dimensions,5,"sdf",true,"fv",false);
        Cargo cargo1 = new Cargo(dimensions1,6,"147",true,"fv",false);
        Cargo cargo2 = new Cargo(dimensions,8,"285",true,"fv",false);
        System.out.println(cargo);
        System.out.println(cargo1);
        System.out.println(cargo2);
        cargo = cargo.setAddress("Moscow");
        cargo1 = cargo1.setAddress("Dmitrov");
        cargo2 = cargo2.setAddress("Klin");
        cargo = cargo.setWeight(10);
        cargo1 = cargo1.setWeight(15);
        cargo2 = cargo2.setWeight(200);
        Dimensions dimensions3 = new Dimensions(7,7,7);
        cargo2 = cargo2.setSize(dimensions3);
        System.out.println(cargo);
        System.out.println(cargo1);
        System.out.println(cargo2);

    }
}
