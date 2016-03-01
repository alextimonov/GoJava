package ua.goit.timonov.hometask_03.flowers;

public class Rose extends Flower {

    private int mThorn;

    public Rose() {
        super("red, yellow, white");
        mName = "rose";
    }

    public Rose(int mBarbs) {
        this();
        this.mThorn = mBarbs;
    }

    public int getmThorn() {
        return mThorn;
    }

    @Override
    public void smell() {
        System.out.println("Rose smells magnificent!");
    }
}
