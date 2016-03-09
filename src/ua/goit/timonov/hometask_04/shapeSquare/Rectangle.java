package ua.goit.timonov.hometask_04.shapeSquare;

import java.util.List;

/**
 * Class provides implementation of Rectangle by two points,
 * finds rectangle's square by coordinates of two opposite points of rectangle
 */
public class Rectangle extends Shape {
    public static final int RECTANGLE_NUMBER_POINTS = 2;

    /**
     * Constructs rectangle by list of two points
     * @param pointList     list of points, each point is object of class Point
     */
    public Rectangle(List<Point> pointList) {
        super(pointList);
        checkPointList(RECTANGLE_NUMBER_POINTS);
    }

    /**
     * Finds the square of rectangle by coordinates of two opposite points of rectangle
     * @return      square of rectangle
     */
    @Override
    public double findSquare() {
        double dx = Math.abs(pointList.get(0).getX() -  pointList.get(1).getX());
        double dy = Math.abs(pointList.get(0).getY() -  pointList.get(1).getY());
        return dx * dy;
    }
}
