package uk.co.rodderscode.doccreator;


import uk.co.rodderscode.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class HtmlCreator implements SpecialDocument {

    StringBuilder document = new StringBuilder();

    public HtmlCreator(){
        init();
    }

    private void init() {
        String header = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\" />\n";

        add(header);

        add("<body>\n");
    }

    @Override
    public void add(String str){
        document.append(str);
    };

    @Override
    public void title(String str, int level){
        StringBuilder s = new StringBuilder("\n<h"+level+">");
        s.append(str);
        s.append("</h"+level+">\n");
        document.append(s);
    }

    @Override
    public void list(ArrayList<String> str) {
        StringBuilder s = new StringBuilder("\n<ul>");

        for (String targetS : str){
            s.append("\n\t<li>" + targetS + "</li>");
        }

        s.append("\n</ul>\n");
        document.append(s);
    }

    @Override
    public void text(String str){
        add(str);
    }


    public String getFinal(){
        add("\n</body>\n</html>");
        return document.toString();
    }


}
