package ru.sftr.SoftwareTesting.Sandbox;

public class HelloWorldEdited {

    public static void main(String[] args) {

        hello("Alex");
        hello("world");

        Square square = new Square(1.2);
        Rectangle rectangle = new Rectangle(2, 3);

        System.out.println("Площадь квадрата со стороной " + square.length + " равна " + area(square));
        System.out.println("Площадь прямоугольника со стороной а = " + rectangle.lengthA + " и b = " + rectangle.lengthB + " равна " + area(rectangle));
    }

    public static void hello(String name) {
        System.out.println("Hello" + ' ' + name + "!");
    }

    public static double area(Square a) {
        double areaSquare = a.length * a.length;
        return areaSquare;
    }

    public static double area(Rectangle r) {
        double areaRectangle = r.lengthA * r.lengthB;
        return areaRectangle;
    }


}