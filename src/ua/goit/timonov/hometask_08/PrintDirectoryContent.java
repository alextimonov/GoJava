package ua.goit.timonov.hometask_08;

import ua.goit.timonov.hometask_03.filesystem.Directory;
import ua.goit.timonov.hometask_03.filesystem.File;

import java.util.ArrayList;
import java.util.List;

/**
 * Makes List of Strings to print File data in table
 */
public class PrintDirectoryContent {
    /**
     *
     * @param directory         Directory, whose content to be printed
     * @return                  List of strings with files' data
     */
    public static List<String> makeListOfStringsToPrint(Directory directory) {
        List<String> listOfStringsToPrint = new ArrayList<>();
        for (File file : directory.getFileList()) {
            listOfStringsToPrint.add(PrintFileData.print(file));
        }
        return listOfStringsToPrint;
    }
}
