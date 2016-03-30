package ua.goit.timonov.hometask_08;

import ua.goit.timonov.hometask_03.extratasks.SortMergeImpl;
import ua.goit.timonov.hometask_03.filesystem.*;

import java.util.*;

/**
 * Class that prints object's collection of class File and its extending classes
 */
public class ListOfFiles {

    /* Directory with list of files (objects of class File */
    private Directory dir;

    /**
     * creates object's collection of class File and extending classes
     */
    public void createDirectory() {
        dir = new Directory("Sundry");
        dir.addFile(new File("presentation", "ppt"));
        dir.addFile(new TextFile("readme"));
        dir.addFile(new TextFile("text"));
        dir.addFile(new AudioFile("music"));
        dir.addFile(new ImageFile("picture"));
        dir.addFile(new File("suspicious"));
    }

    /**
     * prints object's collection of class File and extending classes
     */
    public void output(String message) {
        PrintTableWithFileData table = new PrintTableWithFileData();
        System.out.println(table.printHyphens());
        System.out.println(table.tableHeader(message));
        System.out.println(table.printHyphens());
        System.out.println(table.tableColumnNames());
        System.out.println(table.printHyphens());
        dir.printFiles();
        System.out.println(table.printHyphens());
        System.out.println();
    }

    /**
     * makes sorted collection based on TreeSet from unsorted List
     * @return      sorted set of objects of class File
     *//*
    public Set<File> makeSortedList() {
        Set<File> setFile = new TreeSet<>();
        for (File file : dir.getFileList()) {
            setFile.add(file);
        }
        return setFile;
    }*/

    private static void sortFilesByName(ListOfFiles listOfFiles) {
        SortMergeImpl sortMerge = new SortMergeImpl();
        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.getFileName().compareTo(file2.getFileName());
            }
        };
        List<File> fileList = listOfFiles.dir.getFileList();
        sortMerge.sort(fileList, comparator);
    }

    public static void main(String[] args) {
        ListOfFiles listOfFiles = new ListOfFiles();
        listOfFiles.createDirectory();
        listOfFiles.output("DIRECTORY contains next files:");
        sortFilesByName(listOfFiles);
        listOfFiles.output("SORTED list (by filename):");
    }
}
