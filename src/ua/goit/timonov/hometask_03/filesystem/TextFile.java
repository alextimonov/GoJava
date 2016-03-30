package ua.goit.timonov.hometask_03.filesystem;

public class TextFile extends File {

    public TextFile(String fileName) {
        super(fileName);
        fileExtension = "txt";
    }

    @Override
    /**
     * @return      Name of class
     */
    public String getClassName() {
        return "TextFile";
    }
}
