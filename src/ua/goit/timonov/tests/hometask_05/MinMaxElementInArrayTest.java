package ua.goit.timonov.tests.hometask_05;

import org.junit.Test;
import ua.goit.timonov.hometask_05.MinMaxElementInArray;

import static org.junit.Assert.*;

/**
 * Class for testing MinMaxElementInArray
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

    @Test
    public void testSortNormal_1() {
        int[] actual =   {10, 6, 2, 8, 4, 10, 5};
        int[] expected = {2, 4, 5, 6, 8, 10, 10};
        makeTrueTest(actual, expected);
    }

    @Test
    public void testSortNormal_2() {
        int[] actual =   {5, 4, 3, 2, 1, 0};
        int[] expected = {0, 1, 2, 3, 4, 5};
        makeTrueTest(actual, expected);
    }

    @Test
    public void testSortNormal_3() {
        int[] actual =   {5, 4, 3, 5, 2, 3, 1, 0};
        int[] expected = {0, 1, 2, 3, 3, 4, 5, 5};
        makeTrueTest(actual, expected);
    }

    @Test
    public void testSortBorder_1() {
        int[] actual =   {1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1};
        makeTrueTest(actual, expected);
    }

    @Test
    public void testSortBorder_2() {
        int[] actual =   {5};
        int[] expected = {5};
        makeTrueTest(actual, expected);
    }

    @Test
    public void testSortBorder_3() {
        int[] actual =   {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        makeTrueTest(actual, expected);
    }

    @Test(expected = NullPointerException.class)
    public void testSortAbnormal_1() {
        int[] actual = null;
        int[] expected = null;
        makeTrueTest(actual, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortAbnormal_2() {
        int[] actual = new int[0];
        int[] expected = new int[0];
        makeTrueTest(actual, expected);
    }

    private void makeTrueTest(int[] actual, int[] expected) {
        array = new MinMaxElementInArray(actual);
        array.sort(actual);
        assertArrayEquals(expected, array.getArray());
    }
}