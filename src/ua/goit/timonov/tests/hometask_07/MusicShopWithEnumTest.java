package ua.goit.timonov.tests.hometask_07;

import org.junit.Test;
import ua.goit.timonov.hometask_03.musicalinstruments.*;
import ua.goit.timonov.hometask_07.MusicShopWithEnum;
import ua.goit.timonov.hometask_07.TypesOfInstruments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for class MusicShopWithEnum
 */
public class MusicShopWithEnumTest {
    MusicShopWithEnum shop = new MusicShopWithEnum();

    @Test
    public void testPrepareInstrumentsNormal_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(2, 3, 6);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 2);
        order.put("trumpet", 1);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.PIANO);
        expected.add(TypesOfInstruments.TRUMPET);
        expected.add(TypesOfInstruments.GUITAR);
        expected.add(TypesOfInstruments.GUITAR);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    private void createListOfInstrumentsInShop(int nPianos, int nGuitars,  int nTrumpets) {
        for (int i = 0; i < nPianos ; i++) {
            shop.addInstrumentToList(TypesOfInstruments.PIANO);
        }
        for (int i = 0; i < nGuitars ; i++) {
            shop.addInstrumentToList(TypesOfInstruments.GUITAR);
        }
        for (int i = 0; i < nTrumpets ; i++) {
            shop.addInstrumentToList(TypesOfInstruments.TRUMPET);
        }
    }

    @Test
    public void testPrepareInstrumentsNormal_2() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 4, 2);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.PIANO);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test
    public void testPrepareInstrumentsBorder_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 2);
        order.put("trumpet", 1);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.PIANO);
        expected.add(TypesOfInstruments.TRUMPET);
        expected.add(TypesOfInstruments.GUITAR);
        expected.add(TypesOfInstruments.GUITAR);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrepareInstrumentsAbnormal_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 2);
        order.put("guitar", 3);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.TRUMPET);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = WrongInstrumentNameException.class)
    public void testPrepareInstrumentsAbnormal_2() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("pianino", 2);
        order.put("Guitar", 3);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.TRUMPET);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = WrongInstrumentNumberException.class)
    public void testPrepareInstrumentsAbnormal_3() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 0);
        order.put("trumpet", 1);
        List<TypesOfInstruments> expected = new ArrayList<TypesOfInstruments>();
        expected.add(TypesOfInstruments.TRUMPET);
        List<TypesOfInstruments> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }
}
