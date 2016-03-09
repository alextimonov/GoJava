package ua.goit.timonov.hometask_04.shapeSquare;

import java.util.List;

/**
 * Abstract class for different shapes
 */
public abstract class Shape {
    /** List of points that define the Shape  */
    protected List<Point> pointList;

    /**
     * Constructs shape by list of its points
     * @param pointList     list of points, each point is object of class Point
     */
    public Shape(List<Point> pointList) {
        this.pointList = pointList;
    }

    /**
     * Abstract method to find the square of shape
     * @return      square of shape
     */
    public abstract double findSquare();


    // checks if list of points hasn't exactly number of points for certain shape or if it points to null
    protected void checkPointList(int nPoints) {
        if (pointList == null) {
            throw new NullPointerException("pointList points to null!");
        }
        if (pointList.size() != nPoints) {
            throw new IllegalArgumentException("This shape must have " + nPoints + " points!");
        }
    }
}
