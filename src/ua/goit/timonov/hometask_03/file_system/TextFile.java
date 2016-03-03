package ua.goit.timonov.hometask_03.filesystem;

public class TextFile extends File {

    public TextFile(String fileName) {
        super(fileName);
        fileExtension = "txt";
    }
}
