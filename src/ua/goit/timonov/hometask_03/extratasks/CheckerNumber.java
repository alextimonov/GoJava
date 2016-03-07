package ua.goit.timonov.hometask_03.extratasks;

import java.util.ArrayList;
import java.util.List;

/**
 * The class with methods to check if the integer number is:
 * 1) even number or not;
 * 2) the power of two;
 * 3) palindrome number;
 * 4) prime number.
 */
public class CheckerNumber {

    /**
     * Checks if int number is even or not (0, -2, -4... are considered even)
     * @param value    Input integer number
     * @return         True if value is even, or false if value is odd
     */
    public boolean checkEven(int value) {
        return value % 2 == 0;
    }

    /**
     * Checks if int number is power of two
     * @param value     Input integer number
     * @return          True if value is the power of two, or false if not;
     *                  also returns false, if value is less than two
     */
    public boolean checkIsPowerOfTwo(int value) {
        if (value <2) {
            return false;
        }
        else {
            for (int i = 2; i <= value && i < Integer.MAX_VALUE / 2; i *= 2) {
                if (i == value) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Checks if int number is prime number
     * @param value    Input integer number
     * @return         True if value is prime number, or false if not
     */
    public boolean checkPrime(int value) {
        if (value < 2) {
            return false;
        }
        for (int i = 2; i < value / 2 ; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if int number is palindrome (is the same if read from right ro left)
     * @param value    Input integer number
     * @return         True if value is palindrome, or false if not
     */
    public boolean checkPalindrome(int value) {
        if (value < 0) return false;
        else {
            List<Integer> integerList = parseIntToArray(value);
            return checkListIntForPalindrome(integerList);
        }
    }

    // Parses int number to list of number's digits
    private static List<Integer> parseIntToArray(int n) {
        List<Integer> result = new ArrayList<>();
        int k = n;
        while (k > 0) {
            int f = (Integer) (k % 10);
            result.add(f);
            k = k / 10;
        }
        return result;
    }

    // Checks list of digits if it's the same from left to right and backwards
    private boolean checkListIntForPalindrome(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() / 2 ; i++) {
            if (integerList.get(i) != integerList.get(integerList.size()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
