package ua.goit.timonov.hometask_03.filesystem;

public class ImageFile extends File {
    public ImageFile(String fileName) {
        super(fileName);
        fileExtension = "png";
    }


    /**
     * @return      Name of class
     */
    @Override
    public String getFileType() {
        return "ImageFile";
    }
}
