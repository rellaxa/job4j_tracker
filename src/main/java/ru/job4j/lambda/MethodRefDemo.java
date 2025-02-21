package ru.job4j.lambda;

public class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Иcxoднaя строка: " + inStr);
        System.out.println("Cтpoкa с противоположным порядком следования символов:  " + outStr);
    }
}
