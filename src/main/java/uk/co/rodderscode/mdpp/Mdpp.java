package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.doccreator.*;
import uk.co.rodderscode.utils.Printer;

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
        // Line by line
        scanner.useDelimiter(Pattern.compile("\\n"));
        // get the parser
        Lexer lexer = new Lexer();

        int lineNum = 0;
        while(scanner.hasNext()){
            String line = scanner.next();
            AST.add(lexer.tokenize(line, lineNum++));
        }

        compile();

    }


    public void compile() {
        Compiler compiler = new Compiler();
        compiler.setAST(AST);
        compiler.read();
    }


}
