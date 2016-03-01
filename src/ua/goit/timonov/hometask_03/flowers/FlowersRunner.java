package ua.goit.timonov.hometask_03.flowers;

public class FlowersRunner {
    public static void main(String[] args) {
        BouquetOfFlowers bouquet = new BouquetOfFlowers();
        Flower flower = new Tulip();
        bouquet.add(flower);
        bouquet.add(new Astra());
        bouquet.add(new Chamomile());
        flower = new Rose();
        bouquet.add(flower);
        bouquet.output();

        RoseBush bush = new RoseBush();
        Rose rose = (Rose) flower;
        bush.add(rose);
        bush.add(new Rose());
        bush.add(new Rose(7));
        bush.add(new Rose(12));
        bush.output();
    }
}
