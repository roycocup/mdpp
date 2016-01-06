package uk.co.rodderscode.doccreator;


import uk.co.rodderscode.mdpp.Syntax;

import java.util.ArrayList;

public interface SpecialDocument {

    void add(String str);
    void title(String str, int level);
    void list(ArrayList<String> str, Syntax listType);
    void text(String str);
    String getFinal();

}
