package ua.goit.timonov.hometask_03.filesystem;

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
        for (File file : fileList) {
            file.printFileData();
        }
    }


}
