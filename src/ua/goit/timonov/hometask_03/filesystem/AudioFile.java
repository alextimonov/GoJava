package ua.goit.timonov.hometask_03.filesystem;

public class AudioFile extends File {

    public AudioFile(String fileName) {
        super(fileName);
        fileExtension = "mp3";
    }

    @Override
    /**
     * @return      Name of class
     */
    public String getClassName() {
        return "AudioFile";
    }
}
