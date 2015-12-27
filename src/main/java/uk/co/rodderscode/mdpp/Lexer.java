package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.mdpp.exceptions.Line;
import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();


    public Lexer() {}

    public Line tokenize(String str, int lineNum) {
        MdppScanner scanner = new MdppScanner(str);
        while (scanner.hasNext()) {
            char c = scanner.readNext();
            convertToToken(c);
        }

        Syntax type = (tokens.size() > 0) ? tokens.get(0).getToken() : Syntax.WHITESPACE;

        Line line = new Line(type, lineNum, str, tokens);
        return line;
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


}
