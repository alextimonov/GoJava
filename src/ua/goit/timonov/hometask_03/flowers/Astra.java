package ua.goit.timonov.hometask_03.flowers;

public class Astra extends Flower {
    public Astra() {
        super("pink");
        mName = "astra";
    }

    @Override
    public void smell() {
        System.out.println("Astra smells not bad.");
    }
}
