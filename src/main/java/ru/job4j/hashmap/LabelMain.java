package ru.job4j.hashmap;

public class LabelMain {
    public static void main(String[] args) {
        Label label1 = new Label("Метка 1", 4.5);
        Label label2 = new Label("Метка 2", 2);
        System.out.println(label1.compareTo(label2));
    }
}
