package ua.goit.timonov.tests.hometask_08;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_03.filesystem.*;
import ua.goit.timonov.hometask_08.PrintDirectoryContent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing class for PrintDirectoryContent
 */
public class PrintDirectoryContentTest {
    Directory dir;

    @Before
    public void setUp() throws Exception {
        dir = new Directory("Sundry");
        dir.addFile(new File("presentation", "ppt"));
        dir.addFile(new TextFile("readme"));
        dir.addFile(new TextFile("text"));
        dir.addFile(new AudioFile("music"));
        dir.addFile(new ImageFile("picture"));
        dir.addFile(new File("suspicious"));
    }

    @Test
    public void testMakeListOfStringsToPrintNormal() {
        List<String> actual = PrintDirectoryContent.makeListOfStringsToPrint(dir);
        List<String> expected = new ArrayList<>();
        expected.add("| File           | presentation.ppt    |");
        expected.add("| TextFile       | readme.txt          |");
        expected.add("| TextFile       | text.txt            |");
        expected.add("| AudioFile      | music.mp3           |");
        expected.add("| ImageFile      | picture.png         |");
        expected.add("| File           | suspicious.         |");
        assertEquals(expected, actual);
    }

    @Test
    public void testMakeListOfStringsToPrintSorted() {
        dir.sortFilesByName();
        List<String> actual = PrintDirectoryContent.makeListOfStringsToPrint(dir);
        List<String> expected = new ArrayList<>();
        expected.add("| AudioFile      | music.mp3           |");
        expected.add("| ImageFile      | picture.png         |");
        expected.add("| File           | presentation.ppt    |");
        expected.add("| TextFile       | readme.txt          |");
        expected.add("| File           | suspicious.         |");
        expected.add("| TextFile       | text.txt            |");
        assertEquals(expected, actual);
    }
}