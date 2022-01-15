package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean isElectrician;

    public Builder(String name, String surname, String education, String birthday, int practiceExp, String lang, boolean isElectrician) {
        super(name, surname, education, birthday, practiceExp);
        this.isElectrician = isElectrician;
    }

    public boolean workWithVoltage() {
        return isElectrician;
    }
}
