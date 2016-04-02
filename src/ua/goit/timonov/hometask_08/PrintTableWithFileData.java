package ua.goit.timonov.hometask_08;

/**
 * Prints the table to the console with given title
 */
public class PrintTableWithFileData {
    public static final int N_OF_HYPHENS_IN_TABLE = 40;
    public static final int N_BORDERS = 2;
    public static final char BORDER = '|';
    public static final char SPACE = ' ';

    /**
     * creates header of table with given title
     * @param message       given title of table
     * @return              string with header of table
     */
    public static String tableHeader(String message) {
        int numberOfSpaces = N_OF_HYPHENS_IN_TABLE - N_BORDERS - message.length() - 1;
        final StringBuilder sb = new StringBuilder();
        sb.append(BORDER).append(SPACE).append(message);
        for (int i = 0; i < numberOfSpaces; i++) {
            sb.append(SPACE);
        }
        sb.append(BORDER);
        return sb.toString();
    }

    /**
     * creates header of table columns
     * @return          string with header of table columns
     */
    public static String tableColumnNames() {
        final StringBuilder sb = new StringBuilder();
        sb.append(BORDER).append(" Name of class  ").append(BORDER);
        sb.append(SPACE).append("Filename.Extnsn").append("     ").append(BORDER);
        return sb.toString();
    }

    /**
     * prints line of hyphens
     * @return          string with hyphens
     */
    public static String printHyphens() {
        final StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N_OF_HYPHENS_IN_TABLE; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
