package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.doccreator.*;
import uk.co.rodderscode.mdpp.Line;
import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;
import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mdpp {

    private String filename     = null;
    private File inputFile      = null;
    private List<Line> AST      = new ArrayList<>();
    private SpecialDocument document; // The final output document



    public Mdpp(String filename) throws NotValidMdppFile {
        this.filename = filename;
        if( !isMarkdown() )
            throw new NotValidMdppFile("File is not valid markdown file (.md)");
        inputFile = new File(filename);
    }

    /**
     * Checks if the file has a valid .md extension
     * @return boolean
     */
    private Boolean isMarkdown() {
        int dotIndex = filename.lastIndexOf(".")+1; //otherwise the dot will be included
        String extension = filename.substring(dotIndex);
        return extension.equals("md");
    }

    /**
     * Lexical and Syntax Frontend Production
     * @throws FileNotFoundException
     */
    public void parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);


        int lineNum = 0;
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            Lexer lexer = new Lexer();
            AST.add(lexer.tokenize(next, lineNum++));
        }

//        Printer.pl(AST);
    }


    public void compile() {}

    private void read(Line line){}


}
