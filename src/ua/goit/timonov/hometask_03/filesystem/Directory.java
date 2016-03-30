package ua.goit.timonov.hometask_03.filesystem;

import ua.goit.timonov.hometask_08.PrintFileData;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String dirName;
    private List<File> fileList;

    public List<File> getFileList() {
        return fileList;
    }

    public Directory(String dirName) {
        this.dirName = dirName;
        fileList = new ArrayList<>();
    }

    public void addFile(File file) {
        fileList.add(file);
    }

    public void printFiles() {
        PrintFileData printFileData = new PrintFileData();
        for (File file : fileList) {
            System.out.println(printFileData.print(file));
        }
    }
}
