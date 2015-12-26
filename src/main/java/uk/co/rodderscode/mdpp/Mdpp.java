package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.doccreator.*;
import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;
import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mdpp {

    private String filename = null;
    private File inputFile = null;
    public List<ArrayList<Syntax>> AST = new ArrayList<>();
    private SpecialDocument document;

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


    public void parse() throws FileNotFoundException {
        loadInputFile();

        Scanner scanner = new Scanner(inputFile);
        Lexer lexer = new Lexer();

        int line = 0;
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            lexer.tokenize(next);
            AST.add(lexer.getTokenized());
        }

//        Printer.pl(AST);

    }


    public void compileTo(TargetType type){
        //TODO: support other types
        compile();
    }

    public void compile() {

        SpecialDocument document = SpecialDocFactory.getInstance(TargetType.HTML);
        Iterator<ArrayList<Syntax>> iterator = AST.iterator();

        // Line by line
        while(iterator.hasNext()){
            ArrayList<Syntax> line = iterator.next();

            // Token by token
            for (Syntax node : line){
                switch (node){
                    case TITLE:
                        break;
                }
            }
        }

        Printer.pl(document.getFinal());
    }

}
