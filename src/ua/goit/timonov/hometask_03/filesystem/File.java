package ua.goit.timonov.hometask_03.filesystem;

public class File {
    protected String fileName;
    protected String fileExtension;

    // ========== Getters ===========
    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @return      Name of class
     */
    public String getFileType() {
        return "File";
    }

    public File(String fileName) {
        this.fileName = fileName;
        this.fileExtension = "";
    }

    public File(String fileName, String extension) {
        this.fileName = fileName;
        this.fileExtension = extension;
    }
}
