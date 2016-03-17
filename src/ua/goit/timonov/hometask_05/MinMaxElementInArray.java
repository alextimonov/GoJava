package ua.goit.timonov.hometask_05;

import ua.goit.timonov.hometask_03.extratasks.ArraySortable;


/**
 * Class MinMaxElementInArray provides array of int numbers with methods that
 * 1) finds min element;
 * 2) finds max element;
 * 3) sorts array with Quicksort algorithm
 * Implements method sort(int[] array) with implementation of quick sort
 */
public class MinMaxElementInArray implements ArraySortable {

    /** Array of int numbers */
    private int[] array;

    /**
     * Constructor, that creates MinMaxElementInArray by number of elements
     * @param nElems        number of elements in array
     */
    public MinMaxElementInArray(int nElems) {
        array = new int[nElems];
    }

    /**
     * Constructor, that creates MinMaxElementInArray by given array
     * @param array         array of int numbers
     */
    public MinMaxElementInArray(int[] array) {
        this.array = array;
        checkArguments();
    }

    /** =============== Getter ================= */
    public int[] getArray() {
        return array;
    }

    /**
     * Finds value of max element in array
     * @return           value of max element in array
     */
    public int findMaxElement() {
        checkArguments();
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

    /**
     * Finds value of min element in array
     * @return           value of min element in array
     */
    public int findMinElement() {
        checkArguments();
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    // Checks given array if it points to null or if it's empty
    private void checkArguments() {
        if (array == null) {
            throw new NullPointerException("Field array equals null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array's length is 0.");
        }
    }

    /**
     * Overridden method sort - quick sort implementation
     */
    @Override
    public void sort() {
        checkArguments();
        quickSort(0, array.length - 1);
    }

    // Implementation of sorting array with recursive algo quicksort
    private void quickSort(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            // takes last right element as pivot value
            int pivot = array[rightBorder];
            // divides array to two parts due to pivot value, finds position of partition
            int posPartition = partition(leftBorder, rightBorder, pivot);
            // recursive invoke of quicksort for array's left part
            quickSort(leftBorder, posPartition - 1);
            // recursive invoke of quicksort for array's right part
            quickSort(posPartition + 1, rightBorder);
        }
    }

    // divides array to two parts due to pivot value, returns position of partition
    private int partition(int leftBorder, int rightBorder, int pivot) {
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
                swap(leftPtr, rightPtr);
                wasSwap = true;
            }
        }
        swap(leftPtr, rightBorder);
        return leftPtr;
    }

    // Swaps two elements in array by their indexes
    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
