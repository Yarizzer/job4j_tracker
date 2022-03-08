package ru.job4j.function;

import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());
    }
}
