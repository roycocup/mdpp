package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();


    public Node tokenize(String str, int lineNum) {
        // If this is an empty line (a line break)
            // create a node that represents a line break

        // check the grammar for existence of rules.

        Printer.pl(str+" "+lineNum);
        MdppScanner scanner = new MdppScanner(str);
        while (scanner.hasNext()) {
            char c = scanner.readNext();
            convertToToken(c);
        }

        Syntax type = (tokens.size() > 0) ? tokens.get(0).getToken() : Syntax.NULL;
        Node node = new Node(type, lineNum, str, tokens);
        return node;
    }

    private void convertToToken(Character c) {}

}
