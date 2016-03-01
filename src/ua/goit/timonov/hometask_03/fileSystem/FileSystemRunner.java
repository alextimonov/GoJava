package ua.goit.timonov.hometask_03.fileSystem;

public class FileSystemRunner {
    public static void main(String[] args) {
        Directory directory = new Directory("My directory");
        directory.addFile(new File("presentation", "ppt"));
        directory.addFile(new TextFile("readme"));
        directory.addFile(new AudioFile("song"));
        directory.addFile(new ImageFile("picture"));
        directory.addFile(new File("suspicious"));
        directory.printFiles();
    }
}
