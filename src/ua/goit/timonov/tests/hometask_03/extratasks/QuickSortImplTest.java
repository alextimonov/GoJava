package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Test;
import ua.goit.timonov.hometask_03.extratasks.QuickSortImpl;

import static org.junit.Assert.*;

/**
 * Created by Alex on 16.03.2016.
 */
public class QuickSortImplTest {
    QuickSortImpl array;

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
        array = new QuickSortImpl(actual);
        array.sort(actual);
        assertArrayEquals(expected, array.getArray());
    }
}