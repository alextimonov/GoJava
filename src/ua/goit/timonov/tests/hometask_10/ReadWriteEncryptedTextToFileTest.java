package ua.goit.timonov.tests.hometask_10;

import org.junit.Test;
import ua.goit.timonov.hometask_10.ReadWriteEncryptedTextToFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public void testReadTextFromFileNormal_1() throws IOException {
        String inputFileName = "resources/txt/hometask_10/encryptedLong.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
        assertEquals(expected, actual);
    }

    @Test
    public void testWriteTextToFileNormal_1() throws IOException {
        String outputFileName = "resources/txt/hometask_10/encryptedLong.txt";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
        String actual = readWriter.readTextFromFile(outputFileName, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadTextFromFileNormal_2() throws IOException {
        String inputFileName = "resources/txt/hometask_10/encryptedShort.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_SHORT);
        assertEquals(expected, actual);
    }

    @Test
    public void testWriteTextToFileNormal_2() throws IOException {
        String outputFileName = "resources/txt/hometask_10/encryptedShort.txt";
        String expected = readInitialText(FILE_NAME_SHORT);
        readWriter.writeTextToFile(outputFileName, expected, 10);
        String actual = readWriter.readTextFromFile(outputFileName, 10);
        assertEquals(expected, actual);
    }

    @Test (expected = FileNotFoundException.class)
    public void testReadTextFromFileAbnormal_1() throws IOException {
        String inputFileName = "resources/txt/noDirectory/noFile.txt";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = NullPointerException.class)
    public void testReadTextFromFileAbnormal_2() throws IOException {
        String inputFileName = null;
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testReadTextFromFileAbnormal_3() throws IOException {
        String inputFileName = "";
        String actual = readWriter.readTextFromFile(inputFileName, 10);
        String expected = readInitialText(FILE_NAME_LONG);
    }

    @Test (expected = FileNotFoundException.class)
    public void testWriteTextToFileAbnormal_1() throws IOException {
        String outputFileName = "resources/txt/noDirectory/noFile.txt";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    @Test (expected = NullPointerException.class)
    public void testWriteTextToFileAbnormal_2() throws IOException {
        String outputFileName = null;
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWriteTextToFileAbnormal_3() throws IOException {
        String outputFileName = "";
        String expected = readInitialText(FILE_NAME_LONG);
        readWriter.writeTextToFile(outputFileName, expected, 10);
    }

    private String readInitialText(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while((c = reader.read())!=-1) {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}