package ru.job4j.pattern;

import java.util.Scanner;

public class Canvas {

    private ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.print("Какую фигуру вы хотите построить: ");
        String ans = input.nextLine();
        if ("прямоугльник".equals(ans)) {
            operator = new RectangleOperator();
        } else {
            operator = new TriangleOperator();
        }
        Canvas canvas = new Canvas(operator);
        canvas.demonstrate();
    }
}