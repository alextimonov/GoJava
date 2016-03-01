package ua.goit.timonov.hometask_03.fileSystem;

public class AudioFile extends File {

    public AudioFile(String fileName) {
        super(fileName);
        fileExtension = "mp3";
    }
}
