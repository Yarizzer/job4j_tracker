package ru.job4j.pojo;

public interface Transport {
    void drive();

    void setPassangers(int count);

    int priceFor(int gasAmount);
}
