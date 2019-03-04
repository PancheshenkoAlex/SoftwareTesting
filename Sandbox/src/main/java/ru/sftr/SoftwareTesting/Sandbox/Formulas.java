package ru.sftr.SoftwareTesting.Sandbox;

public class Formulas {

    public static void main(String[] args) {

       /* Square square = new Square(1.2);
        Rectangle rectangle = new Rectangle(2, 3);*/

        Point point_1 = new Point(1.1, 2.2);
        Point point_2 = new Point(2.2, 1.1);


        /*System.out.println("Площадь квадрата со стороной " + square.length + " равна " + square.area());
        System.out.println("Площадь прямоугольника со стороной а = " + rectangle.lengthA + " и b = " + rectangle.lengthB + " равна " + rectangle.area());*/

        System.out.println("ФУНКЦИЯ: Расстояние между двумя точками равно " + distance(point_1, point_2));
        System.out.println("МЕТОД: Расстояние между двумя точками равно " + point_1.distance(point_2));
    }

    public static double distance(Point p1, Point p2) {
        double distance = Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
        return distance;
    }
}