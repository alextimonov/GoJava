package ua.goit.timonov.hometask_03.filesystem;

public class AudioFile extends File {

    public AudioFile(String fileName) {
        super(fileName);
        fileExtension = "mp3";
    }


    /**
     * @return      Name of class
     */
    @Override
    public String getFileType() {
        return "AudioFile";
    }
}
