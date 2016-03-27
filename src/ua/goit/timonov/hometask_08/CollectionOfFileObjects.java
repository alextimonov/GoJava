package ua.goit.timonov.hometask_08;

import ua.goit.timonov.hometask_03.filesystem.*;

import java.util.*;

/**
 * Class that prints object's collection of class File and its extending classes
 */
public class CollectionOfFileObjects {


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
        TableForFileList table = new TableForFileList();
        table.makeTableHeader(message);
        dir.printFiles();
        table.printHyphens();
    }

    /**
     * makes sorted collection based on TreeSet from unsorted List
     * @return      sorted set of objects of class File
     */
    public Set<File> makeSortedList() {
        Set<File> setFile = new TreeSet<>();
        for (File file : dir.getFileList()) {
            setFile.add(file);
        }
        return setFile;
    }

    public static void main(String[] args) {
        CollectionOfFileObjects collectionOfFileObjects = new CollectionOfFileObjects();
        collectionOfFileObjects.createDirectory();
        collectionOfFileObjects.output("DIRECTORY contains next files:");
        System.out.println();

        TableForFileList table = new TableForFileList();
        table.makeTableHeader("SORTED list (by filename):");
        Set<File> setFile = collectionOfFileObjects.makeSortedList();
        for (File file : setFile) {
            file.printFileData();
        }
        table.printHyphens();
    }
}
