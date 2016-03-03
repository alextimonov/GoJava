package ua.goit.timonov.hometask_03.filesystem;

public class File {
    protected String fileName;
    protected String fileExtension;

    public File(String fileName) {
        this.fileName = fileName;
        this.fileExtension = "";
    }

    public File(String fileName, String extension) {
        this.fileName = fileName;
        this.fileExtension = extension;
    }

    public void printFileName() {
        if (fileExtension == "") {
            System.out.println(fileName);
        }
        else {
            System.out.println(fileName + "." + fileExtension);
        }
    }
}
