package ua.goit.timonov.tests.hometask_03.extratasks;

import ua.goit.timonov.hometask_03.extratasks.SortMergeImpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 18.03.2016.
 */
public class SMIRunner {
    public static void main(String[] args) {
        SortMergeImpl<Integer> sortMerge = new SortMergeImpl<>();
        List<Integer> list = Arrays.asList(4, 8, 2, 6);
        sortMerge.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer value1, Integer value2) {
                return value1 - value2;
            }
        });
        System.out.println(list.toString());
    }
}
