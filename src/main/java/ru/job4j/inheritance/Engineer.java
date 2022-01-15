package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int practiceExp;

    public Engineer(String name, String surname, String education, String birthday, int practiceExp) {
        super(name, surname, education, birthday);
        this.practiceExp = practiceExp;
    }
}
