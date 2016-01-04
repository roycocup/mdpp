package uk.co.rodderscode.mdpp;

import uk.co.rodderscode.doccreator.*;
import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;

public class Mdpp {
    private File inputFile      = null;
    private File outputFile     = null;
    private List<Node> AST      = new ArrayList<>();
    private SpecialDocument document; // The final output document


    /**
     * Constructor
     * @param inputFile
     * @param outputFile
     */
    public Mdpp(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
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

    }


    public void compile() {
        Compiler compiler = new Compiler();
        compiler.setAST(AST);
        compiler.read();
        document = compiler.getFinal();
        write();
    }

    private void write() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outputFile, "UTF-8");
            writer.write(document.getFinal());
            Printer.pl("Job done!");
        }catch(FileNotFoundException | UnsupportedEncodingException e){
            System.err.println(Arrays.toString(e.getStackTrace()));
        }finally {
            if (writer != null)
                writer.close();
        }

    }


}
