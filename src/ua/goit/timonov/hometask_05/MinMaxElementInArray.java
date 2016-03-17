package ua.goit.timonov.hometask_05;

/**
 * Class MinMaxElementInArray provides array of int numbers with methods that
 * 1) finds min element;
 * 2) finds max element;
 */
public class MinMaxElementInArray {

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
}
