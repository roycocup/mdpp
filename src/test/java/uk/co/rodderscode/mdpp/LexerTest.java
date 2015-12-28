package uk.co.rodderscode.mdpp;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import uk.co.rodderscode.mdpp.Line;

import static org.junit.Assert.*;


public class LexerTest {

    Lexer lexer;

    @Before
    public void setUp() throws Exception {
        lexer = new Lexer();
    }

    @Test
    public void testTokenize() throws Exception {
        String str = "this should be good";
        Line line = lexer.tokenize(str, 0);

        assertEquals("There should be 19 tokens in this object", 19 ,line.getTokens().size());
    }
}