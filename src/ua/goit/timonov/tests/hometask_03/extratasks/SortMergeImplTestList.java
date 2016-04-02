package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.extratasks.SortMergeImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 29.03.2016.
 */
public class SortMergeImplTestList {
    SortMergeImpl sortMerge;
    Comparator<String> comparator;

    @Before
    public void setUp() {
        comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        sortMerge = new SortMergeImpl();
    }

    @Test
    public void testSortNormal_1() {
        List<String> actual = new ArrayList<>(Arrays.asList("XYZ", "ABC", "STU", "FGH"));
        List<String> expected = new ArrayList<>(Arrays.asList("ABC", "FGH", "STU", "XYZ"));
        makeTrueTest(actual, expected, comparator);
    }

    @Test
    public void testSortNormal_2() {
        List<String> actual = new ArrayList<>(Arrays.asList("potato", "carrot", "apple", "cherry", "apple"));
        List<String> expected = new ArrayList<>(Arrays.asList("apple", "apple", "carrot", "cherry", "potato"));
        makeTrueTest(actual, expected, comparator);
    }

    @Test
    public void testSortNormal_3() {
        List<String> actual = new ArrayList<>(Arrays.asList("potato", "carrot", "apple", "cherry", "apple"));
        List<String> expected = new ArrayList<>(Arrays.asList("apple", "apple", "carrot", "cherry", "potato"));
        makeTrueTest(actual, expected, comparator);
    }

    @Test
    public void testSortBorder_1() {
        List<String> actual = new ArrayList<>(Arrays.asList("apple", "apple", "apple"));
        List<String> expected = new ArrayList<>(Arrays.asList("apple", "apple", "apple"));
        makeTrueTest(actual, expected, comparator);
    }

    @Test
    public void testSortBorder_2() {
        List<String> actual = new ArrayList<>(Arrays.asList("zzz"));
        List<String> expected = new ArrayList<>(Arrays.asList("zzz"));
        makeTrueTest(actual, expected, comparator);
    }

    @Test
    public void testSortBorder_3() {
        List<String> actual = new ArrayList<>(Arrays.asList(""));
        List<String> expected = new ArrayList<>(Arrays.asList(""));
        makeTrueTest(actual, expected, comparator);
    }

    @Test(expected = NullPointerException.class)
    public void testSortAbnormal_1() {
        List<String> actual = null;
        List<String> expected = null;
        makeTrueTest(actual, expected, comparator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortAbnormal_2() {
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        makeTrueTest(actual, expected, comparator);
    }

    private void makeTrueTest(List<String> actual, List<String> expected, Comparator<String> comparator) {
        sortMerge.sort(actual, comparator);
        assertEquals(expected, actual);
    }
}
