package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.doccreator.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Mdpp {
    private File inputFile      = null;
    private List<Node> AST      = new ArrayList<>();
    private SpecialDocument document; // The final output document


    /**
     * Constructor
     * @param file
     */
    public Mdpp(File file) {
        inputFile = file;
    }

    /**
     * Lexical and Syntax Frontend Production
     * @throws FileNotFoundException
     */
    public void parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        //paragraphs
        scanner.useDelimiter(Pattern.compile("\\n"));
        // get the parser
        Lexer lexer = new Lexer();

        int lineNum = 0;
        while(scanner.hasNext()){
            String paragraph = scanner.next();
            AST.add(lexer.tokenize(paragraph, lineNum++));
        }

//        Printer.pl(AST);
    }


    public void compile() {}

    private void read(Node line){}


}
