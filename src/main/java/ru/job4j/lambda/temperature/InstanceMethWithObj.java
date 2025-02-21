package ru.job4j.lambda.temperature;

public class InstanceMethWithObj {
    static <T> int counter(T[] vales, MyFunc<T> f, T v) {
        int count = 0;
        for (T vale : vales) {
            if (f.func(vale, v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83)
        };
        int count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Количество суток, когда самая высокая темпратура была 89 градусов: " + count);

        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(90));
        System.out.println("Количество суток, когда самая высокая темпратура была меньше 90 градусов: " + count);
    }
}

