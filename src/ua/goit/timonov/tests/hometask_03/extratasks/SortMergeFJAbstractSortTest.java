package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import ua.goit.timonov.extratasks.SortMergeForkJoin;
import ua.goit.timonov.tests.hometask_05.AbstractSortTest;

/**
 * Created by Alex on 06.04.2016.
 */
public class SortMergeFJAbstractSortTest extends AbstractSortTest {

    @Before
    public void setUp() {
        super.setSortingAlgorithm(new SortMergeForkJoin());
    }
}