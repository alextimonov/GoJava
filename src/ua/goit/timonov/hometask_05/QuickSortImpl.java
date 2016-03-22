package ua.goit.timonov.hometask_05;

import ua.goit.timonov.hometask_03.extratasks.SortingAlgorithm;

/**
 * Implements method sort(int[] array) with implementation of quick sort
 */
public class QuickSortImpl implements SortingAlgorithm {

    /** Default constructor that prevents to create an object */
    public QuickSortImpl() {}

    // Checks given array if it points to null or if it's empty
    private static void checkArguments(int[] array) {
        if (array == null) {
            throw new NullPointerException("Null is given as argument!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array is given as argument!");
        }
    }

    /**
     * Quick sort implementation
     */
    public void sort(int[] array) {
        checkArguments(array);
        quickSort(array, 0, array.length - 1);
    }

    // Implementation of sorting array with recursive algo quicksort
    private static void quickSort(int[] array, int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            // takes last right element as pivot value
            int pivot = array[rightBorder];
            // divides array to two parts due to pivot value, finds position of partition
            int posPartition = partition(array, leftBorder, rightBorder, pivot);
            // recursive invoke of quicksort for array's left part
            quickSort(array, leftBorder, posPartition - 1);
            // recursive invoke of quicksort for array's right part
            quickSort(array, posPartition + 1, rightBorder);
        }
    }

    // divides array to two parts due to pivot value, returns position of partition
    private static int partition(int[] array, int leftBorder, int rightBorder, int pivot) {
        int leftPtr = leftBorder;
        int rightPtr = rightBorder - 1;
        boolean wasSwap = true;
        while (wasSwap)
        {
            wasSwap = false;
            while (array[leftPtr] <= pivot && leftPtr < rightBorder)
                leftPtr++;
            while (array[rightPtr] >= pivot && rightPtr > leftBorder)
                rightPtr--;
            if (leftPtr < rightPtr  ) {
                swap(array, leftPtr, rightPtr);
                wasSwap = true;
            }
        }
        swap(array, leftPtr, rightBorder);
        return leftPtr;
    }

    // Swaps two elements in array by their indexes
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
