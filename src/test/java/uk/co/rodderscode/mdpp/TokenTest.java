package uk.co.rodderscode.mdpp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rodrigodias on 28/12/2015.
 */
public class TokenTest {

    Token token;
    Character c = 'c';
    Syntax s = Syntax.CHARACTER;

    @Before
    public void setUp() throws Exception {

        token = new Token(c, s);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(token.getValue(), c);
    }

    @Test
    public void testGetToken() throws Exception {
        assertEquals(token.getToken(), s);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(s.toString(), token.toString());
    }
}