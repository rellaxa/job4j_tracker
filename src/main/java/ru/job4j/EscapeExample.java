package ru.job4j;

public class EscapeExample {
    public static void main(String[] args) {
        String s = "Я изучаю на \"Job4j\" экранирование символов.";
        System.out.println(s);

        char escape = '\"';
        System.out.println(escape);

        System.out.println('\'');

        String string = "Я изучаю на 'Job4j' экранирование символов";
        System.out.println(string);

        string = "C:\\projects\\job4j\\File.java";
        System.out.println(string);

        System.out.print("Старый длинный текст\r");
        System.out.println("Новый текст");

        System.out.print("Первая строка\nВторая строка");

        System.out.println("Без отступа");
        System.out.println("\tОдин отступ");
        System.out.println("\t\tДва отступа");

        System.out.println("Job4jjj\b\b");
    }
}
