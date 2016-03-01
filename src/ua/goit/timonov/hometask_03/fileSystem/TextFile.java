package ua.goit.timonov.hometask_03.fileSystem;

public class TextFile extends File {

    public TextFile(String fileName) {
        super(fileName);
        fileExtension = "txt";
    }
}
