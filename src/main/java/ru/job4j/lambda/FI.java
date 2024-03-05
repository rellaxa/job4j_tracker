package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Arrays.sort(attachments, comparator);
    }
}
