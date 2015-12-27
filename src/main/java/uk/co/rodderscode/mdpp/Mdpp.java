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
    private SpecialDocument document;

    private List<ArrayList<Token>> AST = new ArrayList<>();

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
        document = SpecialDocFactory.getInstance(TargetType.HTML);
        Iterator<ArrayList<Token>> iterator = AST.iterator();
        // Line by line
        int lineNum = 0;  // line counter
        while(iterator.hasNext()){
            // Get a tokenized line
            ArrayList<Token> line = iterator.next();
            synthesize(line, lineNum);
            lineNum++;
        }

        Printer.pl(document.getFinal());
    }

    /**
     * Create intermediate code (html partials) for the final output
     * @param line
     * @param lineNumber
     * @return
     */
    private void synthesize(ArrayList<Token> line, int lineNumber) {
        StringBuilder finalOutput       = new StringBuilder();
        TokenIterator tokenIterator     = new TokenIterator(line);
        TokenFlags flag = null;
        // token by token
        while(tokenIterator.hasNext()){
            Token token = tokenIterator.getNextToken();

            switch (token.getToken()){
                case TITLE:
                    // if this is the beginning of the line
                    if (tokenIterator.getPosition() == 0)
                        flag = TokenFlags.TITLE;
                        // check how many more of the same symbol do we have
                    // if not, its a character, just append to the output
//                    int similar = tokenIterator.getNextIfSimilar(Syntax.TITLE, tokenIterator.getPosition());
//                    Printer.pl(similar);
                    break;
                case LIST:
                    break;
                case INTEGER:
                    break;
                case PUNCTUATION:
                    break;
                case DASH:
                    break;
                case WEIRD_SHIT:
                    break;
                default:
                case WHITESPACE:
                case CHARACTER:
                    finalOutput.append(token.getValue());
                    break;
            }

        }
        if ( flag != null ){
            if (flag.equals(TokenFlags.TITLE))
                document.title(finalOutput.toString(), 1);

            if (flag.equals(TokenFlags.LIST)) {
                String[] s = {finalOutput.toString()};
                document.list(s);
            }
        }



    }


}
