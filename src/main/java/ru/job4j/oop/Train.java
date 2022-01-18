package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Rails only");
    }

    @Override
    public void stop() {
        System.out.println("On the stations");
    }
}
