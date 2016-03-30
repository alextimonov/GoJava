package ua.goit.timonov.tests.hometask_08;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_03.filesystem.*;
import ua.goit.timonov.hometask_08.PrintTableWithFileData;

import static org.junit.Assert.*;

/**
 * Testing class for PrintTableWithFileData
 */
public class PrintTableWithFileDataTest {
    Directory dir;

    @Before
    public void setUp() {
        dir = new Directory("Sundry");
        dir.addFile(new File("presentation", "ppt"));
        dir.addFile(new TextFile("readme"));
        dir.addFile(new TextFile("text"));
        dir.addFile(new AudioFile("music"));
        dir.addFile(new ImageFile("picture"));
        dir.addFile(new File("suspicious"));
    }

    @Test
    public void testTableHeaderNormal_1() {
        String actual = PrintTableWithFileData.tableHeader
                ("DIRECTORY " + dir.getDirName() + " contains next files:");
        String expected = "| DIRECTORY Sundry contains next files:|";
        assertEquals(expected, actual);
    }

    @Test
    public void testTableColumnNamesNormal_1() {
        String actual = PrintTableWithFileData.tableColumnNames();
        String expected = "| Name of class  | Filename.Extnsn     |";
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintHyphensNormal_1() {
        String actual = PrintTableWithFileData.printHyphens();
        String expected = "----------------------------------------";
        assertEquals(expected, actual);
    }
}