package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    ArrayList<Token> tokens = new ArrayList<>();


    public Node tokenize(String str, int lineNum) {

        // Get all rules from Grammar
        List<Syntax> allSyntaxes = Syntax.getAll();

        // This will hold the expressions caught by the regex
        StringBuilder expression = new StringBuilder();

        // The final return node
        Node node = new Node();
        node.setLineNum(lineNum);
        node.setOriginal(str);

        // Catch newlines
        if (str.length() < 1 ) {
            node.setType(Node.NodeType.NEWLINE);
            node.setValue("\n");
        }

        for (Syntax s : allSyntaxes) {
            Matcher matcher = s.getPattern().matcher(str);

            // merge all the matches into one expression only
            while (matcher.find())
                expression.append(matcher.group());

            if (expression.length() > 0) {
                node.setType(Node.NodeType.EXPRESSION);
                node.setValue(expression.toString());
            }
        }

        // If at this point a node is still not set this may be just simple text
        if (node.getValue() == null){
            node.setType(Node.NodeType.TEXT);
            node.setValue(str);
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

        // There should not be more that one node to return
        return node;

    }

    private void convertToToken(Character c) {}

}
