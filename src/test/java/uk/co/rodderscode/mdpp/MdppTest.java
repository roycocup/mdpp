package uk.co.rodderscode.mdpp;

import org.junit.Before;
import org.junit.Test;
import uk.co.rodderscode.utils.Printer;

import static org.junit.Assert.*;


public class MdppTest {


    String filename1 = "mockup.md";
    Mdpp mdPlusPlus = null;

    @Before
    public void before(){

        try{
            mdPlusPlus = new Mdpp(filename1);
        }catch (Exception e){
            Printer.err("Error constructing mdPlusPlus");
        }
    }

    @Test
    public void testSetFilename() throws Exception {
        assertNotNull("Variable for filename should not be null", mdPlusPlus.getFilename());
        assertEquals("Filename should be "+filename1.toString(), filename1, mdPlusPlus.getFilename());
    }

    @Test
    public void testGetFilename() throws Exception {
        String somefilename = "another.md";
        mdPlusPlus.setFilename(somefilename);
        assertEquals("Filename should be the same", somefilename, mdPlusPlus.getFilename());
    }

    @Test
    public void testIsMarkdown() throws Exception {
        assertTrue("Input file has md extension", mdPlusPlus.isMarkdown());

        mdPlusPlus.setFilename("something.tar.md");
        assertTrue("Files with more than one dot are not handled", mdPlusPlus.isMarkdown());
    }

    @Test
    public void testParse() throws Exception {

    }
}