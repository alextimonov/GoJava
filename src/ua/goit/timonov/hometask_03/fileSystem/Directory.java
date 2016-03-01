package ua.goit.timonov.hometask_03.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String dirName;
    private List<File> fileList;

    public Directory(String dirName) {
        this.dirName = dirName;
        fileList = new ArrayList<>();
    }

    public void addFile(File file) {
        fileList.add(file);
    }

    public void printFiles() {
        System.out.println("DIRECTORY " + dirName + " contains next files:");
        for (File file : fileList) {
            file.printFileName();
        }
    }
}
