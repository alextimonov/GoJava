package ua.goit.timonov.tests.hometask_10;

import org.junit.Test;
import ua.goit.timonov.hometask_10.ReadWriteEncryptedTextToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Testing class for ReadWriteEncryptedTextToFile
 */
public class ReadWriteEncryptedTextToFileTest {
    ReadWriteEncryptedTextToFile readWriter = new ReadWriteEncryptedTextToFile();
    public static final String FILE_NAME_LONG = "resources/txt/hometask_10/long.txt";
    public static final String FILE_NAME_SHORT = "resources/txt/hometask_10/short.txt";

    @Test
    public void testReadTextFromFileNormal_1() {
        String inputFileName = "resources/txt/hometask_10/encryptedLong.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
        assertEquals(expected, actual);
    }

    @Test
    public void testWriteTextToFileNormal_1() {
        String outputFileName = "resources/txt/hometask_10/encryptedLong.txt";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
        String actual = readWriter.readTextFromFile(outputFileName, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadTextFromFileNormal_2() {
        String inputFileName = "resources/txt/hometask_10/encryptedShort.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_SHORT);
        assertEquals(expected, actual);
    }

    @Test
    public void testWriteTextToFileNormal_2() {
        String outputFileName = "resources/txt/hometask_10/encryptedShort.txt";
        String expected = readInitialText(FILE_NAME_SHORT);
        readWriter.writeTextToFile(outputFileName, expected, 10);
        String actual = readWriter.readTextFromFile(outputFileName, 10);
        assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void testReadTextFromFileAbnormal_1() {
        String inputFileName = "resources/txt/noDirectory/noFile.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = NullPointerException.class)
    public void testReadTextFromFileAbnormal_2() {
        String inputFileName = null;
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testReadTextFromFileAbnormal_3() {
        String inputFileName = "";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = RuntimeException.class)
    public void testWriteTextToFileAbnormal_1() {
        String outputFileName = "resources/txt/noDirectory/noFile.txt";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    @Test (expected = NullPointerException.class)
    public void testWriteTextToFileAbnormal_2() {
        String outputFileName = null;
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWriteTextToFileAbnormal_3() {
        String outputFileName = "";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    private String readInitialText(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while((c = reader.read())!=-1) {
                sb.append((char) c);
            }
        }
        catch (IOException e) {
            throw new RuntimeException("IO Exception while reading file" + fileName, e);
        }
        return sb.toString();
    }
}