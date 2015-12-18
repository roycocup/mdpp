package uk.co.rodderscode.mdpp;


import uk.co.rodderscode.utils.Printer;

public class MarkdownPlusPlus implements MarkdownFile {

    private String filename;

    public MarkdownPlusPlus(String filename) throws Exception {
        setFilename(filename);
        if( !isMarkdown() )
            throw new Exception("File is not valid markdown file (.md)");
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {return this.filename;}

    public MDPPDocument parse(){

        MDPPDocument doc = new MDPPDocument();
        return doc;
    }


    public Boolean isMarkdown() {
        try {
            int dotIndex = filename.indexOf(".")+1; //otherwise the dot will be included
            String extension = filename.substring(dotIndex);
            return extension.equals("md") ? true : false;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}
