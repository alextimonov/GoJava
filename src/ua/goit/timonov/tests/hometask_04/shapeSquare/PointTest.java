package ua.goit.timonov.tests.hometask_04.shapeSquare;

import org.junit.Test;
import ua.goit.timonov.hometask_04.shapeSquare.Point;

import static org.junit.Assert.*;

public class PointTest {
    private Point pointA;
    private Point pointB;

    @Test
    public void testFindDistanceNormal_1() {
        pointA = new Point(10, 0);
        pointB = new Point(0, 0);
        assertEquals(10, pointA.findDistance(pointB), 10E-6);
    }

    @Test
    public void testFindDistanceNormal_2() {
        pointA = new Point(10, 0);
        pointB = new Point(0, 10);
        assertEquals(10 * Math.sqrt(2), pointA.findDistance(pointB), 10E-6);
    }

    @Test
    public void testFindDistanceNormal_3() {
        pointA = new Point(4, -3);
        pointB = new Point(-4, 3);
        assertEquals(10, pointA.findDistance(pointB), 10E-6);
    }

    @Test
    public void testFindDistanceBorder_1() {
        pointA = new Point(0, 0);
        pointB = new Point(0, 0);
        assertEquals(0, pointA.findDistance(pointB), 10E-6);
    }
}