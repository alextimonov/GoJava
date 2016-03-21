package ua.goit.timonov.hometask_05;

/**
 * Class MinMaxElementInArray provides array of int numbers and finds maximum and minimum elements
 */
public class MinMaxElementInArray {

    /** Default constructor that prevents to create an object */
    private MinMaxElementInArray() {}

    /**
     * Finds value of max element in array
     * @param array     array if ints
     * @return          value of max element in array
     */
    public static int findMaxElement(int[] array) {
        checkArguments(array);
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

    /**
     * Finds value of min element in array
     * @param array      array of ints
     * @return           value of min element in array
     */
    public static int findMinElement(int[] array) {
        checkArguments(array);
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    // Checks given array if it points to null or if it's empty
    private static void checkArguments(int[] array) {
        if (array == null) {
            throw new NullPointerException("Field array equals null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array's length is 0.");
        }
    }
}
