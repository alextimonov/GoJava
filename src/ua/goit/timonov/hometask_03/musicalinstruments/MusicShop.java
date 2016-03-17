package ua.goit.timonov.hometask_03.musicalinstruments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Class MusicShop provides musical shop with different types of musical instruments.
*
*/
public class MusicShop {
    /* String names of stored instruments */
    private static final String[] instrumentNames = {"piano", "guitar", "trumpet"};

    /* Map with key - type of musical instrument and value - available quantity of that instrument */
    private Map <MusicalInstrument, Integer> instrumentsMap;

    /* Default constructor */
    public MusicShop() {
        instrumentsMap = new HashMap<>();
    }

    /**
     * Adds entry of next instrument type
     * @param instrument    type of musicalInstrument to be added
     * @param nInstruments  its quantity
     */
    public void addInstrumentToMap(MusicalInstrument instrument, int nInstruments) {
        instrumentsMap.put(instrument, nInstruments);
    }

    /**
    * Prepares the consignment of instruments due to given order.
    * Decreases quantity of instruments for number of prepared instruments
    * @param order      order with entries: string name of instrument and its number
    * @return           list of prepared instruments
    */
    public List <MusicalInstrument> prepareInstruments(Map<String, Integer> order)
            throws WrongInstrumentNameException, WrongInstrumentNumberException {
        int pianosToPrepare = 0;
        int guitarsToPrepare = 0;
        int trumpetsToPrepare = 0;

        checkOrder(order);
        for (String instrument : order.keySet()) {
            switch (instrument) {
                case "piano":
                    pianosToPrepare = order.get(instrument);
                    break;
                case "guitar":
                    guitarsToPrepare = order.get(instrument);
                    break;
                case "trumpet":
                    trumpetsToPrepare = order.get(instrument);
                    break;
                /*default:
                    // NOP
                    break;*/
            }
        }
        checkOnBalances(pianosToPrepare, guitarsToPrepare, trumpetsToPrepare);
        subtractInstruments(pianosToPrepare, guitarsToPrepare, trumpetsToPrepare);
        return createListOfPreparedInstuments(pianosToPrepare, guitarsToPrepare, trumpetsToPrepare);
    }

    // Creates resulting list of prepared instruments
    private List<MusicalInstrument> createListOfPreparedInstuments
            (int pianosToPrepare, int guitarsToPrepare, int trumpetsToPrepare) {
        List<MusicalInstrument> resultList = new ArrayList<>();
        for (int i = 0; i < pianosToPrepare; i++) {
            resultList.add(new Piano());
        }
        for (int i = 0; i < guitarsToPrepare; i++) {
            resultList.add(new Guitar());
        }
        for (int i = 0; i < trumpetsToPrepare; i++) {
            resultList.add(new Trumpet());
        }
        return resultList;
    }

    // Subtracts the number of prepared instruments out of current balance
    private void subtractInstruments(int pianosToPrepare, int guitarsToPrepare, int trumpetsToPrepare) {
        for (MusicalInstrument instrument : instrumentsMap.keySet()) {
            if (instrument instanceof Piano) {
                int newValue = instrumentsMap.get(instrument) - pianosToPrepare;
                instrumentsMap.replace(instrument, newValue);
            }
            if (instrument instanceof Guitar) {
                int newValue = instrumentsMap.get(instrument) - guitarsToPrepare;
                instrumentsMap.replace(instrument, newValue);
            }
            if (instrument instanceof Trumpet) {
                int newValue = instrumentsMap.get(instrument) - trumpetsToPrepare;
                instrumentsMap.replace(instrument, newValue);
            }
        }
    }

    // Checks if there is enough instruments in the shop for each type
    // throws IllegalArgumentException if there is not
    private void checkOnBalances(int pianosToPrepare, int guitarsToPrepare, int trumpetsToPrepare) {
        for (MusicalInstrument instrument : instrumentsMap.keySet()) {
            if (instrument instanceof Piano && pianosToPrepare > instrumentsMap.get(instrument))
                throw new IllegalArgumentException("There's not enough pianos!");
            if (instrument instanceof Guitar && guitarsToPrepare > instrumentsMap.get(instrument))
                throw new IllegalArgumentException("There's not enough guitars!");
            if (instrument instanceof Trumpet && trumpetsToPrepare > instrumentsMap.get(instrument))
                throw new IllegalArgumentException("There's not enough trumpets!");
        }
    }

    // Checks order for proper names in String names of instruments in given order.
    // If it isn't, throws WrongInstrumentNameException
    // Also checks if it's positive number of required instruments.
    // If it isn't, throws WrongInstrumentNumberException
    private void checkOrder(Map<String, Integer> order)
            throws WrongInstrumentNameException, WrongInstrumentNumberException {
        for (String instrument : order.keySet()) {
            checkInstrumentName(instrument);
        }
        for (String instrument : order.keySet()) {
            if (order.get(instrument) <= 0)
                throw new WrongInstrumentNumberException("There is wrong number of " + instrument +
                        ", it should be positive integer.");
        }
    }

    // Checks if given String name is in the instrumentNames
    // If it isn't, throws WrongInstrumentNameException
    private void checkInstrumentName(String instrument) throws WrongInstrumentNameException {
        boolean foundProperName = false;
        int i = 0;
        while (!foundProperName && i < instrumentNames.length) {
            if (instrument == instrumentNames[i++]) {
                foundProperName = true;
            }
        }
        if (!foundProperName) {
            throw new WrongInstrumentNameException("There is wrong instrument name in the order: " + instrument);
        }
    }

    // Outputs current balances of instruments to console
    public void output() {
        for (MusicalInstrument instrument : instrumentsMap.keySet()) {
            instrument.play();
            System.out.println(instrumentsMap.get(instrument) + " times");
        }
    }
}