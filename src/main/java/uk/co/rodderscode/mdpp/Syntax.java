package uk.co.rodderscode.mdpp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public enum Syntax{
    EM                  ("", Pattern.compile("")),
    STRONG              ("", Pattern.compile("")),
    STRONGEM            ("", Pattern.compile("")),
    STRIKETHROUGH       ("", Pattern.compile("")),
    HEADER              ("", Pattern.compile("#{1,6}[^\\s\\w]*")),
    MULTILINEHEADER     ("", Pattern.compile("")),
    URL                 ("code", Pattern.compile("")),
    HREF                ("link", Pattern.compile("")),
    PARAGRAPH           ("p", Pattern.compile("")),
    NEWLINE             ("break", Pattern.compile("")),
    BULLETSTART         ("ul", Pattern.compile("")),
    MARKDOWNCODESPAN    ("span", Pattern.compile("")),
    UNKNOWN             ("unknown", Pattern.compile("")),
    NULL                ("null", Pattern.compile(""));


    private String name;
    private Pattern pattern;

    Syntax(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }


    static List<Syntax> getAll(){
        List<Syntax> l = new ArrayList<>();
        for(Syntax v : Syntax.values())
            l.add(v);
        return l;
    }


}