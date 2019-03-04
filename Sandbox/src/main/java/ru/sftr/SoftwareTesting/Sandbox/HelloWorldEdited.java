package ru.sftr.SoftwareTesting.Sandbox;

public class HelloWorldEdited {

    public static void main(String[] args) {

        hello("Alex");
        hello("world");
        double l = 1.2;
        double a = 2, b = 3;
        System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));
        System.out.println("Площадь прямоугольника со стороной а = " + a + " и b = " + b + " равна " + area(a, b))
        ;
    }

    public static void hello(String name) {
        System.out.println("Hello" + ' ' + name + "!");
    }

    public static double area(double len) {
        double areaSquare = len * len;
        return areaSquare;
    }

    public static double area(double a, double b){
        double areaRectangle = a * b;
        return areaRectangle;
    }


}