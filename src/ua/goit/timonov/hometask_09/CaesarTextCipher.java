package ua.goit.timonov.hometask_09;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;

/**
 * Provides encryption and decryption of text by Caesar algorithm
 */
public class CaesarTextCipher {
    /**
     * encrypts given String by Caesar algorithm
     * @param inputText     given text
     * @param key           number of chars to shift
     * @return              encrypted text
     */
    public String encrypt(String inputText, int key) {
        checkArgument(inputText);
        return shiftText(inputText, key);
    }

    /**
     * decrypts given String by Caesar algorithm
     * @param inputText     given encrypted text
     * @param key           number of chars to shift
     * @return              decrypted text
     */
    public String decrypt(String inputText, int key) {
        checkArgument(inputText);
        return shiftText(inputText, -key);
    }

    // checks given string if it points to null
    private void checkArgument(String inputText) {
        if (inputText == null) throw new NullPointerException("Given string points to null!");
    }

    // shifts chars in the inputText on given number of chars (key)
    private String shiftText(String inputText, int key) {
        char[] charArray = inputText.toCharArray();
        char[] shiftedCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length ; i++) {
            shiftedCharArray[i] = shiftChar(charArray[i], key);
        }
        return new CharArray(shiftedCharArray, 0, shiftedCharArray.length, false).toString();
    }

    // shifts char in the inputText on given number of chars (key)
    private char shiftChar(char ch, int key) {
        int ciphered = ((int) ch + key + Character.MAX_VALUE) % Character.MAX_VALUE;
        return (char) ciphered;
    }
}
