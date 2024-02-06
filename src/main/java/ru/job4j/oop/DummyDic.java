package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic amI = new DummyDic();
        String word = "mindfulness";
        System.out.println(amI.engToRus(word));
    }
}