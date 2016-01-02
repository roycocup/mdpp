package uk.co.rodderscode.mdpp;


import java.util.ArrayList;

public class Node {

    private NodeType type   = null;
    private int lineNum     = 0;
    private String value    = null;
    private String original = null;
    private Syntax token    = null;

    enum NodeType{
        EXPRESSION,
        TEXT,
        NEWLINE;
    }

    public Node() {}

    public void setType(NodeType type) {
        this.type = type;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setToken(Syntax token) {this.token = token;}

    public NodeType getType() {
        return type;
    }

    public int getLineNum() {
        return lineNum;
    }

    public String getValue() {
        return value;
    }

    public String getOriginal() {return original;}

    public Syntax getToken() {return token;}
}
