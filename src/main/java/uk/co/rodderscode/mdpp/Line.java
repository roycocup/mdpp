package uk.co.rodderscode.mdpp;


import java.util.ArrayList;

public class Line {

    private final Syntax type;
    private final int lineNumber;
    private final String origContent;
    private final ArrayList<Token> tokens;

    public Line(Syntax type, int lineNumber, String origContent, ArrayList<Token> tokens) {
        this.type = type;
        this.lineNumber = lineNumber;
        this.origContent = origContent;
        this.tokens = tokens;
    }


    public Syntax getType() {
        return type;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getOrigContent() {
        return origContent;
    }

    public ArrayList<Token> getTokens() {return tokens;}


}
