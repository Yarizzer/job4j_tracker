package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        int rnd = new Random().nextInt(3);
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        if (rnd == 0) {
            System.out.println(name + " - Yep");
        } else if (rnd == 1) {
            System.out.println(name + " - Nope");
        } else {
            System.out.println(name + " - Perhaps");
        }
    }
}
