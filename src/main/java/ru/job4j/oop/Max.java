package ru.job4j.oop;

public class Max {
    public int max(int left, int right) {
        return left > right ? left : right;
    }

    public int max(int first, int second, int third) {
        return first > second ? max(first, third) : max(second, third);
    }

    public int max(int first, int second, int third, int fourth) {
        return first > second ? max(first, third, fourth) : max(second, third, fourth);
    }
}
