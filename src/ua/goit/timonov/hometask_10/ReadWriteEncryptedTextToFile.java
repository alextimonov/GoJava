package ua.goit.timonov.hometask_10;

import ua.goit.timonov.hometask_09.CaesarTextCipher;

import java.io.*;

/**
 * Provides work with encrypted text file: read and write
 */
public class ReadWriteEncryptedTextToFile {
    /* object of class CaeserTextCipher */
    private CaesarTextCipher coder = new CaesarTextCipher();

    /**
     * reads text from file and decrypt it
     * @param fileName          relative file path
     * @param key               encryption key
     * @return                  text that being read from file
     */
    public String readTextFromFile(String fileName, int key) throws IOException {
        checkString(fileName);
        StringBuilder readText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while((c = reader.read())!=-1) {
                readText.append((char) c);
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("Can't find file " + fileName);
        }
        catch (IOException e) {
            throw new IOException("IO error while reading file " + fileName);
        }
        return coder.decrypt(readText.toString(), key);
    }

    /**
     * encrypt given text and writes it to file
     * @param fileName              relative file path
     * @param givenText             text for writing to file
     * @param key                   encryption key
     */
    public void writeTextToFile(String fileName, String givenText, int key) throws IOException {
        checkString(fileName);
        checkString(givenText);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            out.write(coder.encrypt(givenText, key));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("Can't find file " + fileName);
        }
        catch (IOException e) {
            throw new IOException("IO error while writing file " + fileName);
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
