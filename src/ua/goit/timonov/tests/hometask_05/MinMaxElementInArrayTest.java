package ua.goit.timonov.tests.hometask_05;

import org.junit.Test;
import ua.goit.timonov.hometask_05.MinMaxElementInArray;

import static org.junit.Assert.*;

/**
 * Testing class for class MinMaxElementInArray
 */
public class MinMaxElementInArrayTest {
    MinMaxElementInArray array;

    @Test
    public void testFindMaxElementNormal_1() {
        array = new MinMaxElementInArray(new int[] {3, 5, 1, 7, 4, 6, 8, 5});
        assertEquals(8, array.findMaxElement());
    }

    @Test
    public void testFindMaxElementNormal_2() {
        array = new MinMaxElementInArray(new int[] {2, 4, 6, 8, 10});
        assertEquals(10, array.findMaxElement());
    }

    @Test
    public void testFindMaxElementBorder_1() {
        array = new MinMaxElementInArray(5);
        assertEquals(0, array.findMaxElement());
    }

    @Test(expected = NullPointerException.class)
    public void testFindMaxElementAbnormal_1() {
        array = null;
        assertEquals(0, array.findMaxElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMaxElementAbnormal_2() {
        array = new MinMaxElementInArray(0);
        assertEquals(0, array.findMaxElement());
    }

    @Test
    public void testFindMinElementNormal_1() {
        array = new MinMaxElementInArray(new int[] {3, 5, 1, 7, 4, 6, 8, 5});
        assertEquals(1, array.findMinElement());
    }

    @Test
    public void testFindMinElementNormal_2() {
        array = new MinMaxElementInArray(new int[] {2, 4, 6, 8, 10});
        assertEquals(2, array.findMinElement());
    }

    @Test
    public void testFindMinElementBorder_1() {
        array = new MinMaxElementInArray(5);
        assertEquals(0, array.findMinElement());
    }

    @Test(expected = NullPointerException.class)
    public void testFindMinElementAbnormal_1() {
        array = null;
        assertEquals(0, array.findMinElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMinElementAbnormal_2() {
        array = new MinMaxElementInArray(0);
        assertEquals(0, array.findMinElement());
    }
}