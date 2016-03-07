package ua.goit.timonov.hometask_03.extratasks;

/**
 * The class with method to sort the array of integer numbers.
 * Implements method sort(int[] array) with implementation of sortMerge
 */
public class SortMergeArray implements ArraySortable {

    /** Array of int numbers to sort */
    private int[] array;

    /** =============== Getter & Setter ================= */
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        checkArguments(array);
        this.array = array;
    }

    // Checks given array if it points to null or if it's empty
    private void checkArguments(int[] array) {
        if (array == null) {
            throw new NullPointerException("Null is given as argument!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array is given as argument!");
        }
    }

    /**
     * Overridden method sort - merge sort implementation
     */
    @Override
    public void sort() {
        sortMerge(array, 0, array.length-1);
    }

    /**
     * Implementation of sorting array with algo sortMerge
     */
    private static void sortMerge(int[] array, int leftBound, int rightBound) {

        if (leftBound == rightBound) {
            return;
        }
        else {
            int middle = (rightBound + leftBound) / 2;
            sortMerge(array, leftBound, middle);
            sortMerge(array, middle+1, rightBound);
            mergeArrays(array, leftBound, middle+1, rightBound);
        }
    }

    // Merges two sorted parts of array (left & right) to one sorted array
    private static void mergeArrays(int[] array, int leftPtr, int rightPtr, int rightBound) {
        int nElements = rightBound - leftPtr + 1;
        int leftStart = leftPtr;
        int[] work = new int [nElements];
        int leftBound = rightPtr-1;
        int i = 0;
        while (leftPtr <= leftBound && rightPtr <= rightBound) {
            if (array[leftPtr] < array[rightPtr]) {
                work[i++] = array[leftPtr++];
            }
            else {
                work[i++] = array[rightPtr++];
            }
        }
        while (leftPtr <= leftBound) {
            work[i++] = array [leftPtr++];
        }
        while (rightPtr <= rightBound) {
            work[i++] = array [rightPtr++];
        }
        for (i = 0; i < nElements; i++) {
            array[leftStart+i] = work[i];
        }
    }
}
