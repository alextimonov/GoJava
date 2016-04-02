package ua.goit.timonov.hometask_03.filesystem;

import ua.goit.timonov.extratasks.SortMergeImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides directory with files of different types
 */
public class Directory {
    /* name of directory */
    private String dirName;
    /* list of files in directory */
    private List<File> fileList;

    /* Constructor with given name of directory */
    public Directory(String dirName) {
        this.dirName = dirName;
        fileList = new ArrayList<>();
    }

    /* ========== Getters ============= */
    public List<File> getFileList() {
        return fileList;
    }

    public String getDirName() {
        return dirName;
    }

    /**
     * adds new file to file list of Directory
     * @param file          given object of class File
     */
    public void addFile(File file) {
        fileList.add(file);
    }

    /**
     * sorts files by their filename using sort merge algorithm
     */
    public void sortFilesByName() {
        SortMergeImpl sortMerge = new SortMergeImpl();
        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.getFileName().compareTo(file2.getFileName());
            }
        };
        sortMerge.sort(fileList, comparator);
    }
}