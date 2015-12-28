package uk.co.rodderscode.mdpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rodrigodias on 28/12/2015.
 */
public class LineTest {

    Lexer lexer;
    Line line;
    String str;

    @Before
    public void setUp() throws Exception {
        lexer = new Lexer();
        str = "this is the original content";
        line = new Line(Syntax.CHARACTER, 0, str, lexer.tokenize(str, 0).getTokens());
    }


    @Test
    public void testGetType() throws Exception {
        assertEquals(Syntax.CHARACTER, line.getType());
    }

    @Test
    public void testGetLineNumber() throws Exception {
        assertEquals(line.getLineNumber(), 0);
    }

    @Test
    public void testGetOrigContent() throws Exception {
        assertEquals(str, line.getOrigContent());
    }

    @Test
    public void testGetTokens() throws Exception {
        assertEquals(lexer.tokenize(str, 0).getTokens(), line.getTokens());
    }
}