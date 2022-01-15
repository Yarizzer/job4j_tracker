package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean canHealHeart;

    public Surgeon(String name, String surname, String education, String birthday, String qualification, boolean canHealHeart) {
        super(name, surname, education, birthday, qualification);
        this.canHealHeart = canHealHeart;
    }

    public boolean canChangePacemaker() {
        return canHealHeart;
    }
}
