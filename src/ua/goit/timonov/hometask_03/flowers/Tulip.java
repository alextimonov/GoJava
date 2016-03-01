package ua.goit.timonov.hometask_03.flowers;

public class Tulip extends Flower {

    public Tulip() {
        super("red, yellow, orange");
        mName = "tulip";
    }

    @Override
    public void smell() {
        System.out.println("Tulip smells beautiful.");
    }
}
