package ua.goit.timonov.hometask_03.flowers;

import java.util.ArrayList;
import java.util.List;

public class BouquetOfFlowers {
    private List<Flower> mBouquet;

    public BouquetOfFlowers() {
        mBouquet = new ArrayList<>();
    }

    public void output() {
        System.out.println("Here is the bouquet of flowers...");
        for (Flower flower : mBouquet) {
            flower.smell();
            flower.showColor();
            System.out.println();
        }
    }

    public void add(Flower flower) {
        mBouquet.add(flower);
    }
}
