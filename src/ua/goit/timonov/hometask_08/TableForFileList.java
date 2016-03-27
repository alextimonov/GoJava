package ua.goit.timonov.hometask_08;

/**
 * Prints the table to the console with given title
 */
public class TableForFileList {
    public static final int NUMBER_OF_HYPHENS_IN_TABLE = 40;

    /**
     * creates header of table with given title
     * @param message       given title of table
     */
    public static void makeTableHeader(String message) {
        printHyphens();
        System.out.printf("|  %-35s |", message);
        System.out.println();
        printHyphens();
        System.out.printf("| Name of class  |      Filename.Extnsn|");
        System.out.println();
        printHyphens();
    }

    /**
     * prints line of hyphens
     */
    public static void printHyphens() {
        for (int i = 0; i < NUMBER_OF_HYPHENS_IN_TABLE; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
