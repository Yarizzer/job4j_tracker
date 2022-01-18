package ru.job4j.pojo;

public class Bus implements Transport {
    private int passangers;

    @Override
    public void drive() {
        System.out.println("Wroom - wroom");
    }

    @Override
    public void setPassangers(int count) {
        this.passangers = count;
    }

    @Override
    public int priceFor(int gasAmount) {
        return gasAmount * 45;
    }
}
