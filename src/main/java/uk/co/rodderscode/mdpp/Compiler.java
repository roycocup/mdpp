package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.List;


public class Compiler {

    private List<Node> AST = new ArrayList<>();


    public Compiler() {}

    public void setAST(List<Node> AST) {
        this.AST = AST;
    }

    void read(){
        //Printer.pl(AST);
        for (Node n : AST) {
            Printer.pl("This is a: " + n.getType() + " Find: " + n.getValue());
            if (n.getType() == Node.NodeType.EXPRESSION)
                Printer.pl("This is also an: " + n.getToken().toString());
        }
    }


}
