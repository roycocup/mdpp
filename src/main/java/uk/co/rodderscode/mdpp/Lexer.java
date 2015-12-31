package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();


    public Node tokenize(String str, int lineNum) {
        // If this is an empty line (a line break)
            // create a node that represents a line break


        boolean i = str.matches("[\\n\\r]+");
        if (i)
            Printer.pl(str+" "+i);

        // check the grammar for existence of rules.
        List<Syntax> allSyntaxes = Syntax.getAll();

        for (Syntax s : allSyntaxes) {
            Matcher m = s.getPattern().matcher(str);
            boolean b = m.matches();
            if (b) {
//                Printer.pl("Name: " + s.getName());
//                Printer.pl("Pattern: "+s.getPattern());
            }
        }

        /*
        MdppScanner scanner = new MdppScanner(str);
        while (scanner.hasNext()) {
            char c = scanner.readNext();
            convertToToken(c);
        }
        Syntax type = (tokens.size() > 0) ? tokens.get(0).getToken() : Syntax.NEWLINE;
        Node node = new Node(type, lineNum, str, tokens);
        */
        Node node = new Node();
        return node;
    }

    private void convertToToken(Character c) {}

}
