package ru.job4j.lambda;

import java.util.Comparator;

public class AttachmentComp {
    public static Comparator main() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
    }
}
