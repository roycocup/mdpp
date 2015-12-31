package uk.co.rodderscode.mdpp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public enum Syntax{
//    EM                  ("", Pattern.compile("")),
//    STRONG              ("", Pattern.compile("")),
//    STRONGEM            ("", Pattern.compile("")),
//    STRIKETHROUGH       ("", Pattern.compile("")),
//    MULTILINEHEADER     ("", Pattern.compile("")),
//    MARKDOWNCODESPAN    ("span", Pattern.compile("")),

    HEADER              ("title", Pattern.compile("#*[\\s\\w]*")),

    HREF                ("link", Pattern.compile(
                        "\\[[\\w\\s]*]\\((\\b"+
                        "(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+"+
                        "[-A-Za-z0-9+&@#/%=~_|]([\\s\\\"\\w]*)\\)")),

    REFERENCE_LINK      ("ref_link", Pattern.compile("\\[[\\w\\s]*]\\[[a-z]*\\]")),

    REFERENCE           ("reference", Pattern.compile("\\[[\\w\\s]*]:[\\s]+"+
                        "(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+"+
                        "[-A-Za-z0-9+&@#/%=~_|][\\s]+")),

    PARAGRAPH           ("p", Pattern.compile("\\n\\n")),
    NEWLINE             ("break", Pattern.compile("\\n")),
    OLIST               ("ol", Pattern.compile("(\\d\\.)+")),
    ULIST               ("ul", Pattern.compile("\\+\\s")),
    UNKNOWN             ("unknown", Pattern.compile("")),
    TEST("test", Pattern.compile("#")),
    NULL                ("null", Pattern.compile(""));


    private String name;
    private Pattern pattern;

    Syntax(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }

    static List<Syntax> getAll(){
        List<Syntax> l = new ArrayList<>();
        for(Syntax v : Syntax.values())
            l.add(v);
        return l;
    }


}