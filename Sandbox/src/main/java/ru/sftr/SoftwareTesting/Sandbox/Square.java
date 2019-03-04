package ru.sftr.SoftwareTesting.Sandbox;

public class Square {
    public double length;

    public Square(double length) {
        this.length = length;
    }


    public double area() {
        double areaSquare = this.length * this.length;
        return areaSquare;
    }
}
