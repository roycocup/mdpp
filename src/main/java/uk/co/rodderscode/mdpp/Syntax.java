package uk.co.rodderscode.mdpp;

import java.util.ArrayList;
import java.util.List;

public enum Syntax{
    NULL,
    WHITESPACE,
    CHARACTER,
    TITLE,
    LIST,
    INTEGER,
    PUNCTUATION,
    DASH,
    WEIRD_SHIT;

    Syntax() {}

    static List<Syntax> getAll(){
        List<Syntax> l = new ArrayList<>();
        for(Syntax v : Syntax.values())
            l.add(v);
        return l;
    }


}