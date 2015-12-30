package uk.co.rodderscode.mdpp;

import java.util.ArrayList;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();
    MdppScanner scanner;

    public Lexer() {}

    public Line tokenize(String str, int lineNum) {
        scanner = new MdppScanner(str);
        while (scanner.hasNext()) {
            char c = scanner.readNext();
            convertToToken(c);
        }

        Syntax type = (tokens.size() > 0) ? tokens.get(0).getToken() : Syntax.NULL;

        Line line = new Line(type, lineNum, str, tokens);
        return line;
    }

    private void convertToToken(Character c) {


    }


}
