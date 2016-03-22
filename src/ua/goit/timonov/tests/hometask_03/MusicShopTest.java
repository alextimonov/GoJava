package ua.goit.timonov.tests.hometask_03;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_03.musicalinstruments.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Testing class for class MusicShop
 */
public class MusicShopTest {
    MusicShop shop = new MusicShop();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPrepareInstrumentsNormal_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(2, 3, 6);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 2);
        order.put("trumpet", 1);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Piano());
        expected.add(new Trumpet());
        expected.add(new Guitar());
        expected.add(new Guitar());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    private void createListOfInstrumentsInShop(int nPianos, int nGuitars,  int nTrumpets) {
        for (int i = 0; i < nPianos ; i++) {
            shop.addInstrumentToList(new Piano());
        }
        for (int i = 0; i < nGuitars ; i++) {
            shop.addInstrumentToList(new Guitar());
        }
        for (int i = 0; i < nTrumpets ; i++) {
            shop.addInstrumentToList(new Trumpet());
        }
    }

    @Test
    public void testPrepareInstrumentsNormal_2() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 4, 2);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Piano());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test
    public void testPrepareInstrumentsBorder_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 2);
        order.put("trumpet", 1);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Piano());
        expected.add(new Trumpet());
        expected.add(new Guitar());
        expected.add(new Guitar());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPrepareInstrumentsAbnormal_1() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 2);
        order.put("guitar", 3);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Trumpet());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = WrongInstrumentNameException.class)
    public void testPrepareInstrumentsAbnormal_2() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("pianino", 2);
        order.put("Guitar", 3);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Trumpet());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }

    @Test (expected = WrongInstrumentNumberException.class)
    public void testPrepareInstrumentsAbnormal_3() throws WrongInstrumentNameException, WrongInstrumentNumberException {
        createListOfInstrumentsInShop(1, 2, 1);
        Map<String, Integer> order = new HashMap<>();
        order.put("piano", 1);
        order.put("guitar", 0);
        order.put("trumpet", 1);
        List<MusicalInstrument> expected = new ArrayList<MusicalInstrument>();
        expected.add(new Trumpet());
        List<MusicalInstrument> boughtInstruments = shop.prepareInstruments(order);
        assertEquals(expected, boughtInstruments);
    }
}
