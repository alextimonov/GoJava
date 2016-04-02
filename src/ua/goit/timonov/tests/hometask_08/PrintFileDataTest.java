package ua.goit.timonov.tests.hometask_08;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_03.filesystem.*;
import ua.goit.timonov.hometask_08.PrintFileData;

import static org.junit.Assert.*;

/**
 * Testing class for PrintFileData
 */
public class PrintFileDataTest {
    File file;

    @Test
    public void testPrintNormal_1() {
        file = new TextFile("readme");
        String actual = PrintFileData.print(file);
        String expected = "| TextFile       | readme.txt          |";
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintNormal_2() {
        file = new AudioFile("music");
        String actual = PrintFileData.print(file);
        String expected = "| AudioFile      | music.mp3           |";
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintNormal_3() {
        file = new ImageFile("picture");
        String actual = PrintFileData.print(file);
        String expected = "| ImageFile      | picture.png         |";
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintNormal_4() {
        file = new File("suspicious");
        String actual = PrintFileData.print(file);
        String expected = "| File           | suspicious.         |";
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintBorder_1() {
        file = new File("");
        String actual = PrintFileData.print(file);
        String expected = "| File           | .                   |";
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void testPrintAbnormal_1() {
        file = null;
        String actual = PrintFileData.print(file);
    }
}