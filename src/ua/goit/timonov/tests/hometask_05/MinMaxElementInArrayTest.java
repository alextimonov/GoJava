package ua.goit.timonov.tests.hometask_05;

import org.junit.Test;
import ua.goit.timonov.hometask_05.MinMaxElementInArray;

import static org.junit.Assert.*;

/**
 * Testing class for class MinMaxElementInArray
 */
public class MinMaxElementInArrayTest {
    int[] array;

    @Test
    public void testFindMaxElementNormal_1() {
        int[] array = new int[] {3, 5, 1, 7, 4, 6, 8, 5};
        assertEquals(8, MinMaxElementInArray.findMaxElement(array));
    }

    @Test
    public void testFindMaxElementNormal_2() {
        int[] array = new int[] {2, 4, 6, 8, 10};
        assertEquals(10, MinMaxElementInArray.findMaxElement(array));
    }

    @Test
    public void testFindMaxElementBorder_1() {
        int[] array = new int[] {0, 0, 0, 0, 0};
        assertEquals(0, MinMaxElementInArray.findMaxElement(array));
    }

    @Test(expected = NullPointerException.class)
    public void testFindMaxElementAbnormal_1() {
        int[] array = null;
        assertEquals(null, MinMaxElementInArray.findMaxElement(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMaxElementAbnormal_2() {
        int[] array = new int[] {};
        assertEquals(null, MinMaxElementInArray.findMaxElement(array));
    }

    @Test
    public void testFindMinElementNormal_1() {
        int[] array = new int[]  {3, 5, 1, 7, 4, 6, 8, 5};
        assertEquals(1, MinMaxElementInArray.findMinElement(array));
    }

    @Test
    public void testFindMinElementNormal_2() {
        int[] array = new int[] {2, 4, 6, 8, 10};
        assertEquals(2, MinMaxElementInArray.findMinElement(array));
    }

    @Test
    public void testFindMinElementBorder_1() {
        int[] array = new int[] {0, 0, 0, 0, 0};
        assertEquals(0, MinMaxElementInArray.findMinElement(array));
    }

    @Test(expected = NullPointerException.class)
    public void testFindMinElementAbnormal_1() {
        int[] array = null;
        assertEquals(null, MinMaxElementInArray.findMinElement(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMinElementAbnormal_2() {
        int[] array = new int[] {};
        assertEquals(null, MinMaxElementInArray.findMinElement(array));
    }
}