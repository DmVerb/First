package ru.skillbox;

public class Computer {
Cpu cpuType;
    public final Ram ramType;
    public final HDD hdd;
    public final Screen screenType;
    public final Keyboard keyboardType;
    public final String vendor;
    public final String name;
    public static int totalWeight = 0;

    public Computer(Cpu cpuType, Ram ramType, HDD hdd, Screen screenType, Keyboard keyboardType, String vendor, String name) {
        this.cpuType = cpuType;
        this.ramType = ramType;
        this.hdd = hdd;
        this.screenType = screenType;
        this.keyboardType = keyboardType;
        this.vendor = vendor;
        this.name = name;
    }

    public Cpu getCpuType() {
        return cpuType;
    }

    public Ram getRamType() {
        return ramType;
    }

    public HDD getStorageDeviceType() {
        return hdd;
    }

    public Screen getScreenType() {
        return screenType;
    }

    public Keyboard getKeyboardType() {
        return keyboardType;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public static void setTotalWeight(int totalWeight) {
        Computer.totalWeight = totalWeight;
    }

    public static int getTotalWeight(){
        return totalWeight = Cpu.getWeight()+Ram.getWeight()+ HDD.getWeight()+Screen.getWeight()+Keyboard.getWeight();

    }

    @Override
    public String toString() {
        return  "Компьютер:      "+ name +'\n'+'\n'+
                " Производитель: " + vendor + '\n' +
                " Процессор:     " + cpuType +'\n'+
                " Память:        " + ramType +'\n'+
                " Жесткий диск:  " + hdd +'\n'+
                " Дисплей:       " + screenType +'\n'+
                " Клавиатура:    " + keyboardType +'\n';
    }
}
