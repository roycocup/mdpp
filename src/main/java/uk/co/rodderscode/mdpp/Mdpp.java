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

    // Abstract Syntax Tree. Not a tree in this case as its much easier to just iterate on a flat array
    // and there is no syntax checking at the moment either
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
     * Lexical and Syntax Frontend Production
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
            read(line);
        }

        Printer.pl(document.getFinal());
    }


    private void read(Line line){
        // build the document now.
        if (line.getType().equals(Syntax.TITLE)){
            //TODO: Need to get the "look for similar" function working so that we get the levels for a title here.
            // 1. Need to iterate the characters,
            // 2. remove the titles in the beginning
            // 3. return as string to add to html title
            StringBuilder s = new StringBuilder();
            int counter = 0;
            for (Token token : line.getTokens()){
                //TODO: this will remove title symbols from the middle of the text too. Must fix.
                if (token.getToken().equals(Syntax.TITLE)) {
                    counter++;
                    continue;
                }
                s.append(token.getValue());
            }
            document.title(s.toString(), counter);
            return;
        }

        for (Token token : line.getTokens()) {
            document.text(token.getValue().toString());
        }

    }


}
