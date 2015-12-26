package uk.co.rodderscode.doccreator;


public class SpecialDocFactory {

    public static SpecialDocument getInstance(TargetType type) {
        SpecialDocument d = null;
        switch (type){
            case HTML:
                d = new HtmlCreator();
                break;
            case RTF:
                break;
            case TXT:
                break;
        }
        return d;
    }

}
