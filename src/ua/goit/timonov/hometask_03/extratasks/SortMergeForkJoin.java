package ua.goit.timonov.hometask_03.extratasks;

import java.util.concurrent.RecursiveAction;

/**
 * A class with implementation of integer numbers array merge sorting.
 * Uses ForkJoin framework, extends recursive resultless ForkJoinTask
 */
public class SortMergeForkJoin extends RecursiveAction {

    /** int number of array part's left bound to sort  */
    private int leftBound;
    /** int number of array part's right bound to sort */
    private int rightBound;
    /** Array of int numbers to sort */
    private int[] array;
    /** Object of class SortMergeImpl with implementation of ordinary merge sort (without ForkJoin) */
    SortMergeImplArray sortMergeArray;

    /** Default constructor  */
    public SortMergeForkJoin() {
    }

    /** Constructor with given leftBound, rightBound & array */
    public SortMergeForkJoin(int leftBound, int rightBound, int[] array) {
        sortMergeArray = new SortMergeImplArray(array);
        checkArguments(array);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.array = array;
    }

    // Checks given array if it points to null or if it's empty using method of SortMergeImpl class
    private void checkArguments(int[] array) {
//        SortMergeImplArray.checkArguments(array);
    }

    /** =============== Getter ================= */
    public int[] getArray() {
        return array;
    }

    /**
     * The main computation performed by this task.
     * Recursive resultless method that can be forked and joined.
     * Sorts array with MergeSort algorithm.
     */
    @Override
    protected void compute() {
        if (leftBound == rightBound) {
            return;
        }
        else {
            int middle = (rightBound + leftBound) / 2;
            SortMergeForkJoin leftTask = new SortMergeForkJoin(leftBound, middle, array);
            SortMergeForkJoin rightTask = new SortMergeForkJoin(middle + 1, rightBound, array);
            leftTask.fork();
            rightTask.fork();
            leftTask.join();
            rightTask.join();
            mergeArrays(array, leftBound, middle+1, rightBound);
        }
    }

    // Merges two sorted parts of array (left & right) to one sorted array using method of SortMergeImpl class
    private void mergeArrays(int[] array, int leftBound, int middle, int rightBound) {
        sortMergeArray.mergeArrays(array, leftBound, middle, rightBound);
    }
}
