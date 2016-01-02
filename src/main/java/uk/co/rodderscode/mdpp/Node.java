package uk.co.rodderscode.mdpp;


import java.util.ArrayList;

public class Node {

    private NodeType type;
    private int lineNum;
    private String value;

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
}
