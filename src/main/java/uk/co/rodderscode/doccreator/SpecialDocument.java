package uk.co.rodderscode.doccreator;


public interface SpecialDocument {

    void add(String str);
    void title(String str, int level);
    void list(String[] str);
    void text(String str);
    String getFinal();

}
