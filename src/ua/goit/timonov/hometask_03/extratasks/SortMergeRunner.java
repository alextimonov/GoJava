package ua.goit.timonov.hometask_03.extratasks;

import ua.goit.timonov.utils.NumberUtils;
import java.util.Scanner;

public class SortMergeRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of elements in Array. ");
        int nElements = NumberUtils.inputInt(sc);
        System.out.print("Input max value in Array. ");
        int max = NumberUtils.inputInt(sc);
        int[] array = NumberUtils.generateRandomArray(nElements, max);
        System.out.println("Current array is: ");
        printArray(array);
        sortMerge(array, 0, array.length-1);
        System.out.println("Sorted array is: ");
        printArray(array);
    }

    private static int[] copy(int[] array) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            resultArray[i] = array[i];
        }
        return resultArray;
    }

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

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
