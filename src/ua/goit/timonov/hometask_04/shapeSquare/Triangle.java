package ua.goit.timonov.hometask_04.shapeSquare;

import java.util.List;

/**
 * Class provides implementation of Triangle by tree points,
 * finds triangle's square by coordinates of three points.
 */
public class Triangle extends Shape {
    public static final int TRIANGLE_NUMBER_POINTS = 3;

    /**
     * Constructs triangle by list of three points
     * @param pointList     list of points, each point is object of class Point
     */
    public Triangle(List<Point> pointList) {
        super(pointList);
        checkPointList(TRIANGLE_NUMBER_POINTS);
    }

    /**
     * Finds the square of triangle by coordinates of tree points of triangle
     * @return      square of triangle
     * @throws      IllegalStateException if triangle has less than three points
     */
    @Override
    public double findSquare() {
        try {
            double sideAB = pointList.get(0).findDistance(pointList.get(1));
            double sideBC = pointList.get(1).findDistance(pointList.get(2));
            double sideAC = pointList.get(0).findDistance(pointList.get(2));
            double p = (sideAB + sideBC + sideAC) / 2;
            return Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideAC));
        }
        catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Despite check in constructor triangle has less than three points!");
        }
    }
}
