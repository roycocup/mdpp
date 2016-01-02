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

    public Compiler() {}

    public void setAST(List<Node> AST) {this.AST = AST;}

    void read(){
        Boolean listOpen = false;

        for (Node n : AST) {
            // if its simple text, just add text
            // if its a new line add it too
            // if its an expression
                // if a list has been open
                    // is this another element for the list
                        // if yes
                            // add new element to list
                        // if no
                            // close list

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
                            n.getOriginal().substring(counter),
                            counter
                    );

                }

                // is it a list
                    // open a list tag
                    // include this one
                // is it a link
                    // add to link with the anchor wrapping the words
                // is it reference link
                    // if this reference exist already throw error

        }

        Printer.pl(document.getFinal());
    }


}
