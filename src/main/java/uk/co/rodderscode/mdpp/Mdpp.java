package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.doccreator.SpecialDocFactory;
import uk.co.rodderscode.doccreator.SpecialDocument;
import uk.co.rodderscode.doccreator.TargetType;
import uk.co.rodderscode.mdpp.exceptions.NotValidMdppFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mdpp {

    private String filename = null;
    private File inputFile = null;
    public ArrayList<HashMap<Integer, String>> AST = new ArrayList<>();
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

        int line = 0;
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            Lexer lexer = new Lexer();
            lexer.tokenize(next);
            HashMap hm = new HashMap();
            hm.put(line++, lexer.getTokenized());
            AST.add(hm);
            line++;
        }

//        Printer.pl(AST);

    }


    public void compileTo(TargetType type){
        //TODO: support other types
        compile();
    }

    public void compile() {

        SpecialDocument document = SpecialDocFactory.getDocInstance(TargetType.HTML);
        Iterator<HashMap<Integer, String>> iterator = AST.iterator();

        // Line by line
        while(iterator.hasNext()){
            HashMap<Integer, String> hm = iterator.next();
            Collection values = hm.values();

            // Token by token
            Iterator<Syntax> i2 = values.iterator();
            while(i2.hasNext()) {
                switch (i2.next()) {
                    case TITLE:
                        break;
                    case INTEGER:
                        break;
                    case LIST:
                        break;
                    case PUNCTUATION:
                        break;
                    case DASH:
                    case WEIRD_SHIT:
                        break;
                    case WHITESPACE:
                    case CHARACTER:
                        break;

                }
            }
        }

//        Printer.pl(document.getOutput());
    }

}
