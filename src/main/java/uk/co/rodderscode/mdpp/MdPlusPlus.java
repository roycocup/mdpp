package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.utils.Printer;

import java.io.File;
import java.util.Scanner;

public class MdPlusPlus implements MdFile {

    private String filename = null;
    private File inputFile = null;

    public MdPlusPlus(String filename) throws Exception {
        setFilename(filename);
        if( !isMarkdown() )
            throw new Exception("File is not valid markdown file (.md)");
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {return this.filename;}

    //TODO: Needs to handle several dots and full paths
    public Boolean isMarkdown() {
        try {
            int dotIndex = filename.indexOf(".")+1; //otherwise the dot will be included
            String extension = filename.substring(dotIndex);
            return extension.equals("md") ? true : false;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public MDPPDocument parse() {
        loadInputFile();
        try {
            Scanner scanner = new Scanner(inputFile);
        }catch (Exception e){
            Printer.err("Issue with scanner");
            return null;
        }

        MDPPDocument doc = new MDPPDocument();
        return doc;
    }

    private void loadInputFile() {
        inputFile = new File(filename);
    }
}