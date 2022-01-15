package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int id;

    public Dentist(String name, String surname, String education, String birthday, String qualification, int id) {
        super(name, surname, education, birthday, qualification);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
