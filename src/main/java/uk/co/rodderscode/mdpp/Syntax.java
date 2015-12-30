package uk.co.rodderscode.mdpp;

import java.util.ArrayList;
import java.util.List;

public enum Syntax{
    EM,
    STRONG,
    STRONGEM,
    STRIKETHROUGH,
    HEADER,
    MULTILINEHEADER,
    URL,
    HREF,
    PARAGRAPH,
    NEWLINE,
    BULLETSTART,
    MARKDOWNCODESPAN,
    UNKNOWN,
    NULL;

    Syntax() {}

    static List<Syntax> getAll(){
        List<Syntax> l = new ArrayList<>();
        for(Syntax v : Syntax.values())
            l.add(v);
        return l;
    }


}