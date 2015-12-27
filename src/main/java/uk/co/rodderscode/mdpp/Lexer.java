package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.Map;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();

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
                tokens.add(new Token(c, Syntax.WHITESPACE));
                break;
            case '#':
                tokens.add(new Token(c, Syntax.TITLE));
                break;
            case '*':
                tokens.add(new Token(c, Syntax.LIST));
                break;
            default:
                if (Character.isDigit(c) == true){
                    tokens.add(new Token(c, Syntax.INTEGER));
                } else if (Character.isLetter(c)){
                    tokens.add(new Token(c, Syntax.CHARACTER));
                    break;
                } else {
                    int type = Character.getType(c);
                    if (type == Character.END_PUNCTUATION) {
                        tokens.add(new Token(c, Syntax.PUNCTUATION));
                        break;
                    } else if (type == Character.OTHER_PUNCTUATION){
                        tokens.add(new Token(c, Syntax.PUNCTUATION));
                        break;
                    }else{
                        Printer.log("found type: "+type+" when tokenizing string");
                        tokens.add(new Token(c, Syntax.WEIRD_SHIT));
                        break;
                    }
                }
                break;
        }
    }


    ArrayList<Token> getTokenized(){
        return tokens;
    }

}
