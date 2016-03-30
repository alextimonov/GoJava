package ua.goit.timonov.hometask_08;

import ua.goit.timonov.hometask_03.filesystem.File;

/**
 * Prints data of File in Table
 */
public class PrintFileData {
    public static final int N_CHARS_IN_COLUMN1 = 17;
    public static final int N_CHARS_IN_COLUMN2 = 21;
    public static final int N_BORDERS = 2;
    public static final char BORDER = '|';
    public static final char SPACE = ' ';

    /**
     * @param file      File, whose data to be printed
     * @return          String with file data
     */
    public String print(File file) {
        final StringBuilder sb = new StringBuilder();
        sb
                .append(BORDER)
                .append(SPACE)
                .append(file.getClassName());
        int numberOfSpaces = N_CHARS_IN_COLUMN1 - N_BORDERS - file.getClassName().length();
        for (int i = 0; i < numberOfSpaces ; i++) {
            sb.append(SPACE);
        }
        sb
                .append(BORDER)
                .append(SPACE)
                .append(file.getFileName())
                .append(".")
                .append(file.getFileExtension());
        numberOfSpaces = N_CHARS_IN_COLUMN2 - N_BORDERS - file.getFileName().length() -
                file.getFileExtension().length();
        for (int i = 0; i < numberOfSpaces ; i++) {
            sb.append(SPACE);
        }
        sb.append(BORDER);
        return sb.toString();
    }

}
