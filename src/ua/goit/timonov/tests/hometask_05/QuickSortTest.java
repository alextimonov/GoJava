package ua.goit.timonov.tests.hometask_05;

import org.junit.Before;
import ua.goit.timonov.hometask_05.QuickSortImpl;

/**
 * Created by Alex on 22.03.2016.
 */
public class QuickSortTest extends AbstractSortTest {
    @Before
    public void setUp() throws Exception {
        super.setSortingAlgorithm(new QuickSortImpl());

    }
}
