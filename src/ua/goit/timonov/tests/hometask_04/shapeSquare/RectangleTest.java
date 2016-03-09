package ua.goit.timonov.tests.hometask_04.shapeSquare;

import org.junit.Test;
import ua.goit.timonov.hometask_04.shapeSquare.Point;
import ua.goit.timonov.hometask_04.shapeSquare.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RectangleTest {
    private List<Point> pointList;
    private Rectangle rectangle;

    @Test
    public void testFindSquareNormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(5, 3));
        rectangle = new Rectangle(pointList);
        assertEquals(15.0, rectangle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareNormal_2() {
        pointList = new ArrayList<>();
        pointList.add(new Point(-4, -2));
        pointList.add(new Point(3, 4));
        rectangle = new Rectangle(pointList);
        assertEquals(42.0, rectangle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareBorder_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(-5, 0));
        pointList.add(new Point(5, 0));
        rectangle = new Rectangle(pointList);
        assertEquals(0, rectangle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareBorder_2() {
        pointList = new ArrayList<>();
        pointList.add(new Point(5, 0));
        pointList.add(new Point(5, 0));
        rectangle = new Rectangle(pointList);
        assertEquals(0, rectangle.findSquare(), 10E-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindSquareAbmormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(5, 0));
        rectangle = new Rectangle(pointList);
        assertEquals(0, rectangle.findSquare(), 10E-6);
    }

    @Test(expected = NullPointerException.class)
    public void testFindSquareAbmormal_2() {
        pointList = null;
        rectangle = new Rectangle(pointList);
        assertEquals(0, rectangle.findSquare(), 10E-6);
    }

}