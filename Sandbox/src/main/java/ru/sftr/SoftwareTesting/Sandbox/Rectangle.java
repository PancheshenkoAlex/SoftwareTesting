package ru.sftr.SoftwareTesting.Sandbox;

public class Rectangle {
    public double lengthA, lengthB;

    public Rectangle(double a, double b) {
        this.lengthA = a;
        this.lengthB = b;
    }

    public double area() {
        double areaRectangle = this.lengthA * this.lengthB;
        return areaRectangle;
    }

}
