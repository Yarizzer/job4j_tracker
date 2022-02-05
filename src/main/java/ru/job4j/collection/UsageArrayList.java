package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arList = new ArrayList<>();
        arList.add("Petr");
        arList.add("Ivan");
        arList.add("Stepan");

        arList.forEach((name) -> System.out.println(name));
    }
}
