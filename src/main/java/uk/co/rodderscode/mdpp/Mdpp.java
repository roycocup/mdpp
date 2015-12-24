package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;
import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mdpp {

    private String filename = null;
    private File inputFile = null;

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


    public void parse() throws FileNotFoundException {
        loadInputFile();

        Scanner scanner = new Scanner(inputFile);
        Lexer lexer = new Lexer();

        String line = scanner.nextLine();
        lexer.tokenize(line);
        Printer.pl(lexer.getTokenized());
        /*
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            lexer.tokenize(next);
            Printer.pl(lexer.getTokenized());
        }
        */

    }

    private void loadInputFile() {
        inputFile = new File(filename);
    }
}
