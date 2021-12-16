package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Keyboard key = new Keyboard(500, IlluminationKeboard.YES, KeyboardType.FLEXIBlE);
        Screen sdv = new Screen(15, ScreenType.TN, 500);
        Ram ram1 = new Ram(RamType.DDR2_SDRAM, 128, 500);
        HDD Storage1 = new HDD(HDDType.SSD, 500, 500);
        Cpu cpu1 = new Cpu(2800, 2, ManufacturerCPU.AMD, 1200);
        Computer comp1 = new Computer(cpu1, ram1, Storage1, sdv, key, "Я", "First");
        System.out.println(Computer.getTotalWeight());
        System.out.println(comp1);
    }
}
