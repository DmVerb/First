package ru.skillbox;

public class Cargo {
    private final Dimensions size;
    private final int weight;
    private final String address;
    private final boolean notFlip;
    private final String registrationNumber;
    private final boolean fragile;

    public Cargo(Dimensions size, int weight, String address,
                 boolean notFlip, String registrationNumber, boolean fragile) {
        this.size = size;
        this.weight = weight;
        this.address = address;
        this.notFlip = notFlip;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public Cargo setSize(Dimensions size) {
        return new Cargo(size, weight,
                address, notFlip, registrationNumber, fragile);
    }

    public Dimensions getSize() {
        return size;
    }

    public Cargo setWeight(int weight) {
        return new Cargo(size, weight,
                address, notFlip, registrationNumber, fragile);
    }

    public int getWeight() {
        return weight;
    }

    public Cargo setAddress(String address) {
        return new Cargo(size, weight,
                address, notFlip, registrationNumber, fragile);
    }

    public String getAddress() {
        return address;
    }

    public boolean isNotFlip() {
        return notFlip;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public String toString() {
        return "Cargo{" +
                "размер =" + size +
                ", масса =" + weight +
                ", адрес ='" + address + '\'' +
                ", переворачивать =" + notFlip +
                ", регистрационный номер='" + registrationNumber + '\'' +
                ", хрупкое=" + fragile +
                '}';
    }
}
