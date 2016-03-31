package ua.goit.timonov.hometask_10;

import ua.goit.timonov.hometask_09.CaesarTextCipher;

import java.io.*;

/**
 * Provides work with text file: read and write
 */
public class ReadWriteTextFile {
    /* relative file path to read */
    public static final String INPUT_FILE_NAME = "resources/txt/hometask_10/readtext.txt";
    /* relative file path to write */
    public static final String OUTPUT_FILE_NAME = "resources/txt/hometask_10/writetext.txt";
    /* value of encryption key */
    public static final int ENCRYPTION_KEY = 10;

    /* object of class CaeserTextCipher */
    private CaesarTextCipher coder = new CaesarTextCipher();

    public ReadWriteTextFile() {
    }

    /**
     * reads text from file
     * @param fileName          relative file path
     * @return                  text that being read from file
     */
    public String readTextFromFile(String fileName) {
        StringBuilder readText = new StringBuilder();
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((line = in.readLine()) != null) {
                readText
                        .append(line)
                        .append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return readText.toString();
        return coder.decrypt(readText.toString(), ENCRYPTION_KEY);
    }

    /**
     * writes text to file
     * @param fileName              relative file path
     * @param givenText             text for writing to file
     * @return                      text that was written to file
     */
    public String writeTextToFile(String fileName, String givenText) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            out.write(coder.encrypt(givenText, ENCRYPTION_KEY));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return givenText;
    }

    public static void main(String[] args) {
        ReadWriteTextFile rwtf = new ReadWriteTextFile();
        String readText = rwtf.readTextFromFile(INPUT_FILE_NAME);
        System.out.println(readText);
        String writeText = rwtf.writeTextToFile(OUTPUT_FILE_NAME, readText);
        System.out.println(writeText);
    }
}
