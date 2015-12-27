package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.doccreator.*;
import uk.co.rodderscode.mdpp.exceptions.Line;
import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;
import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mdpp {

    private String filename = null;
    private File inputFile = null;
    private SpecialDocument document;

    private List<Line> AST = new ArrayList<>();

    public Mdpp(String filename) throws NotValidMdppFile {
        setFilename(filename);
        if( !isMarkdown() )
            throw new NotValidMdppFile("File is not valid markdown file (.md)");
    }


    public void setFilename(String filename) {this.filename = filename;}

    public String getFilename() {return this.filename;}

    /**
     * Checks if the file has a valid .md extension
     * @return boolean
     */
    private Boolean isMarkdown() {
        int dotIndex = filename.lastIndexOf(".")+1; //otherwise the dot will be included
        String extension = filename.substring(dotIndex);
        return extension.equals("md");
    }

    private void loadInputFile() {
        inputFile = new File(filename);
    }


    /**
     * Lexical and Syntax Frontend Analysis
     * @throws FileNotFoundException
     */
    public void parse() throws FileNotFoundException {
        loadInputFile();

        Scanner scanner = new Scanner(inputFile);

        int lineNum = 0;
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            Lexer lexer = new Lexer();
            AST.add(lexer.tokenize(next, lineNum++));
        }

//        Printer.pl(AST);
    }


    public void compileTo(TargetType type){
        //TODO: support other types
        compile();
    }

    public void compile() {
        document = SpecialDocFactory.getInstance(TargetType.HTML);
        Iterator<Line> iterator = AST.iterator();
        // Line by line
        while(iterator.hasNext()){
            // Get a tokenized line
            Line line = iterator.next();
            synthesize(line);
        }

        Printer.pl(document.getFinal());
    }

    private void synthesize(Line line) {

        Printer.pl(line.getLineNumber()+" "+line.getTokens().toString());

    }


}
