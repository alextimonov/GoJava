package ua.goit.timonov.hometask_03.musicalinstruments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicalInstrumentRunner {
    public static void main(String[] args) {
        MusicShop musicShop = new MusicShop();

        int nPianos = 2;
        int nGuitars = 16;
        int nTrumpets = 7;
        musicShop.addInstrumentToMap(new Piano(), nPianos);
        musicShop.addInstrumentToMap(new Guitar(), nGuitars);
        musicShop.addInstrumentToMap(new Trumpet(), nTrumpets);
        System.out.println("Current balances in music shop are: ");
        musicShop.output();

        Map<String, Integer> order = new HashMap<>();
        order.put("guitar", 7);
        order.put("trumpet", 2);
        makeOrder(musicShop, order);

        order = new HashMap<>();
        order.put("piano", 1);
        makeOrder(musicShop, order);

        order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 8);
        order.put("trumpet", 6);
        makeOrder(musicShop, order);
    }

    private static void makeOrder(MusicShop musicShop, Map<String, Integer> order) {
        System.out.println("Order is: ");
        System.out.println(order);

        try {
            List<MusicalInstrument> boughtInstruments = musicShop.prepareInstruments(order);
            System.out.println("Bought instruments: ");
            for (MusicalInstrument boughtInstrument : boughtInstruments) {
                boughtInstrument.play();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println();
        System.out.println("Current balances in music shop are: ");
        musicShop.output();
    }
}
