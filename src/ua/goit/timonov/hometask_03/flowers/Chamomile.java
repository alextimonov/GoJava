package ua.goit.timonov.hometask_03.flowers;

public class Chamomile extends Flower {
    public Chamomile() {
        super("white with yellow");
        mName = "chamomile";
    }

    @Override
    public void smell() {
        System.out.println("Chamomile almost doesn't smell.");
    }
}
