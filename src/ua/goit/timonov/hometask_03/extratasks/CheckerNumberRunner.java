package ua.goit.timonov.hometask_03.extratasks;

import ua.goit.timonov.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckerNumberRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = NumberUtils.inputInt(sc);
        System.out.println("Is n = " + n + " even number? - Answer: " + checkEven(n));
        System.out.println("Is n = " + n + " prime number? - Answer: " + checkPrime(n));
        System.out.println("Is n = " + n + " palindrome number? - Answer: " + checkPalindrome(n));
        System.out.println("Is n = " + n + " a power of 2? - Answer: " + checkIsPowerOfTwo(n));
        sc.close();
    }

    private static boolean checkIsPowerOfTwo(int n) {
        if (n<2) {
            return false;
        }
        else {
            for (int i = 2; i <= n; i *= 2) {
                if (i == n) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean checkEven(int n) {
        return n % 2 == 0;
    }

    private static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n / 2 ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindrome(int n) {
        List<Integer> integerList = parseIntToArray(n);
        return checkListIntForPalindrome(integerList);
    }

    private static boolean checkListIntForPalindrome(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() / 2 ; i++) {
            if (integerList.get(i) != integerList.get(integerList.size()-i-1)) {
                return false;
            }
        }
        return true;
    }

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
}
