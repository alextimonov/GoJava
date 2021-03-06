package ua.goit.timonov.hometask_07;

import ua.goit.timonov.hometask_03.musicalinstruments.WrongInstrumentNameException;
import ua.goit.timonov.hometask_03.musicalinstruments.WrongInstrumentNumberException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* Class MusicShopWithEnum provides musical shop with different types of musical instruments.
*/
public class MusicShopWithEnum {
    /* List of musical instruments in the shop */
    private List <TypesOfInstruments> instrumentsList;

    /* Default constructor */
    public MusicShopWithEnum() {
        instrumentsList = new ArrayList<>();
    }

    /**
     * Adds entry of next instrument type
     * @param instrument    type of musicalInstrument to be added
     */
    public void addInstrumentToList(TypesOfInstruments instrument) {
        instrumentsList.add(instrument);
    }

    /**
    * Prepares the consignment of instruments due to given order.
    * Decreases quantity of instruments for number of prepared instruments
    * @param order      order with entries: string name of instrument and its number
    * @return           list of prepared instruments
    */
    public List <TypesOfInstruments> prepareInstruments(Map<String, Integer> order)
            throws WrongInstrumentNameException, WrongInstrumentNumberException {
        checkOrder(order);
        checkOnBalances(order);
        return createListOfPreparedInstuments(order);
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

    // Checks if there is enough instruments in the shop for each type
    // throws IllegalArgumentException if there is not
    private void checkOnBalances(Map<String, Integer> order) {

        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String orderedInstrument = orderEntry.getKey();
            Integer numberOfOrderedInstruments = orderEntry.getValue();
            int numberOfInstrumentsInShop = 0;
            for (TypesOfInstruments instrument : instrumentsList) {
                if (instrument.toString().equalsIgnoreCase(orderedInstrument))
                    numberOfInstrumentsInShop++;
            }
            if (numberOfInstrumentsInShop < numberOfOrderedInstruments) {
                throw new IllegalArgumentException("There's not enough " + orderedInstrument +"s!");
            }
        }
    }

    // Creates resulting list of prepared instruments
    private List<TypesOfInstruments> createListOfPreparedInstuments(Map<String, Integer> order) {

        List<TypesOfInstruments> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String orderedInstrument = orderEntry.getKey();
            Integer numberOfOrderedInstruments = orderEntry.getValue();
            int numberOfInstrumentsRemoved = 0;
            Iterator<TypesOfInstruments> iterator = instrumentsList.iterator();
            while (iterator.hasNext()) {
                TypesOfInstruments instrument = iterator.next();
                if (instrument.toString().equalsIgnoreCase(orderedInstrument) &&
                        numberOfOrderedInstruments > numberOfInstrumentsRemoved) {
                    resultList.add(instrument);
                    iterator.remove();
                    numberOfInstrumentsRemoved++;
                }
            }
        }
        return resultList;
    }

    // Checks if given String name is in the typesOfInstruments
    // If it isn't, throws WrongInstrumentNameException
    private void checkInstrumentName(String instrument) throws WrongInstrumentNameException {
        boolean foundProperName = false;
        int i = 0;
        TypesOfInstruments types[] = TypesOfInstruments.values();
        while (!foundProperName && i < types.length) {
            if (instrument.equalsIgnoreCase(types[i++].toString())) {
                foundProperName = true;
            }
        }
        if (!foundProperName) {
            throw new WrongInstrumentNameException("There is wrong instrument name in the order: " + instrument);
        }
    }
}