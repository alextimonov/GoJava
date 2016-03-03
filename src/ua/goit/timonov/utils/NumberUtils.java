package ua.goit.timonov.utils;

import java.util.Random;
import java.util.Scanner;

public class NumberUtils {

    public NumberUtils() {}

    public static int inputInt(Scanner sc) {
        System.out.println("Please, input integer number: ");
        int result = 0;
        boolean isInputSuccessful = false;
        while (!isInputSuccessful) {
            try {
                String s = sc.nextLine();
                result = Integer.parseInt(s);
                isInputSuccessful = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Must be integer number! Input one more: ");
            }
        }
        return result;
    }

    public static int[] generateRandomArray(int nElements, int max) {
        int[] array = new int[nElements];
        Random rand = new Random();
        for (int i = 0; i < nElements; i++) {
            array[i] = rand.nextInt(max);
        }
        return array;
    }
}
