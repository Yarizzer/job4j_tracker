package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int lLen = left.length();
        int rLen = right.length();
        if (lLen != rLen) {
            rsl = lLen < rLen ? -1 : 1;
        } else {
            for (int i = 0; i < lLen; i++) {
                int comp = Character.compare(left.charAt(i), right.charAt(i));
                if (comp != 0) {
                    rsl = comp;
                    break;
                }
            }
        }
        return rsl;
    }
}
