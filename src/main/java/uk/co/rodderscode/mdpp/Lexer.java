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

        for (Syntax s : allSyntaxes) {
            Matcher matcher = s.getPattern().matcher(str);

            // merge all the matches into one expression only
            while (matcher.find())
                expression.append(matcher.group());

            node.setLineNum(lineNum);
            if (expression.length() > 0) {
                node.setValue(expression.toString());
                node.setType(Node.NodeType.EXPRESSION);
            } else {
                node.setValue("\n");
                node.setType(Node.NodeType.NEWLINE);
            }
            node.setOriginal(str);

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
