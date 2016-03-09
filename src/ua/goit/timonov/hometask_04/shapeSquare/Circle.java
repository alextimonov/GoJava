package ua.goit.timonov.hometask_04.shapeSquare;

import java.util.List;

/**
 * Class provides implementation of Circle by two points: center and any point on the circle
 * finds circles square
 */
public class Circle extends Shape {
    public static final int CIRCLE_NUMBER_POINTS = 2;

    /**
     * Constructs circle by list of two points
     * @param pointList     list of points (one is the center, other - a point on a circle),
     *                      each point is object of class Point
     */
    public Circle(List<Point> pointList) {
        super(pointList);
        checkPointList(CIRCLE_NUMBER_POINTS);
    }

    /**
     * Finds the square of circle by coordinates of center point and point  on a circle
     * @return      square of circle
     */
    @Override
    public double findSquare() {
        double radius = pointList.get(0).findDistance(pointList.get(1));
        return Math.PI * Math.pow(radius, 2);
    }
}
