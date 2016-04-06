package ua.goit.timonov.extratasks;

import java.util.concurrent.*;

/**
 * A class with implementation of integer numbers array merge sorting.
 * Uses ForkJoin framework, extends recursive resultless ForkJoinTask
 */
public class SortMergeForkJoin extends RecursiveAction implements Runnable, SortingAlgorithm {

    public static final int N_THREADS = 2;
    /** int number of array part's left bound to sort  */
    private int leftBound;
    /** int number of array part's right bound to sort */
    private int rightBound;
    /** Array of int numbers to sort */
    private int[] array;
    /** Object of class SortMergeImpl with implementation of ordinary merge sort (without ForkJoin) */
    SortMergeImplArray sortMergeImplArray;

    /** Default constructor  */
    public SortMergeForkJoin() {
    }

    /** Constructor with given leftBound, rightBound & array */
    public SortMergeForkJoin(int leftBound, int rightBound, int[] array) {
        sortMergeImplArray = new SortMergeImplArray(array);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.array = array;
    }

    /** =============== Getters & Setters ================= */
    public int[] getArray() {
        return array;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }

    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void sort(int[] array) {
        setLeftBound(0);
        setRightBound(array.length - 1);
        setArray(array);
        sortMergeImplArray = new SortMergeImplArray(array);
        compute();
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
        System.out.println("Compute method was invoked");
    }

    @Override
    public void run() {
        if (leftBound == rightBound) {
            return;
        }
        else {
            int middle = (rightBound + leftBound) / 2;
            SortMergeForkJoin leftTask = new SortMergeForkJoin(leftBound, middle, array);
            SortMergeForkJoin rightTask = new SortMergeForkJoin(middle + 1, rightBound, array);
//            ExecutorService executorService = new ForkJoinPool();
            ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
            Future futureLeft = executorService.submit(leftTask);
            Future futureRight = executorService.submit(rightTask);
            try {
                while (futureLeft.get() != null && futureRight.get() != null) {
                    //NOP
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            mergeArrays(array, leftBound, middle+1, rightBound);
        }
        System.out.println("Run method was invoked");
    }

    // Merges two sorted parts of array (left & right) to one sorted array using method of SortMergeImpl class
    private void mergeArrays(int[] array, int leftBound, int middle, int rightBound) {
        sortMergeImplArray.mergeArrays(array, leftBound, middle, rightBound);
    }
}
