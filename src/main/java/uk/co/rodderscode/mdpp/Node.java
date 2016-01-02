package uk.co.rodderscode.mdpp;


import java.util.ArrayList;

public class Node {

    private NodeType type;
    private int lineNum;
    private String value;
    private String original;

    enum NodeType{
        EXPRESSION,
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

    public NodeType getType() {
        return type;
    }

    public int getLineNum() {
        return lineNum;
    }

    public String getValue() {
        return value;
    }

    public String getOriginal() {
        return original;
    }
}
