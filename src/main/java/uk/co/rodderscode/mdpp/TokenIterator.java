package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.mdpp.Syntax;
import uk.co.rodderscode.mdpp.Token;
import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.Iterator;

public class TokenIterator {

    ArrayList<Token> token  = null;
    int position = 0;

    public TokenIterator(ArrayList<Token> token) {
        this.token = token;
    }

    public Token getNextToken(){
        if (hasNext())
            return token.get(position++);
        return null;
    }

    public Token getPreviousToken(){
        return token.get(--position);
    }

    public Token getCurrentToken(){
        return token.get(position);
    }

    public Token peek(int position){
        return token.get(position);
    }

    public Token lookBack(){
        return token.get(position-1);
    }

    public Boolean hasNext(){
        return ( position < token.size() );
    }

    /**
     * Returns the index the last repeating similar token
     * @param syntaxType
     * @param tempPosition
     * @return
     */
    public int getNextIfSimilar(Syntax syntaxType, int tempPosition) {
        if (peek(tempPosition++).getToken().equals(syntaxType)) {
            getNextIfSimilar(syntaxType, tempPosition++);
        }

        return tempPosition;
    }


    public int getPosition() {
        return position;
    }
}
