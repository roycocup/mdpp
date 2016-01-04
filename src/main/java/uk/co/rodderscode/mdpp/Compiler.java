package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.doccreator.SpecialDocFactory;
import uk.co.rodderscode.doccreator.SpecialDocument;
import uk.co.rodderscode.doccreator.TargetType;
import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Compiler {

    private List<Node> AST = new ArrayList<>();
    private SpecialDocument document = SpecialDocFactory.getInstance(TargetType.HTML);
    private ArrayList<String> list = new ArrayList<>();

    public Compiler() {}

    public void setAST(List<Node> AST) {this.AST = AST;}

    void read(){
        Boolean listOpen = false;

        for (Node n : AST) {
            // if its simple text, just add text
            if (n.getType() == Node.NodeType.TEXT)
                document.text(n.getValue());
            // if its a new line add it too
            if (n.getType() == Node.NodeType.NEWLINE)
                document.text(n.getValue());
            // if its an expression
            if (n.getType() == Node.NodeType.EXPRESSION){
                // if a list has been open
                if (listOpen) {
                    // is this another element for the list (<li>)
                    if (n.getToken() == Syntax.OLIST || n.getToken() == Syntax.ULIST ) {
                        // yes = add new element to list
                        list.add(n.getOriginal().substring(n.getValue().length()));
                    } else {
                        // no - close list
                        document.list(list);
                        listOpen = false;
                    }
                }
                // is it a title
                if (n.getToken() == Syntax.HEADER) {
                    // regex how many symbols it has
                    int counter = 0;
                    for (char c : n.getValue().toCharArray()){
                        if (c == '#')
                            counter++;
                        else
                            break; // break out of the loop if the next successive symbol is not a header
                    }
                    // add to title with number of symbols
                    document.title(
                            // removing the initial characters for the header
                            n.getOriginal().substring(counter),
                            counter
                    );

                }
                // is it a list
                if (n.getToken() == Syntax.ULIST || n.getToken() == Syntax.OLIST ) {
                    // open a list tag and include this one
                    list.add(n.getOriginal().substring(n.getValue().length()));
                    listOpen = true;
                }
                // is it a link
                if (n.getToken() == Syntax.HREF) {
                    // add to link with the anchor wrapping the words
                }

                // is it s reference to a link
                if (n.getToken() == Syntax.REFERENCE) {

                }

                // is it defined reference link
                if (n.getToken() == Syntax.REFERENCE_LINK) {
                    // if this reference exist already throw error
                }

            }

        }

        Printer.pl(document.getFinal());
    }


}
