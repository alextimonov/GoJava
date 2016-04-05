package ua.goit.timonov.tests.hometask_09;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.goit.timonov.hometask_09.CaesarTextCipher;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Parameterized Test for class CeasarTextCipher
 */

@RunWith (value = Parameterized.class)
public class CaesarTextCipherParameterizedTest {
    private String initialText;
    private int key;
    private String expectedEncrypt;
    private String expectedDecrypt;

    @Parameterized.Parameters(name = "{index}: encrypted string \"{0}\" by key {1} is \"{2}\", decrypted is \"{3}\"")
    public static Iterable<Object[]> getParameterizedData() {
        return Arrays.asList(new Object[][] {
                {"abc", 3, "def", "^_`"},
                {"FGH", -5, "ABC", "KLM"},
                {"qwerty", 0, "qwerty", "qwerty"},
                {"UVWXYZ", 12, "abcdef", "IJKLMN"},
                {"", 5, "", ""}
        });
    }

    public CaesarTextCipherParameterizedTest(String initialText, int key, String expectedEncrypt,
                                             String expectedDecrypt) {
        this.initialText = initialText;
        this.key = key;
        this.expectedEncrypt = expectedEncrypt;
        this.expectedDecrypt = expectedDecrypt;
    }

    @Test
    public void testEncrypt() {
        assertEquals(expectedEncrypt, new CaesarTextCipher().encrypt(initialText, key));
    }

    @Test
    public void testDecrypt() {
        assertEquals(expectedDecrypt, new CaesarTextCipher().decrypt(initialText, key));
    }
}