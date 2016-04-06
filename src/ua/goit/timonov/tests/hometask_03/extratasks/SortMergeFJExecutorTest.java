package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.extratasks.SortMergeForkJoin;

import static org.junit.Assert.*;

import java.util.concurrent.*;

/**
 * Class for testing SortMergeForkJoin class (Merge Sort of integer array using ForkJoin Framework)
 */
public class SortMergeFJExecutorTest {
    private SortMergeForkJoin sortMergeFJ;
    private ForkJoinPool pool;

    @Before
    public void setUp() {
        pool = new ForkJoinPool();
    }

    @Test
    public void testSortNormal_1() {
        int[] actual =   {10, 6, 2, 8, 4};
        int[] expected = {2, 4, 6, 8, 10};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortNormal_2() {
        int[] actual =   {5, 4, 3, 2, 1, 0};
        int[] expected = {0, 1, 2, 3, 4, 5};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortNormal_3() {
        int[] actual =   {5, 4, 3, 5, 2, 3, 1, 0};
        int[] expected = {0, 1, 2, 3, 3, 4, 5, 5};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortNormal_4() {
        int[] actual =   {5, 4, 3, 5, 2, 3, 1, 0, 3, 2, 4, 5, 6, 0, 1};
        int[] expected = {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortNormal_5() {
        int[] actual =   {5, 6, 4, 3, 2, 1, 0};
        int[] expected = {0, 1, 2, 3, 4, 5, 6};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortBorder_1() {
        int[] actual =   {1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortBorder_2() {
        int[] actual =   {5};
        int[] expected = {5};
        makeTrueTest(expected, actual);
    }

    @Test
    public void testSortBorder_3() {
        int[] actual =   {1, 2, 3};
        int[] expected = {1, 2, 3};
        makeTrueTest(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSortAbnormal_1() {
        int[] actual =   null;
        int[] expected = null;
        makeTrueTest(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortAbnormal_2() {
        int[] actual =   {};
        int[] expected = {};
        makeTrueTest(expected, actual);
    }

    private void makeTrueTest(int[] expected, int[] actual) {
        sortMergeFJ = new SortMergeForkJoin(0, actual.length - 1, actual);
//        pool.invoke(sortMergeFJ);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future futureTask = executor.submit(sortMergeFJ);
        try {
            while (futureTask.get() != null) {
                //NOP
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        actual = sortMergeFJ.getArray();
        assertArrayEquals(expected, actual);
    }
}