package ua.goit.timonov.hometask_03.extratasks;

/**
 * Created by Alex on 12.03.2016.
 */
public class QuickSortImpl implements ArraySortable {
    /** Array of int numbers to sort */
    private int[] array;

    /** Default constructor  */
    public QuickSortImpl() {
    }

    /** Constructor with ready array */
    public QuickSortImpl(int[] array) {
        this.array = array;
    }

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

    @Override
    public void sort() {


    }
}
