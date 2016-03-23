package ua.goit.timonov.tests.hometask_05;

import org.junit.Before;
import ua.goit.timonov.hometask_05.QuickSortImpl;

/**
 * Testing class for class QuickSortImpl
 */
public class QuickSortTest extends AbstractSortTest {
    @Before
    public void setUp() {
        super.setSortingAlgorithm(new QuickSortImpl());

    }
}
