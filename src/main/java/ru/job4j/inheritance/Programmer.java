package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, String birthday, int practiceExp, String lang) {
        super(name, surname, education, birthday, practiceExp);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
