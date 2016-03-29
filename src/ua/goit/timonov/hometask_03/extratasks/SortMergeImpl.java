package ua.goit.timonov.hometask_03.extratasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The class with method to sort the array of integer numbers.
 * Implements method sort(int[] array) with implementation of sortMerge
 */
public class SortMergeImpl <T> implements SortingAlgorithm {

    /** List of objects to sort */
    private List<T> list = new ArrayList<T>();

    /** Comparator that defines way of comparison */
    private Comparator<T> comparator;

    /** Default constructor  */
    public SortMergeImpl() {
    }

    /** Constructor with given comparator  */
    public SortMergeImpl(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    /** Constructor with ready list */
    public SortMergeImpl(List<T> list) {
        this.list = list;
    }

    /** =============== Getter & Setter ================= */
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    // Checks given list if it points to null or if it's empty
    private <T> void checkArguments(List<T> list) {
        if (list == null) {
            throw new NullPointerException("Null is given as argument!");
        }
        if (list.size() == 0) {
            throw new IllegalArgumentException("Empty array is given as argument!");
        }
    }

    /**
     * Overridden method sort - merge sort implementation
     */
//    @Override
    public void sort(int[] array) {
        // TODO check array - is it relevant argument
        for (int i = 0; i < array.length ; i++) {
            T elem = (T) new Integer(array[i]);
            list.add(elem);
        }
        sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            array[i] = (Integer) list.get(i);
        }
    }

//    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        checkArguments(list);
        setList(list);
        sortMerge(0, list.size()-1, comparator);
    }

    /**
     * Implementation of sorting list with algo sortMerge
     */
    private void sortMerge(int leftBound, int rightBound, Comparator<T> comparator) {
        if (leftBound == rightBound) {
            return;
        }
        else {
            int middle = (rightBound + leftBound) / 2;
            sortMerge(leftBound, middle, comparator);
            sortMerge(middle+1, rightBound, comparator);
            mergeLists(list, leftBound, middle+1, rightBound, comparator);
        }
    }

    // Merges two sorted parts of list (left & right) to one sorted list
    protected  <T> void mergeLists(List<T> list, int leftPtr, int rightPtr,
                                                  int rightBound, Comparator<T> comparator) {
        int nElements = rightBound - leftPtr + 1;
        int leftStart = leftPtr;
        List<T> work = new ArrayList<T>();
        int leftBound = rightPtr-1;
        int i = 0;
        while (leftPtr <= leftBound && rightPtr <= rightBound) {
            if ( comparator.compare(list.get(leftPtr), list.get(rightPtr)) < 0 ) {
                work.add(list.get(leftPtr++));
                i++;
            }
            else {
                work.add(list.get(rightPtr++));
            }
        }
        while (leftPtr <= leftBound) {
            work.add(list.get(leftPtr++));
            i++;
        }
        while (rightPtr <= rightBound) {
            work.add(list.get(rightPtr++));
            i++;
        }
        for (i = 0; i < nElements; i++) {
            list.add(leftStart+i, work.get(i));
            list.remove(leftStart+i+1);
        }
    }
}
