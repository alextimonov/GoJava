package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import ua.goit.timonov.extratasks.SortMergeImpl;
import ua.goit.timonov.tests.hometask_05.AbstractSortTest;

import java.util.Comparator;

/**
 * Created by Alex on 29.03.2016.
 */
public class SortMergeImplTestInt extends AbstractSortTest {
    @Before
    public void setUp() {
        Comparator<Integer> comparator = (value1, value2) -> value1 - value2;
        super.setSortingAlgorithm(new SortMergeImpl(comparator));
    }
}
