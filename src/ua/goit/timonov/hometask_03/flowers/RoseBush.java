package ua.goit.timonov.hometask_03.flowers;

import java.util.ArrayList;
import java.util.List;

public class RoseBush {
    private List<Rose> mRoseList;

    public RoseBush() {
        mRoseList = new ArrayList<>();
    }

    public void add(Rose rose) {
        mRoseList.add(rose);
    }

    public void output() {
        System.out.println("Here is the rose bush...");
        for (Rose rose : mRoseList) {
            rose.showColor();
            System.out.println("It has " + rose.getmThorn() + " thorns.");
            System.out.println();
        }
    }
}
