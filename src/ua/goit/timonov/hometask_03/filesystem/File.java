package ua.goit.timonov.hometask_03.filesystem;

public class File {
    protected String fileName;
    protected String fileExtension;

    // ======= Getters & Setters ========
    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @return      Name of class
     */
    public String getClassName() {
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

    public void printFileData() {
        String nameOfClass = this.getClass().getSimpleName();
        System.out.printf("|  %-12s  |  %12s.%3s   |", nameOfClass, fileName, fileExtension);
        System.out.println();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("File{");
        sb.append("fileName='").append(fileName).append('\'');
        sb.append(", fileExtension='").append(fileExtension).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
