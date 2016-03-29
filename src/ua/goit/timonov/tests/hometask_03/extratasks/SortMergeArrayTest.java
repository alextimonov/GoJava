package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import ua.goit.timonov.hometask_03.extratasks.SortMergeImplArray;
import ua.goit.timonov.tests.hometask_05.AbstractSortTest;

/**
 * Testing class for class SortMergeArray
 */
public class SortMergeArrayTest extends AbstractSortTest {
    @Before
    public void setUp() {
        super.setSortingAlgorithm(new SortMergeImplArray());
    }
}
