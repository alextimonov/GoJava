package ua.goit.timonov.hometask_03.flowers;

public class Flower {
    private String mColor;
    protected String mName;

    public Flower() {
        mName = "flower";
    }

    public Flower(String mColor) {
        this();
        this.mColor = mColor;
    }

    public void smell() {
        System.out.println("A flower usually smells pretty.");
    }

    public void showColor() {
        System.out.println("This " + mName + " can have colors: " + mColor);
    }
}
