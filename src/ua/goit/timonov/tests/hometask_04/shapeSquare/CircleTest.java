package ua.goit.timonov.tests.hometask_04.shapeSquare;

import org.junit.Test;
import ua.goit.timonov.hometask_04.shapeSquare.Circle;
import ua.goit.timonov.hometask_04.shapeSquare.Point;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CircleTest {

    private List<Point> pointList;
    private Circle rectangle;

    @Test
    public void testFindSquareNormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(5, 0));
        Circle circle = new Circle(pointList);
        assertEquals(Math.PI * 25, circle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareNormal_2() {
        pointList = new ArrayList<>();
        pointList.add(new Point(3, 3));
        pointList.add(new Point(3, 6));
        Circle circle = new Circle(pointList);
        assertEquals(Math.PI * 9, circle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareNormal_3() {
        pointList = new ArrayList<>();
        pointList.add(new Point(-6, 3));
        pointList.add(new Point(4, 3));
        Circle circle = new Circle(pointList);
        assertEquals(Math.PI * 100, circle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareBorder_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(3, 3));
        pointList.add(new Point(3, 3));
        Circle circle = new Circle(pointList);
        assertEquals(0, circle.findSquare(), 10E-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindSquareAbnormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(3, 3));
        Circle circle = new Circle(pointList);
        assertEquals(0.0, circle.findSquare(), 10E-6);
    }

    @Test(expected = NullPointerException.class)
    public void testFindSquareAbnormal_2() {
        pointList = null;
        Circle circle = new Circle(pointList);
        assertEquals(0.0, circle.findSquare(), 10E-6);
    }

}