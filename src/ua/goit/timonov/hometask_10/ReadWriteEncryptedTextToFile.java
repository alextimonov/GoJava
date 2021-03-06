package ua.goit.timonov.hometask_10;

import ua.goit.timonov.hometask_09.CaesarTextCipher;

import java.io.*;

/**
 * Provides work with encrypted text file: read and write
 */
public class ReadWriteEncryptedTextToFile {
    private CaesarTextCipher coder = new CaesarTextCipher();

    /**
     * reads text from file and decrypt it
     * @param fileName          relative file path
     * @param key               encryption key
     * @return                  text that being read from file
     */
    public String readTextFromFile(String fileName, int key) {
        checkString(fileName);
        StringBuilder readText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while((c = reader.read())!=-1) {
                readText.append((char) c);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + fileName, e);
        }
        catch (IOException e) {
            throw new RuntimeException("IO error while reading file " + fileName, e);
        }
        return coder.decrypt(readText.toString(), key);
    }

    /**
     * encrypt given text and writes it to file
     * @param fileName              relative file path
     * @param givenText             text for writing to file
     * @param key                   encryption key
     */
    public void writeTextToFile(String fileName, String givenText, int key) {
        checkString(fileName);
        checkString(givenText);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            out.write(coder.encrypt(givenText, key));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + fileName, e);
        }
        catch (IOException e) {
            throw new RuntimeException("IO error while writing file " + fileName, e);
        }
    }

    // Checks given String if it points to null or is empty
    private void checkString(String fileName) {
        if (fileName == "") {
            throw new IllegalArgumentException("String is empty!");
        }
        if (fileName == null) {
            throw new NullPointerException("String points to null!");
        }
    }
}
