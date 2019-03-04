package ru.sftr.SoftwareTesting.Sandbox;

public class Point {
    public double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }



    public double distance(Point p2){

        double distance = Math.sqrt(((p2.x - this.x)*(p2.x - this.x)) + ((p2.y - this.y)*(p2.y - this.y)));
        return distance;
    }

}
