package ru.job4j.pattern.factory;

public class ConstructorRef {
    static <R, T> R myClassFactory(MyFunc<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc<MyClass<Double>, Double> myClassCons = MyClass::new;
        MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("val в mc равно " + mc.getVal());

        MyFunc<MyClass2, String> myClassStr = MyClass2::new;
        MyClass2 mcStr = myClassFactory(myClassStr, "Lambda");
        System.out.println("str в mcStr равно " + mcStr.getStr());
    }
}
