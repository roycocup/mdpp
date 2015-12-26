package uk.co.rodderscode.doccreator;


public class SpecialDocFactory {

    public static SpecialDocument getDocInstance(TargetType type){
        if (type.equals(TargetType.HTML)) {
            return new HtmlCreator();
        }else {
            return null;
        }
    }

}
