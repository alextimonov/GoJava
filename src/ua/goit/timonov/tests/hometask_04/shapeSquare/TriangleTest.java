package ua.goit.timonov.tests.hometask_04.shapeSquare;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_04.shapeSquare.Point;
import ua.goit.timonov.hometask_04.shapeSquare.Triangle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alex on 08.03.2016.
 */
public class TriangleTest {
    private List<Point> pointList;
    private Triangle triangle;

    @Test
    public void testFindSquareNormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(0, 5));
        pointList.add(new Point(4, 0));
        triangle = new Triangle(pointList);
        assertEquals(10.0, triangle.findSquare(), 10E-6);
    }

    @Before
    public void setUp2() throws Exception {

    }

    @Test
    public void testFindSquareNormal_2() {
        pointList = new ArrayList<>();
        pointList.add(new Point(6, 0));
        pointList.add(new Point(0, 4));
        pointList.add(new Point(0, -4));
        triangle = new Triangle(pointList);
        assertEquals(24.0, triangle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareBorder_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(-5, 0));
        pointList.add(new Point(5, 0));
        triangle = new Triangle(pointList);
        assertEquals(0.0, triangle.findSquare(), 10E-6);
    }

    @Test
    public void testFindSquareBorder_2() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(0, 0));
        pointList.add(new Point(0, 0));
        triangle = new Triangle(pointList);
        assertEquals(0.0, triangle.findSquare(), 10E-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindSquareAbnormal_1() {
        pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        triangle = new Triangle(pointList);
        assertEquals(0.0, triangle.findSquare(), 10E-6);
    }

    @Test(expected = NullPointerException.class)
    public void testFindSquareAbnormal_2() {
        pointList = null;
        triangle = new Triangle(pointList);
        assertEquals(0.0, triangle.findSquare(), 10E-6);
    }
}