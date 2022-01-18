package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Road only");
    }

    @Override
    public void stop() {
        System.out.println("On the bus stop");
    }
}
