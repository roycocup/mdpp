package uk.co.rodderscode.doccreator;



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
    public void text(String str){
        add(str);
    }

    @Override
    public void list(String[] str){
        StringBuilder s = new StringBuilder("\n<ul>");
        s.append("<li>"+str+"</li>");
        s.append("</ul>\n");
        document.append(s);
    }

    public String getFinal(){
        add("\n</body></html>");
        return document.toString();
    }


}
