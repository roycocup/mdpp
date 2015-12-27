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


    /**
     * Lexical and Syntax Frontend Analysis
     * @throws FileNotFoundException
     */
    public void parse() throws FileNotFoundException {
        loadInputFile();

        Scanner scanner = new Scanner(inputFile);
        Lexer lexer = new Lexer();

        int line = 0;
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            lexer.tokenize(next);
            //TODO: AST needs to have the characters and some annotations for the backend
            AST.add(lexer.getTokenized());
        }
//        Printer.pl(AST);

    }


    public void compileTo(TargetType type){
        //TODO: support other types
        compile();
    }

    /**
     * Backend Synthesize
     */
    public void compile() {

        SpecialDocument document = SpecialDocFactory.getInstance(TargetType.HTML);
        Iterator<ArrayList<Syntax>> iterator = AST.iterator();

        // Line by line
        while(iterator.hasNext()){
            ArrayList<Syntax> line = iterator.next();

            // Token by token
            List<Syntax> constants = Syntax.getAll(); // all the constants from Syntax enum
            for (Syntax node : line){
                if(constants.contains(node)) {
                    // Dynamically call the enum constant and send it to a react method
                    react(Syntax.valueOf(node.toString()));
                }
            }
        }

//        Printer.pl(document.getFinal());
    }

    private void react(Syntax syntax) {

    }

}
