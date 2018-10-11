package main.it.sevenbits;

public class Interval {
    private double segment;

    public Interval(Point PointOne, Point PointTwo) {
        double x = Math.pow(Math.abs(PointOne.GetX() - PointTwo.GetX()), 2);
        double y = Math.pow(Math.abs(PointOne.GetY() - PointTwo.GetY()), 2);
        segment = Math.sqrt(x + y);
    }

    public double getSegment() {
        return segment;
    }
}
