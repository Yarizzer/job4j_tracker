package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
//        - метод split() класса String - необходим для того, чтобы отделить часть строки, которая будет содержать номер задачи;
//        - метод Integer.parseInt() - позволит преобразовать строку, содержащее номер задачи в число типа Integer;
//        - метод Integer.compare() - позволит корректно сравнить номера задач.

//        String[] lNum = left.split(". ")[0].split(".");
//        String[] rNum = right.split(". ")[0].split(".");

        String lNum = left.split(". ")[0];

        System.out.println(left);
//        for (String s : lNum) {
//            System.out.println(s);
//        }
        //System.out.println(lNum);


        return left.compareTo(right);
    }

    public static void main(String[] args) {
        LexSort obj = new LexSort();
        String[] in = {
                "Task.",
                "1. Task.",
                "2. Task.",
                "3. Task"
        };
//        String[] out = {
//                "1. Task.",
//                "2. Task.",
//                "10. Task."
//        };
        Arrays.sort(in, obj);
    }
}
