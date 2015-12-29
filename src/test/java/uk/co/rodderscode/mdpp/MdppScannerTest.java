package uk.co.rodderscode.mdpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rodrigo on 29/12/2015.
 */
public class MdppScannerTest {
    MdppScanner scanner;
    String str = "this is the string";

    @Before
    public void setUp() throws Exception {
        scanner = new MdppScanner(str);
    }

    @After
    public void destroy(){
        scanner = null;
    }

    @Test
    public void testSetString() throws Exception {
        String testString = "this is a test string";
        scanner.setString(testString);
        assertEquals(testString, scanner.getString());
    }

    @Test
    public void testHasNext() throws Exception {
        assertTrue(scanner.hasNext());
    }

    @Test
    public void testReadNext() throws Exception {
        assertEquals(str.charAt(0), scanner.readNext());
        assertEquals(str.charAt(1), scanner.readNext());
        assertEquals(str, scanner.getString());
    }

    @Test
    public void testReadPrev() throws Exception {
        scanner.readNext();
        assertEquals(str.charAt(0), scanner.readPrev());
    }

    @Test
    public void testGetPosition() throws Exception {
        assertEquals(0, scanner.getPosition());
    }

    @Test
    public void testGetSize() throws Exception {
        assertEquals(str.length(), scanner.getSize());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(str.charAt(0), scanner.get(0));
        int lastChar = str.length()-1;
        assertEquals(str.charAt(lastChar), scanner.get(lastChar));
    }
    
}