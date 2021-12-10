package ru.skillbox;

public enum RamType {
    SDRAM("SDRAM"), DDR_SDRAM("DDR_SDRAM"), DDR2_SDRAM("DDR2_SDRAM"), DDR3_SDRAM("DDR3_SDRAM"), RIMM("RIMM");

    private final String tittle;

    RamType(String tittle) {
        this.tittle = tittle;
    }

    public String toString() {
        return tittle;
    }
}
