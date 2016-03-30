package ua.goit.timonov.hometask_03.filesystem;

public class ImageFile extends File {
    public ImageFile(String fileName) {
        super(fileName);
        fileExtension = "png";
    }

    @Override
    /**
     * @return      Name of class
     */
    public String getClassName() {
        return "ImageFile";
    }
}
