package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Lexer {

    ArrayList<Syntax> tokens = new ArrayList<>();

    public Lexer() {}


    public void tokenize(String str) {
        MdppScanner scanner = new MdppScanner(str);
        while (scanner.hasNext() == true) {
            char c = scanner.readNext();
            convertToToken(c);
        }

    }

    private void convertToToken(Character c) {
        switch (c){
            case ' ':
                tokens.add(Syntax.WHITESPACE);
                break;
            case '#':
                tokens.add(Syntax.TITLE);
                break;
            case '*':
                tokens.add(Syntax.LIST);
                break;
            default:
                tokens.add(Syntax.CHARACTER);
                break;
        }
    }


    String getTokenized(){
        return tokens.toString();
    }


    enum Syntax{
        WHITESPACE,
        CHARACTER,
        TITLE,
        LIST,
    }
}
