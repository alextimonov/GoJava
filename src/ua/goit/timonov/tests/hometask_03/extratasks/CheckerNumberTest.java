package ua.goit.timonov.tests.hometask_03.extratasks;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.goit.timonov.hometask_03.extratasks.CheckerNumber;

import static org.junit.Assert.*;

public class CheckerNumberTest {
    private CheckerNumber checkerNumber;

    @Before
    public void setUp() {
        checkerNumber = new CheckerNumber();
    }

    /** ================ Tests for method checkEven() ================ */

    @Test
    public void testCheckEvenNormal_1() {
        assertTrue(checkerNumber.checkEven(100));
    }

    @Test
    public void testCheckEvenNormal_3() {
        assertFalse(checkerNumber.checkEven(17));
    }

    @Test
    public void testCheckEvenBorder_1() {
        assertTrue(checkerNumber.checkEven(0));
    }


    @Test
    public void testCheckEvenBorder_2() {
        assertFalse(checkerNumber.checkEven(Integer.MAX_VALUE));
    }

    @Test
    public void testCheckEvenAbnormal_1() {
        assertTrue(checkerNumber.checkEven(Integer.MIN_VALUE));
    }

    @Test
    public void testCheckEvenAbnormal_2() {
        assertTrue(checkerNumber.checkEven(-10));
    }

    /** ================ Tests for method checkPrime() ================ */

    @Test
    public void testCheckPrimeNormal_1() {
        assertTrue(checkerNumber.checkPrime(7));
    }

    @Test
    public void testCheckPrimeNormal_2() {
        assertTrue(checkerNumber.checkPrime(257));
    }

    @Test
    public void testCheckPrimeNormal_3() {
        assertFalse(checkerNumber.checkPrime(323));
    }

    @Test
    public void testCheckPrimeBorder_1() {
        assertTrue(checkerNumber.checkPrime(2));
    }

    @Test
    public void testCheckPrimeBorder_2() {
        assertFalse(checkerNumber.checkPrime(1));
    }

    // time to pass next test ~ 17 s
    @Ignore
    @Test
    public void testCheckPrimeBorder_3() {
        assertTrue(checkerNumber.checkPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testCheckPrimeAbnormal_1() {
        assertFalse(checkerNumber.checkPrime(0));
    }

    @Test
    public void testCheckPrimeAbnormal_2() {
        assertFalse(checkerNumber.checkPrime(-20));
    }

    /** ================ Tests for method checkIsPowerOfTwo() ================ */

    @Test
    public void testCheckIsPowerOfTwoNormal_1() {
        assertTrue(checkerNumber.checkIsPowerOfTwo(1024));
    }

    @Test
    public void testCheckIsPowerOfTwoNormal_2() {
        assertTrue(checkerNumber.checkIsPowerOfTwo(1_048_576));
    }

    @Test
    public void testCheckIsPowerOfTwoNormal_3() {
        assertFalse(checkerNumber.checkIsPowerOfTwo(1_000_000));
    }

    @Test
    public void testCheckIsPowerOfTwoBorder_1() {
        assertTrue(checkerNumber.checkIsPowerOfTwo(2));
    }

    @Test
    public void testCheckIsPowerOfTwoBorder_2() {
        assertFalse(checkerNumber.checkIsPowerOfTwo(Integer.MAX_VALUE));
    }

    @Test
    public void testCheckIsPowerOfTwoBorder_3() {
        assertFalse(checkerNumber.checkIsPowerOfTwo(1));
    }

    @Test
    public void testCheckIsPowerOfTwoAbnormal_1() {
        assertFalse(checkerNumber.checkIsPowerOfTwo(0));
    }

    @Test
    public void testCheckIsPowerOfTwoAbnormal_2() {
        assertFalse(checkerNumber.checkIsPowerOfTwo(-100));
    }

    /** ================ Tests for method checkPalindrome() ================ */

    @Test
    public void testcheckPalindromeNormal_1() {
        assertTrue(checkerNumber.checkPalindrome(12321));
    }

    @Test
    public void testcheckPalindromeNormal_2() {
        assertTrue(checkerNumber.checkPalindrome(777777));
    }

    @Test
    public void testcheckPalindromeNormal_3() {
        assertFalse(checkerNumber.checkPalindrome(123421));
    }

    @Test
    public void testcheckPalindromeBorder_1() {
        assertTrue(checkerNumber.checkPalindrome(5));
    }

    @Test
    public void testcheckPalindromeBorder_2() {
        assertTrue(checkerNumber.checkPalindrome(0));
    }

    @Test
    public void testcheckPalindromeAbnormal_1() {
        assertFalse(checkerNumber.checkPalindrome(-121));
    }

    @Test
    public void testcheckPalindromeAbnormal_2() {
        assertFalse(checkerNumber.checkPalindrome(-1000));
    }

}