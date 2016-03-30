package ua.goit.timonov.tests.hometask_09;

import org.junit.Test;
import ua.goit.timonov.hometask_03.filesystem.File;
import ua.goit.timonov.hometask_03.filesystem.ImageFile;
import ua.goit.timonov.hometask_03.filesystem.TextFile;
import ua.goit.timonov.hometask_08.PrintFileData;
import ua.goit.timonov.hometask_09.CaesarTextCipher;

import static org.junit.Assert.*;

/**
 * Testing class for CaesarTextCipher
 */
public class CaesarTextCipherTest {
    CaesarTextCipher encoder = new CaesarTextCipher();

    @Test
    public void testEncryptNormal_1() {
        String actual = encoder.encrypt("abcdeABCDE", 5);
        String expected = "fghijFGHIJ";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptNormal_2() {
        String actual = encoder.encrypt("UVWXYZ", 12);
        String expected = "abcdef";
        assertEquals(expected, actual);
    }

    @Test
    public void testDecryptNormal_1() {
        String actual = encoder.decrypt("fghijFGHIJ", 5);
        String expected = "abcdeABCDE";
        assertEquals(expected, actual);
    }

    @Test
    public void testDecryptNormal_2() {
        String actual = encoder.decrypt("abcdef", 12);
        String expected = "UVWXYZ";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptDecryptNormal_3() {
        String initial = "abcdeABCDE";
        String actual = encoder.encrypt(initial, 10);
        String expected = "klmnoKLMNO";
        assertEquals(expected, actual);
        actual = encoder.decrypt(actual, 10);
        assertEquals(initial, actual);
    }

    @Test
    public void testEncryptDecryptFileData_1() {
        File file = new TextFile("readme");
        String initial = PrintFileData.print(file);
        String actual = encoder.decrypt(encoder.encrypt(initial, 20), 20);
        String expected = "| TextFile       | readme.txt          |";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptFileData_1() {
        File file = new ImageFile("picture");
        String initial = PrintFileData.print(file);
        String actual = encoder.encrypt(initial, 1);
        String expected = "}!JnbhfGjmf!!!!!!}!qjduvsf/qoh!!!!!!!!!}";
        assertEquals(expected, actual);
    }

    @Test
    public void testDecryptFileData_1() {
        String initial = "}!JnbhfGjmf!!!!!!}!qjduvsf/qoh!!!!!!!!!}";
        String actual = encoder.decrypt(initial, 1);
        String expected = "| ImageFile      | picture.png         |";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptBorder_1() {
        String actual = encoder.encrypt("abcdeABCDE", 0);
        String expected = "abcdeABCDE";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptBorder_2() {
        String actual = encoder.encrypt("abcdeABCDE", Character.MAX_VALUE);
        String expected = "abcdeABCDE";
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptBorder_3() {
        String actual = encoder.encrypt("", 5);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void testEncryptAbnormal_1() {
        String initial = null;
        String actual = encoder.encrypt(initial, 5);
        String expected = null;
        assertEquals(expected, actual);
    }
}