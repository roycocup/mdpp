package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mdpp implements MdFile {

    private String filename = null;
    private File inputFile = null;

    public Mdpp(String filename) throws NotValidMdppFile {
        setFilename(filename);
        if( !isMarkdown() )
            throw new NotValidMdppFile("File is not valid markdown file (.md)");
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {return this.filename;}

    public Boolean isMarkdown() {
        int dotIndex = filename.lastIndexOf(".")+1; //otherwise the dot will be included
        String extension = filename.substring(dotIndex);
        return extension.equals("md");
    }

    public MdppDocument parse() throws FileNotFoundException {
        loadInputFile();

        Scanner scanner = new Scanner(inputFile);

        while(scanner.hasNext()){
            SyntaxNode.isCommand(scanner.next().toString());
        }

        MdppDocument doc = new MdppDocument();
        return doc;
    }

    private void loadInputFile() {
        inputFile = new File(filename);
    }
}
