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
    private String expected;

    @Parameterized.Parameters(name = "{index}: result of encrypting \"{0}\" by key {1} is \"{2}\"")
    public static Iterable<Object[]> getParameterizedData() {
        return Arrays.asList(new Object[][] {
                {"abc", 3, "def"},
                {"FGH", -5, "ABC"},
                {"qwerty", 0, "qwerty"},
                {"UVWXYZ", 12, "abcdef"},
                {"", 5, ""}
        });
    }

    public CaesarTextCipherParameterizedTest(String initialText, int key, String expected) {
        this.initialText = initialText;
        this.key = key;
        this.expected = expected;
    }

    @Test
    public void testEncrypt() {
        assertEquals(expected, new CaesarTextCipher().encrypt(initialText, key));
    }

    @Test (expected = NullPointerException.class)
    public void testEncryptAbnormal_1() {
        CaesarTextCipher encoder = new CaesarTextCipher();
        String initial = null;
        String actual = encoder.encrypt(initial, 5);
    }
}