package ru.skillbox;

public class Cpu {
    private int rate;
    private int core;
    private static int weight;
    private ManufacturerCPU manufacturerCPU;

    public Cpu(int rate, int core, ManufacturerCPU manufacturerCPU, int weight) {
        this.rate = rate;
        this.core = core;
        this.manufacturerCPU = manufacturerCPU;
        this.weight = weight;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void setManufactureCPU(ManufacturerCPU manufacturerCPU) {
        this.manufacturerCPU = manufacturerCPU;
    }
    public ManufacturerCPU getManufacturerCPU() {return manufacturerCPU;}

    public static void setWeight(int weight) {
        Cpu.weight = weight;
    }

    public static int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "частота " + rate +
                ", ядро " + core +
                ", производитель " + manufacturerCPU;
    }
}

