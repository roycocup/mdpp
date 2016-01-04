package uk.co.rodderscode.doccreator;


import java.util.ArrayList;

public interface SpecialDocument {

    void add(String str);
    void title(String str, int level);
    void list(ArrayList<String> str);
    void text(String str);
    String getFinal();

}
