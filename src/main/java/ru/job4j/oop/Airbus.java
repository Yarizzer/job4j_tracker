package ru.job4j.oop;

public class Airbus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Air only");
    }

    @Override
    public void stop() {
        System.out.println("On the airports");
    }
}
