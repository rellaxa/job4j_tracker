package ru.job4j.varargs;

public class VarArgs {
    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String text(int x, int y, String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String text(int x, int y, Object... objects) {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) {
            builder.append(object);
        }
        return builder + " Количество соединенных элементов: " + objects.length;
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static String text(String string) {
        return string;
    }

    public static void main(String[] args) {
        System.out.println(text());
        System.out.println(text("aaa"));
        System.out.println(text("aaa", "bbb", "ccc"));
        System.out.println(text("aaa", "bbb", "ccc", "ddd", "eee"));
        System.out.println(text(1, 2, "Here ", "we ", "go ", "again"));
        System.out.println(text(3, 4, 5, 6, 7, 8, 9));
        System.out.println(text(30, "aaa", "bbb"));
        System.out.println(text("aaa"));
    }
}